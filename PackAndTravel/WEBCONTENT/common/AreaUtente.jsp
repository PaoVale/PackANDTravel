<%@ page language="java" errorPage="errorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Area Personale</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/styles/AreaUtente.css">
<script type="text/javascript"
	src="<%=request.getContextPath() %>/scripts/AreaUtente.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath() %>/scripts/validate.js"></script>


</head>
<body>
	<%@ include file="Header.jsp"%>
	<h1>Il mio account</h1>
	<%String email= auth.getEmail(); 
String nome=auth.getName();
String cognome=auth.getSurname();
String indirizzo=auth.getAddress();
String cellulare=auth.getNumber();
%>
	<div class="user-info">
		<h2>I miei dati</h2>
		<p>
			<strong>Email:</strong> <span id="email"><%= email %></span>
		</p>

		<p>
			<strong>Nome:</strong> <span id="nome"><%= nome %></span>
		</p>
		<p>
			<strong>Cognome:</strong> <span id="cognome"><%= cognome %></span>
		</p>
		<p>
			<strong>Indirizzo:</strong> <span id="indirizzo"><%= indirizzo %></span>
		</p>
		<p>
			<strong>Cellulare:</strong> <span id="cellulare"><%= cellulare %></span>
		</p>




	</div>
	<form id="regForm" method="post" action="/PackAndTravel/ModificaDatiServlet" onsubmit="event.preventDefault();checkModifica(this)">
		<fieldset>
			<legend>Modifica Dati</legend>
				<p>Modifica password:</p>
                <input type="password" id="password" name="password" placeholder="Nuova password" onChange="return validatePassword()" onInput="return validatePassword()">
                <br>
                <span id="errorpswd"></span>
     			<br><br>
                <input type="password" id="ConfermaPassword" name="ConfermaPassword" placeholder="Conferma password" onChange="return pswMatching()" onInput="return pswMatching()">
                <br>
                <span id="matchError"></span>
            
				
				
				<p>Modifica indirizzo:</p>
				<input type="text"> <br>
				<p>Modifica cellulare:</p>
				<input type="text" id="cellulare" name="cellulare" onInput="return validateCellulare()" onChange="return validateCellulare()"> 
				<br>
				<span id="errorCellulare"></span> <br> <br>

				<button type="submit" >Modifica dati</button>
		</fieldset>
	</form>
</body>
<br>
<%@ include file="Footer.jsp"%>

</html>
