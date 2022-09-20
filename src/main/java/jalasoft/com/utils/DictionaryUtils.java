package jalasoft.com.utils;

import java.util.Arrays;
import java.util.List;

import jalasoft.com.models.Task;

public class DictionaryUtils {

	public List<String> getWordsFromTask(Task task) {
		List<String> titleWords = phraseToList(task.getTitle());
		List<String> descriptionWords = phraseToList(task.getDescription());
		titleWords.addAll(descriptionWords);
		return titleWords;
	}
	
	public List<String> phraseToList(String phrase) {		
		return Arrays.asList(phrase.split(" "));
	}
}
