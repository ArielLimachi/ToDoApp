package jalasoft.com.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jalasoft.com.models.ToDoDictionary;
import jalasoft.com.models.Word;
import jalasoft.com.models.WordAutoComplete;

public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ToDoDictionary dictionary;
	private WordAutoComplete autocomplete;

	public SearchServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		dictionary = new ToDoDictionary();
		autocomplete = new WordAutoComplete();

		List<Word> resultSet = dictionary.search(new Word(request.getParameter("wordToSearch")));
		List<String> autocompletePossibleWords = autocomplete.autocomplete(dictionary,
				"" + request.getParameter("wordToSearch"));

		String result = request.getParameter("wordToSearch");
		request.setAttribute("result", result);
		request.setAttribute("resultSet", resultSet);
		request.setAttribute("autocomplete", autocompletePossibleWords);
		request.getRequestDispatcher("SearchResults.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("search post");
	}

}
