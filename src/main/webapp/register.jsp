<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">

</head>
<body>
    <div class="container">
        <div class="form">
            <h3>Register Here</h3>
            <%
                String errorMessage = (String) request.getAttribute("error");
                if (errorMessage != null) {
                    out.println("<p style='color:red;'>" + errorMessage + "</p>");
                }
            %>
            <div class="input">
                <form action="register" method="post">
                    <label for="username">Username</label>
                    <input type="text" name="username" id="username" placeholder="Enter Here"  autocomplete="off"/>
                    <label for="password">Password</label>
                    <input type="password" name="password" id="password" placeholder="Enter Here" autocomplete="off"/>
                    <label for="confirmPassword">Confirm Password</label>
                    <input type="password" name="confirmPassword" id="confirmPassword" placeholder="Enter Here" autocomplete="off"/>
                    <label for="mail">Enter Email</label>
                    <input type="email" name="email" id="mail" placeholder="Enter Here" autocomplete="off"/>
                    <label for="number">Enter Contact Number</label>
                    <input type="text" name="number" id="number" placeholder="Enter Here" autocomplete="off" maxlength="10"/>
                    <button type="submit">Register</button>
                    <p>Go back to Login Page - <a href="index.jsp">Go To Login</a> </p>
                </form>
            </div>
        </div>
    </div>
</body>
</html>