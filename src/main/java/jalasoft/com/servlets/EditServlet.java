package jalasoft.com.servlets;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jalasoft.com.models.CustomDate;
import jalasoft.com.models.Status;
import jalasoft.com.models.Task;
import jalasoft.com.models.ToDoListPersister;

public class EditServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public EditServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		ToDoListPersister.setEditingTask(UUID.fromString(id));
		response.sendRedirect("EditTask.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ToDoListPersister.updateTask(buildTask(request));

		response.sendRedirect("ToDoList.jsp");
	}

	public Task buildTask(HttpServletRequest request) {
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String statusAsString = request.getParameter("status");
		Status status = Status.PENDING;
		switch (statusAsString) {
		case "DONE":
			status = Status.COMPLETE;
			break;
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
