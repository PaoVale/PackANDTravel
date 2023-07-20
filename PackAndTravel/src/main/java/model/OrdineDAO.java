package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
//import java.util.logging.Logger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.sql.DataSource;

public class OrdineDAO {
	
	
	private DataSource ds=null;
	//private static Logger logger = Logger.getAnonymousLogger();
	
	 public OrdineDAO(DataSource ds) {
		    super();
		    this.ds=ds;
		  }

	private static final String TABLE_NAME = "ordine";
	
	//stringhe costanti per evitare duplicazioni
	private static final String NUM_ORDINE = "codice";
	private static final String EMAIL = "accout_email";
	private static final String DATA = "data_effettuazione";
	private static final String PREZZO = "prezzo";
	
	private static final String CONST_SELECT = "SELECT * FROM ";
	
	
	
	
	public synchronized void doSave(OrdineBean ordine) throws SQLException { //salva un ordine

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		

		String insertSQL = "INSERT INTO " + OrdineDAO.TABLE_NAME
				+ " (account_email, prezzo_tot) VALUES ( ?,  ?)";

		try {
			connection = ds.getConnection();
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(insertSQL);
			
			preparedStatement.setString(1, ordine.getEmail());
			preparedStatement.setDouble(2, ordine.getPrezzo());
			
			preparedStatement.executeUpdate();
			
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
	}




	public synchronized Collection<OrdineBean> doRetrieveByEmail(String email) throws SQLException{
		Connection con=null;
		  PreparedStatement pst=null;
		  Collection<OrdineBean> ordini = new LinkedList<OrdineBean>();
		  String query= "SELECT * FROM ORDINE WHERE account_email=? ORDER BY data_effettuazione DESC" ;
		  try {
			  con=ds.getConnection();
			  pst=con.prepareStatement(query);
			  pst.setString(1,email);
			  ResultSet rs=pst.executeQuery();
			  while(rs.next()) {
				  OrdineBean ordine=new OrdineBean();
				  ordine.setCodice(rs.getInt("codice"));
				  ordine.setDataOrdine(rs.getDate("data_effettuazione"));
				  ordine.setEmail(rs.getString("account_email"));
				  ordine.setPrezzo(rs.getDouble("prezzo_tot"));
				  ordini.add(ordine);
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
		  
		  return ordini;
		  
	}
	
	public synchronized void doSaveOrdineContieneProdotto(OrdineBean ordine,Prodotto prodotto) throws SQLException { //salva un ordine

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		

		String insertSQL = "INSERT INTO articolo (ordine_codice, codice_prodotto,nome,quantità,prezzo) VALUES ( ?, ?, ?, ?, ?)";

		try {
			connection = ds.getConnection();
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, ordine.getCodice());
			preparedStatement.setInt(2, prodotto.getCodice());
			preparedStatement.setString(3, prodotto.getNome());
			//preparedStatement.setInt(4,ordine.quantità())
			preparedStatement.setDouble(5, prodotto.getPrezzo());
			
			preparedStatement.executeUpdate();
			
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
	}


	
	
	
	
	

}