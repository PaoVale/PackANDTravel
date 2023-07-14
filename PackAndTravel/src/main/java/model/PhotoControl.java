package model;

import java.io.IOException;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;



public class PhotoControl {
	private  DataSource ds=null;
	
	
	public PhotoControl(DataSource ds) {
		super();
		this.ds=ds;
	}
	

	
	public synchronized byte[] load(int id) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		byte[] bt = null;

		try {
			con = ds.getConnection();
			String query = "SELECT photo FROM prodotto WHERE codice = ?";
			stmt = con.prepareStatement(query);
			
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				bt = rs.getBytes("photo");
			}

		} catch (SQLException sqlException) {
			System.out.println(sqlException);
		} 
		finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
				//logger.log(Level.WARNING, LOG_MSG1);
			} finally {
				if (con != null)
					con.close();
			}
		}
		return bt;
	}
	
	
	public synchronized void updatePhoto(int idA, InputStream photo) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		
		
		try {
			con = ds.getConnection();
			stmt = con.prepareStatement("UPDATE prodotto SET photo = ? WHERE codice = ?");
			try {
				stmt.setBinaryStream(1, photo, photo.available());
				stmt.setInt(2, idA);	
				stmt.executeUpdate();
			} catch (IOException e) {
				e.printStackTrace();
				//logger.log(Level.WARNING, "Problema IO!");
			}
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
				//logger.log(Level.WARNING, LOG_MSG1);
			} finally {
				if (con != null)
					con.close();
			}
		}
	}
}


