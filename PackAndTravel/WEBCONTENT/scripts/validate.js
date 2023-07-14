/**
 * 
 */

const nameOrLastnamePattern = /^[A-Za-z]+$/;
const emailPattern = /^[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;

const pswdPattern = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()])[0-9a-zA-Z!@#$%^&*()]{8,}$/;
const celPattern = /^\d{10}$/;

const nameErrorMessage = "Un nome valido deve contenere solo lettere";
const lastnameErrorMessage = "Un cognome valido deve contenere solo lettere";
const emailErrorMessage = "Una email valida deve essere nella forma username@domain.ext";
const mismatchPSWD = "Password e conferma password non corrispondono";
const pswdMessage = "La password deve avere almeno 8 caratteri, almeno una lettera minuscola, una maiuscola, un numero e un carattere speciale"
const celMessage="Numero di telefono non valido";

function validateFormElem(formElem, pattern, span, message) {
  if (formElem.value.match(pattern)) {
    formElem.classList.remove("error");
    span.style.color = "black";
    span.innerHTML = "";
    return true;
  }
  formElem.classList.add("error");
  span.innerHTML = message;
  span.style.color = "#c42b2d";
  return false;
}

function validateNome() {
  let valid = true;
  let form = document.getElementById("regForm");

  let spanName = document.getElementById("errorName");
  if (!validateFormElem(form.nome, nameOrLastnamePattern, spanName, nameErrorMessage))
    valid = false;


  return valid;
}

function validateCognome() {
  let valid = true;
  let form = document.getElementById("regForm");

  let spanName = document.getElementById("errorLastname");
  if (!validateFormElem(form.cognome, nameOrLastnamePattern, spanName, lastnameErrorMessage))
    valid = false;


  return valid;
}


function validateEmail() {
  let valid = true;
  let form = document.getElementById("regForm");

  let spanEmail = document.getElementById("errorEmail");
  if (!validateFormElem(form.email, emailPattern, spanEmail, emailErrorMessage))
    valid = false;
  
  return valid;
}

function pswMatching() {

  let form = document.getElementById("regForm");

  let spanPswd = document.getElementById("matchError");

  let psw1 = form.password.value;
  let psw2 = form.ConfermaPassword.value;


  if (psw1 != psw2) {
    spanPswd.classList.add("error");
    spanPswd.innerHTML = mismatchPSWD;
    spanPswd.style.color = "#c42b2d";
    return false;
  }

  spanPswd.classList.remove("error");
  spanPswd.style.color = "black";
  spanPswd.innerHTML = "";
  return true;

}

function validatePassword() {
  // La password deve avere almeno 8 caratteri
  // Deve contenere almeno una lettera minuscola, una maiuscola, un numero e un carattere speciale
  // Esempio di caratteri speciali: !@#$%^&*()

  let form = document.getElementById("regForm");

  let spanPswd = document.getElementById("errorpswd");

  let psw1 = form.password.value;


  if (psw1.match(pswdPattern)) {
    spanPswd.classList.remove("error");
    spanPswd.style.color = "black";
    spanPswd.innerHTML = "";
    return true;
  }

  spanPswd.classList.add("error");
  spanPswd.innerHTML = pswdMessage;
  spanPswd.style.color = "#c42b2d";
  return false; 

}


function validateCellulare() {
  let valid = true;
  let form = document.getElementById("regForm");

  let spanCellulare = document.getElementById("errorCellulare");
  if (!validateFormElem(form.cellulare, celPattern, spanCellulare, celMessage))
    valid = false;

  return valid;
}




function checkSignup(obj) {
  let check = true;
  if (!validateNome()) check = false;
  if (!validateCognome()) check = false;
  if (!validateEmail()) check = false;
  if (!pswMatching()) check = false;
  if (!validatePassword()) check = false;
  if (!validateCellulare()) check = false;

  if (check) obj.submit();
}

function checkModifica(obj){
	let check=true;
	let form = document.getElementById("regForm");
	if (form.password.value!="" && !pswMatching()) check = false;
	if (form.password.value!="" && !validatePassword()) check = false;
	if(form.cellulare.value!="" && !validateCellulare()) check = false;
	if(form.password.value=="" && form.cellulare.value=="" && form.indirizzo.value=="") check=false;
	
	if (check) obj.submit();
	
}


function checkModificaProdotto(form) {
  // Ottenere i valori dei campi del modulo
  
  var nome = form.nome.value;
  var descrizione = form.descrizione.value;
  var categoria = form.categoria.value;
  var prezzo = form.prezzo.value;
  var immagine = form.immagine.value;

  // Verificare se tutti i campi sono vuoti
  if (
    
    nome === "" &&
    descrizione === "" &&
    categoria === "" &&
    prezzo === "" &&
    immagine === ""
  ) {
    return false; // Impedire l'invio del modulo
  }

  // Se la validazione è passata, consentire l'invio del modulo
  return true;
}
