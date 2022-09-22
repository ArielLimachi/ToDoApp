package jalasoft.com.models;

import java.util.HashSet;
import java.util.Set;

import jalasoft.com.utils.Constants;
import jalasoft.com.utils.DictionaryUtils;

public class ToDoDictionary extends Dictionary<String> {

	DictionaryUtils dictionaryUtils;
	Set<String> words;

	public ToDoDictionary() {
		dictionaryUtils = new DictionaryUtils();
		setItems();
	}

	@Override
	public String search(String wordToSearch) {
		String resultWords = Constants.EMPTY;
		for (String word : items) {
			if (word.equals(wordToSearch)) {
				resultWords = wordToSearch;
			}
		}
		return resultWords;
	}

	@Override
	public void setItems() {
		items = new HashSet<String>();
		for (Task task : ToDoListPersister.getInstance().getTasks()) {
			addItems(dictionaryUtils.getWordsFromTask(task));
		}
	}

}
