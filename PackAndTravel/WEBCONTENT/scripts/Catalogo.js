document.addEventListener("DOMContentLoaded", function() {
  // Codice JavaScript per gestire il clic sul pulsante "Aggiungi al carrello"
  function aggiungiAlCarrello(event) {
    var pulsante = event.target; // Ottieni il pulsante cliccato
    // Disabilita il pulsante dopo il clic per evitare clic multipli
    pulsante.disabled = true;
    // Cambia il testo del pulsante in "Aggiunto al carrello"
    pulsante.innerText = "Aggiunto al carrello";

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

  // Seleziona tutti gli elementi con la classe "aggiungiAlCarrello" e aggiungi un gestore di eventi a ciascuno
  var pulsantiAggiungi = document.getElementsByClassName("aggiungiAlCarrello");
  for (var i = 0; i < pulsantiAggiungi.length; i++) {
    pulsantiAggiungi[i].addEventListener("click", aggiungiAlCarrello);
  }
});
