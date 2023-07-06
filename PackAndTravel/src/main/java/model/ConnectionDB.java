package model;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionDB {
  

  private static DataSource ds;
  static Connection conn = null;

  public static Connection getConnection()  {
    try {
      Context initCtx = new InitialContext();
      Context envCtx = (Context) initCtx.lookup("java:comp/env");

      ds = (DataSource) envCtx.lookup("jdbc/packandtravel");
      conn = ds.getConnection();
      System.err.print("nel Database\n");

    } catch (NamingException e) {
      System.err.print("non nel Database");
      System.err.println("Error:" + e.getMessage());
      
    } catch (SQLException e) {
 
      e.printStackTrace();
    }
return conn;
  }
  
}