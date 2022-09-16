package jalasoft.com.models;

import java.util.List;
import java.util.UUID;

public class ToDoListPersister {

	private static Page<Task> page = new Page<Task>(10);
	private static Task editingTask;

	public static void addTask(Task task) {
		page.addItem(task);
	}

	public static void removeTask(Task task) {
		page.removeItem(task);
	}

	public static void removeTask(UUID taskId) {
		for (int i = 0; i < page.getItems().size(); i++) {
			if (taskId.equals(page.getItems().get(i).getId())) {
				removeTask(page.getItems().get(i));
			}
		}
	}

	public static void updateTask(Task task) {
		removeTask(editingTask);
		addTask(task);
	}

	public static Task getTaskById(UUID taskId) {
		Task auxTask = new Task();
		for (int i = 0; i < page.getItems().size(); i++) {
			if (taskId.equals(page.getItems().get(i).getId())) {
				auxTask = page.getItems().get(i);
			}
		}
		return auxTask;
	}

	public static List<Task> getTasks() {
		return page.getItems();
	}

	public static void setEditingTask(UUID idTask) {
		editingTask = getTaskById(idTask);
	}

	public static Task getEditingTask() {
		return editingTask;
	}
}
