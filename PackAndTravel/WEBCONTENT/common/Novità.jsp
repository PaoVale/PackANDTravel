
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="ISO-8859-1">
<title>Novità - Pack &amp; Travel</title>

<link rel="stylesheet" href="<%=request.getContextPath() %>/styles/Novità.css" type="text/css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js" 
		integrity="sha384-oqVuAfXRKap7fdgcCY5uykM6+R9GqQ8K/uxy9rx7HNQlGYl1kPzQho1wx4JwY8wC"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/styles/Filter.css">
</head>
<body>

<%@ include file="Header.jsp" %>

<main>
   <section class="novita-section">
   	<%@ include file="Filter_novità.jsp" %>
      <h2>Novità</h2>
      <!-- Inserisci qui il codice per visualizzare i prodotti di valigie dal database -->
   </section>
</main>

<%@ include file="Footer.jsp" %>

</body>
</html>
