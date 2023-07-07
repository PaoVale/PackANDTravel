package control;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import model.ConnectionDB;

@WebServlet("/DisplayServlet")
public class DisplayServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
    public DisplayServlet() {
        super();
    }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.getWriter().append("Served at: ").append(request.getContextPath());
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    System.out.println("In do post method of Display Image servlet.");
    String imageId=request.getParameter("imageId");
    int id=Integer.parseInt(imageId);
    
    //getting database connection (jdbc code)
        Connection con=null;
        int imgId=0;
        String imgFileName=null;
        try 
        {
        	DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
          
			  PreparedStatement stmt; 
			  String query="select * from prodotto where codice=? ";
			  stmt=con.prepareStatement(query); 
			  stmt.setInt(1, id); 
			  ResultSet rs=stmt.executeQuery();
			         
			  rs.next();
              imgId=rs.getInt("codice");
              imgFileName=rs.getString("foto");
            }
         
        catch (Exception e)
        {
          System.out.println(e);
        }
        
        RequestDispatcher rd;
        request.setAttribute("id",String.valueOf(imgId));  //valueOf
        request.setAttribute("img",imgFileName);
        rd=request.getRequestDispatcher("DisplayImage.jsp");
        rd.forward(request, response);

  }

}