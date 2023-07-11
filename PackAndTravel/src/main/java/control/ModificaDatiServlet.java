package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ModificaDatiServlet
 */
@WebServlet("/ModificaDatiServlet")
public class ModificaDatiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String passwordNuova=null;
		String confermaPassword=null;
		
		if(!passwordNuova.equals(confermaPassword)) {
	        String error = "Password e conferma password non corrispondono";
	        request.setAttribute("error", error);
	        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/common/AreaUtente.jsp");
	        dispatcher.forward(request, response);
	        
	      }
		
		
	}

}
