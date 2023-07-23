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



import model.*;
/**
 * Servlet implementation class CarrelloServlet
 */
@WebServlet("/CarrelloServlet")
public class CarrelloServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getAnonymousLogger();

	private static final String CARRELLO = "carrello";

	public CarrelloServlet() {
        super();
    }

	
	  protected void doGet(HttpServletRequest request, HttpServletResponse
	  response) throws ServletException, IOException {
	  
	  doPost(request, response); }
	 

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
		Cart carrello = (Cart) request.getSession().getAttribute(CARRELLO);
		if (carrello == null) {
			carrello = new Cart();
			request.getSession().setAttribute(CARRELLO, carrello);
		}
		
		
		String action = request.getParameter("action");
		String codeStr = request.getParameter("idProdotto");
		String redirect = request.getParameter("redirect"); 		
		

		if (action != null && codeStr != null) {
			int code = Integer.parseInt(codeStr);
						
			DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
			ProdottoDAO prodottoDao=new ProdottoDAO(ds);
			
			switch (action) {
			case "add": {
				try {
					carrello.addProduct(prodottoDao.doRetrieveByKey(code));
				} catch (SQLException e) {
					logger.log(Level.WARNING, "Problema accesso DB!");
				}
				break;
			}
			case "delete": {
				try {
					carrello.deleteProduct(prodottoDao.doRetrieveByKey(code));
				} catch (Exception e) {
					logger.log(Level.WARNING, "Problema accesso DB!");
					
				}
				break;
			}
			default: break;
			}
		}
		request.getSession().setAttribute(CARRELLO, carrello);
		RequestDispatcher dispatcher;

		if (redirect != null && redirect.equals("catalogo")) {
			dispatcher = this.getServletContext().getRequestDispatcher("/common/Index.jsp");
			  dispatcher.forward(request, response);
			return;
		}
		if (redirect != null && redirect.equals(CARRELLO)) {
			dispatcher = this.getServletContext().getRequestDispatcher("/common/Carrello.jsp");
			  dispatcher.forward(request, response);
		}


		}
}
