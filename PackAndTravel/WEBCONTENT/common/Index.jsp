<%@page import="model.*, java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<%
request.setAttribute("categoria", null);
int id = 3;
request.setAttribute("id", id);
Collection<Prodotto> prodotti = (Collection<Prodotto>) request.getAttribute("prodotti");
if (prodotti == null){
	RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/VisualizzaProdottiServlet");
	dispatcher.forward(request, response);	
	return;
}

	 List<Prodotto> prodottiList = new ArrayList<>(prodotti);

     // Step 2: Estrai 9 elementi casuali dalla lista
     List<Prodotto> elementiCasuali = HelperClass.estraiElementiCasuali(prodottiList, 9);

     // Step 3: Crea una nuova lista e salva gli elementi casuali
     List<Prodotto> elementiCasualiSalvati = new ArrayList<>(elementiCasuali);
     
     


%>

<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="ISO-8859-1">
<title>Pack &amp; Travel</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/styles/catalogo.css" type="text/css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
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
    
    <div class="album py-5">
  <div class="container">
    <div class="row">
      <% if (prodotti != null && prodotti.size() != 0) {
    	  Iterator<?> it = elementiCasualiSalvati.iterator();
        
        while (it.hasNext()) {
          Prodotto prodotto = (Prodotto) it.next();
      %>
      <div class="col-md-4">
        <div class="card mb-4 box-shadow">
          <div class="card-body d-flex flex-column align-items-center">
            <%-- <p class="card-text nome"><%=prodotto.getNome()%></p> --%>
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

<%@ include file="Footer.jsp" %>
<script type="text/javascript" src="<%=request.getContextPath() %>/scripts/Catalogo.js"></script>
</body>
</html>