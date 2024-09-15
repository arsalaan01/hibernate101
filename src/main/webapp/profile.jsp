<%@ page import="org.geekmozo.entities.Student" %><%--
  Created by IntelliJ IDEA.
  User: Arsalaan
  Date: 12/09/24
  Time: 2:14 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
  <title>Welcome to Dashboarc</title>
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

  <div class="link">
      <a href="addBook.jsp"><button class="green">Add Book</button></a>
      <a href="showBooks"><button class="blue">Show Books</button></a>
      <a href="addBook.jsp"><button class="red">Delete Book</button></a>
      <a href="addBook.jsp"><button class="orange">Update Book</button></a>
  </div>

</body>
</html>
