<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.*" %>

<%
request.setAttribute("categoria", null);
int id = 1;
request.setAttribute("id", id);
Collection<?> prodotti = (Collection<?>) request.getAttribute("prodotti");
if (prodotti == null){
	RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/VisualizzaProdottiServlet");
	dispatcher.forward(request, response);	
	return;
}

%>

<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="ISO-8859-1">

<title>Product View - Pack And Travel</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/styles/ProductView.css">
<script src="<%=request.getContextPath()%>/scripts/ProductView.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath() %>/scripts/validate.js"></script>


</head>
<body>
<body>
<%@ include file="../common/Header.jsp" %>

	<div id= "container">
	 <h2>
    Visualizza prodotti <span id="toggleButton1" class="cursor-pointer" onclick="toggleContent('toggleButton1', 'productTable')">+</span>
  </h2>
	<table id="productTable" border="1" class="hidden" > 
	
  <tr>
    <th>Codice </th>
    <th>Nome  </th>
    <th>Descrizione</th>
    <th>Categoria </th>
    <th>Prezzo</th>
    <th>Foto</th>
    
  </tr>
  
	

	<%
			if (prodotti != null && prodotti.size() != 0) {
				Iterator<?> it = prodotti.iterator();
				while (it.hasNext()) {
					Prodotto prodotto = (Prodotto) it.next();
		%>
	<tr>
			<td><%=prodotto.getCodice()%></td>
			<td><%=prodotto.getNome()%></td>
			<td><%=prodotto.getDescrizione()%></td>
			<td> <%=prodotto.getCategoria_nome() %></td>
			<td><%=prodotto.getPrezzo() %></td>
			<td><img class="img" src="<%=request.getContextPath()%>/getPicture?codice=<%=prodotto.getCodice()%>" alt="immagine prodotto"></td> 
		</tr>
	<%
				}
			} else {
		%>
		<tr>
			<td colspan="6">No products available</td>
		</tr>
		<%
			}
		%>
	</table>
	<h2>Inserisci nuovo prodotto <span id="toggleButton2" class="cursor-pointer" onclick="toggleContent('toggleButton2', 'insertForm')">+</span></h2>
  	<form id="insertForm" action="/PackAndTravel/AddProdottoServlet" method="post" class="hidden" enctype="multipart/form-data">
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
		<input name="prezzo" type="number" step="0.01" min="0" required><br> <br> 
		<label for="immagine">Immagine:</label> <br> 
		<input type="file" name="immagine"> <br> <br> 
		<input type="submit" value="Aggiungi"> 
		<input type="reset" value="Reset">
	</form>

	<h2>Elimina un prodotto <span id="toggleButton3" class="cursor-pointer" onclick="toggleContent('toggleButton3', 'deleteForm')">+</span></h2>
  <form id="deleteForm" action="/PackAndTravel/DeleteProdottoServlet" method="post" class="hidden">
		<p>Inserisci codice:</p>
		<input name="codiceEliminazione" type="number" min="0" required><br>
		<br> <input type="submit" value="Elimina">
	</form>

	<h2>Modifica un prodotto <span id="toggleButton4" class="cursor-pointer" onclick="toggleContent('toggleButton4', 'editForm')">+</span></h2>
  <form action="/PackAndTravel/ModificaProdottoServlet" id="editForm" method="post" class="hidden" enctype="multipart/form-data" onsubmit="return checkModificaProdotto(this)">
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
		<input name="prezzo" type="number" step="0.01" min="0"> <br> <br> 
		<label for="immagine">Modifica immagine:</label> <br>  
		<input type="file" name="immagine"> <br> <br> 
		<input type="submit" value="Modifica"> 
		<input type="reset" value="Reset">

	</form>

</div>
<%@ include file="../common/Footer.jsp" %>
</body>
</html>