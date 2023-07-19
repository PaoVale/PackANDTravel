<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.Prodotto, model.ProdottoDAO, java.util.*"%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="ISO-8859-1">
<title>Pack&amp;Travel</title>

<link rel="stylesheet" href="<%=request.getContextPath() %>/styles/DettaglioProdotto.css" type="text/css">
	
</head>
<body>
	<%@ include file="Header.jsp" %>


<%
	
	
	Prodotto prodotto = (Prodotto) request.getAttribute("prodotto");
	
	int code = Integer.parseInt(request.getParameter("code"));
	request.setAttribute("code", code);
	
	
	if (prodotto == null) {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/DettaglioProdottoServlet");
		dispatcher.forward(request, response);
		return;
	}
	
	%>
	<div class="container">
	
  <div class="left-div">
    <img src="<%=request.getContextPath()%>/getPicture?codice=<%=prodotto.getCodice() %>" alt="immagine prodotto" width=500px height=auto>
  </div>
  <div class="right-div">
  
 
  
  	<h5><%=prodotto.getCodice()%></h5>
    <h2><%=prodotto.getNome()%></h2>
    <p><%=prodotto.getDescrizione()%></p>
    <h2><%=prodotto.getPrezzo()%></h2>
    <a id="icon" ><i class="fas fa-heart" ></i></a>
    
    <br><br>
    <button class="button_style"> Aggiungi al carrello </button>
  </div>
  
</div>

	<%@ include file="Footer.jsp" %>
</body>
</html>