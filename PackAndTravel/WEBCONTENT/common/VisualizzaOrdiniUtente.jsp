<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1" 
    import = "model.OrdineBean, java.util.*"
    
%>

<!DOCTYPE html>
<html lang=it>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Visualizza Ordini Utente</title>

<link rel="stylesheet" href="<%=request.getContextPath()%>/styles/VisualizzaOrdiniUtente.css">

</head>



	<%
	    
	
	Collection<?> ordini = (Collection<?>) request.getAttribute("ordini");
	if (ordini == null){
	  RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/VisualizzaOrdiniServlet");
	  dispatcher.forward(request, response);  
	  return;
	}
      	
	%>


<body>
<%@ include file="Header.jsp" %>
	
	<section class="visualizzaOrdiniUser">

	<h2>I tuoi ordini</h2>
				
		<table class="table table-sm table-dark table-hover table-bordered">
			<caption> </caption>  
			<thead>
				<tr>
					<th scope="col">Codice ordine</th>
					<th scope="col">Data ordine</th>
					<th scope="col">Totale</th>
					<th scope="col">Dettagli</th>
				</tr>
			</thead>
			<tbody>
			<%if (ordini != null && ordini.size() != 0) {
		        Iterator<?> it = ordini.iterator();
		        while (it.hasNext()) {
		          OrdineBean ordine = (OrdineBean) it.next();%>
				<tr>
					<th scope="row"><%=ordine.getCodice()%></th>
					<td><%=ordine.getDataOrdine()%></td>
					<td><%=ordine.getPrezzo()%> &euro;</td>
                	<td>
                		<a href="/PackAndTravel/SetCodiceServlet?code=<%=ordine.getCodice()%>">Visualizza dettagli </a>
  					</td> 
				</tr>
			<%} }%>
			</tbody>
		</table>
	
	 </section>
		
		<%@ include file="Footer.jsp" %>

</body>
</html>