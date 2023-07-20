package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import model.AccountUser;
import model.Cart;
import model.CartItem;
import model.OrdineBean;
import model.OrdineDAO;

/**
 * Servlet implementation class CheckOutServlet
 */
@WebServlet("/CheckoutServlet")
public class CheckOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CheckOutServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	/**
	 *
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cart carrello = (Cart) request.getSession().getAttribute("carrello");
		AccountUser user = (AccountUser) request.getSession().getAttribute("auth"); // recupero info utente per salvare l'ordine
		
		if (carrello == null || user == null) {
			request.getRequestDispatcher("common/Login.jsp").forward(request, response);
			return;
		}

		
		List<CartItem> elementi = carrello.getProducts(); // recupero elementi nel carrello

		if (elementi == null || elementi.isEmpty()) {
			String error = "Non puoi procedere al pagamento con un carrello vuoto!";
			request.setAttribute("error", error);
			request.getRequestDispatcher("common/Carrello.jsp").forward(request, response);
			return;
		}

		
		DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
		
		//effettuo l'ordine

		OrdineDAO ordinedao = new OrdineDAO(ds);
		OrdineBean ordine = new OrdineBean();
		Double totaleString =  (Double) request.getSession().getAttribute("totale");
		
		 
		try {
			
			ordine.setEmail(user.getEmail());
			
			ordine.setPrezzo(totaleString);
			ordinedao.doSave(ordine);
		} catch (SQLException e1) {
			//logger.log(Level.WARNING, LOG_MSG);
		}

		/*
		 * DettaglioOrdineDAO dettaglioOrdineDAO = new DettaglioOrdineDAO();
		 * 
		 * try { for (CartItem elem : elementi) { DettaglioOrdineBean dettaglioOrdine =
		 * new DettaglioOrdineBean();
		 * dettaglioOrdine.setCodiceProdotto(elem.getProductBean().getCode());
		 * dettaglioOrdine.setQuantita(elem.getQuantita());
		 * dettaglioOrdine.setPrezzo(elem.getProductBean().getPrice());
		 * dettaglioOrdine.setNumeroOrd(numeroOrd);
		 * 
		 * dettaglioOrdineDAO.doSave(dettaglioOrdine); } } catch (SQLException e) {
		 * e.printStackTrace(); }
		 */
		
		
		
		request.getSession().setAttribute("carrello", null);
		
		request.getRequestDispatcher("common/Index.jsp").forward(request, response);
		
	}
	}


