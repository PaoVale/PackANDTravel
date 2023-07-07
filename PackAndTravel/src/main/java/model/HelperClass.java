package model;

import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HelperClass {
  
  private HelperClass() {
  }
  private static Logger logger = Logger.getAnonymousLogger();
  
  public static String toHash(String password) {
    StringBuilder sb = new StringBuilder();
        try {
            java.security.MessageDigest digest = java.security.MessageDigest.getInstance("SHA-512");
            if(password != null) {
              byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
              for (int i = 0; i < hash.length; i++) {
                sb.append(Integer.toHexString( 
                                  (hash[i] & 0xFF) | 0x100 
                              ).toLowerCase().substring(1,3));
              }
            }
        } catch (java.security.NoSuchAlgorithmException e) {
          logger.log(Level.WARNING, "Problema hash pswd!");
        }
        return sb.toString();
    }}