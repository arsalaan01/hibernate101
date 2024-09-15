package org.geekmozo.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.geekmozo.dao.StudentDaoImpl;
import org.geekmozo.entities.Student;

import java.io.IOException;

@WebServlet(name = "login", value = "/login")
public class LoginServlet extends HttpServlet {

    StudentDaoImpl studentDao = new StudentDaoImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String error = "";

        String user = req.getParameter("username");
        String password = req.getParameter("password");

        if(user.isEmpty() || password.isEmpty()){
            error = "Username/Password doesn't match.";
        }else {
            Student student = studentDao.authenticateStudent(user,password);
            HttpSession session = req.getSession();
            session.setAttribute("student",student);
            resp.sendRedirect("profile.jsp");
        }

    }
}
