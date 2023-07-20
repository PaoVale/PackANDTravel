<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script src="<%=request.getContextPath()%>/scripts/validate.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/styles/Checkout.css" type="text/css">
    <meta charset="UTF-8">
    
    <title>Checkout</title>
        
</head>
<%

	AccountUser user = (AccountUser)session.getAttribute("auth");
	if(user != null){

	
%>

<body>
   <%@ include file="Header.jsp" %>
   	<%String email= auth.getEmail(); 
String nome=auth.getName();
String cognome=auth.getSurname();
String indirizzo=auth.getAddress();
String cellulare=auth.getNumber();
%>
        <h1 id="titolo">Checkout</h1>
    
    <div class="container">
    <div class="user-info">
		<h2>Informazioni di spedizione</h2>
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
      <div class="form">
       <form action="/PackAndTravel/CheckoutServlet" method="post" id="checkoutForm" onsubmit="event.preventDefault();checkCheckout(this)" >
            <h3>Procedi al pagamento</h3><br>
        <div>
         <label for="cardNumber">Numero di carta:</label>
         <input class="inputField" type="text" id="cardNumber" name="cardNumber" required onChange="return validateNumCarta()"  onInput="return validateNumCarta()"> <span id="cardNumberError" ></span>
		</div>
		<br>
		<div>
         <label for="expirationDate">Data di scadenza:</label>
         <input class="js-iframe-input date-field input-field" id="expirationDate" name="expirationDate" type="tel" placeholder="MM/YY"   maxlength="5" onChange="return validateScadenzaCarta()" onInput="return validateScadenzaCarta()" > <span id="expiryError"></span>
        </div><br>
		<div>
         <label for="cvv">CVV:</label>
         <input class="inputField" type="text" id="cvv" name="cvv" required onChange="return validateCVV()" onInput="return validateCVV()"> <span id="CVVError"></span>
		</div>
		<br>
		<div>
        </a> <input type="submit"  class="checkout-button" value="Conferma ordine">
        </div>
        <br>
       </form>
       </div>
        <%}else{ 
			String path = request.getContextPath();
			response.sendRedirect(path + "/common/Login.jsp");
				return ;
		}
			%>
    </div>
    
    <%@ include file="/common/Footer.jsp" %>





</body>
</html>

