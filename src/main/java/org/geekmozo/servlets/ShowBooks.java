package org.geekmozo.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.geekmozo.dao.BookDao;
import org.geekmozo.entities.Book;
import org.geekmozo.entities.Library;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/showBooks")
public class ShowBooks extends HttpServlet {
    private BookDao bookDao = new BookDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookDao.getBooks();
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        pw.println(books);
        req.setAttribute("books", books);
        req.getRequestDispatcher("showBooks.jsp").forward(req, resp);

    }
}
