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

	<div class="container">
		<div class="filter">
			<label for="color">Colore:</label> <span class="filter-expand"
				data-filter-id="colorOptions"
				onclick="toggleFilterOptions('colorOptions')"></span>
			<div id="colorOptions" class="filter-options">
				<input type="checkbox" id="arancione" name="color" value="arancione">
				<label for="arancione">Arancione</label><br> <input
					type="checkbox" id="beige" name="color" value="beige"> <label
					for="beige">Beige</label><br> <input type="checkbox"
					id="bianco" name="color" value="bianco"> <label
					for="bianco">Bianco</label><br> <input type="checkbox"
					id="blu" name="color" value="blu"> <label for="blu">Blu</label><br>

				<input type="checkbox" id="giallo" name="color" value="giallo">
				<label for="giallo">Giallo</label><br> <input type="checkbox"
					id="grigio" name="color" value="grigio"> <label
					for="grigio">Grigio</label><br> <input type="checkbox"
					id="marrone" name="color" value="marrone"> <label
					for="marrone">Marrone</label><br> <input type="checkbox"
					id="nero" name="color" value="nero"> <label for="nero">Nero</label><br>

				<input type="checkbox" id="rosa" name="color" value="rosa">
				<label for="rosa">Rosa</label><br> <input type="checkbox"
					id="rosso" name="color" value="rosso"> <label for="rosso">Rosso</label><br>

				<input type="checkbox" id="verde" name="color" value="verde">
				<label for="verde">Verde</label><br> <input type="checkbox"
					id="verde-acqua" name="color" value="verde-acqua"> <label
					for="verde-acqua">Verde acqua</label><br> <input
					type="checkbox" id="viola" name="color" value="viola"> <label
					for="viola">Viola</label><br>


			</div>
		</div>
		<div class="filter">
			<label for="price">Prezzo:</label> <span class="filter-expand"
				data-filter-id="priceOptions"
				onclick="toggleFilterOptions('priceOptions')"></span>
			<div id="priceOptions" class="filter-options">
				<input type="checkbox" id="price-0-50" name="price" value="0-50">
				<label for="price-0-50">0-50&euro;</label><br> <input
					type="checkbox" id="price-50-100" name="price" value="50-100">
				<label for="price-50-100">50-100&euro;</label><br> <input
					type="checkbox" id="price-100-plus" name="price" value="100-plus">
				<label for="price-100-plus">100&euro;+</label><br>

			</div>
		</div>
		<!-- <div class="filter">
			<label for="category">Categoria:</label> <span class="filter-expand"
				data-filter-id="categoryOptions"
				onclick="toggleFilterOptions('categoryOptions')"></span>
			<div id="categoryOptions" class="filter-options">
				<input type="checkbox" id="categoria-accessori" name="categoria"
					value="accessori"> <label for="categoria-accessori">Accessori</label><br>

				<input type="checkbox" id="categoria-borsoni" name="categoria"
					value="borsoni"> <label for="categoria-borsoni">Borsoni</label><br>

				<input type="checkbox" id="categoria-valigie" name="categoria"
					value="valigie"> <label for="categoria-valigie">Valigie</label><br>

				<input type="checkbox" id="categoria-zaini" name="categoria"
					value="zaini"> <label for="categoria-zaini">Zaini</label><br>

			</div>
		</div> -->
		<button type="submit" class="btn-cerca">Cerca</button>

	</div>


</body>
</html>