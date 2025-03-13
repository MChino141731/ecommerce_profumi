package com.corsosiam.services;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.corsosiam.entities.Profumo;
import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;

public class CatalogoBI {
    // CACHE
    public List<Profumo> prodotti  = new ArrayList<>();

    public List<Profumo> loadCatalogo() {
        if(prodotti.isEmpty()){
            resetCache();
        }
        return prodotti;
    }

    public void resetCache() {
        prodotti.clear();
        MongoCollection<Document> documents = this.getCollection();
        for (Document doc : documents.find()) {
            Gson gson = new Gson();
            Profumo prodotto = gson.fromJson(doc.toJson(), Profumo.class);
            prodotti.add(prodotto);
        }
    }

    // public Profumo save(Profumo prodotto){
    //     MongoCollection<Document> documents = this.getCollection();
    //     Gson gson = new Gson();
    //     try {
    //         prodotto.setId(UUID.randomUUID().toString());
    //         InsertOneResult resp = documents.insertOne(Document.parse(gson.toJson(prodotto)));
    //         if(!prodotto.getId().equals(resp.getInsertedId().toString())){
    //             return null;
    //         }
    //     } catch (Exception e) {
    //         return null;
    //     }
    //     this.resetCache();
    //     return prodotto;
    // }

    private  MongoCollection<Document> getCollection() {
        MongoDBConnector mongodb = new MongoDBConnector();
        mongodb.setConnection();
        mongodb.setDatabase("ecommerce");

        MongoCollection<Document> documents = mongodb.load("catalogo");
        return documents;
    }

}
