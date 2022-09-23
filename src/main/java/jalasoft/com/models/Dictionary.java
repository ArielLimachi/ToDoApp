package jalasoft.com.models;

import java.util.Set;

public abstract class Dictionary<T> implements ISearch<T> {

	Set<T> items;

	public abstract void setItems();

	public void addItem(T item) {
		items.add(item);
	}

	public void addItems(Set<T> items) {
		this.items.addAll(items);
	}

	public void removeItem(T item) {
		items.remove(item);
	}

	public Set<T> getItems() {
		return items;
	}
}
