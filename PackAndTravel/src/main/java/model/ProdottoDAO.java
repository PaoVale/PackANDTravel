package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.logging.Logger;

import javax.sql.DataSource;

public class ProdottoDAO {
	
	private DataSource ds=null;
	  
	  private static final Logger logger = Logger.getLogger(ProdottoDAO.class.getName());

	  public ProdottoDAO(DataSource ds) {
	    super();
	    this.ds=ds;
	  }
	
	  public synchronized Collection<Prodotto> doRetriveAll(String order) throws SQLException {
		  Connection con=null;
		  PreparedStatement pst=null;
		  Collection<Prodotto> prodotti = new LinkedList<Prodotto>();
		  String query = "select * from prodotto";
		  
		  if(order!=null && !order.equals("")) {
			  query += "ORDER BY "+order;
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
				  prodotto.setFoto(rs.getString("foto"));
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
