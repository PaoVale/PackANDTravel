package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;




public class AccountUserDAO {
  private Connection con;
  private String query;
  private PreparedStatement pst;
  private ResultSet rs;
  
  public AccountUserDAO(Connection con){
    this.con=con;
    
  }

  public AccountUser userLogin(String email, String password) {
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
      System.out.print(e.getMessage());
    }
    return accountuser;
  
  }
}