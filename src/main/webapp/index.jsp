<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">

</head>
<body>
    <div class="container">
        <%
            String errorMessage = (String) request.getAttribute("error");
            if (errorMessage != null) {
                out.println("<p style='color:red;'>" + errorMessage + "</p>");
            }
        %>
        <div class="form">
            <h3>Login</h3>
            <div class="input">
                <form action="login" method="post">
                    <label for="username">Username</label>
                    <input type="text" name="username" id="username" placeholder="Enter Here"  autocomplete="off"/>
                    <label for="password">Password</label>
                    <input type="password" name="password" id="password" placeholder="Enter Here" autocomplete="off"/>
                    <button type="submit">Login Here</button>
                </form>
                <p>Not a User - <a href="register.jsp">Register Here</a> </p>
            </div>
        </div>
    </div>
</body>
</html>