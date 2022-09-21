package jalasoft.com.models;

import java.util.List;

public interface ISearch<T> {
	List<T> search(T object);
}
