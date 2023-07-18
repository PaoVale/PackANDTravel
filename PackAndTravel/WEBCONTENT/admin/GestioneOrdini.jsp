<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="ISO-8859-1">
<title>Gestioni ordini</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/styles/ProductView.css">
<script src="<%=request.getContextPath()%>/scripts/ProductView.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath() %>/scripts/validate.js"></script>
</head>
<body>

<%@ include file="../common/Header.jsp" %>

<div id= "container">
	 <h2>
    Visualizza ordini <span id="toggleButton1" class="cursor-pointer" onclick="toggleContent('toggleButton1', 'productTable')">+</span>
  </h2>
	<table id="productTable" border="1" class="hidden" > 
	
  <tr>
    <th>Codice </th>
    <th>Data_spedizione  </th>
    <th>Data_effettuazione</th>
    <th>Prezzo_totale </th>
    <th>Acoount</th>
    
  </tr>
	
	<tr>
			<%-- <td><%=prodotto.getCodice()%></td>
			<td><%=prodotto.getNome()%></td>
			<td><%=prodotto.getDescrizione()%></td>
			<td> <%=prodotto.getCategoria_nome() %></td>
			<td><%=prodotto.getPrezzo() %></td>
			<td><img class="img" src="<%=request.getContextPath()%>/getPicture?codice=<%=prodotto.getCodice()%>" alt="immagine prodotto"></td> 
		 --%>
		</tr>
	
		<tr>
			<td colspan="6">No order available</td>
		</tr>
		
	</table>
	</div>
	
	

<%@ include file="../common/Footer.jsp" %>

</body>
</html>