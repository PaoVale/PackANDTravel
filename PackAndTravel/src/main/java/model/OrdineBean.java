package model;

import java.io.Serializable;
import java.sql.Date;

public class OrdineBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	int codice;
	String email;
	Date dataOrdine;
	double prezzo;
	
	
	public OrdineBean(){
		email = "";
		codice = 0;
		prezzo = 0;
	}



	public double getPrezzo() {
		return prezzo;
	}



	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}



	public int getCodice() {
		return codice;
	}



	public void setCodice(int codice) {
		this.codice = codice;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Date getDataOrdine() {
		return dataOrdine;
	}



	public void setDataOrdine(Date dataOrdine) {
		this.dataOrdine = dataOrdine;
	}
	
	
}