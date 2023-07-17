<%@page import="model.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="ISO-8859-1">
<title>Pack &amp; Travel</title>

<link rel="stylesheet" href="<%=request.getContextPath() %>/styles/Index.css" >


</head>
<body>

<%@ include file="Header.jsp" %>
<div class="picture">
  <div class="image-wrapper">
    <img src="<%=request.getContextPath() %>/images/foto_HOME.jpg" alt="Homepage Image">
    <div class="overlay">
      <span>Pack Smarter,<br>Travel Better</span>
    </div>
  </div>
</div>

<section> 
<div class="suggeriti"> 
   <h2 class="Suggested">Suggested</h2>
</div>
</section>
<br>
<!-- Inserisci qui il codice per visualizzare i prodotti dal database -->


<%@ include file="Footer.jsp" %>

</body>
</html>
