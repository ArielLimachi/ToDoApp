package jalasoft.com.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jalasoft.com.models.Task;
import jalasoft.com.models.ToDoDictionary;
import jalasoft.com.models.ToDoListPersister;
import jalasoft.com.models.WordAutoComplete;
import jalasoft.com.utils.Constants;

public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ToDoDictionary dictionary;
	private WordAutoComplete autocomplete;
	private List<Task> resultSet;
	private List<String> autocompletePossibleWords;

	public SearchServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		dictionary = new ToDoDictionary();
		autocomplete = new WordAutoComplete();

		resultSet = ToDoListPersister.getInstance()
				.getTaskByWord(Constants.EMPTY + request.getParameter(Constants.WORD_PARAMETER_NAME));

		autocompletePossibleWords = autocomplete.autocomplete(dictionary,
				Constants.EMPTY + request.getParameter(Constants.WORD_PARAMETER_NAME));

		String result = request.getParameter(Constants.WORD_PARAMETER_NAME);
		request.setAttribute(Constants.RESULT_PARAMETER_NAME, result);
		request.setAttribute(Constants.RESULT_SET_PARAMETER_NAME, resultSet);
		request.setAttribute(Constants.AUTOCOMPLETE_PARAMETER_NAME, autocompletePossibleWords);
		request.getRequestDispatcher(Constants.JSP_FILE_NAME_SEARCH_TASK).forward(request, response);
	}
}
