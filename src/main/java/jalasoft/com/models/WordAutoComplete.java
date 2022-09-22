package jalasoft.com.models;

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.SynthPasswordFieldUI;

public class WordAutoComplete {

	List<String> possibleWords;

	public WordAutoComplete() {
		possibleWords = new ArrayList<>();
	}

	public List<String> autocomplete(ToDoDictionary dictionary, String wordAsString) {

		purgeList();
		for (String dictionaryWord : dictionary.getItems()) {
			if (dictionaryWord.contains(wordAsString)) {
				possibleWords.add(dictionaryWord);
			}
		}

		return possibleWords;
	}

	public void purgeList() {
		if (!possibleWords.isEmpty()) {
			possibleWords.removeAll(possibleWords);
		}
	}

}
