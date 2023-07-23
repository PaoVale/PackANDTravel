package control;

import java.io.IOException;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import model.AccountUser;
import model.Articolo;
import model.ArticoloDAO;
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
	private static Logger logger = Logger.getAnonymousLogger();

       
    
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
		int codiceGenerato=0;
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
		ArticoloDAO articolodao = new ArticoloDAO(ds);
		
		try {
			
			ordine.setEmail(user.getEmail());
			ordine.setDataOrdine(new java.sql.Date(System.currentTimeMillis()));
			ordine.setPrezzo(totaleString);
			codiceGenerato=ordinedao.doSave(ordine);
			
			System.out.println(codiceGenerato);
		} catch (SQLException e1) {
			logger.log(Level.WARNING, "Errore in effettuazione ordine");
		}
		
		try {
			for(CartItem item : elementi) {
				Articolo articolo = new Articolo();
				articolo.setNome(item.getProdotto().getNome());
				articolo.setQuantita(item.getQuantita());
				articolo.setPrezzo(item.getProdotto().getPrezzo());
				articolo.setOrdineCodice(codiceGenerato);
				articolo.setProdottoCodice(item.getProdotto().getCodice());
				articolodao.doSave(articolo);
			}
		}catch (SQLException e1) {
				logger.log(Level.WARNING, "Errore in aggiunta articoli");
				
			}
		
		request.getSession().setAttribute("carrello", null);
		
		request.getRequestDispatcher("common/VisualizzaOrdiniUtente.jsp").forward(request, response);
		
	}
	}


