<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  errorPage="errorPage.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Carrello</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/styles/Carrello.css">
</head>
<body>
    <%@ include file="Header.jsp"%>
    
 
 <% 
	
	Cart carrello = (Cart) session.getAttribute("carrello");
	String error = (String)request.getAttribute("error");
	if(error == null)
		error = "";
	if(carrello == null){
		response.sendRedirect("/PackAndTravel/CarrelloServlet?redirect=carrello");
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
			
            <td><%=pb.getProdotto().getCategoria_nome() %></td>
            <td><%=pb.getProdotto().getPrezzo()%> &euro;</td>
            <td><%=pb.getQuantita() %></td>
            <td><%=pb.getProdotto().getPrezzo() * pb.getQuantita()%>&euro;</td>
            
            </tr>
               
               
               <%} %>

            </tbody>
            <tfoot>
                <tr>
                    <td colspan="3">Totale</td>
                    <td id="cart-total"></td>
                </tr>
            </tfoot>
        </table>

        <a href="checkout.html" class="checkout-button">Procedi al Checkout</a>
    </main>
</body>
<%@ include file="Footer.jsp"%>
</html>
