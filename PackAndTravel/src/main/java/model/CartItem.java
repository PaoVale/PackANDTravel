package model;

import java.io.Serializable;

public class CartItem implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Prodotto prodotto;
	private int quantita;
	

	public CartItem(Prodotto prodotto, int quantita) {
		this.prodotto = prodotto;
		this.quantita = quantita;
		
	}

	public Prodotto getProdotto() {
		return prodotto;
	}

	public void setProdotto(Prodotto prodotto) {
		this.prodotto = prodotto;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

}
