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
@WebServlet("/DettaglioProdottoServlet")
public class DettaglioProdottoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getAnonymousLogger();

     
    public DettaglioProdottoServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
		ProdottoDAO prodotto = new ProdottoDAO(ds);
		String codice=request.getParameter("code");
		int code = Integer.parseInt(codice);
		
		
		try {
			request.setAttribute("prodotto", prodotto.doRetrieveByKey(code));
		} catch (SQLException e) {
			logger.log(Level.WARNING, "Problema Parse/Sql!");
		}
		
		RequestDispatcher dispatcher;
		dispatcher = this.getServletContext().getRequestDispatcher("/common/DettaglioProdotto.jsp");
		  dispatcher.forward(request, response);
	}

}