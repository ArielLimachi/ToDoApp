package jalasoft.com.servlets;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jalasoft.com.models.ToDoListPersister;
import jalasoft.com.utils.TaskBuilder;

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ToDoListPersister toDoListPersister;

	public DeleteServlet() {
		super();
		toDoListPersister = new ToDoListPersister();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		toDoListPersister.removeTask(UUID.fromString(id));

		response.sendRedirect("ToDoList.jsp");

	}
}
