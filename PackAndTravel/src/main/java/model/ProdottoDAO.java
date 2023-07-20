package model;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.LinkedList;
//import java.util.logging.Logger;

import javax.sql.DataSource;

public class ProdottoDAO {
	
	private DataSource ds=null;
	
	  
	  //private static final Logger logger = Logger.getLogger(ProdottoDAO.class.getName());

	  public ProdottoDAO(DataSource ds) {
	    super();
	    this.ds=ds;
	  }
	
	  public synchronized Collection<Prodotto> doRetriveAll(String categoria) throws SQLException {
		  Connection con=null;
		  PreparedStatement pst=null;
		  Collection<Prodotto> prodotti = new LinkedList<Prodotto>();
		  
		  String query = "select * from prodotto";
		  if(categoria != null)
			  query += " where categoria_nome =\""+categoria+"\"";	
		  
		  try {
			  con = ds.getConnection();
			  pst=con.prepareStatement(query);
			  ResultSet rs=pst.executeQuery();
			  
			  while(rs.next()) {
				  Prodotto prodotto=new Prodotto();
				  prodotto.setCodice(rs.getInt("codice"));
				  prodotto.setDescrizione(rs.getString("descrizione"));
				  prodotto.setPrezzo(rs.getDouble("prezzo"));
				  prodotto.setNome(rs.getString("nome"));
				  prodotto.setCategoria_nome(rs.getString("categoria_nome"));
				  prodotti.add(prodotto);
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
		  
		  return prodotti;
	  }
	  
	  public synchronized int doSave(Prodotto prodotto) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		int generatedId =0;
		String query = "insert into prodotto(descrizione,prezzo,nome,categoria_nome) values(?,?,?,?)";
		try {
			con = ds.getConnection();

			pst = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, prodotto.getDescrizione());
			pst.setDouble(2,prodotto.getPrezzo() );
			pst.setString(3,prodotto.getNome());
			pst.setString(4, prodotto.getCategoria_nome());
			//pst.setString(5, prodotto.getFoto());

			int rowsAffected = pst.executeUpdate();
			
			if (rowsAffected > 0) {
			    ResultSet generatedKeys = pst.getGeneratedKeys();
			    if (generatedKeys.next()) {
			        generatedId = generatedKeys.getInt(1);
			        // Utilizza l'ID generato come desideri
			        System.out.println("ID generato: " + generatedId);
			    }
			}

			
		} finally {
			try {
				if(pst != null)
					pst.close();
			}finally{
				if(con != null)
					con.close();
			}
	}
return generatedId;
	  }
	  
	  public synchronized void doDelete(int codice) throws SQLException {
			Connection con = null;
			PreparedStatement pst = null;

			String query = "delete from prodotto where codice = ?";
			try {
				con = ds.getConnection();

				pst = con.prepareStatement(query);
				pst.setInt(1, codice);
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
	  
	  public synchronized void doUpdate(String nomeColonna, String contenutoColonna,int codice) throws SQLException {
			Connection con = null;
			PreparedStatement pst = null;

			String query = "update prodotto set "+ nomeColonna +" = ? where codice=? ";
			try {
				con = ds.getConnection();

				pst = con.prepareStatement(query);
				pst.setString(1,contenutoColonna);
				pst.setInt(2, codice);
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

	public synchronized void doUpdatePrezzo(Double prezzo, int codice) throws SQLException {
		
		Connection con = null;
		PreparedStatement pst = null;

		String query = "update prodotto set prezzo = ? where codice=? ";
		try {
			con = ds.getConnection();

			pst = con.prepareStatement(query);
			pst.setDouble(1,prezzo);
			pst.setInt(2, codice);
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

	public Prodotto doRetrieveByKey(int codice) throws SQLException{
		  Connection con=null;
		  PreparedStatement pst=null;
		  Prodotto prodotto= new Prodotto();
		  
		  String query = "select * from prodotto where codice = ?";
		  
		  
		  try {
			  con = ds.getConnection();
			  pst=con.prepareStatement(query);
			  pst.setInt(1, codice);
			  ResultSet rs=pst.executeQuery();
			  
			  while(rs.next()) {
				  prodotto.setCodice(rs.getInt("codice"));
				  prodotto.setDescrizione(rs.getString("descrizione"));
				  prodotto.setPrezzo(rs.getDouble("prezzo"));
				  prodotto.setNome(rs.getString("nome"));
				  prodotto.setCategoria_nome(rs.getString("categoria_nome"));
				  //foto
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
		  
		  return prodotto;
	  
	}
	  
	public synchronized Collection<Prodotto> SelectProdotto(int codice) throws SQLException {
		  Connection con=null;
		  PreparedStatement pst=null;
		  Collection<Prodotto> prodotti = new LinkedList<Prodotto>();
		  
		  String query = "select * from prodotto where codice=?";
		  
		  try {
			  con = ds.getConnection();
			  pst=con.prepareStatement(query);
			  pst.setInt(1, codice);
			  ResultSet rs=pst.executeQuery();
			  
			  
				  Prodotto prodotto=new Prodotto();
				  prodotto.setCodice(rs.getInt("codice"));
				  prodotto.setDescrizione(rs.getString("descrizione"));
				  prodotto.setPrezzo(rs.getDouble("prezzo"));
				  prodotto.setNome(rs.getString("nome"));
				  prodotto.setCategoria_nome(rs.getString("categoria_nome"));
				  prodotti.add(prodotto);
			  
		  }finally {
				try {
					if(pst != null)
						pst.close();
				}finally{
					if(con != null)
						con.close();
				}
		}
		  
		  return prodotti;
	  }

	public synchronized Collection<Prodotto>  doRetrieveByOrdine(String categoria, String orderValue) throws SQLException {
		 Connection con=null;
		  PreparedStatement pst=null;
		  Collection<Prodotto> prodotti = new LinkedList<Prodotto>();
		  String query = "SELECT * FROM prodotto where categoria_nome =\"" + categoria+ "\"" + "ORDER BY prezzo";
		  if(orderValue.equals("decrescente"))
		  query += " DESC";
		  else if(orderValue.equals("crescente"))
		  query += " ASC";
		  System.out.println(query);		
		  
		  try {
			  con = ds.getConnection();
			  pst=con.prepareStatement(query);
			  ResultSet rs=pst.executeQuery();
			  
			  while(rs.next()) {
				  Prodotto prodotto=new Prodotto();
				  prodotto.setCodice(rs.getInt("codice"));
				  prodotto.setDescrizione(rs.getString("descrizione"));
				  prodotto.setPrezzo(rs.getDouble("prezzo"));
				  prodotto.setNome(rs.getString("nome"));
				  prodotto.setCategoria_nome(rs.getString("categoria_nome"));
				  prodotti.add(prodotto);
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
		  
		  return prodotti;
	  }
	  
	public synchronized Collection<Prodotto> doRetrieveByPrezzo(String categoria, int prezzoMin, int prezzoMax) throws SQLException {
		 Connection con=null;
		  PreparedStatement pst=null;
		  Collection<Prodotto> prodotti = new LinkedList<Prodotto>();
		  String query;
		  
		  if(prezzoMax != 0)
		  query = "SELECT * FROM prodotto WHERE prezzo >=" +prezzoMin+ " AND prezzo <="+ prezzoMax+ " and categoria_nome= \""+categoria+"\"";
		  else	
			  query = "SELECT * FROM prodotto WHERE prezzo >=" +prezzoMin+ " and categoria_nome= \""+categoria+"\"";
		  try {
			  con = ds.getConnection();
			  pst=con.prepareStatement(query);
			  ResultSet rs=pst.executeQuery();
			  
			  while(rs.next()) {
				  Prodotto prodotto=new Prodotto();
				  prodotto.setCodice(rs.getInt("codice"));
				  prodotto.setDescrizione(rs.getString("descrizione"));
				  prodotto.setPrezzo(rs.getDouble("prezzo"));
				  prodotto.setNome(rs.getString("nome"));
				  prodotto.setCategoria_nome(rs.getString("categoria_nome"));
				  prodotti.add(prodotto);
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
		  
		  return prodotti;
	  }
	  
	public synchronized Collection<Prodotto> doRetrieveByPrezzoAndOrdine(String categoria, int prezzoMin, int prezzoMax, String orderValue) throws SQLException {
		 Connection con=null;
		  PreparedStatement pst=null;
		  Collection<Prodotto> prodotti = new LinkedList<Prodotto>();
		  String query=null;
		  
		  if(prezzoMax != 0) {
			  if(orderValue.equals("decrescente"))
				  query = "SELECT * FROM prodotto WHERE prezzo >=" +prezzoMin+ " AND prezzo <="+ prezzoMax+ " and categoria_nome= \""+categoria+"\" order by prezzo desc";
			  else if(orderValue.equals("crescente"))
				  query = "SELECT * FROM prodotto WHERE prezzo >=" +prezzoMin+ " AND prezzo <="+ prezzoMax+ " and categoria_nome= \""+categoria+"\" order by prezzo asc";
		  }
		  else if(prezzoMax==0) {
			  if(orderValue.equals("decrescente"))
				  query = "SELECT * FROM prodotto WHERE prezzo >=" +prezzoMin+ " and categoria_nome= \""+categoria+"\" order by prezzo desc";
			  else if(orderValue.equals("crescente"))
				  query = "SELECT * FROM prodotto WHERE prezzo >=" +prezzoMin+" and categoria_nome= \""+categoria+"\" order by prezzo asc";
		  }
		  try {
			  con = ds.getConnection();
			  pst=con.prepareStatement(query);
			  ResultSet rs=pst.executeQuery();
			  
			  while(rs.next()) {
				  Prodotto prodotto=new Prodotto();
				  prodotto.setCodice(rs.getInt("codice"));
				  prodotto.setDescrizione(rs.getString("descrizione"));
				  prodotto.setPrezzo(rs.getDouble("prezzo"));
				  prodotto.setNome(rs.getString("nome"));
				  prodotto.setCategoria_nome(rs.getString("categoria_nome"));
				  prodotti.add(prodotto);
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
		  
		  return prodotti;
	  }
	  
	  

	  
}
