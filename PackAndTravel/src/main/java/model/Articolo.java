package model;

public class Articolo {

	private int codice;
	private String nome;
	private int quantità;
	private int ordine_codice;
	private int prodotto_codice;
	private double prezzo;
	
	
	
	public Articolo() {
		super();
			}



	public Articolo( String nome, int quantità, int ordine_codice, int prodotto_codice, double prezzo) {
		
		this.nome = nome;
		this.quantità = quantità;
		this.ordine_codice = ordine_codice;
		this.prodotto_codice = prodotto_codice;
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



	public int getQuantità() {
		return quantità;
	}



	public void setQuantità(int quantità) {
		this.quantità = quantità;
	}



	public int getOrdine_codice() {
		return ordine_codice;
	}



	public void setOrdine_codice(int ordine_codice) {
		this.ordine_codice = ordine_codice;
	}



	public int getProdotto_codice() {
		return prodotto_codice;
	}



	public void setProdotto_codice(int prodotto_codice) {
		this.prodotto_codice = prodotto_codice;
	}



	public double getPrezzo() {
		return prezzo;
	}



	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	
	
}
