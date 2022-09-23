package jalasoft.com.servlets;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jalasoft.com.models.ToDoListPersister;
import jalasoft.com.utils.Constants;
import jalasoft.com.utils.Utils;

public class EditServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public EditServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter(Constants.ID_PARAMETER_NAME);
		ToDoListPersister.getInstance().setEditingTask(UUID.fromString(id));
		response.sendRedirect(Constants.JSP_FILE_NAME_EDIT_TASK);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ToDoListPersister.getInstance().updateTask(Utils.buildTask(request));
		response.sendRedirect(Constants.JSP_FILE_NAME_TO_DO_LIST);
	}
}
