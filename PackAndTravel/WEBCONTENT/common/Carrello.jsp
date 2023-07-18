<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Carrello</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/styles/Carrello.css">
</head>
<body>
    <%@ include file="Header.jsp"%>
    
        <h1 id="titolo">Il tuo Carrello</h1>
    

    <main class="container">
        <table>
            <thead>
                <tr>
                    <th>Prodotto</th>
                    <th>Prezzo</th>
                    <th>Quantit&agrave;</th>
                    <th>Totale</th>
                </tr>
            </thead>
            <tbody>
                <!-- Qui andranno i prodotti aggiunti al carrello come righe della tabella -->
                <!-- Esempio di riga -->
                <!-- <tr>
                    <td>Nome prodotto</td>
                    <td>Prezzo prodotto</td>
                    <td>Quantità prodotto</td>
                    <td>Totale riga</td>
                </tr> -->
            </tbody>
            <tfoot>
                <tr>
                    <td colspan="3">Totale</td>
                    <td id="cart-total"></td>
                </tr>
            </tfoot>
        </table>

        <a href="checkout.html" class="checkout-button">Procedi al Checkout</a>
    </main>
</body>
<%@ include file="Footer.jsp"%>
</html>
