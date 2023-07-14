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

import model.AccountUserDAO;
import model.ProdottoDAO;

/**
 * Servlet implementation class ModificaProdottoServlet
 */
@WebServlet("/ModificaProdottoServlet")
public class ModificaProdottoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ModificaProdottoServlet() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
		ProdottoDAO prodotto=new ProdottoDAO(ds);
		int codice=0;
		codice= Integer.parseInt(request.getParameter("codiceModifica"));
		String nome=null;
		String descrizione= null;
		String categoria=null;
		Double prezzo=0.0;
		
		
		if (request.getParameter("nome")!="")
		{
			nome = request.getParameter("nome");
			
			try {
				prodotto.doUpdate("nome", nome, codice);
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		
		if (request.getParameter("descrizione")!="")
		{
			descrizione = request.getParameter("descrizione");
			
			try {
				prodotto.doUpdate("descrizione", descrizione, codice);
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
		
		if (request.getParameter("prezzo")!="")
		{
			prezzo = Double.parseDouble( request.getParameter("prezzo"));
			
			try {
				prodotto.doUpdatePrezzo(prezzo, codice);
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin/ProductView.jsp");
		dispatcher.forward(request, response); 
		
	}

}
