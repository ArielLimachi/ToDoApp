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
import jalasoft.com.utils.TaskBuilder;

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
		ToDoListPersister.updateTask(TaskBuilder.build(request));
		response.sendRedirect("ToDoList.jsp");
	}
}
