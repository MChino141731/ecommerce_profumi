<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
import="java.io.*, corsosiam.*, corsosiam.entities.*" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCUMENT html>

<html>
    <head>
        <title>Ecommerce</title>
        <link href="./css/style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <h1>Carrello</h1>
        <table>
            <tr>
                <th>Marca</th>
                <th>Modello</th>
                <th>Prezzo</th>
                <th>Quantita</th>
            </tr>
            <tbody>
                <c:forEach var="articolo" items="${carrello}" varStatus="loop">
                <tr>
                    <td>${articolo.prodotto.marca}</td>
                    <td>${articolo.prodotto.modello}</td>
                    <td>${articolo.prodotto.prezzo}</td>
                    <td>${articolo.qta}</td>
                </tr>
            </c:forEach>
            </tbody>

        </table>
    </body>
</html>