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
import jalasoft.com.utils.Utils;

public class ListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ListServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect(Constants.JSP_FILE_NAME_NEW_TASK);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ToDoListPersister.getInstance().addTask(Utils.buildTask(request));
		response.sendRedirect(Constants.JSP_FILE_NAME_TO_DO_LIST);
	}
}
