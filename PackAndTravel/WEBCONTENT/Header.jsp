<%@page import="model.*" %>
<%@page import="control.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%
	AccountUser auth = (AccountUser) request.getSession().getAttribute("auth") ;
	if(auth!=null){
		request.setAttribute("auth",auth);
	}
%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="ISO-8859-1">
<title>Pack &amp; Travel</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<link rel="stylesheet" href="styles/Header.css" type="text/css">
<script  src="scripts/ToooltipsIcone.js" type="text/javascript"></script>
</head>
<body>
<header class="header">
   <div class="logo">
      <a href="Index.jsp"><img src="images/logo-removebg-preview.png" alt="Logo"> </a>
      <div class="icons">
            <!-- TODO aggiungi tooltips alle icone -->     
         <% if(auth != null){ %>
         	<a href="#">I miei ordini</a>
         <%} %>
         
         <a href="#"><i class="fas fa-shopping-cart"></i></a> <!-- Icona per il carrello -->
        
         <% 
         	if(auth != null){ %>
         	<a href="Wishlist.jsp" ><i class="fas fa-heart" ></i></a> 
         	
         	<a href="log-out"><i class="fas fa-sign-out-alt"></i></a> 
         <%} else{%>
         
         	<a href="Login.jsp"><i class="fas fa-user"></i></a>
         	
         <%} %>
         	
         
         
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
