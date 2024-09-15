<%@ page import="org.geekmozo.entities.Student" %><%--
  Created by IntelliJ IDEA.
  User: Arsalaan
  Date: 13/09/24
  Time: 8:27 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
    <title>Add Book Here</title>
</head>
<body>
<%! String username=""; %>
<%
    HttpSession session1 = request.getSession(false);
    if (session1 != null) {
        Student student = (Student) session1.getAttribute("student");
        if (student != null) {
            username = student.getUsername();
        } else {
            response.sendRedirect("index.jsp");
        }
    } else {
        response.sendRedirect("index.jsp");
    }
%>
<nav>
    <div>
        <%= username %>
    </div>
    <div>
        <a class="logout" href="logout">Logout</a>
    </div>
</nav>
<div class="container">
    <div class="form">
        <h3>Update your book</h3>
        <%
            String errorMessage = (String) request.getAttribute("error");
            if (errorMessage != null) {
                out.println("<p style='color:red;'>" + errorMessage + "</p>");
            }
        %>
        <div class="input">
            <form action="updateBook" method="post">
                <input type="hidden" name="id" value="${book.bookId}">
<%--                <label for="bookName">Book Name</label>--%>
<%--                <input type="text" name="bookName" id="bookName" placeholder="Enter Here"  autocomplete="off"/>--%>
<%--                <label for="publisher">Publisher</label>--%>
<%--                <input type="text" name="publisher" id="publisher" placeholder="Enter Here" autocomplete="off"/>--%>
<%--                <label for="price">Price</label>--%>
<%--                <input type="text" name="price" id="price" placeholder="Enter Here" autocomplete="off"/>--%>
<%--                <label for="category">Category</label>--%>
<%--                <select name="category" id="category">--%>
<%--                    <option value="fictional">Fictional</option>--%>
<%--                    <option value="drama">Drama</option>--%>
<%--                    <option value="motivational">Motivational</option>--%>
<%--                    <option value="autobiography">Auto Biographies</option>--%>
<%--                </select>--%>
<%--                </br>--%>
                <label for="libraryName">Enter Library Name</label>
                <input type="text" name="library" id="libraryName" placeholder="Enter Here" autocomplete="off" />
                <label for="libraryIncharge">Enter Library Incharge Name</label>
                <input type="text" name="libraryIncharge" id="libraryIncharge" placeholder="Enter Here" autocomplete="off" />
                <label for="libraryPosition">Enter Library Position</label>
                <input type="text" name="libraryPosition" id="libraryPosition" placeholder="Enter Here" autocomplete="off" />
                <button type="submit" class="green">Add book</button>
                <p>Go back to Profile Page - <a href="profile.jsp" class="red">Go To Dashboard</a> </p>
            </form>
        </div>
    </div>
</div>
</body>
</html>
