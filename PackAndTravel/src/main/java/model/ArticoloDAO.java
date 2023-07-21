package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class ArticoloDAO {

	private DataSource ds=null;

	public ArticoloDAO(DataSource ds) {
		super();
		this.ds = ds;
	}
	
	
	public synchronized void doSave(Articolo articolo) throws SQLException {
	    Connection con = null;
	    PreparedStatement pst = null;
	    
	    String query = "insert into articolo(nome,quantità,prezzo,ordine_codice,prodotto_codice) values(?,?,?,?,?)";
	    try {
	      con = ds.getConnection();

	      pst = con.prepareStatement(query);
	      pst.setString(1, articolo.getNome());
	      pst.setInt(2, articolo.getQuantità());
	      pst.setDouble(3,articolo.getPrezzo() );
	      pst.setInt(4, articolo.getOrdine_codice());
	      pst.setInt(5, articolo.getProdotto_codice() );
	     

	      pst.executeUpdate();
	      
	          
	    } finally {
	      try {
	        if(pst != null)
	          pst.close();
	      }finally{
	        if(con != null)
	          con.close();
	      }
	  }
	
	    }
	
}
