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

import model.AccountUser;
import model.AccountUserDAO;
import model.HelperClass;

/**
 * Servlet implementation class ModificaDatiServlet
 */
@WebServlet("/ModificaDatiServlet")
public class ModificaDatiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getAnonymousLogger();

       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountUser auth = (AccountUser) request.getSession().getAttribute("auth");
		DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
		AccountUserDAO user = new AccountUserDAO(ds);
		String email = auth.getEmail();
		String passwordNuova=null;
		String confermaPassword=null;
		String indirizzo = null;
		String cellulare = null;	
		
		
		
	 	   if(request.getParameter("password")!= "") {
			passwordNuova= request.getParameter("password");
			confermaPassword = request.getParameter("ConfermaPassword");		
		
			if(!passwordNuova.equals(confermaPassword)) { 
		      String error ="Password e conferma password non corrispondono";
		      request.setAttribute("error", error); 
		      RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/common/AreaUtente.jsp");
		      dispatcher.forward(request, response);}
		
		 passwordNuova= HelperClass.toHash(passwordNuova);
		 try {
			user.doUpdatePassword(email,passwordNuova);
		} catch (SQLException e) {
			logger.log(Level.WARNING, "Problema Sql!");
		}
	 	   }
		  
		  if(request.getParameter("indirizzo")!="") {
			  indirizzo=request.getParameter("indirizzo");
			  System.out.println("Indirizzo mandato: "+indirizzo);
			  try {
				user.doUpdateAddress(email, indirizzo);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			  auth.setAddress(indirizzo);
		  }
		 
		
		  if(request.getParameter("cellulare")!="") {
			  cellulare=request.getParameter("cellulare");
			  System.out.println("Cellulare mandato: "+cellulare);
			  try {
				user.doUpdateNumber(email, cellulare);
			} catch (SQLException e) {
				logger.log(Level.WARNING, "Problema Sql!");
			}
			  auth.setNumber(cellulare);
		  }
		  RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/common/AreaUtente.jsp");
		  dispatcher.forward(request, response); 
		
		}
	 	 	   
	
	
	}
	
	


