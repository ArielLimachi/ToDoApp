package jalasoft.com.models;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class Task {

	private UUID id;
	private String title;
	private String description;
	private Status status;
	private CustomDate initialDate;
	private CustomDate dueDate;

	public Task() {
		id = UUID.randomUUID();
		title = "To Do";
		description = "No description";
		status = Status.PENDING;
		Date actualDate = new Date();
		dueDate = new CustomDate(actualDate.getYear(), actualDate.getMonth(), actualDate.getDate());
		initialDate = new CustomDate(actualDate.getYear(), actualDate.getMonth(), actualDate.getDate());
	}

	public Task(String title, String description, Status status, CustomDate initialDate, CustomDate dueDate) {
		id = UUID.randomUUID();
		this.title = title;
		this.description = description;
		this.status = status;
		this.initialDate = initialDate;
		this.dueDate = dueDate;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public CustomDate getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(CustomDate initialDate) {
		this.initialDate = initialDate;
	}

	public CustomDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(CustomDate dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		return Objects.equals(id, other.id);
	}
}
