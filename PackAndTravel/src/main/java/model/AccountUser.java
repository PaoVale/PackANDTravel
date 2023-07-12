package model;

public class AccountUser {
  private String name;
  private String surname;
  private String email;
  private String password;
  private String address;
  private String number;
  boolean isAdmin;
  
  
  
  public AccountUser() {
    super();
  }


  public AccountUser(String name, String surname, String email, String password, String address, String number) {
    this.name = name;
    this.surname = surname;
    this.email = email;
    this.password = password;
    this.address = address;
    this.number = number;
    this.isAdmin = false;
  }


  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public String getSurname() {
    return surname;
  }


  public void setSurname(String surname) {
    this.surname = surname;
  }


  public String getEmail() {
    return email;
  }


  public void setEmail(String email) {
    this.email = email;
  }


  public String getPassword() {
    return password;
  }


  public void setPassword(String password) {
    this.password = password;
  }


  public String getAddress() {
    return address;
  }


  public void setAddress(String address) {
    this.address = address;
  }


  public String getNumber() {
    return number;
  }


  public void setNumber(String number) {
    this.number = number;
  }


  public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}  
 
  
  

}