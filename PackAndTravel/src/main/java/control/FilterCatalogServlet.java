package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
	private static Logger logger = Logger.getAnonymousLogger();
	private static final String ERROR = "Problema Sql!";
       
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
		final String PRODOTTI = "prodotti";
		
		String categoria= (String) request.getParameter("categoria");
		DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
		ProdottoDAO prodotto = new ProdottoDAO(ds);
		
		String priceValue = request.getParameter("price");
        String orderValue = request.getParameter("ordina-per");
        
        if(orderValue!=null && priceValue==null) {
        	try {
				request.setAttribute(PRODOTTI, prodotto.doRetrieveByOrdine(categoria,orderValue));
			} catch (SQLException e) {
			
				logger.log(Level.WARNING, ERROR,e);
			}
        	
        }
        else if(priceValue!=null && orderValue==null) {
    	   if(priceValue.equals("0-50"))
    		   try {
   				request.setAttribute(PRODOTTI, prodotto.doRetrieveByPrezzo(categoria,0,50));
   			} catch (SQLException e) {
   			
   				logger.log(Level.WARNING, ERROR ,e);
   			}
    	   else if(priceValue.equals("50-100"))
    		   try {
   				request.setAttribute(PRODOTTI, prodotto.doRetrieveByPrezzo(categoria,50,100));
   			} catch (SQLException e) {
   			
   				logger.log(Level.WARNING, ERROR,e);
   			}
    	   else
    		   try {
      				request.setAttribute(PRODOTTI, prodotto.doRetrieveByPrezzo(categoria,100,0));
      			} catch (SQLException e) {
      			
      				logger.log(Level.WARNING, ERROR,e);
      			}   
        }
        else if(priceValue!=null && orderValue!=null) {
        	if(priceValue.equals("0-50"))
     		   try {
    				request.setAttribute(PRODOTTI,prodotto.doRetrieveByPrezzoAndOrdine(categoria,0,50,orderValue));
    			} catch (SQLException e) {
    			
    				logger.log(Level.WARNING, ERROR,e);
    			}
     	   else if(priceValue.equals("50-100"))
     		   try {
    				request.setAttribute(PRODOTTI, prodotto.doRetrieveByPrezzoAndOrdine(categoria,50,100,orderValue));
    			} catch (SQLException e) {
    			
    				logger.log(Level.WARNING, ERROR,e);
    			}
     	   else
     		   try {
       				request.setAttribute(PRODOTTI, prodotto.doRetrieveByPrezzoAndOrdine(categoria,100,0,orderValue));
       			} catch (SQLException e) {
       			
       				logger.log(Level.WARNING, ERROR,e);
       			}   
        	
        }

        
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/common/Catalogo.jsp?categoria="+categoria);
		dispatcher.forward(request, response);
	}

}
