package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
//import java.util.logging.Logger;

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
				+ " (account_email, data_effettuazione,prezzo_tot) VALUES ( ?, ?, ?)";

		try {
			connection = ds.getConnection();
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(insertSQL);
			
			preparedStatement.setString(1, ordine.getEmail());
			preparedStatement.setDate(2, new java.sql.Date(ordine.getDataOrdine().getTime()));
			preparedStatement.setDouble(3, ordine.getPrezzo());
			
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


	
	public synchronized OrdineBean doRetrieveByKey(int numeroOrd) throws SQLException{ //trova un ordine
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		OrdineBean bean = new OrdineBean();
		String selectSQL = CONST_SELECT + OrdineDAO.TABLE_NAME + " WHERE codice = ?";
		try {
			connection = ds.getConnection();	
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, numeroOrd);
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				bean.setCodice(rs.getInt(NUM_ORDINE));
				bean.setEmail(rs.getString(EMAIL));
				bean.setDataOrdine(rs.getDate(DATA));
				bean.setPrezzo(rs.getDouble(PREZZO));
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
		return bean;
	}

	
	public synchronized Collection<OrdineBean> doRetrieveAll(String order) throws SQLException { //trova tutti gli ordini
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<OrdineBean> ordini = new LinkedList<>();

		String selectSQL = CONST_SELECT + OrdineDAO.TABLE_NAME + " ORDER BY ?";

		

		try {
			connection = ds.getConnection();
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(selectSQL);
			if (order != null && !order.equals("")) {
				preparedStatement.setString(1, order);
			}

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				OrdineBean bean = new OrdineBean();
				bean.setCodice(rs.getInt(NUM_ORDINE));
				bean.setEmail(rs.getString(EMAIL));
				bean.setDataOrdine(rs.getDate(DATA));
				
				
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
	
	
	public synchronized Collection<OrdineBean> doRetrieveByEmail(String email, String order) throws SQLException { //trova tutti gli ordini di un determinato cliente
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<OrdineBean> ordini = new LinkedList<>();

		String selectSQL = CONST_SELECT + OrdineDAO.TABLE_NAME + " WHERE email=? ORDER BY ?";

		

		try {
			connection = ds.getConnection();
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, email);
			if (order != null && !order.equals("")) {
				preparedStatement.setString(2, order);
			}
			
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				OrdineBean bean = new OrdineBean();
				bean.setCodice(rs.getInt(NUM_ORDINE));
				bean.setEmail(rs.getString(EMAIL));
				bean.setDataOrdine(rs.getDate(DATA));
				
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
	
	
	public synchronized int doRetrieveMaxNumOrdine() throws SQLException{ //trova il numero ordine da utulizzare
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String selectSQL = "SELECT MAX(numero_ord) AS MAX FROM " + OrdineDAO.TABLE_NAME;
		
		int max = 0 ;
		
		try {
			connection = ds.getConnection();	
			preparedStatement = connection.prepareStatement(selectSQL);
			ResultSet rs = preparedStatement.executeQuery();
			
			
			while (rs.next()) {
				max = rs.getInt("MAX");
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
		return max;
	}
	
	public synchronized Collection<OrdineBean> doRetrieveByUserData(String email, Date startDate, Date endDate) throws SQLException { //trova tutti gli ordini di un determinato cliente
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<OrdineBean> ordini = new LinkedList<>();

		String selectSQL = CONST_SELECT + OrdineDAO.TABLE_NAME + " WHERE email=? "
				+ " AND data BETWEEN ? AND ?";

		
		try {
			connection = ds.getConnection();
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, email);
			preparedStatement.setDate(2, startDate);
			preparedStatement.setDate(3, endDate);

			
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				OrdineBean bean = new OrdineBean();
				bean.setCodice(rs.getInt(NUM_ORDINE));
				bean.setEmail(rs.getString(EMAIL));
				bean.setDataOrdine(rs.getDate(DATA));
				
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
	
	public synchronized Collection<OrdineBean> doRetrieveByData(Date startDate, Date endDate) throws SQLException { //trova tutti gli ordini di un determinato cliente
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<OrdineBean> ordini = new LinkedList<>();

		String selectSQL = CONST_SELECT + OrdineDAO.TABLE_NAME + " WHERE "
				+ "data BETWEEN ? AND ?";

		
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