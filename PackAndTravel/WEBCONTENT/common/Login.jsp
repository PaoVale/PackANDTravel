<%@page import="model.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="errorPage.jsp"%>

<%-- <%
	AccountUser auth = (AccountUser) request.getSession().getAttribute("auth") ;
	if(auth!=null){
		request.setAttribute("auth",auth);
	}
%> --%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Accesso - Pack &amp; Travel</title>

<link rel="stylesheet" href="<%=request.getContextPath() %>/styles/Login.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>

<body>
<section id="homeIcons">
	<a href="<%=request.getContextPath() %>/common/Index.jsp"><i class="fa fa-home" ></i> </a>
</section>

	
	<main>
	
	<% 
    String error = (String)request.getAttribute("error");
    if(error == null)
      error="";
  
  %>
  
    <section class="loginSection">      
		<section class="login-section">
			<h2>Log in</h2>
			<form method="post" action="/PackAndTravel/LoginServlet" id="formLogin">
				<div class="form-group">
					<label for="email">Email:</label> <input type="email" id="email"
						name="email" required>
				</div>
				<div class="form-group">
					<label for="password">Password:</label> <input type="password"
						id="password" name="password" required>
				</div>
				
			<p  style="color:red "> <%=error %> </p>
				
				

				<button type="submit" onclick="errorLogin()">Accedi</button>
			</form>
			<br> Non sei registrato? <a href="<%=request.getContextPath() %>/common/Registrati.jsp">Iscriviti!</a>
		</section>
		</section>
	</main>

	<hr>
	<hr>
	<footer>

		<%@ include file="Footer.jsp"%>
	</footer>
</body>
</html>