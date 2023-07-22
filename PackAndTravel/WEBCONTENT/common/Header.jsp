<%@page import="model.*" %>
<%@page import="control.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%
	AccountUser auth = (AccountUser) request.getSession().getAttribute("auth") ;
	if(auth!=null){
		request.setAttribute("auth",auth);
	}
%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="ISO-8859-1">
<title>Pack &amp; Travel</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/styles/Header.css" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath() %>/scripts/Header.js"></script>
</head>
<body>
<header class="header">
   <div class="logo">
   
      <a href="<%=request.getContextPath() %>/common/Index.jsp"><img src="<%=request.getContextPath() %>/images/logo-removebg-preview.png" alt="Logo"> </a>
      <div class="icons">
            <!-- TODO aggiungi tooltips alle icone -->     
         <% if(auth != null){ %>
         
         	
         	<a href="<%=request.getContextPath()%>/common/AreaUtente.jsp" title="I miei dati"><i class="fas fa-user"></i></a>
         <%} %>
         
         <a href="<%=request.getContextPath()%>/common/Carrello.jsp"><i class="fas fa-shopping-cart" title="Carrello"></i></a> <!-- Icona per il carrello -->
        
         <% 
         	if(auth != null){ %>
         	
         	<% if(auth.isAdmin()){ %>
         <a href="#" onclick="toggleDropdown()" title="Area riservata"><i class="fas fa-cog"></i></a>
         <div id="dropdownMenu" class="dropdown-content">
           <a href="<%=request.getContextPath()%>/admin/ProductView.jsp">Gestione Prodotti</a>
           <a href="<%=request.getContextPath()%>/admin/GestioneOrdini.jsp">Gestione Ordini</a>
         </div>
         
         <%} %>
         	<a href="/PackAndTravel/LogoutServlet" title="Logout"><i class="fas fa-sign-out-alt"></i></a> 
         <%} else{%>
         
         	<a href="<%=request.getContextPath()%>/common/Login.jsp" title="Login"><i class="fas fa-user"></i></a>
         	
         <%} %>
         	
         
         
      </div>
   </div>
</header>

<nav class="navigation">
   <a href="<%=request.getContextPath() %>/common/Catalogo.jsp?categoria=valigia">Valigie</a>
   <a href="<%=request.getContextPath() %>//common/Catalogo.jsp?categoria=zaino">Zaini</a>
   <a href="<%=request.getContextPath() %>/common/Catalogo.jsp?categoria=accessorio">Accessori</a>
   <a href="<%=request.getContextPath() %>/common/Catalogo.jsp?categoria=borsone">Borsoni</a>
</nav>

</body>
</html>