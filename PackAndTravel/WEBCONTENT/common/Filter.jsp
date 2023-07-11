<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/styles/Filter.css">
<script src="<%=request.getContextPath()%>/scripts/Filter.js"></script>
</head>
<body>
  <form>
    <div class="container">
      <div class="filter">
        <label for="color">Colore:</label> <span class="filter-expand"
          data-filter-id="colorOptions"
          onclick="toggleFilterOptions('colorOptions')"></span>
        <div id="colorOptions" class="filter-options">
          <input type="radio" id="arancione" name="color" value="arancione">
          <label for="arancione">Arancione</label><br> <input
            type="radio" id="beige" name="color" value="beige"> <label
            for="beige">Beige</label><br> <input type="radio" id="bianco"
            name="color" value="bianco"> <label for="bianco">Bianco</label><br>
          <input type="radio" id="blu" name="color" value="blu"> <label
            for="blu">Blu</label><br> <input type="radio" id="giallo"
            name="color" value="giallo"> <label for="giallo">Giallo</label><br>
          <input type="radio" id="grigio" name="color" value="grigio">
          <label for="grigio">Grigio</label><br> <input type="radio"
            id="marrone" name="color" value="marrone"> <label
            for="marrone">Marrone</label><br> <input type="radio"
            id="nero" name="color" value="nero"> <label for="nero">Nero</label><br>
          <input type="radio" id="rosa" name="color" value="rosa"> <label
            for="rosa">Rosa</label><br> <input type="radio" id="rosso"
            name="color" value="rosso"> <label for="rosso">Rosso</label><br>
          <input type="radio" id="verde" name="color" value="verde">
          <label for="verde">Verde</label><br> <input type="radio"
            id="verde-acqua" name="color" value="verde-acqua"> <label
            for="verde-acqua">Verde acqua</label><br> <input type="radio"
            id="viola" name="color" value="viola"> <label for="viola">Viola</label><br>
        </div>
      </div>

      <div class="filter">
        <label for="price">Prezzo:</label> <span class="filter-expand"
          data-filter-id="priceOptions"
          onclick="toggleFilterOptions('priceOptions')"></span>
        <div id="priceOptions" class="filter-options">
          <input type="radio" id="price-0-50" name="price" value="0-50">
          <label for="price-0-50">0-50&euro;</label><br> <input
            type="radio" id="price-50-100" name="price" value="50-100">
          <label for="price-50-100">50-100&euro;</label><br> <input
            type="radio" id="price-100-plus" name="price" value="100-plus">
          <label for="price-100-plus">100&euro;+</label><br>
        </div>
      </div>


      <div class="filter">
        <label for="order">Ordina per:</label> <span class="filter-expand"
          data-filter-id="orderOptions"
          onclick="toggleFilterOptions('orderOptions')"></span>
        <div id="orderOptions" class="filter-options">
          <input type="radio" id="order-crescente" name="ordina-per"
            value="crescente"> <label for="ordina-per">Prezzo
            crescente</label><br> <input type="radio" id="order-decrescente"
            name="ordina-per" value="decrescente"> <label
            for="ordina-per">Prezzo decrescente</label><br>
        </div>
      </div>
      <button type="submit" class="btn-cerca">Cerca</button>

    </div>

  </form>


</body>
</html>