package control;

import java.io.IOException;


import java.sql.Date;
import java.sql.SQLException;

import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import model.OrdineBean;
import model.OrdineDAO;


@WebServlet("/VisualizzaOrdiniAdmin")
public class VisualizzaOrdiniAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public VisualizzaOrdiniAdmin() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = (String)request.getParameter("utente");
	    String startD =  (String)request.getParameter("startDate");
	    String endD = (String)request.getParameter("endDate");
	    DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
	    Date startDate = null;
	    Date endDate = null;
	    

	    
	    
	    if (startD != null && !startD.equals("")) {
	      startDate = java.sql.Date.valueOf(startD);
	    System.out.println("start date in if: "+ startDate);
	    }
	    else {
	      startDate = java.sql.Date.valueOf("2023-04-15");
	    	System.out.println("start date in else: "+ startDate);
	    }
	    if(endD != null && !endD.equals("")) {
	    	
	    
	      endDate = java.sql.Date.valueOf(endD);
	      System.out.println("end date in if: "+ endDate);
	    } else {
	    	
	      endDate = new java.sql.Date(System.currentTimeMillis());
	      System.out.println("end date in else: "+ endDate);
	    }
	    OrdineDAO oDAO = new OrdineDAO(ds);
	    List <OrdineBean> ordineList = null;
	    
	    
	    
	    
	    
		if (email != null && email.equals("all"))
	        try {
	          ordineList = (List<OrdineBean>) oDAO.doRetrieveByData(startDate, endDate);
	        } catch (SQLException e) {
	          //logger.log(Level.WARNING, "Problema accesso DB!");
	        	e.printStackTrace();
	        }
	    else{
	      try {
	        ordineList = (List<OrdineBean>) oDAO.doRetrieveByUserData(email, startDate, endDate);
	      } catch (SQLException e) {
	        //logger.log(Level.WARNING, "Problema accesso DB!");
	    	  e.printStackTrace();
	      }
	    }
	      
	      request.setAttribute("listOrdine", ordineList);
	      RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/GestioneOrdini.jsp");
	      dispatcher.forward(request, response);
	}

}
