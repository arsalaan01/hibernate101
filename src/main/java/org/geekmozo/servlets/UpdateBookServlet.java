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

@WebServlet("/updateBook")
public class UpdateBookServlet extends HttpServlet {

    private BookDao bookDao = new BookDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        Book book = bookDao.getBook(id);
        req.setAttribute("book", book);
        req.getRequestDispatcher("updateBook.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IOException {
//        String bookName = req.getParameter("bookName");
//        String publisher = req.getParameter("publisher");
//        int price = Integer.parseInt(req.getParameter("price"));
//        String category = req.getParameter("category");
        int bookId = Integer.parseInt(req.getParameter("id"));
        String library = req.getParameter("library");
        String libraryIncharge = req.getParameter("libraryIncharge");
        String libraryPosition = req.getParameter("libraryPosition");

        Library libObj = new Library(library,libraryIncharge,libraryPosition);

        Book book = new Book();
        book.setBookId(bookId);
        book.setLibrary(libObj);
        bookDao.updateBook(book);
        resp.sendRedirect("showBooks");
    }
}
