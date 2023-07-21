package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SetCodiceServlet")
public class SetCodiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public SetCodiceServlet() {
        super();
        }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codice = request.getParameter("code");
		System.out.println("codice in set codice"+codice);
		request.getSession().setAttribute("codice", codice);
		
	    response.sendRedirect(request.getContextPath() + "/common/DettaglioOrdine.jsp");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
