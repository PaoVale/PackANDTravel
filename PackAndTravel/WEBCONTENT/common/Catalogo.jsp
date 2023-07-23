<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
import="model.Prodotto, model.ProdottoDAO, java.util.*" pageEncoding="ISO-8859-1" 
%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%String categoria = request.getParameter("categoria");
request.setAttribute("categoria", categoria); 
String titolo;
if(categoria.equals("zaino"))
	titolo="Zaini";
else if(categoria.equals("valigia"))
	titolo="Valigie";
else if(categoria.equals("borsone"))
	titolo = "Borsoni";
else
	titolo = "Accessori";
%>

<title><%=titolo %>- Pack &amp; Travel</title>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" href="<%=request.getContextPath() %>/styles/catalogo.css" type="text/css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"> 

</head>

<body>

<%@ include file="Header.jsp" %>


<div class="sidebar" id="mySidebar">
    <a href="javascript:void(0)" class="closebtn" onclick="closeSidebar()">&times;</a>
    
    <form action="/PackAndTravel/FilterCatalogServlet?categoria=<%=categoria %>" method="post">
    <div class="container">
      <div class="filter">
        <label for="price">Prezzo:</label> <span class="filter-expand" data-filter-id="priceOptions"></span>
        <div id="priceOptions" class="filter-options">
          <input type="radio" id="price-0-50" name="price" value="0-50">
          <label for="price-0-50">0-50&euro;</label><br> 
          <input type="radio" id="price-50-100" name="price" value="50-100">
          <label for="price-50-100">50-100&euro;</label><br> 
          <input type="radio" id="price-100-plus" name="price" value="100-plus">
          <label for="price-100-plus">100&euro;+</label><br>
        </div>
      </div>


      <div class="filter">
        <label for="order">Ordina per:</label> <span class="filter-expand" data-filter-id="orderOptions"></span>
        <div id="orderOptions" class="filter-options">
          <input type="radio" id="order-crescente" name="ordina-per" value="crescente"> 
          <label for="ordina-per">Prezzo crescente</label><br> 
          <input type="radio" id="order-decrescente" name="ordina-per" value="decrescente"> 
          <label for="ordina-per">Prezzo decrescente</label><br>
        </div>
      </div>
      <button type="submit" class="btn-cerca">Cerca</button>

    </div>

  </form>
</div>

<div id="main">
    <button class="openbtn" onclick="openSidebar()">&#9776; Filtra</button>
</div>
<%
	
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
   <h2 id="titolo"><%=titolo %></h2>
	
      
      
    <div class="album py-5">
  <div class="container">
    <div class="row">
      <% if (prodotti != null && prodotti.size() != 0) {
        Iterator<?> it = prodotti.iterator();
        while (it.hasNext()) {
          Prodotto prodotto = (Prodotto) it.next();
      %>
      <div class="col-md-4">
        <div class="card mb-4 box-shadow">
          <div class="card-body d-flex flex-column align-items-center">
            <a href="<%=request.getContextPath()%>/common/DettaglioProdotto.jsp?code=<%=prodotto.getCodice()%>" class="card-text nome"><%=prodotto.getNome()%>
            <img class="card-img-top img" src="<%=request.getContextPath()%>/getPicture?codice=<%=prodotto.getCodice()%>" alt="immagine prodotto"></a>
            <div class="d-flex justify-content-center flex-column ">
 				 <p class="text-center prezzo"><%=prodotto.getPrezzo()%>&euro;</p>
 				<!-- Trasforma il link in un bottone utilizzando un button tag -->
<button type="button" class="btn btn-info btn-block aggiungiAlCarrello" data-id="<%=prodotto.getCodice()%>">Aggiungi al carrello</button>



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

<%@ include file="/common/Footer.jsp" %>

<script type="text/javascript" src="<%=request.getContextPath() %>/scripts/Catalogo.js"></script>
</body>
</html>


