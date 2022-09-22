package jalasoft.com.servlets;

import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jalasoft.com.models.ToDoDictionary;
import jalasoft.com.models.Word;

public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ToDoDictionary dictionary;

	public SearchServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		dictionary = new ToDoDictionary();
		List<Word> resultSet = dictionary.search(new Word(request.getParameter("wordToSearch")));

		String result = request.getParameter("wordToSearch");
		request.setAttribute("result", result);
		request.setAttribute("resultSet", resultSet);
		request.getRequestDispatcher("SearchResults.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("search post");
	}

}
