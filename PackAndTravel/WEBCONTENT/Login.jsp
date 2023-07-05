<%@page import="model.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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
<title>Accesso - Pack &amp; Travel</title>
<link rel="stylesheet" href="styles/Login.css">


</head>
<body>


	<main>
		<section class="login-section">
			<h2>Log in</h2>
			<form method="post" action="user-login" id="formLogin">
				<div class="form-group">
					<label for="email">Email:</label> <input type="email" id="email"
						name="email" required>
				</div>
				<div class="form-group">
					<label for="password">Password:</label> <input type="password"
						id="password" name="password" required>
				</div>
				

				
				<%
				Boolean accessoNegato = (Boolean) session.getAttribute("accessoNegato");
				if (accessoNegato != null && accessoNegato) {
				%>
				
				<p id="errorLogin">Login errato, riprova.</p>
				<%
				// Resetta l'attributo nella sessione
				session.setAttribute("accessoNegato", false);
				//session.removeAttribute("accessoNegato");
				}
				%>

				<button type="submit" onclick="errorLogin()">Accedi</button>
			</form>
			<!-- <p id="errorLogin"></p>
			 <script type="text/javascript" src="scripts/ErrorLogin.js"></script> -->
			<br> Non sei registrato? <a href="Registrati.jsp">Iscriviti!</a>
		</section>
	</main>

	<hr>
	<hr>
	<footer>

		<%@ include file="Footer.jsp"%>
	</footer>
</body>
</html>
