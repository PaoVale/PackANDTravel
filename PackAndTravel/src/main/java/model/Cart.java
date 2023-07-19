package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cart implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<CartItem> items;

	public Cart() {
		items = new ArrayList<>();
	}

	public void addProduct(Prodotto prodotto) {
		for (CartItem item : items) {
			if (item.getProdotto().getCodice() == prodotto.getCodice()) {
				item.setQuantita(item.getQuantita() + 1);
				return;
			}
		}
		items.add(new CartItem(prodotto, 1));
	}

	public void deleteProduct(Prodotto prodotto) {
		for (CartItem item : items) {
			if (item.getProdotto().getCodice() == prodotto.getCodice()) {
				if (item.getQuantita() > 1) {
					item.setQuantita(item.getQuantita() - 1);
				} else {
					items.removeIf(a -> a.getProdotto().getCodice() == prodotto.getCodice());
				}
				return;
			}
		}
	}
	
	public List<CartItem> getProducts() {
		return items;
	}
	
	public int getItemsCount() {
		return items.stream().mapToInt(i->i.getQuantita()).sum();
	}
	
	public double getTotale() {
		return items.stream().mapToDouble(i->i.getProdotto().getPrezzo()*i.getQuantita()).sum();
	}
	
	
}
