<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="ISO-8859-1">
<title>Pack&amp;Travel</title>
<link href="DettaglioProdotto.css" rel="stylesheet" >
</head>
<body>
	<%@ include file="Header.jsp" %>
	
	<div class="container">
  <div class="left-div">
    <img src="<%=request.getContextPath()%>/images/logo-removebg-preview.png" alt="immagine prodotto" width=500px height=auto>
  </div>
  <div class="right-div">
  	<h5>Codice prodotto</h5>
    <h2>nome prodotto</h2>
    <p>Descrizione</p>
    <h2>Prezzo</h2>
    <a href="<%=request.getContextPath()%>/common/Wishlist.jsp" ><i class="fas fa-heart" ></i></a>
    <br><br>
    <button> Aggiungi al carrello </button>
  </div>
</div>

	<%@ include file="Footer.jsp" %>
</body>
</html>