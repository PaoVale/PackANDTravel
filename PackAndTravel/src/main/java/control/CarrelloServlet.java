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



import model.*;
/**
 * Servlet implementation class CarrelloServlet
 */
@WebServlet("/CarrelloServlet")
public class CarrelloServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	private static final String CARRELLO = "carrello";

	public CarrelloServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("Sono nella servlet carrello");
			System.out.println("Ho aggiunto il prodotto "+request.getParameter("idProdotto"));
		Cart carrello = (Cart) request.getSession().getAttribute(CARRELLO);
		if (carrello == null) {
			carrello = new Cart();
			request.getSession().setAttribute(CARRELLO, carrello);
		}
		
		
		String action = request.getParameter("action");
		String codeStr = request.getParameter("idProdotto");
		String redirect = request.getParameter("redirect"); 
		System.out.println("Redirect"+redirect);
		System.out.println("Action"+action);
		System.out.println("id: "+codeStr);
		
		

		if (action != null && codeStr != null) {
			int code = Integer.parseInt(codeStr);
			
			
			DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
			ProdottoDAO prodottoDao=new ProdottoDAO(ds);
			
			switch (action) {
			case "add": {
				try {
					carrello.addProduct(prodottoDao.doRetrieveByKey(code));
					System.out.println("Sto facendo add");
				} catch (SQLException e) {
					//logger.log(Level.WARNING, "Problema accesso DB!");
				}
				break;
			}
			case "delete": {
				try {
					carrello.deleteProduct(prodottoDao.doRetrieveByKey(code));
				} catch (SQLException e) {
					//logger.log(Level.WARNING, "Problema accesso DB!");
				}
				break;
			}
			default: break;
			}
		}
		request.getSession().setAttribute(CARRELLO, carrello);
		RequestDispatcher dispatcher;

		if (redirect != null && redirect.equals("catalogo")) {
			dispatcher = this.getServletContext().getRequestDispatcher("/common/Catalogo.jsp");
			dispatcher.forward(request, response);
			return;
		}
		if (redirect != null && redirect.equals(CARRELLO)) {
			dispatcher = this.getServletContext().getRequestDispatcher("/common/Index.jsp");
			dispatcher.forward(request, response);
		}


		}
}
