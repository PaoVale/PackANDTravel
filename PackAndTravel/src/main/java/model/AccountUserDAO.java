package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.*;




public class AccountUserDAO {
  private Connection con;
  
  
  
  private static final Logger logger = Logger.getLogger(AccountUserDAO.class.getName());
  
  public AccountUserDAO(Connection con){
    this.con=con;
    
  }

  public AccountUser userLogin(String email, String password) {
    ResultSet rs;
    String query;
    PreparedStatement pst;
    AccountUser accountuser= null;
    try {
      
      query = "select * from accountuser where email = ? and passw = ?";
      pst = this.con.prepareStatement(query);
      pst.setString(1, email);
      pst.setString(2, password);
      rs = pst.executeQuery();
      
      if(rs.next()) {
        accountuser = new AccountUser();
        accountuser.setEmail(rs.getString("email"));
        //user.setPassword(rs.getString("passw"));
        accountuser.setName(rs.getString("nome"));
        accountuser.setSurname(rs.getString("cognome"));
        accountuser.setAddress(rs.getString("indirizzo"));
        accountuser.setNumber(rs.getString("telefono"));
        
      }
      
    }catch(Exception e) {
      e.printStackTrace();
      logger.log(Level.SEVERE , e.getMessage());
    }
    return accountuser;
  
  }
}