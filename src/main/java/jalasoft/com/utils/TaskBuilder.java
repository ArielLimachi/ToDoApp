package jalasoft.com.utils;

import javax.servlet.http.HttpServletRequest;

import jalasoft.com.models.CustomDate;
import jalasoft.com.models.Status;
import jalasoft.com.models.Task;

public class TaskBuilder {

	public Task build(HttpServletRequest request) {
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String statusAsString = request.getParameter("status");
		Status status = Status.PENDING;
		if(statusAsString.equals(""+Status.COMPLETE)) {
			status = Status.COMPLETE;
		}		
		String initialDateAsString = request.getParameter("initialDate");
		String dueDateAsString = request.getParameter("dueDate");

		return new Task(title, description, status, buildDate(initialDateAsString), buildDate(dueDateAsString));
	}
	
	public CustomDate buildDate(String dateAsString) {
		String[] aux = dateAsString.split("-");
		int year = Integer.parseInt(aux[0]);
		int month = Integer.parseInt(aux[1]);
		int day = Integer.parseInt(aux[2]);
		return new CustomDate(year, month, day);
	}	
}
