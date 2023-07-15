<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="model.Prodotto, model.ProdottoDAO, java.util.*" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="ISO-8859-1">
<title>Valigie - Pack &amp; Travel</title>

<link rel="stylesheet" href="<%=request.getContextPath() %>/styles/Valigie_borsoni_zaini_accessori.css" type="text/css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

</head>
<body>

<%@ include file="Header.jsp" %>

<%
String categoria = "valigia";
request.setAttribute("categoria", categoria);	
int id = 2;
request.setAttribute("id", id);
	Collection<?> prodotti = (Collection<?>) request.getAttribute("prodotti");

	
	if (prodotti == null){
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/VisualizzaProdottiServlet");
		dispatcher.forward(request, response);	
		return;
	}	
	
	%>

<main>
   <section class="novita-section">
   <h2>Valigie</h2>
	<%-- <%@ include file="Filter.jsp" %> --%>
      
      
      <div class="album py-5 ">
	
        <div class="container">

          <div class="row">
          
          <% if (prodotti != null && prodotti.size() != 0) {
				Iterator<?> it = prodotti.iterator();
				while (it.hasNext()) {
					Prodotto prodotto = (Prodotto) it.next();
          %>
             <div class="col-md-4">
              <div class="card mb-4 box-shadow">
             <p class="card-text nome"><%=prodotto.getNome()%></p>
                <img class="card-img-top img"  src="<%=request.getContextPath()%>/getPicture?codice=<%=prodotto.getCodice()%>"alt="immagine prodotto"  > 
                <div class="card-body">
                  
                  <div class="d-flex justify-content-between align-items-center">
                  	<a href="#" class="btn btn-info" role="button"><%=prodotto.getPrezzo()%>&euro;</a>
                  </div>
                </div>
              </div>
            </div>
            
            <%} }%>
            
           </div>
        </div>
     </div>
   </section>
</main>

<%@ include file="Footer.jsp" %>

</body>
</html>
