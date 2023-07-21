package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import model.AccountUserDAO;

/**
 * Servlet implementation class GetUsersListServlet
 */
@WebServlet("/GetUsersListServlet")
public class GetUsersListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public GetUsersListServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
		AccountUserDAO tool=new AccountUserDAO(ds);
		
		try {
			request.setAttribute("listaUtenti", tool.doRetriveAll() );
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin/GestioneOrdini.jsp");
	    dispatcher.forward(request, response);
	}

}
