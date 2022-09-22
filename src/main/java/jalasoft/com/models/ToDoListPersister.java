package jalasoft.com.models;

import java.util.List;
import java.util.UUID;

public class ToDoListPersister {

	private static ToDoListPersister INSTANCE;
	private Page<Task> page = new Page<Task>(10);
	private Task editingTask;

	private ToDoListPersister() {
	}

	public static ToDoListPersister getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ToDoListPersister();
		}

		return INSTANCE;
	}

	public void addTask(Task task) {
		page.addItem(task);
	}

	public void removeTask(Task task) {
		page.removeItem(task);
	}

	public void removeTask(UUID taskId) {
		for (int i = 0; i < page.getItems().size(); i++) {
			if (taskId.equals(page.getItems().get(i).getId())) {
				removeTask(page.getItems().get(i));
			}
		}
	}

	public void updateTask(Task task) {
		removeTask(editingTask);
		addTask(task);
	}

	public Task getTaskById(UUID taskId) {
		Task auxTask = new Task();
		for (int i = 0; i < page.getItems().size(); i++) {
			if (taskId.equals(page.getItems().get(i).getId())) {
				auxTask = page.getItems().get(i);
			}
		}
		return auxTask;
	}

	public List<Task> getTasks() {
		return page.getItems();
	}

	public void setEditingTask(UUID idTask) {
		editingTask = getTaskById(idTask);
	}

	public Task getEditingTask() {
		return editingTask;
	}
}
