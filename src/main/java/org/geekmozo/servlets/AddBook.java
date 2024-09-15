package org.geekmozo.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.geekmozo.dao.BookDao;
import org.geekmozo.entities.Book;
import org.geekmozo.entities.Library;
import org.geekmozo.entities.Student;

import java.io.IOException;

@WebServlet("/addbook")
public class AddBook extends HttpServlet {
    private BookDao bookDao = new BookDao();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String error = "";

        String bookName = req.getParameter("bookName");
        String publisher = req.getParameter("publisher");
        int price = Integer.parseInt(req.getParameter("price"));
        String category = req.getParameter("category");
        String library = req.getParameter("library");
        String libraryIncharge = req.getParameter("libraryIncharge");
        String libraryPosition = req.getParameter("libraryPosition");

        Library libObj = new Library(library,libraryIncharge,libraryPosition);

        Book book = new Book(bookName,publisher,price,category,libObj);
        bookDao.saveBook(book);
        resp.sendRedirect("profile.jsp");
    }
}
