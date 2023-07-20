<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "model.OrdineBean, java.util.*"
    errorPage="errorPage.jsp"
%>

<!DOCTYPE html>
<html lang=it>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Visualizza Ordini Utente</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>

<jsp:include page="Header.jsp"/>

	<%
	    
    	List<OrdineBean> ordini = (List<OrdineBean>)request.getAttribute("listOrdini");
					
		if(ordini == null){
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/VisualizzaOrdiniUtente");
			dispatcher.forward(request, response);	
			return;
		}
      	
	%>


<body>

	<section class="visualizzaOrdiniUser">

	<h2>Cronologia ordini</h2>
				
		<table class="table table-sm table-dark table-hover table-bordered">
			<caption> </caption>  
			<thead>
				<tr>
					<th scope="col">Codice ordine</th>
					<th scope="col">Data ordine</th>
					<th scope="col">Prezzo</th>
					<th scope="col">Dettagli</th>
				</tr>
			</thead>
			<tbody>
			<%for(OrdineBean ordine : ordini){%>
				<tr>
					<th scope="row"><%=ordine.getCodice()%></th>
					<td><%=ordine.getDataOrdine()%></td>
					<td><%=ordine.getPrezzo() %>
                	<td><a href="<%=request.getContextPath()%>/common/DettaglioOrdine.jsp?code=<%=ordine.getCodice()%>">Visualizza dettagli </a>
  					</td> 
				</tr>
			<%} %>
			</tbody>
		</table>
	
	 </section>
		
		<jsp:include page="Footer.jsp"/>

</body>
</html>