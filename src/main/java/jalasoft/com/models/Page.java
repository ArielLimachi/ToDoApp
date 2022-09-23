package jalasoft.com.models;

import java.util.ArrayList;
import java.util.List;

public class Page<T> {

	private int quantityLimit;
	private List<T> items;

	public Page(int limit) {
		this.quantityLimit = limit;
		items = new ArrayList<>();
	}

	public void addItem(T object) {
		items.add(object);
	}

	public void removeItem(T object) {
		items.remove(object);
	}

	public int getQuantity() {
		return quantityLimit;
	}

	public void setQuantity(int quantity) {
		this.quantityLimit = quantity;
	}

	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}
}
