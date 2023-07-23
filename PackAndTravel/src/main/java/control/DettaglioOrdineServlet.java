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

import model.ArticoloDAO;


@WebServlet("/DettaglioOrdineServlet")
public class DettaglioOrdineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getAnonymousLogger();
       
    
    public DettaglioOrdineServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
	    ArticoloDAO articolo = new ArticoloDAO(ds);
	    String codiceString=(String) request.getSession().getAttribute("codice");
	    int codice= Integer.parseInt(codiceString);
	    
	    try {
	    	request.setAttribute("articoli", articolo.doRetriveAllByKey(codice)); //codice ordine
	    	
	    } catch (SQLException e) {
	        
	       logger.log(Level.WARNING, "Problema Sql!",e);
	      }
			
			  RequestDispatcher dispatcher =
			  getServletContext().getRequestDispatcher("/common/DettaglioOrdine.jsp");
			  dispatcher.forward(request, response);
			 
	    
			}

}
