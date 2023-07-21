<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*, model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dettaglio Ordine</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/styles/DettaglioOrdine.css">

</head>
<body>
   <%@ include file="Header.jsp" %>
<%
	
	String codice = (String)session.getAttribute("codice");
	System.out.println("il codice in dettaglioordine.jsp: "+codice);
	Collection<?> articoli = (Collection<?>) request.getAttribute("articoli");
	
	
	
	if (articoli == null) {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/DettaglioOrdineServlet");
		dispatcher.forward(request, response);
		return;
	}
	
	%>
<section class="visualizzaOrdiniUser">

	<h2>Il tuo ordine</h2>
				
		<table class="tableDettaglioOrdine">
			<caption> </caption>  
			<thead>
				<tr>
					<th scope="col">Prodotto</th>
					<th scope="col">Prezzo</th>
					<th scope="col">Quantità</th>
				</tr>
			</thead>
			<tbody>
			<%if (articoli != null && articoli.size() != 0) {
		        Iterator<?> it = articoli.iterator();
		        while (it.hasNext()) {
		          Articolo articolo = (Articolo) it.next();%>
				<tr >
					<td><%=articolo.getNome() %> </td>
					
					<td><%=articolo.getPrezzo() %></td>
                	<td><%=articolo.getQuantità() %></td>
				</tr>
			<%} }%>
			</tbody>
		</table>
	
	 </section>	
   <%@ include file="Footer.jsp" %>s
</body>
</html>