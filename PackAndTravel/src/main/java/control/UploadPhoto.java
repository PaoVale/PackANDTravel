package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.DataSource;

import model.PhotoControl;



@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50) 

/**
 * Servlet implementation class UploadPhoto
 */
@WebServlet("/UploadPhoto")
public class UploadPhoto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(UploadPhoto.class.getName());
	

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadPhoto() {
        super();
      
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");  
		PhotoControl tool=new PhotoControl(ds);
		int codice= (int) request.getAttribute("codice");
		Part filePart = request.getPart("immagine");
		
        
        try {
			tool.updatePhoto(codice, filePart.getInputStream());
		} catch (SQLException sqlException) {
			logger.log(Level.WARNING, "Problema SQL!");
			
		}
		

		
	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin/ProductView.jsp");
	  dispatcher.forward(request, response);
	 
	}
	}


