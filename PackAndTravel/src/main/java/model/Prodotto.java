package model;

import java.io.Serializable;

public class Prodotto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int codice;
	private String descrizione;
	private double prezzo;
	private String nome;
	private String categoriaNome;
	
	
	
	
	public Prodotto() {
		super();
		
	}

	public Prodotto(String descrizione, double prezzo, String nome, String categoriaNome) {
		
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.nome = nome;
		this.categoriaNome = categoriaNome;
		
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCategoriaNome() {
		return categoriaNome;
	}

	public void setCategoriaNome(String categoriaNome) {
		this.categoriaNome = categoriaNome;
	}

	
	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}
	
	
	
}
