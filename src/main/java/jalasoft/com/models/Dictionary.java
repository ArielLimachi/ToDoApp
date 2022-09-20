package jalasoft.com.models;

import java.util.List;

public abstract class Dictionary<T> implements ISearch<T> {

	List<T> items;

	public abstract void setItems();

	public void addItem(T item) {
		items.add(item);
	}

	public void addItems(List<T> items) {
		this.items.addAll(items);
	}

	public void removeItem(T item) {
		items.remove(item);
	}

	public List<T> getItems() {
		return items;
	}
}
