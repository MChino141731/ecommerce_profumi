package com.corsosiam;

import java.io.IOException;

import com.corsosiam.services.CatalogoBI;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CatalogoServlet extends HttpServlet {
    CatalogoBI catalogo = new CatalogoBI();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        // preparo già la Request fornendo l'attributo libri con l'elenco dei libri
        request.setAttribute("catalogo", catalogo.loadCatalogo());

        // SEGNALO CHE LA REQUEST VIENE GESTITA DIRETTAMENTE DALLA JSP -> libri.jsp
        // E RICEVERA' LEI REQUEST E INVIERA' LA RESPONSE
        request.getRequestDispatcher("/catalogo.jsp").forward(request, response);
    }
    

}
