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

@WebServlet("/RegistratiServlet")
public class RegistratiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(RegistratiServlet.class.getName());
    public RegistratiServlet() {
        super();
        
    }

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String email = request.getParameter("email");
		    String nome = HelperClass.filter(request.getParameter("nome"));
		    String cognome = HelperClass.filter(request.getParameter("cognome"));
		    String passwd = HelperClass.filter(request.getParameter("password"));
		    String confPass = HelperClass.filter(request.getParameter("ConfermaPassword"));
		    String indirizzo = HelperClass.filter(request.getParameter("indirizzo"));
		    String cellulare = HelperClass.filter(request.getParameter("cellulare"));
		    
		    if(!passwd.equals(confPass)) {
		        String error = "Password e conferma password non corrispondono";
		        request.setAttribute("error", error);
		        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/common/Registrati.jsp");
		        dispatcher.forward(request, response);
		        
		      }
		      
		      
		      AccountUser user = new AccountUser();
		     
		      
		      user.setEmail(email);
		      user.setName(nome);
		      user.setSurname(cognome);
		      user.setPassword(HelperClass.toHash(passwd));
		      user.setAddress(indirizzo);
		      user.setNumber(cellulare);
		      
		      AccountUserDAO userdao=null;		      
		      DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
		      userdao = new AccountUserDAO(ds);
		      try {
		        userdao.doSave(user);
		        
		      } catch (SQLException e) {
		    	  logger.log(Level.WARNING, "Query errata");
		      }
		      
		      
		      
		      RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/common/Login.jsp");
		      dispatcher.forward(request, response);
		    }	    
			
	}


