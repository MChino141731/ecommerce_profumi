package com.corsosiam;

import java.io.IOException;
import java.util.List;

import com.corsosiam.entities.Articolo;
import com.corsosiam.services.CarrelloBI;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CarrelloServlet extends HttpServlet {
    CarrelloBI carrello = new CarrelloBI();
    

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        // preparo già la Request fornendo l'attributo libri con l'elenco dei libri
        request.setAttribute("carrello", carrello.loadCarrello());

        // SEGNALO CHE LA REQUEST VIENE GESTITA DIRETTAMENTE DALLA JSP -> libri.jsp
        // E RICEVERA' LEI REQUEST E INVIERA' LA RESPONSE
        request.getRequestDispatcher("/carrello.jsp").forward(request, response);
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String id_prodotto = request.getParameter("id");
        List<Articolo> articoli = carrello.loadCarrello();
        int qta = 0;
        for(Articolo articolo: articoli){
            if(articolo.getId_prodotto().equals(id_prodotto)){
                qta++;
            }
        }

        Articolo articolo = new Articolo();
        articolo.setId_prodotto(id_prodotto);
        articolo.setQta(qta);
        if(qta==0){
            articolo.setQta(1);
            carrello.save(articolo);
        }
        else {
            articolo.setQta(qta);
            carrello.update(articolo);
        }
        carrello.resetCache();
        request.setAttribute("carrello", carrello.loadCarrello());

        request.getRequestDispatcher("/carrello.jsp").forward(request, response);
    }
}
