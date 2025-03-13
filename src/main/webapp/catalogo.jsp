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
        <h1>Catalogo</h1>
        <table>
            <tr>
                <th>Marca</th>
                <th>Modello</th>
                <th>Prezzo</th>
            </tr>
            <tbody>
                <c:forEach var="prodotto" items="${catalogo}" varStatus="loop">
                <tr>
                    <td>${prodotto.marca}</td>
                    <td>${prodotto.modello}</td> 
                    <td>${prodotto.prezzo}</td> 
                    <td>
                        <form action="carrello" method="post">
                            <input style="display: none;" type="text" name="id" value="${prodotto.getId()}">
                            <input type="submit" value="+">
                        </form>
                    </td>
                    
                </tr>
            </c:forEach>
            </tbody>

        </table>
    </body>
</html>