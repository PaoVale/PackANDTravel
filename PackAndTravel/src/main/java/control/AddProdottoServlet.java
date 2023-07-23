package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


import model.Prodotto;
import model.ProdottoDAO;

/**
 * Servlet implementation class AddProdottoServlet
 */
@WebServlet("/AddProdottoServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50) // 50MB
public class AddProdottoServlet extends HttpServlet {
	private static Logger logger = Logger.getAnonymousLogger();
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Prodotto prodotto = new Prodotto();
		int codice = 0;
		String nome = request.getParameter("nome");
		String descrizione = request.getParameter("descrizione");
		String categoria = request.getParameter("categoria");
		Double prezzo = Double.parseDouble(request.getParameter("prezzo"));
		
		prodotto.setNome(nome);
		prodotto.setDescrizione(descrizione);
		prodotto.setCategoriaNome(categoria);
		prodotto.setPrezzo(prezzo);
		
		 ProdottoDAO prodottodao=null;		      
	      DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
	      prodottodao = new ProdottoDAO(ds);
	      try {
	       codice = prodottodao.doSave(prodotto);
	        
	      } catch (SQLException e) {
	    	  logger.log(Level.WARNING, "Query errata");
	      }
	      
		request.setAttribute("codice", codice);
		System.out.println(nome+" " + descrizione+" "+ categoria+" "+prezzo);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/UploadPhoto");
		dispatcher.forward(request, response); 
		
		
	}

}
