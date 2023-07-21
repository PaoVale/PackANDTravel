package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
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
		AccountUser accountuser=new AccountUser();
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
				accountuser.setAdmin(rs.getBoolean("admin"));

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

	public void doSave(AccountUser user) throws SQLException {
		
		String query;
		PreparedStatement pst=null;
		Connection con=null;
		try {
			con=ds.getConnection();
			query="insert into accountuser(email,passw,nome,cognome,indirizzo,telefono) values(?,?,?,?,?,?)";
			con.setAutoCommit(true);
			pst = con.prepareStatement(query);
			pst.setString(1, user.getEmail());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getName());
			pst.setString(4, user.getSurname());
			pst.setString(5, user.getAddress());
			pst.setString(6,user.getNumber());
			pst.executeUpdate();
		}finally {
			try {
				if(pst != null)
					pst.close();
			}finally{
				if(con != null)
					con.close();
			}
	}
}
	
	public synchronized void doUpdatePassword(String email, String password) throws SQLException {
		String query;
		PreparedStatement pst=null;
		Connection con=null;
		try {
			con=ds.getConnection();
			query = "update accountuser set passw = ? where email = ? ";
			pst = con.prepareStatement(query);
			pst.setString(1, password);
			pst.setString(2, email);
			pst.executeUpdate();
		}finally {
			try {
				if(pst != null)
					pst.close();
			}finally{
				if(con != null)
					con.close();
			}
	}
	}

	public synchronized void doUpdateAddress(String email, String indirizzo) throws SQLException {
		String query;
		PreparedStatement pst=null;
		Connection con=null;
		try {
			con=ds.getConnection();
			query = "update accountuser set indirizzo = ? where email = ? ";
			pst = con.prepareStatement(query);
			pst.setString(1, indirizzo);
			pst.setString(2, email);
			pst.executeUpdate();
		}finally {
			try {
				if(pst != null)
					pst.close();
			}finally{
				if(con != null)
					con.close();
			}
	}
	}
	public synchronized void doUpdateNumber(String email, String cellulare) throws SQLException {
		String query;
		PreparedStatement pst=null;
		Connection con=null;
		try {
			con=ds.getConnection();
			query = "update accountuser set telefono = ? where email = ? ";
			pst = con.prepareStatement(query);
			pst.setString(1, cellulare);
			pst.setString(2, email);
			pst.executeUpdate();
		}finally {
			try {
				if(pst != null)
					pst.close();
			}finally{
				if(con != null)
					con.close();
			}
	}
	}

	public synchronized Collection<AccountUser> doRetriveAll() throws SQLException {
	      Connection con=null;
	      PreparedStatement pst=null;
	      Collection<AccountUser> accountlist = new LinkedList<AccountUser>();
	      
	      String query = "select * from accountuser";
	      
	      try {
	        con = ds.getConnection();
	        pst=con.prepareStatement(query);
	        ResultSet rs=pst.executeQuery();
	        
	        while(rs.next()) {
	          AccountUser user=new AccountUser();
	          user.setEmail(rs.getString("email"));
	          accountlist.add(user);
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
	      
	      return accountlist;
	    }





}