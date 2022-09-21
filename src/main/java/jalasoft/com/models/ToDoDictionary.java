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
	public List<Word> search(Word word) {
		List<Word> resultWords = new ArrayList<>();
		for (Word words : items) {
			if (words.getWord().equals(word.getWord())) {
				resultWords.add(words);
			}
		}
		return resultWords;
	}

	@Override
	public void setItems() {
		items = new ArrayList<Word>();
		for (Task task : tasks) {
			addItems(dictionaryUtils.getWordsFromTask(task));
		}
	}

}
