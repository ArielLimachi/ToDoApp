package jalasoft.com.models;

import java.util.HashSet;
import java.util.Set;

import jalasoft.com.utils.Constants;
import jalasoft.com.utils.DictionaryUtils;

public class ToDoDictionary extends Dictionary<String> {

	Set<String> words;

	public ToDoDictionary() {
		setItems();
	}

	@Override
	public String search(String wordToSearch) {
		return items.stream().allMatch(word -> word.equals(wordToSearch)) ? wordToSearch
				: Constants.WORD_NOT_FOUND_IN_DICTIONARY;
	}

	@Override
	public void setItems() {
		items = new HashSet<String>();
		for (Task task : ToDoListPersister.getInstance().getTasks()) {
			addItems(DictionaryUtils.getWordsFromTask(task));
		}
	}

}
