package model;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

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
	
	
	public synchronized Collection<Articolo> doRetriveAllByKey(int codice) throws SQLException {
	      Connection con=null;
	      PreparedStatement pst=null;
	      Collection<Articolo> articoli = new LinkedList<Articolo>();
	      
	      String query = "select * from articolo where ordine_codice=?";
	     	      
	      try {
	        con = ds.getConnection();
	        pst=con.prepareStatement(query);
	        pst.setInt(1, codice);
	        ResultSet rs=pst.executeQuery();
	        
	        while(rs.next()) {
	          Articolo articolo=new Articolo();
	          articolo.setCodice(rs.getInt("codice"));
	          articolo.setNome(rs.getString("nome"));
	          articolo.setQuantità(rs.getInt("quantità"));
	          articolo.setPrezzo(rs.getDouble("prezzo"));
	          articolo.setOrdine_codice(rs.getInt("ordine_codice"));
	          articolo.setProdotto_codice(rs.getInt("prodotto_codice"));
	          articoli.add(articolo);
	          
	        }
	      }finally {
	        try {
	          if(pst != null)
	            pst.close();
	        }finally{
	          if(con != null)
	            con.close();
	        }
	    }
	      
	      return articoli;
	    }
}
