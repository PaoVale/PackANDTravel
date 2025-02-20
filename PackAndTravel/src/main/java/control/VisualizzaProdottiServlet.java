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
 * Servlet implementation class VisualizzaProdottiServlet
 */
@WebServlet("/VisualizzaProdottiServlet")
public class VisualizzaProdottiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getAnonymousLogger();

    
    public VisualizzaProdottiServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
		ProdottoDAO prodotto = new ProdottoDAO(ds);
		String categoria= (String) request.getAttribute("categoria");
		try {
			request.setAttribute("prodotti", prodotto.doRetriveAll(categoria));
		} catch (SQLException e) {
			logger.log(Level.WARNING, "Problema attributo/query");
			
			
		}
		
		int idRequest = (int) request.getAttribute("id");
		RequestDispatcher dispatcher;
		switch(idRequest) {
		case 1: 
		dispatcher = getServletContext().getRequestDispatcher("/admin/ProductView.jsp");
		dispatcher.forward(request, response); 
		break;
		case 2:
			dispatcher = this.getServletContext().getRequestDispatcher("/common/Catalogo.jsp");
			dispatcher.forward(request, response);
			break;
		case 3: 
			dispatcher = getServletContext().getRequestDispatcher("/common/Index.jsp");
			dispatcher.forward(request, response); 
			break;
		 default:
		        // Il valore di idRequest non corrisponde a nessuno dei casi sopra definiti
		        break;
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}