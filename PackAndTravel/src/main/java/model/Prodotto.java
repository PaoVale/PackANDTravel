package model;

public class Prodotto {
	
	private int codice;
	private String descrizione;
	private double prezzo;
	private String nome;
	private String categoria_nome;
	private String foto;
	
	
	
	public Prodotto() {
		super();
		
	}

	public Prodotto(String descrizione, double prezzo, String nome, String categoria_nome, String foto) {
		
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.nome = nome;
		this.categoria_nome = categoria_nome;
		this.foto = foto;
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

	public String getCategoria_nome() {
		return categoria_nome;
	}

	public void setCategoria_nome(String categoria_nome) {
		this.categoria_nome = categoria_nome;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}
	
	
	
}
