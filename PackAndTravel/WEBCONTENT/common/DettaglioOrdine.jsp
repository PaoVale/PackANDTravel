<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dettaglio Ordine</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/styles/DettaglioOrdine.css">

</head>
<body>

<section class="visualizzaOrdiniUser">

	<h2>Il tuo ordine</h2>
				
		<table class="tableDettaglioOrdine">
			<caption> </caption>  
			<thead>
				<tr>
					<th scope="col">Prodotto</th>
					<th scope="col">Prezzo</th>
					<th scope="col">Quatità</th>
				</tr>
			</thead>
			<tbody>
			<%-- <%if (prodotti != null && prodotti.size() != 0) {
		        Iterator<?> it = prodotti.iterator();
		        while (it.hasNext()) {
		          Prodotto prdottto = (Prodotto) it.next();%> --%>
				<tr >
					<td><%-- <%=prodotto.getNome() %>  --%><br><img alt="Imagine prodotto" src=""></th>
					<td><%-- <%=prodotto.getDataOrdine()%> --%></td>
					<td><%-- <%=prodotto.getPrezzo() %> --%></td>
                	
				</tr>
			<%-- <%} }%> --%>
			</tbody>
		</table>
	
	 </section>	

</body>
</html>