package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.*;

import javax.sql.DataSource;

public class AccountUserDAO {

	private DataSource ds=null;
	
	private static final Logger logger = Logger.getLogger(AccountUserDAO.class.getName());

	public AccountUserDAO(DataSource ds) {
		super();
		this.ds=ds;
	}

	public AccountUser doRetrieveByKey(String email) throws SQLException {
		ResultSet rs;
		String query;
		PreparedStatement pst=null;
		Connection con=null;
		AccountUser accountuser= new AccountUser();
		try {
			con=ds.getConnection();
			query = "select * from accountuser where email = ? ";
			pst = con.prepareStatement(query);
			pst.setString(1, email);
			//pst.setString(2, password);
			rs = pst.executeQuery();

			if(rs.next()) {
				
				accountuser.setEmail(rs.getString("email"));
				accountuser.setPassword(rs.getString("passw"));
				accountuser.setName(rs.getString("nome"));
				accountuser.setSurname(rs.getString("cognome"));
				accountuser.setAddress(rs.getString("indirizzo"));
				accountuser.setNumber(rs.getString("telefono"));

			}

		}catch(Exception e) {
			logger.log(Level.SEVERE, e.getMessage());
			logger.log(Level.SEVERE , e.getMessage());
		} finally {
			try {
				if(pst != null)
					pst.close();
			}finally{
				if(con != null)
					con.close();
			}
			
			
		}
		return accountuser;

	}
}