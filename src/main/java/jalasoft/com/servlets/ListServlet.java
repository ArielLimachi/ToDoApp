package jalasoft.com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jalasoft.com.models.CustomDate;
import jalasoft.com.models.Status;
import jalasoft.com.models.Task;
import jalasoft.com.models.ToDoListPersister;
import jalasoft.com.utils.Constants;
import jalasoft.com.utils.TaskBuilder;

public class ListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	TaskBuilder taskBuilder;

	public ListServlet() {
		super();
		ToDoListPersister.getInstance().addTask(new Task("Backend", "Learn React basics", Status.COMPLETE,
				new CustomDate(2022, 9, 20), new CustomDate(2022, 9, 20)));

		ToDoListPersister.getInstance().addTask(new Task("Backend", "Read about dessing patterns", Status.COMPLETE,
				new CustomDate(2022, 9, 20), new CustomDate(2022, 9, 20)));

		ToDoListPersister.getInstance().addTask(new Task("Fronted", "Code a basic calculator", Status.COMPLETE,
				new CustomDate(2022, 9, 20), new CustomDate(2022, 9, 20)));
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect(Constants.JSP_FILE_NAME_NEW_TASK);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ToDoListPersister.getInstance().addTask(taskBuilder.build(request));
		response.sendRedirect(Constants.JSP_FILE_NAME_TO_DO_LIST);
	}
}
