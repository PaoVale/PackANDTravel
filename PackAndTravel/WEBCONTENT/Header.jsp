<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pack &amp; Travel</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"> <!-- Aggiungi il link al CSS delle icone di Font Awesome -->
<link rel="stylesheet" href="styles/Header.css" type="text/css">
</head>
<body>
<header class="header">
   <div class="logo">
      <a href="Index.jsp"><img src="images/logo-removebg-preview.png" alt="Logo"> </a>
      <div class="icons">
         <a href="Login.jsp"><i class="fas fa-user"></i></a> <!-- Icona per accedere/fare log in -->
         <a href="#"><i class="fas fa-shopping-cart"></i></a> <!-- Icona per il carrello -->
         <a href="Wishlist.jsp"><i class="fas fa-heart"></i></a> <!-- Icona per la wishlist -->
      </div>
   </div>
</header>
<div class="search-bar">
   <input type="text" placeholder="Cerca..."> <!-- Barra di ricerca -->
</div>
<nav class="navigation">
   <a href="Novità.jsp">Novità</a>
   <a href="Valigie.jsp">Valigie</a>
   <a href="Zaini.jsp">Zaini</a>
   <a href="Accessori.jsp">Accessori</a>
   <a href="Borsoni.jsp">Borsoni</a>
</nav>
</body>
</html>
