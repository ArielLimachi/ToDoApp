package jalasoft.com.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jalasoft.com.models.Task;
import jalasoft.com.models.Word;

public class DictionaryUtils {

	public List<Word> getWordsFromTask(Task task) {
		List<Word> titleWords = phraseToList(task, task.getTitle());
		List<Word> descriptionWords = phraseToList(task, task.getDescription());
		List<Word> words = new ArrayList<>();
		words.addAll(titleWords);
		words.addAll(descriptionWords);
		return words;
	}

	public List<Word> phraseToList(Task task, String phrase) {
		List<String> wordsAsString = Arrays.asList(phrase.split(" "));
		List<Word> words = new ArrayList<Word>();
		for (String wordAsString : wordsAsString) {
			words.add(new Word(wordAsString, task.getId()));
		}
		return words;
	}

}
