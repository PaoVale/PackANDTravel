<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*, model.*" %>
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

<%
	//Collection<?> listaUtenti = (Collection<?>) request.getAttribute("listaUtenti");
	List<AccountUser> listaUtenti = (List<AccountUser>) request.getAttribute("listaUtenti");
	if(listaUtenti==null){
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/GetUsersListServlet");
	    dispatcher.forward(request, response);
	}
%>

<%@ include file="../common/Header.jsp" %>

<div id= "container">
   <h2>
    Visualizza ordini
  </h2>
  
  <form action="/PackAndTravel/VisualizzaOrdiniAdmin" method="post" >
  		<label for="startDate">Data di inizio:</label> <br>
        <input class="inputField" type="date" id="startDate" name="startDate"><br>
		<br>
        <label for="endDate">Data di fine:</label> <br>
        <input class="inputField" type="date" id="endDate" name="endDate"><br>
        <br>
        <label for="username">Email utente: </label> 
        <select class="inputField" id="utente" name="utente" required>
        	<option value="all">Tutti gli utenti</option>
        	<%if (listaUtenti != null) {
        		for(AccountUser user: listaUtenti) {%>
        		<option value="<%=user.getEmail()%>"><%=user.getEmail()%></option>
        	<%}} %>
        </select>
        <br><br>
        <input type="submit" class="btn btn-primary" value="Cerca">
  </form>
  <br>
  
  <%
    
      List<OrdineBean> ordini = (List<OrdineBean>)request.getAttribute("listOrdine");
    
      if(ordini != null){
  %>
  
  <table id="productTable" border="1" > 
  
  <tr>
    <th>Codice</th>
    <th>Data effettuazione</th>
    <th>Prezzo totale </th>
    <th>Account</th>
        
  </tr>
  <%for(OrdineBean ordine: ordini){ %>
  <tr>
	
      <td><a href="/PackAndTravel/SetCodiceServlet?code=<%=ordine.getCodice()%>"><%=ordine.getCodice()%> </a></td>
      <td><%=ordine.getDataOrdine()%></td>
      <td><%=ordine.getPrezzo()%></td>
      <td> <%=ordine.getEmail() %></td>
     
    </tr>
   <%}}else{ %>
    <tr>
      <td colspan="6">No order available</td>
    </tr>
    
  
  
  <%} %>
  </table>
</div>
<%@ include file="../common/Footer.jsp" %>

</body>
</html>