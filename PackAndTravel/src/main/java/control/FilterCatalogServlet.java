package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import model.ProdottoDAO;

/**
 * Servlet implementation class FilterCatalogServlet
 */
@WebServlet("/FilterCatalogServlet")
public class FilterCatalogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FilterCatalogServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String categoria= (String) request.getParameter("categoria");
		System.out.println("categoria filter: " + categoria);
		DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
		ProdottoDAO prodotto = new ProdottoDAO(ds);
		
		String priceValue = request.getParameter("price");
        String orderValue = request.getParameter("ordina-per");
        
        if(orderValue!=null && priceValue==null) {
        	try {
				request.setAttribute("prodotti", prodotto.doRetrieveByOrdine(categoria,orderValue));
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
        	
        }
        else if(priceValue!=null && orderValue==null) {
    	   if(priceValue.equals("0-50"))
    		   try {
   				request.setAttribute("prodotti", prodotto.doRetrieveByPrezzo(categoria,0,50));
   			} catch (SQLException e) {
   			
   				e.printStackTrace();
   			}
    	   else if(priceValue.equals("50-100"))
    		   try {
   				request.setAttribute("prodotti", prodotto.doRetrieveByPrezzo(categoria,50,100));
   			} catch (SQLException e) {
   			
   				e.printStackTrace();
   			}
    	   else
    		   try {
      				request.setAttribute("prodotti", prodotto.doRetrieveByPrezzo(categoria,100,0));
      			} catch (SQLException e) {
      			
      				e.printStackTrace();
      			}   
        }
        else if(priceValue!=null && orderValue!=null) {
        	if(priceValue.equals("0-50"))
     		   try {
    				request.setAttribute("prodotti",prodotto.doRetrieveByPrezzoAndOrdine(categoria,0,50,orderValue));
    			} catch (SQLException e) {
    			
    				e.printStackTrace();
    			}
     	   else if(priceValue.equals("50-100"))
     		   try {
    				request.setAttribute("prodotti", prodotto.doRetrieveByPrezzoAndOrdine(categoria,50,100,orderValue));
    			} catch (SQLException e) {
    			
    				e.printStackTrace();
    			}
     	   else
     		   try {
       				request.setAttribute("prodotti", prodotto.doRetrieveByPrezzoAndOrdine(categoria,100,0,orderValue));
       			} catch (SQLException e) {
       			
       				e.printStackTrace();
       			}   
        	
        }

       
       
        // Esempio di output per verificare i valori ricevuti
        System.out.println("Prezzo selezionato: " + priceValue);
        System.out.println("Ordine selezionato: " + orderValue);
        
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/common/Catalogo.jsp?categoria="+categoria);
		dispatcher.forward(request, response);
	}

}
