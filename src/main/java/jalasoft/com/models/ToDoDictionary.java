package jalasoft.com.models;

import java.util.ArrayList;
import java.util.List;

public class ToDoDictionary extends Dictionary<String> {

	ToDoListPersister taskPersistence;
	List<Task> tasks;

	public ToDoDictionary() {
		taskPersistence = new ToDoListPersister();
		tasks = taskPersistence.getTasks();
	}

	@Override
	public String search(String object) {
		return null;
	}

	@Override
	public void setItems() {
		items = new ArrayList<String>();
	}

}
