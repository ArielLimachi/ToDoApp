package jalasoft.com.models;

import java.util.ArrayList;
import java.util.List;

import jalasoft.com.utils.DictionaryUtils;

public class ToDoDictionary extends Dictionary<Word> {

	ToDoListPersister taskPersistence;
	DictionaryUtils dictionaryUtils;
	List<Task> tasks;

	public ToDoDictionary() {
		taskPersistence = new ToDoListPersister();
		tasks = taskPersistence.getTasks();
		dictionaryUtils = new DictionaryUtils();

		setItems();
	}

	@Override
	public Word search(Word word) {
		return null;
	}

	@Override
	public void setItems() {
		items = new ArrayList<Word>();
		for (Task task : tasks) {

			addItems(dictionaryUtils.getWordsFromTask(task));
		}
	}

}
