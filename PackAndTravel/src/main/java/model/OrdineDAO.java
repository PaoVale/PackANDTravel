package model;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.LinkedList;




import javax.sql.DataSource;

public class OrdineDAO {
	
	
	private DataSource ds=null;
	
	
	 public OrdineDAO(DataSource ds) {
		    super();
		    this.ds=ds;
		  }

	private static final String TABLE_NAME = "ordine";
	
	//stringhe costanti per evitare duplicazioni
	private static final String NUM_ORDINE = "codice";
	private static final String EMAIL = "account_email";
	private static final String DATA = "data_effettuazione";
	private static final String PREZZO = "prezzo_tot";
	
	private static final String CONST_SELECT = "SELECT * FROM ";
	
	
	
	
	public synchronized int doSave(OrdineBean ordine) throws SQLException { //salva un ordine

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		int generatedId= 0;
		String insertSQL = "INSERT INTO " + OrdineDAO.TABLE_NAME
				+ " (account_email, prezzo_tot,data_effettuazione) VALUES ( ?,  ?,?)";

		try {
			connection = ds.getConnection();
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setString(1, ordine.getEmail());
			preparedStatement.setDouble(2, ordine.getPrezzo());
			preparedStatement.setDate(3, new java.sql.Date(ordine.getDataOrdine().getTime()));
			int rowsAffected= preparedStatement.executeUpdate();
			if (rowsAffected > 0) {
		          ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
		          if (generatedKeys.next()) {
		              generatedId = generatedKeys.getInt(1);
		              // Utilizza l'ID generato come desideri
		             
		          }
		          
		}} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return generatedId;
	}




	public synchronized Collection<OrdineBean> doRetrieveByEmail(String email) throws SQLException{
		Connection con=null;
		  PreparedStatement pst=null;
		  Collection<OrdineBean> ordini = new LinkedList<>();
		  String query= CONST_SELECT +"ORDINE WHERE account_email=? ORDER BY data_effettuazione DESC" ;
		  try {
			  con=ds.getConnection();
			  pst=con.prepareStatement(query);
			  pst.setString(1,email);
			  ResultSet rs=pst.executeQuery();
			  while(rs.next()) {
				  OrdineBean ordine=new OrdineBean();
				  ordine.setCodice(rs.getInt(NUM_ORDINE));
				  ordine.setDataOrdine(rs.getDate(DATA));
				  ordine.setEmail(rs.getString(EMAIL));
				  ordine.setPrezzo(rs.getDouble(PREZZO));
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




	public synchronized Collection<OrdineBean> doRetrieveByData(Date startDate, Date endDate) throws SQLException { //trova tutti gli ordini di un determinato cliente
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;

	    Collection<OrdineBean> ordini = new LinkedList<>();

	    String selectSQL = CONST_SELECT + OrdineDAO.TABLE_NAME + " WHERE "
	        + "data_effettuazione BETWEEN ? AND ?";

	    
	    try {
	      connection = ds.getConnection();
	      connection.setAutoCommit(true);
	      preparedStatement = connection.prepareStatement(selectSQL);
	      preparedStatement.setDate(1, startDate);
	      preparedStatement.setDate(2, endDate);

	      
	      ResultSet rs = preparedStatement.executeQuery();

	      while (rs.next()) {
	        OrdineBean bean = new OrdineBean();
	        bean.setCodice(rs.getInt(NUM_ORDINE));
	        bean.setEmail(rs.getString(EMAIL));
	        bean.setDataOrdine(rs.getDate(DATA));
	        bean.setPrezzo(rs.getDouble(PREZZO));
	        ordini.add(bean);
	      }

	    } finally {
	      try {
	        if (preparedStatement != null)
	          preparedStatement.close();
	      } finally {
	        if (connection != null)
	          connection.close();
	      }
	    }
	    return ordini;
	  }




	public synchronized Collection<OrdineBean> doRetrieveByUserData(String email, Date startDate, Date endDate) throws SQLException { //trova tutti gli ordini di un determinato cliente
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;

	    Collection<OrdineBean> ordini = new LinkedList<>();

	    String selectSQL = CONST_SELECT  +"ordine WHERE account_email=? AND (data_effettuazione BETWEEN ? AND ?)";
	    
	    try {
	      connection = ds.getConnection();
	      
	      preparedStatement = connection.prepareStatement(selectSQL);
			
			  preparedStatement.setString(1, email);
			  preparedStatement.setDate(2,startDate); 
			  preparedStatement.setDate(3, endDate);
			 
	      
	      ResultSet rs = preparedStatement.executeQuery();

	      while (rs.next()) {
	        OrdineBean bean = new OrdineBean();
	        bean.setCodice(rs.getInt(NUM_ORDINE));
	        bean.setEmail(rs.getString(EMAIL));
	        bean.setDataOrdine(rs.getDate(DATA));
	        bean.setPrezzo(rs.getDouble(PREZZO));
	        
	        ordini.add(bean);
	      }

	    } finally {
	      try {
	        if (preparedStatement != null)
	          preparedStatement.close();
	      } finally {
	        if (connection != null)
	          connection.close();
	      }
	    }
	    return ordini;
	  }


	
	
	
	
	

}