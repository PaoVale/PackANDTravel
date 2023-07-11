<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Area Personale</title>
 <style>
    /* Stile CSS per la pagina */
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 20px;
    }

    h1 {
      margin-bottom: 20px;
    }

    .user-info {
      background-color: #f5f5f5;
      padding: 20px;
      border-radius: 5px;
      margin-bottom: 20px;
    }

    .user-info h2 {
      margin-top: 0;
    }

    .user-info p {
      margin-bottom: 10px;
    }

    .user-info strong {
      font-weight: bold;
    }

    .btn-modify {
      margin-right: 10px;
    }

    .input-container {
      display: flex;
      flex-direction: column;
      margin-bottom: 10px;
    }

    .input-container input[type="password"] {
      margin-bottom: 5px;
    }
  </style>
</head>
<body>
  <h1>Il mio account</h1>

  <div class="user-info">
    <h2>I miei dati</h2>
    <p><strong>Email:</strong> </p>
    <p><strong>Nome:</strong> </p>
    <p><strong>Cognome:</strong> </p>
    <p><strong>Indirizzo:</strong> </p>
    <p><strong>Cellulare:</strong> </p>
    
   <button class="btn-modify" onclick="openPasswordFields()">Modifica Password</button>
    <div id="passwordFieldsContainer"></div>
  <br> 
    <button class="btn-modify" onclick="modifyAddress()">Modifica Indirizzo</button> <br> <br>
    <button class="btn-modify" onclick="modifyPhoneNumber()">Modifica Cellulare</button>
    </div>
    <!-- Aggiungi altre informazioni dell'utente che desideri visualizzare -->
  

  <!-- Aggiungi altre sezioni o informazioni personali dell'utente a tuo piacimento -->
<script>
function openPasswordFields() {
    var passwordFieldsContainer = document.getElementById("passwordFieldsContainer");

    // Crea i campi di input per la nuova password e la conferma
    var newPasswordInput = document.createElement("input");
    newPasswordInput.type = "password";
    newPasswordInput.placeholder = "Nuova password";
    newPasswordInput.className = "input-container";

    var confirmPasswordInput = document.createElement("input");
    confirmPasswordInput.type = "password";
    confirmPasswordInput.placeholder = "Conferma password";
    confirmPasswordInput.className = "input-container";

    // Aggiungi i campi di input al contenitore
    passwordFieldsContainer.innerHTML = "";
    passwordFieldsContainer.appendChild(newPasswordInput);
    passwordFieldsContainer.appendChild(confirmPasswordInput);
  }
</script>


</body>


</html>
