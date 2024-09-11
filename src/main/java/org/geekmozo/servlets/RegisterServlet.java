package org.geekmozo.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.geekmozo.dao.StudentDaoImpl;
import org.geekmozo.entities.Student;

import java.io.IOException;

@WebServlet(name = "register", value = "/register")
public class RegisterServlet extends HttpServlet {
    StudentDaoImpl studentDao = new StudentDaoImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String error = "";

        String user = req.getParameter("username");
        String password = req.getParameter("password");
        String cofirmPassword = req.getParameter("confirmPassword");
        String email = req.getParameter("email");
        String number = req.getParameter("number");

        Student student = new Student();
        student.setUsername(user);
        if(password.equals(cofirmPassword)){
            student.setPassword(password);
        }else{
            error = "Password doesn't match";
        }

        student.setEmail(email);
        student.setContactNumber(number);

        if(!error.isEmpty()){
            req.setAttribute("error", error);
            // Forward the request to the JSP page
            RequestDispatcher dispatcher = req.getRequestDispatcher("register.jsp");
            dispatcher.forward(req, resp);
        }else {
            studentDao.registerStudent(student);
            resp.sendRedirect("index.jsp");
        }
    }
}
