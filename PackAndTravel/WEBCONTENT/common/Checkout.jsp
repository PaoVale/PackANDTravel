<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    
    <title>Checkout</title>
    <style>
        /* Stile generale */
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }
        /* Header */
        header {
            background-color: #333;
            color: #fff;
            padding: 1rem;
            text-align: center;
        }
        header h1 {
            margin: 0;
        }
        /* Contenitore principale */
        .container {
            max-width: 800px;
            margin: 2rem auto;
            background-color: #fff;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            padding: 1rem;
            border-radius: 4px;
        }
        /* Form */
        form {
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 1rem;
        }
        label {
            font-weight: bold;
        }
        input[type="text"],
        input[type="email"],
        input[type="tel"],
        select {
            width: 100%;
            padding: 0.5rem;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        /* Dettagli dell'ordine */
        .order-details {
            margin-top: 1rem;
            border-top: 1px solid #ccc;
            padding-top: 1rem;
        }
        .order-details h2 {
            margin-top: 0;
        }
        /* Pulsante di checkout */
        .checkout-button {
            margin-top: 1rem;
            display: block;
            width: 100%;
            background-color: #333;
            color: #fff;
            padding: 1rem;
            text-align: center;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 1rem;
        }
        .checkout-button:hover {
            background-color: #555;
        }
    </style>
</head>
<body>
   <%@ include file="Header.jsp" %>
        <h1>Checkout</h1>
    
    <div class="container">
    <div class="user-info">
		<h2>Informazioni di spedizione</h2>
		<p>
			<strong>Email:</strong> <span id="email"></span>
		</p>

		<p>
			<strong>Nome:</strong> <span id="nome"></span>
		</p>
		<p>
			<strong>Cognome:</strong> <span id="cognome"></span>
		</p>
		<p>
			<strong>Indirizzo:</strong> <span id="indirizzo"></span>
		</p>
		<p>
			<strong>Cellulare:</strong> <span id="cellulare"></span>
		</p>




	</div>
        <form>
            <h3>Procedi al pagamento</h3><br>
        <div>
        <label for="cardNumber">Numero di carta:</label>
        <input class="inputField" type="text" id="cardNumber" name="cardNumber" required onChange="return validateNumCarta()"> <span id="cardNumberError"></span><br>
		</div><br>
	<div>
        <label for="expirationDate">Data di scadenza:</label>
        <input class="js-iframe-input date-field input-field" id="encryptedExpiryDate" type="tel" placeholder="MM/YY"   maxlength="5" >
        <!-- <input class="inputField" type="month" id="expirationDate" name="expirationDate" required onChange="return validateScadenzaCarta()"> <span id="expiryError"></span><br> -->
	</div><br>
	<div>
        <label for="cvv">CVV:</label>
        <input class="inputField" type="text" id="cvv" name="cvv" required onChange="return validateCVV()"> <span id="CVVError"></span>
	</div><br>
	<div>
        <input type="submit" class="btn btn-primary"value="Conferma Ordine">
        </div><br>
        </form>
        <div class="order-details">
            <h2>Dettagli dell'ordine</h2>
            <!-- Inserisci qui i dettagli dell'ordine, come elenco di prodotti, importo totale, etc. -->
        </div>
        <button class="checkout-button">Procedi al pagamento</button>
    </div>
    <%@ include file="/common/Footer.jsp" %>
    <script>
document.getElementById('encryptedExpiryDate').addEventListener('input', function (e) {
  var input = e.target.value;
  if (input.length === 2 && !input.includes('/')) {
    e.target.value = input + '/';
  }
});
</script>
</body>
</html>

