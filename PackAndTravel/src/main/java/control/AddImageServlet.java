package control;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.DataSource;

import model.ConnectionDB;



@MultipartConfig
@WebServlet("/AddImageServlet")
public class AddImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddImageServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		
		String codice=request.getParameter("codice");
	    int cod=Integer.parseInt(codice);
	    
		System.out.println("Sono nel do post");
		Part file=request.getPart("image");
		
		String imageFileName=file.getSubmittedFileName();
		System.out.println("file name:"+imageFileName);
		
		String uploadPath="C:/Users/La Pao/git/PackAndTravel/PackAndTravel/WEBCONTENT/images/"+imageFileName;
		System.out.println("Upload path = "+uploadPath);
		
		
		DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
		
		try {
		FileOutputStream fos= new FileOutputStream(uploadPath);
		InputStream is=file.getInputStream();
		byte[] data=new byte[is.available()];
		is.read(data);
		fos.write(data);
		fos.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		Connection con=null;
		try {
			//con=ConnectionDB.getConnection();
			con=ds.getConnection();
			PreparedStatement pst=null;
			String query="update prodotto set foto=? where codice=?";
			pst=con.prepareStatement(query);
			pst.setString(1, imageFileName);
			pst.setInt(2, cod);
			int rows=pst.executeUpdate();
			
			if(rows>0)
			{
				System.out.println("imagine aggiunta");
			}else {
				System.out.println("immagine non aggiunta");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		response.sendRedirect("AddImage.jsp");
	}

}
