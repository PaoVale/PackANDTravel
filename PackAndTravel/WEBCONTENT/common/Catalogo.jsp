<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
import="model.Prodotto, model.ProdottoDAO, java.util.*" pageEncoding="ISO-8859-1" 
%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="ISO-8859-1">

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


</head>
<body>

<%@ include file="Header.jsp" %>

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
	<%-- <%@ include file="Filter.jsp" %> --%>
      
      
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
            <%-- <p class="card-text nome"><%=prodotto.getNome()%></p> --%>
            <a href="<%=request.getContextPath()%>/common/DettaglioProdotto.jsp?code=<%=prodotto.getCodice()%>" class="card-text nome"><%=prodotto.getNome()%>
            <img class="card-img-top img" src="<%=request.getContextPath()%>/getPicture?codice=<%=prodotto.getCodice()%>" alt="immagine prodotto"></a>
            <div class="d-flex justify-content-center flex-column ">
 				 <p class="text-center prezzo"><%=prodotto.getPrezzo()%>&euro;</p>
 				<a href="#" class="btn btn-info btn-block aggiungiAlCarrello" data-id="<%=prodotto.getCodice()%>">Aggiungi al carrello</a>


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


