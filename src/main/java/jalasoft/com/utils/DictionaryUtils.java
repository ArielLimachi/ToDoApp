package jalasoft.com.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import jalasoft.com.models.Task;

public class DictionaryUtils {

	private DictionaryUtils() {
	}

	static public Set<String> getWordsFromTask(Task task) {
		Set<String> titleWords = phraseToList(task, task.getTitle());
		Set<String> descriptionWords = phraseToList(task, task.getDescription());
		Set<String> words = new HashSet<String>();
		words.addAll(titleWords);
		words.addAll(descriptionWords);
		return words;
	}

	static Set<String> phraseToList(Task task, String phrase) {
		Set<String> items = new HashSet<String>(Arrays.asList(phrase.split(Constants.SPACE)));
		return items;
	}

}
