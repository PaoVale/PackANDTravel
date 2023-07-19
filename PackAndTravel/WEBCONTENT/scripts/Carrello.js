var quantita = 0;

function increaseQuantity(elementId) {
    var quantityElement = document.getElementById(elementId);
    var currentQuantity = parseInt(quantityElement.innerText);
    quantityElement.innerText = currentQuantity + 1;
}

function decreaseQuantity(elementId) {
    var quantityElement = document.getElementById(elementId);
    var currentQuantity = parseInt(quantityElement.innerText);
    if (currentQuantity > 1) {
        quantityElement.innerText = currentQuantity - 1;
    }
}
document.addEventListener("DOMContentLoaded", function() {
  // Codice JavaScript per gestire il clic sul pulsante "Aggiungi al carrello"
  function aggiungiAlCarrello(event) {
	 
    var pulsante = event.target; // Ottieni il pulsante cliccato
   var quantityElement = pulsante.parentNode.querySelector(".quantity-value");
    quantita = parseInt(quantityElement.innerText); // Aggiorna il valore della variabile 'quantita'

    // Ottieni l'ID del prodotto dal pulsante (attributo data-id)
    var prodottoId = pulsante.dataset.id;

    // Crea un oggetto XMLHttpRequest per la richiesta AJAX
    var xhr = new XMLHttpRequest();

    // Imposta il gestore degli eventi per la risposta della richiesta
    xhr.onreadystatechange = function() {
      if (xhr.readyState === 4) {
        // La richiesta è stata completata, puoi gestire la risposta qui
        if (xhr.status === 200) {
          // La servlet ha risposto con successo
   		  prezzo = parseFloat(document.getElementById('prezzoProdotto'+prodottoId).innerHTML);
          document.getElementById('total'+prodottoId).innerHTML= (prezzo*quantita).toFixed(2); 
          console.log("Prodotto aggiunto al carrello con successo.");
        } else {
          // La servlet ha risposto con un errore
          console.error("Errore durante l'aggiunta del prodotto al carrello.");
        }
      }
    };

    // Prepara i dati da inviare alla servlet (ad esempio, l'ID del prodotto e l'action "add")
    var dati = "idProdotto=" + encodeURIComponent(prodottoId);
    dati += "&action=add"; // Aggiungi il parametro "action" con valore "add"

    // Invia la richiesta POST alla servlet
    xhr.open("POST", "/PackAndTravel/CarrelloServlet", true); // Sostituisci "NomeServlet" con il nome effettivo della tua servlet
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send(dati);
    
  }



  // Codice JavaScript per gestire il clic sul pulsante "Elimina dal carrello"
  function DecrementaDalCarrello(event) {
    var pulsante = event.target; // Ottieni il pulsante cliccato
var quantityElement = pulsante.parentNode.querySelector(".quantity-value");
    quantita = parseInt(quantityElement.innerText); // Aggiorna il valore della variabile 'quantita'   

    // Ottieni l'ID del prodotto dal pulsante (attributo data-id)
    var prodottoId = pulsante.dataset.id;

    // Crea un oggetto XMLHttpRequest per la richiesta AJAX
    var xhr = new XMLHttpRequest();

    // Imposta il gestore degli eventi per la risposta della richiesta
    xhr.onreadystatechange = function() {
      if (xhr.readyState === 4) {
        // La richiesta è stata completata, puoi gestire la risposta qui
        if (xhr.status === 200) {
          // La servlet ha risposto con successo
          prezzo = parseFloat(document.getElementById('prezzoProdotto'+prodottoId).innerHTML);
          document.getElementById('total'+prodottoId).innerHTML= (prezzo*quantita).toFixed(2); 
          console.log("Prodotto decrementato dal carrello con successo.");
        } else {
          // La servlet ha risposto con un errore
          console.error("Errore durante il decremento del prodotto al carrello.");
        }
      }
    };

    // Prepara i dati da inviare alla servlet (ad esempio, l'ID del prodotto e l'action "add")
    var dati = "idProdotto=" + encodeURIComponent(prodottoId);
    dati += "&action=delete"; // Aggiungi il parametro "action" con valore "delete"

    // Invia la richiesta POST alla servlet
    xhr.open("POST", "/PackAndTravel/CarrelloServlet", true); // Sostituisci "NomeServlet" con il nome effettivo della tua servlet
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send(dati);
  }


  // Seleziona tutti gli elementi con la classe "increase-quantity" e aggiungi un gestore di eventi a ciascuno
  var pulsantiIncrease = document.getElementsByClassName("increase-quantity");
  for (var i = 0; i < pulsantiIncrease.length; i++) {
    pulsantiIncrease[i].addEventListener("click", function(event) {
      var quantityElement = event.target.parentNode.querySelector(".quantity-value");
      var currentQuantity = parseInt(quantityElement.innerText);
      quantityElement.innerText = currentQuantity + 1;

      aggiungiAlCarrello(event); // Chiamata alla funzione per aggiungere al carrello
    });
   
  }

  // Seleziona tutti gli elementi con la classe "decrease-quantity" e aggiungi un gestore di eventi a ciascuno
  var pulsantiDecrease = document.getElementsByClassName("decrease-quantity");
  for (var i = 0; i < pulsantiDecrease.length; i++) {
    pulsantiDecrease[i].addEventListener("click", function(event) {
      var quantityElement = event.target.parentNode.querySelector(".quantity-value");
      var currentQuantity = parseInt(quantityElement.innerText);
      if (currentQuantity > 1) {
        quantityElement.innerText = currentQuantity - 1;
      }
      DecrementaDalCarrello(event);
    });
  }
});


