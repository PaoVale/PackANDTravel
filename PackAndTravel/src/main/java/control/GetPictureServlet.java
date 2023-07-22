package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import model.PhotoControl;



@WebServlet("/getPicture")
public class GetPictureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(LoginServlet.class.getName());


	public GetPictureServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");  
		PhotoControl tool=new PhotoControl(ds);
		String idString = (String) request.getParameter("codice");
		int id = Integer.parseInt(idString);
		if (id != 0) 
		{
			byte[] bt = null;
			try {
				bt = tool.load(id);
			} catch (SQLException e) {
				logger.log(Level.WARNING, "Problrma caricamento foto");
			}

			ServletOutputStream out = response.getOutputStream();
			if (bt != null) 
			{
				out.write(bt);
				response.setContentType("image/jpg");
			}
			out.close();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
