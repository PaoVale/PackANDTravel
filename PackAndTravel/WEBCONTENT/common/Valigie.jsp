<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="ISO-8859-1">
<title>Valigie - Pack &amp; Travel</title>

<link rel="stylesheet" href="<%=request.getContextPath() %>/styles/Valigie_borsoni_zaini_accessori.css" type="text/css">


</head>
<body>

<%@ include file="Header.jsp" %>

<main>
   <section class="novita-section">
   <h2>Valigie</h2>
	<%@ include file="Filter.jsp" %>
      
      
      <!-- Inserisci qui il codice per visualizzare i prodotti di valigie dal database -->
   </section>
</main>

<%@ include file="Footer.jsp" %>

</body>
</html>
