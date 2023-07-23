package control;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.DataSource;

import model.ProdottoDAO;

/**
 * Servlet implementation class ModificaProdottoServlet
 */

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)
@WebServlet("/ModificaProdottoServlet")
public class ModificaProdottoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ModificaProdottoServlet() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String PREZZO = "prezzo";
		final String DESCRIZIONE = "descrizione";
		
		DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
		ProdottoDAO prodotto=new ProdottoDAO(ds);
		int codice=0;
		codice= Integer.parseInt(request.getParameter("codiceModifica"));
		String nome=null;
		String descrizione= null;
		String categoria=null;
		Double prezzo;
		
		
		if (request.getParameter("nome")!="" && request.getParameter("nome")!=null && !request.getParameter("nome").isEmpty())
		{
			nome = request.getParameter("nome");
			
			try {
				prodotto.doUpdate("nome", nome, codice);
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		
		if (request.getParameter(DESCRIZIONE)!="" && request.getParameter(DESCRIZIONE)!=null && !request.getParameter(DESCRIZIONE).isEmpty())
		{
			descrizione = request.getParameter(DESCRIZIONE);
			
			try {
				prodotto.doUpdate(DESCRIZIONE, descrizione, codice);
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		
		
		if (request.getParameter("categoria")!= null)
		{
			categoria = request.getParameter("categoria");
			
			try {
				prodotto.doUpdate("categoria_nome", categoria, codice);
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		
		if (request.getParameter(PREZZO)!="" && request.getParameter(PREZZO) != null && !request.getParameter(PREZZO).isEmpty())
		{
			prezzo = Double.parseDouble( request.getParameter(PREZZO));
			
			try {
				prodotto.doUpdatePrezzo(prezzo, codice);
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		
		
		Part immaginePart = request.getPart("immagine");
		String nomeFile = immaginePart.getSubmittedFileName();

		if (nomeFile != null && !nomeFile.isEmpty()) { 
		 
	    	  request.setAttribute("codice", codice);
	      
	      RequestDispatcher dispatcher =
	      getServletContext().getRequestDispatcher("/UploadPhoto");
	      dispatcher.forward(request, response);}
	      else {
	     
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin/ProductView.jsp");
		dispatcher.forward(request, response); 
	      }
		
	}

}
