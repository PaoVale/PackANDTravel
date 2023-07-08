<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Filter novit&agrave;</title>
</head>
<body>


      <div class="filter-bar">
         <h3>Categorie</h3>
         <ul class="filter-list">
            <li>
                <label><input type="checkbox" name="categoria" value="Accessori"> Accessori</label>
            </li>
            <li>
                <label><input type="checkbox" name="categoria" value="Borsone"> Borsone</label>
            </li>
            <li>
                <label><input type="checkbox" name="categoria" value="Valigia"> Valigia</label>
            </li>
            <li>
                <label><input type="checkbox" name="categoria" value="Zaino"> Zaino</label>
            </li>
         </ul>
         
         <h3>Colori</h3>
         <ul class="filter-list">
            <li>
                <label><input type="checkbox" name="colore" value="Bianco"> Bianco</label>
            </li>
            <li>
                <label><input type="checkbox" name="colore" value="Nero"> Nero</label>
            </li>
            <li>
                <label><input type="checkbox" name="colore" value="Grigio"> Grigio</label>
            </li>
            <li>
                <label><input type="checkbox" name="colore" value="verde acqua"> Verde acqua</label>
            </li>
            <li>
                <label><input type="checkbox" name="colore" value="Marrone"> Marrone</label>
            </li>
            <li>
                <label><input type="checkbox" name="colore" value="Beige"> Beige</label>
            </li>
            <li>
                <label><input type="checkbox" name="colore" value="Rosso"> Rosso</label>
            </li>
            <li>
                <label><input type="checkbox" name="colore" value="Blu"> Blu</label>
            </li>
            <li>
                <label><input type="checkbox" name="colore" value="Verde"> Verde</label>
            </li>
            <li>
                <label><input type="checkbox" name="colore" value="Giallo"> Giallo</label>
            </li>
            <li>
                <label><input type="checkbox" name="colore" value="Arancione"> Arancione</label>
            </li>
            <li>
                <label><input type="checkbox" name="colore" value="Viola"> Viola</label>
            </li>
            <li>
                <label><input type="checkbox" name="colore" value="Rosa"> Rosa</label>
            </li>
         </ul>
         
      <h3>Prezzo</h3>
      <ul class="filter-list">
      	<li>
      		<label><input type="radio" name="prezzo" value="0-50"> 0-50&euro;</label>
      	</li>
      	<li>
      		<label><input type="radio" name="prezzo" value="50-100"> 50-100&euro;</label>
      	</li>
      	<li>
      		<label><input type="radio" name="prezzo" value="100+"> 100&euro;+</label>
      	</li>
      </ul>
      </div>
      

</body>
</html>