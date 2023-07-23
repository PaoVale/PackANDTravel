package model;


import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.LinkedList;

import javax.sql.DataSource;

public class ProdottoDAO {
	
	private DataSource ds=null;

	  public ProdottoDAO(DataSource ds) {
	    super();
	    this.ds=ds;
	  }
	  private static final String CRESCENTE = "crescente";
	  private static final String DECRESCENTE = "decrescente";
	  private static final String CATEGORIA = "categoria_nome";
	  private static final String PREZZO = "prezzo";
	  private static final String CODICE = "codice";
	  private static final String DESCRIZIONE = "descrizione";
	  
	  public synchronized Collection<Prodotto> doRetriveAll(String categoria) throws SQLException {
		  Connection con=null;
		  PreparedStatement pst=null;
		  Collection<Prodotto> prodotti = new LinkedList<>();
		  
		  String query = "select * from prodotto";
		  if(categoria != null)
			  query += " where categoria_nome = ?";	
		  
		  try {
			  con = ds.getConnection();
			  pst=con.prepareStatement(query);
			  if(categoria != null)
				  pst.setString(1, categoria);
			  ResultSet rs=pst.executeQuery();
			  
			  while(rs.next()) {
				  Prodotto prodotto=new Prodotto();
				  prodotto.setCodice(rs.getInt(CODICE));
				  prodotto.setDescrizione(rs.getString(DESCRIZIONE));
				  prodotto.setPrezzo(rs.getDouble(PREZZO));
				  prodotto.setNome(rs.getString("nome"));
				  prodotto.setCategoriaNome(rs.getString(CATEGORIA));
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
			pst.setString(4, prodotto.getCategoriaNome());

			int rowsAffected = pst.executeUpdate();
			
			if (rowsAffected > 0) {
			    ResultSet generatedKeys = pst.getGeneratedKeys();
			    if (generatedKeys.next()) {
			        generatedId = generatedKeys.getInt(1);
			        // Utilizza l'ID generato come desideri
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
				  prodotto.setCodice(rs.getInt(CODICE));
				  prodotto.setDescrizione(rs.getString(DESCRIZIONE));
				  prodotto.setPrezzo(rs.getDouble(PREZZO));
				  prodotto.setNome(rs.getString("nome"));
				  prodotto.setCategoriaNome(rs.getString(CATEGORIA));
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
	  
	public synchronized Collection<Prodotto>  doRetrieveByOrdine(String categoria, String orderValue) throws SQLException {
		 Connection con=null;
		  PreparedStatement pst=null;
		  Collection<Prodotto> prodotti = new LinkedList<>();
		  String query = "SELECT * FROM prodotto where categoria_nome = ? ORDER BY prezzo";
		  if(orderValue.equals(DECRESCENTE)) {
		  query += " DESC";
		  }
		  else if(orderValue.equals(CRESCENTE)) {
			  query += " ASC";
		  }
		  		
		  
		  try {
			  con = ds.getConnection();
			  pst=con.prepareStatement(query);
			  pst.setString(1,categoria);
			  ResultSet rs=pst.executeQuery();
			  
			  while(rs.next()) {
				  Prodotto prodotto=new Prodotto();
				  prodotto.setCodice(rs.getInt(CODICE));
				  prodotto.setDescrizione(rs.getString(DESCRIZIONE));
				  prodotto.setPrezzo(rs.getDouble(PREZZO));
				  prodotto.setNome(rs.getString("nome"));
				  prodotto.setCategoriaNome(rs.getString(CATEGORIA));
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
		  Collection<Prodotto> prodotti = new LinkedList<>();
		  String query = "SELECT * FROM prodotto WHERE prezzo >= ? AND categoria_nome = ?";
		  
		  if (prezzoMax != 0) {
			    query = "SELECT * FROM prodotto WHERE prezzo >= ? AND prezzo <= ? AND categoria_nome = ?";
			}
		  try {
			  con = ds.getConnection();
			  pst=con.prepareStatement(query);
			  // Imposto i parametri dei prepared statement
			    pst.setInt(1, prezzoMin); // Imposto il parametro ? con prezzoMin
			    
			    if (prezzoMax != 0) {
			        pst.setInt(2, prezzoMax); // Imposto il parametro ? con prezzoMax
			        pst.setString(3, categoria); // Imposto il parametro ? con categoria
			    } else {
			        pst.setString(2, categoria); // Imposto il parametro ? con categoria
			    }
			  ResultSet rs=pst.executeQuery();
			  
			  while(rs.next()) {
				  Prodotto prodotto=new Prodotto();
				  prodotto.setCodice(rs.getInt(CODICE));
				  prodotto.setDescrizione(rs.getString(DESCRIZIONE));
				  prodotto.setPrezzo(rs.getDouble(PREZZO));
				  prodotto.setNome(rs.getString("nome"));
				  prodotto.setCategoriaNome(rs.getString(CATEGORIA));
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
		  Collection<Prodotto> prodotti = new LinkedList<>();
		  String query=null;
		  
		  if (prezzoMax != 0) {
			    if (orderValue.equals(DECRESCENTE)) {
			        query = "SELECT * FROM prodotto WHERE prezzo >= ? AND prezzo <= ? AND categoria_nome = ? ORDER BY prezzo DESC";
			    } else if (orderValue.equals(CRESCENTE)) {
			        query = "SELECT * FROM prodotto WHERE prezzo >= ? AND prezzo <= ? AND categoria_nome = ? ORDER BY prezzo ASC";
			    }
			} else {
			    if (orderValue.equals(DECRESCENTE)) {
			        query = "SELECT * FROM prodotto WHERE prezzo >= ? AND categoria_nome = ? ORDER BY prezzo DESC";
			    } else if (orderValue.equals(CRESCENTE)) {
			        query = "SELECT * FROM prodotto WHERE prezzo >= ? AND categoria_nome = ? ORDER BY prezzo ASC";
			    }
			}

			try {
			    con = ds.getConnection();
			    pst = con.prepareStatement(query);

			    // Imposto i parametri dei prepared statement
			    int parameterIndex = 1;
			    pst.setDouble(parameterIndex++, prezzoMin); // Imposto il parametro ? con prezzoMin

			    if (prezzoMax != 0) {
			        pst.setDouble(parameterIndex++, prezzoMax); // Imposto il parametro ? con prezzoMax
			    }

			    pst.setString(parameterIndex, categoria);
			  ResultSet rs=pst.executeQuery();
			  
			  while(rs.next()) {
				  Prodotto prodotto=new Prodotto();
				  prodotto.setCodice(rs.getInt(CODICE));
				  prodotto.setDescrizione(rs.getString(DESCRIZIONE));
				  prodotto.setPrezzo(rs.getDouble(PREZZO));
				  prodotto.setNome(rs.getString("nome"));
				  prodotto.setCategoriaNome(rs.getString(CATEGORIA));
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
