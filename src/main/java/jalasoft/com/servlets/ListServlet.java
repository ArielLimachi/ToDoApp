package jalasoft.com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jalasoft.com.models.ToDoListPersister;
import jalasoft.com.utils.TaskBuilder;

public class ListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	TaskBuilder taskBuilder;

	public ListServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("newTaskForm.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ToDoListPersister.getInstance().addTask(taskBuilder.build(request));
		response.sendRedirect("ToDoList.jsp");
	}
}
