package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AccountUserDAO;
import model.ConnectionDB;
import model.AccountUser;

/* Servlet implementation class LoginServlet*/
 
@WebServlet("/user-login")
public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
    response.sendRedirect("Login.jsp");
  }

  /* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  response.setContentType("text/html; charset=UTF=8");
  try(PrintWriter out = response.getWriter()){
    String email= request.getParameter("email");
    String password= request.getParameter("password");
    
    AccountUserDAO udao = new AccountUserDAO(ConnectionDB.getConnection());
    AccountUser user = udao.userLogin(email, password); 
    
    if(user != null) {
		
		  request.getSession().setAttribute("auth", user);
		  response.sendRedirect("Index.jsp");
		 
    }else {
    	response.sendRedirect("Login.jsp");
    	request.getSession().setAttribute("accessoNegato", true);
		
  }
  }
  }

}