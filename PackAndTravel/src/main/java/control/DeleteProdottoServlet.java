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
 * Servlet implementation class DeleteProdottoServlet
 */
@WebServlet("/DeleteProdottoServlet")
public class DeleteProdottoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getAnonymousLogger();

	
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codice = Integer.parseInt(request.getParameter("codiceEliminazione"));
		
		 ProdottoDAO prodottodao=null;		      
	      DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
	      prodottodao = new ProdottoDAO(ds);
	      try {
	        prodottodao.doDelete(codice);
	        
	      } catch (SQLException e) {
	    	  logger.log(Level.WARNING, "Query errata");
	    	 
	      }
	      
		
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin/ProductView.jsp");
		dispatcher.forward(request, response); 
		
	}

	}

