package model;

public class Articolo {

	private int codice;
	private String nome;
	private int quantita;
	private int ordineCodice;
	private int prodottoCodice;
	private double prezzo;
	
	
	
	public Articolo() {
		super();
			}



	public Articolo( String nome, int quantita, int ordineCodice, int prodottoCodice, double prezzo) {
		
		this.nome = nome;
		this.quantita = quantita;
		this.ordineCodice = ordineCodice;
		this.prodottoCodice = prodottoCodice;
		this.prezzo = prezzo;
	}



	public int getCodice() {
		return codice;
	}



	public void setCodice(int codice) {
		this.codice = codice;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public int getQuantita() {
		return quantita;
	}



	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}



	public int getOrdineCodice() {
		return ordineCodice;
	}



	public void setOrdineCodice(int ordineCodice) {
		this.ordineCodice = ordineCodice;
	}



	public int getProdottoCodice() {
		return prodottoCodice;
	}



	public void setProdottoCodice(int prodottoCodice) {
		this.prodottoCodice = prodottoCodice;
	}



	public double getPrezzo() {
		return prezzo;
	}



	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	
	
}
