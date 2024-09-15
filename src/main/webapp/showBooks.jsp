<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.geekmozo.entities.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
  <title>Book List</title>
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
  <h3 class="lib-header">List Of Books in Library</h3>
  <div class="output">
    <table border="1" class="table">
      <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Publisher</th>
        <th>Price</th>
        <th>Category</th>
        <th>Library Name</th>
        <th>Library Incharge</th>
        <th>Location</th>
      </tr>
      <c:forEach var="book" items="${books}">
        <tr>
          <td>${book.getBookId()}</td>
          <td>${book.getBookName()}</td>
          <td>${book.getPublisher()}</td>
          <td>${book.getPrice()}</td>
          <td>${book.getCategory()}</td>
          <td>${book.getLibrary().getLibraryName()}</td>
          <td>${book.getLibrary().getIncharge()}</td>
          <td>${book.getLibrary().getPlace()}</td>
          <td>
                        <a href="updateBook?id=${book.bookId}">Edit</a>
                        <a href="deleteBook?id=${book.bookId}">Delete</a>
          </td>
        </tr>
      </c:forEach>
    </table>
  </div>
  <a href="addBook">Add New Book</a>

</body>
</html>
