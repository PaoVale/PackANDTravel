<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="errorPage.jsp" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Registrazione - Pack &amp; Travel</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/styles/Registrati.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/validate.js"></script>
	<script src="<%=request.getContextPath() %>/scripts/ajax.js"></script>
</head>
<body>
<section id="homeIcons">
	<a href="<%=request.getContextPath() %>/common/Index.jsp"><i class="fa fa-home" ></i> </a>
</section>
<section class="registratiSection"></section>


<br>
    
    <% 
    String error = (String)request.getAttribute("error");
    if(error == null)
      error="";
  
    %>
<p  style="color:red "> <%=error %> </p>

    <div class="container">
        <h1>Registrazione</h1>
        <form id="regForm" action="/PackAndTravel/RegistratiServlet" method="post" onsubmit="event.preventDefault();checkSignup(this)">
        <!-- <input type="hidden" name="action" value="insert"> -->
           
            <div class="form-group">
                <label for="email">*Email:</label>
                <input type="email" id="email" name="email" required onBlur="return validateEmail()" onChange="return tryEmail()"><span id="errorEmail"></span><span id="emailCheckDisponibility"></span>
            </div>
            <div class="form-group">
                <label for="password">*Password:</label>
                <input type="password" id="password" name="password" required onChange="return validatePassword()" onInput="return validatePassword()"><span id="errorpswd"></span>
            </div>
            <div class="form-group">
                <label for="ConfermaPassword">*Conferma password:</label>
                <input type="password" id="ConfermaPassword" name="ConfermaPassword" required onChange="return pswMatching()" onInput="return pswMatching()"><span id="matchError"></span>
            </div>
             <div class="form-group">
                <label for="nome">*Nome:</label>
                <input type="text" id="nome" name="nome" required><span id="errorName" onChange="return validateNome()"></span>
            </div>
             <div class="form-group">
                <label for="cognome">*Cognome:</label>
                <input type="text" id="cognome" name="cognome" required onChange="return validateCognome()"><span id="errorLastname"></span>
            </div>
             <div class="form-group">
                <label for="indirizzo">*Indirizzo:</label>
                <input type="text" id="indirizzo" name="indirizzo" required>
            </div>
            <div>
            	<div class="form-group">
                <label for="cellulare">*Cellulare:</label>
                <input type="text" id="cellulare" name="cellulare" required onChange="return validateCellulare()"><span id="errorCellulare"></span>
            </div>
            
            </div>
           <a> <button type="submit" onclick="tryEmail()">Registrati</button></a>
           <p>*I campi sono obbligatori</p>
        </form>
    </div>
</body>
</html>
