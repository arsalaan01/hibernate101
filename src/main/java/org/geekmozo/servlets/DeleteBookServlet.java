package org.geekmozo.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.geekmozo.dao.BookDao;
import org.geekmozo.entities.Book;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/deleteBook")
public class DeleteBookServlet extends HttpServlet {
    private BookDao bookDao = new BookDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        bookDao.deleteBook(id);
        resp.sendRedirect("showBooks");
    }
}
