package jalasoft.com.utils;

import javax.servlet.http.HttpServletRequest;

import jalasoft.com.models.CustomDate;
import jalasoft.com.models.Status;
import jalasoft.com.models.Task;

public class Utils {

	private Utils() {
	}

	static public Task buildTask(HttpServletRequest request) {
		String title = request.getParameter(Constants.TITLE_PARAMETER_NAME);
		String description = request.getParameter(Constants.DESCRIPTION_PARAMETER_NAME);
		String statusAsString = request.getParameter(Constants.STATUS_PARAMETER_NAME);
		Status status = Status.PENDING;
		if (statusAsString.equals("" + Status.COMPLETE)) {
			status = Status.COMPLETE;
		}
		String initialDateAsString = request.getParameter(Constants.INITIAL_DATE_PARAMETER_NAME);
		String dueDateAsString = request.getParameter(Constants.DUE_DATE_PARAMETER_NAME);

		return new Task(title, description, status, buildDate(initialDateAsString), buildDate(dueDateAsString));
	}

	static public CustomDate buildDate(String dateAsString) {
		String[] aux = dateAsString.split(Constants.HYPHEN);
		int year = Integer.parseInt(aux[0]);
		int month = Integer.parseInt(aux[1]);
		int day = Integer.parseInt(aux[2]);
		return new CustomDate(year, month, day);
	}
}
