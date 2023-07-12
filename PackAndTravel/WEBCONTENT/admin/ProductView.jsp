<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Product View - Pack And Travel</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/styles/ProductView.css">
<script src="<%=request.getContextPath()%>/scripts/ProductView.js"></script>
</head>
<body>
<body>
<%@ include file="../common/Header.jsp" %>

	<div id= "container">
	 <h2>
    Visualizza prodotti <span id="toggleButton1" class="cursor-pointer" onclick="toggleContent('toggleButton1', 'productTable')">+</span>
  </h2>
	<table id="productTable" border="1" class="hidden">
		 <colgroup>
    <col>
    <col>
    <col>
    <col>
    <col>
    <col style="width: 200px;"> <!-- Imposta la larghezza desiderata per la colonna della foto -->
  </colgroup>
  <tr>
    <th>Codice <a href="product?sort=codice">Sort</a></th>
    <th>Nome <a href="product?sort=nome">Sort</a></th>
    <th>Descrizione <a href="product?sort=descrizione">Sort</a></th>
    <th>Categoria <a href="product?sort=categoria">Sort</a></th>
    <th>Prezzo <a href="product?sort=prezzo">Sort</a></th>
    <th>Foto</th>
    <!-- <th>Action</th> -->
  </tr>
  
		<!-- Contenuto della tabella -->
	

	<%-- <%
			if (products != null && products.size() != 0) {
				Iterator<?> it = products.iterator();
				while (it.hasNext()) {
					ProductBean bean = (ProductBean) it.next();
		%> --%>
	<%-- <tr>
			<td><%=bean.getCode()%></td>
			<td><%=bean.getName()%></td>
			<td><%=bean.getDescription()%></td>
			<td><a href="product?driver=drivermanager&action=delete&id=<%=bean.getCode()%>">Delete</a><br>
				<a href="product?driver=drivermanager&action=read&id=<%=bean.getCode()%>">Details</a><br>
				<a href="product?driver=drivermanager&action=addC&id=<%=bean.getCode()%>">Add to cart</a>
				</td>
		</tr> --%>
	<%-- <%
				}
			} else {
		%>
		<tr>
			<td colspan="6">No products available</td>
		</tr>
		<%
			}
		%> --%>
	</table>
	<h2>Inserisci nuovo prodotto <span id="toggleButton2" class="cursor-pointer" onclick="toggleContent('toggleButton2', 'insertForm')">+</span></h2>
  <form id="insertForm" action="product" method="post" class="hidden">
		<input type="hidden" name="action" value="insert"> 
		<label for="nome">Nome:</label> <br> 
		<input name="nome" type="text" maxlength="50" required><br> <br> 
		<label for="descrizione">Descrizione:</label> <br>
		<textarea name="descrizione" rows="3" required> </textarea> <br> <br> 
		<label for="categoria">Categoria:</label><br>
		<input type="radio" id="valigia" name="categoria" value="valigia">
		<label for="valigia">Valigia</label><br> <input type="radio" id="borsone" name="categoria" value="borsone"> 
		<label for="borsone">Borsone</label> <br> 
		<input type="radio" id="zaino" name="categoria" value="zaino"> 
		<label for="zaino">Zaino</label><br>
		<input type="radio" id="accessorio" name="categoria" value="accessorio"> 
		<label for="accessorio">Accessorio</label><br> <br> 
		<label for="prezzo">Prezzo:</label> <br> 
		<input name="prezzo" type="number" min="0" required> <br> <br> 
		<label for="immagine">Immagine:</label> <br> 
		<input type="file" name="immagine"> <br> <br> 
		<input type="submit" value="Aggiungi"> 
		<input type="reset" value="Reset">
	</form>

	<h2>Elimina un prodotto <span id="toggleButton3" class="cursor-pointer" onclick="toggleContent('toggleButton3', 'deleteForm')">+</span></h2>
  <form id="deleteForm" method="post" class="hidden">
		<p>Inserisci codice:</p>
		<input name="codiceEliminazione" type="number" min="0" required><br>
		<br> <input type="submit" value="Elimina">
	</form>

	<h2>Modifica un prodotto <span id="toggleButton4" class="cursor-pointer" onclick="toggleContent('toggleButton4', 'editForm')">+</span></h2>
  <form id="editForm" method="post" class="hidden">
		<label for="codice">Inserisci codice:</label> 
		<input name="codiceModifica" type="number" min="0" required><br> <br> 
		<label for="nome">Modifica nome:</label> <br> 
		<input name="nome" type="text" maxlength="50" ><br> <br> 
		<label for="descrizione">Modifica Descrizione:</label> <br>
		<textarea name="descrizione" rows="3" ></textarea> <br> <br> 
		<label for="categoria">Modifica categoria:</label><br>
		<input type="radio" id="valigia" name="categoria" value="valigia">
		<label for="valigia">Valigia</label> <br> 
		<input type="radio" id="borsone" name="categoria" value="borsone"> 
		<label for="borsone">Borsone</label> <br> 
		<input type="radio" id="zaino" name="categoria" value="zaino"> 
		<label for="zaino">Zaino</label> <br>
		<input type="radio" id="accessorio" name="categoria" value="accessorio"> 
		<label for="accessorio">Accessorio</label> <br> <br> 
		<label for="prezzo">Modifica prezzo:</label> <br> 
		<input name="prezzo" type="number" min="0"> <br> <br> 
		<label for="immagine">Modifica immagine:</label> <br>  
		<input type="file" name="immagine"> <br> <br> 
		<input type="submit" value="Modifica"> 
		<input type="reset" value="Reset">

	</form>

</div>
<%@ include file="../common/Footer.jsp" %>
</body>
</html>