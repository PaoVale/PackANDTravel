<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  errorPage="errorPage.jsp"%>
    <%@ page import="java.text.DecimalFormat" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Carrello</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/styles/Carrello.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
	<script type="text/javascript" src="<%=request.getContextPath() %>/scripts/Carrello.js"></script>
</head>
<body>
    <%@ include file="Header.jsp"%>
    
 
 <% 
	
	Cart carrello = (Cart) session.getAttribute("carrello");
	String error = (String)request.getAttribute("error");
	if(error == null)
		error = "";
	if(carrello == null){
		System.out.println("Carrello è null,prima");
		response.sendRedirect("/PackAndTravel/CarrelloServlet?redirect=carrello");
		System.out.println("Carrello è null,dopo");
		return;
	}
	
	String QtaError = (String) request.getAttribute("QtaError");
	if(QtaError == null)
		QtaError = "";
	
	%> 
    
        <h1 id="titolo">Il tuo Carrello</h1>
    

    <main class="container">
        <table>
            <thead>
                <tr>
                    <th>Prodotto</th>
                    <th>Categoria</th>
                    <th>Prezzo</th>
                    <th>Quantit&agrave;</th>
                    <th>Totale</th>
                    <th>Elimina</th> 
                </tr>
            </thead>
            <tbody>
            <% for(CartItem pb : carrello.getProducts()) { %>
            <tr>
           
            <td> 
           
             <div class="img-prodotto-container">
             
             <p><%=pb.getProdotto().getNome() %></p>
            <img src="<%=request.getContextPath()%>/getPicture?codice=<%=pb.getProdotto().getCodice()%>" alt="immagine prodotto" class="img-prodotto">
            </div>
            </td>
			
            <td ><%=pb.getProdotto().getCategoria_nome() %></td>

            <td id="prezzoProdotto<%=pb.getProdotto().getCodice()%>"><%=pb.getProdotto().getPrezzo()%> &euro;</td> 
         
   			<td> <div class="quantity-container">
        <button class="decrease-quantity" data-id="<%=pb.getProdotto().getCodice()%>" disabled>-</button>
        <span class="quantity-value" ><%=pb.getQuantita() %></span>
        <button class="increase-quantity" data-id="<%=pb.getProdotto().getCodice()%>"  >+</button>
    </div></td>
<td>
    <span id="total<%=pb.getProdotto().getCodice()%>"><%=pb.getProdotto().getPrezzo()*pb.getQuantita()%></span> &euro;
</td>

            <td>
            
    <a href="/PackAndTravel/CarrelloServlet?action=delete&idProdotto=<%=pb.getProdotto().getCodice()%>&redirect=carrello">
        <i class="fas fa-trash-alt trash-icon"></i>
    </a>
</td>

            
            </tr>
               
               
               <%} %>

            </tbody>
            <tfoot>
                <tr>
                    <td colspan="4">Totale </td>
                    <td id="cart-total" data-id="<%=carrello.getTotale()%>"><%=carrello.getTotale()%> &euro;</td>
                </tr>
            </tfoot>
        </table>

        <a href="checkout.html" class="checkout-button">Procedi al Checkout</a>
    </main>
</body>
<%@ include file="Footer.jsp"%>
</html>
