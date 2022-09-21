package jalasoft.com.models;

import java.util.Objects;
import java.util.UUID;

public class Word {

	private String word;
	private UUID taskId;

	public Word(String word, UUID taskId) {
		this.word = word;
		this.taskId = taskId;
	}

	public Word(String word) {
		this.word = word;
		this.taskId = UUID.randomUUID();
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public UUID getTaskId() {
		return taskId;
	}

	public void setTaskId(UUID taskId) {
		this.taskId = taskId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(taskId, word);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		return Objects.equals(taskId, other.taskId) && Objects.equals(word, other.word);
	}
}
