package com.corsosiam.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.corsosiam.entities.Articolo;
import com.corsosiam.entities.Profumo;
import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.InsertOneResult;

public class CarrelloBI {
    // CACHE
    public List<Articolo> articoli  = new ArrayList<>();
    public List<Profumo> prodotti  = new ArrayList<>();
    public CatalogoBI catalogoBI = new CatalogoBI();

    public List<Articolo> loadCarrello() 
    {
        if(articoli.isEmpty()){
            resetCache();
        }
        return articoli;
    }

    public void resetCache()
    {
        articoli.clear();
        MongoCollection<Document> documents = this.getCollection();
        prodotti = catalogoBI.loadCatalogo();
        for (Document doc : documents.find()) {
            Gson gson = new Gson();
            Articolo articolo = gson.fromJson(doc.toJson(), Articolo.class);
            for(Profumo profumo: prodotti){
                if(profumo.getId().equals(articolo.getId_prodotto())){
                    articolo.setProfumo(profumo);
                }
            }
            articoli.add(articolo);
        }
    }

    public Articolo save(Articolo articolo)
    {
        MongoCollection<Document> documents = this.getCollection();
        Gson gson = new Gson();
        try {
            articolo.set_id(UUID.randomUUID().toString());
            InsertOneResult resp = documents.insertOne(Document.parse(gson.toJson(articolo)));
            if(!articolo.get_id().equals(resp.getInsertedId().toString())){
                return null;
            }
        } catch (Exception e) {
            return null;
        }
        this.resetCache();
        return articolo;
    }

    public Articolo update(Articolo articolo)
    {
        MongoCollection<Document> documents = this.getCollection();
        try {
            Bson filter = Filters.eq("id_profumo",  articolo.getId_prodotto());
            Bson update = Updates.inc("qta", articolo.getQta());
            documents.updateOne(filter,update);
        } catch (Exception e)
        {
            return null;
        }
        this.resetCache();
        return articolo;
    }

    private  MongoCollection<Document> getCollection() 
    {
        MongoDBConnector mongodb = new MongoDBConnector();
        mongodb.setConnection();
        mongodb.setDatabase("ecommerce_profumi");

        MongoCollection<Document> documents = mongodb.load("carrello");
        return documents;
    }

}
