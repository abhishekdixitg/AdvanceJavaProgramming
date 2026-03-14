<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Signup</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; background-color: #f4f4f4; }
        .container { background-color: #fff; padding: 25px; border-radius: 8px; box-shadow: 0 2px 10px rgba(0,0,0,0.1); max-width: 500px; margin: 30px auto; }
        h1 { text-align: center; color: #333; }
        label { display: block; margin-bottom: 8px; color: #555; }
        input[type="text"], input[type="email"], input[type="password"] {
            width: calc(100% - 22px); /* Adjust for padding and border */
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            width: 100%;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        .error-message { color: red; font-size: 0.9em; margin-top: -10px; margin-bottom: 10px; }
        .validation-errors { background-color: #ffebe8; border: 1px solid #dd3c10; color: #dd3c10; padding: 10px; margin-bottom: 20px; border-radius: 5px; }
    </style>
</head>
<body>
    <div class="container">
        <h1>Sign Up</h1>

        <%-- Display general validation errors if any (from the Servlet) --%>
        <c:if test="${not empty errors}">
            <div class="validation-errors">
                <ul>
                    <c:forEach var="error" items="${errors}">
                        <li><c:out value="${error}" /></li>
                    </c:forEach>
                </ul>
            </div>
        </c:if>

        <form action="signup" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" value="${user.username}" required>
            <c:if test="${not empty errorUsername}">
                <div class="error-message">${errorUsername}</div>
            </c:if>

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="${user.email}" required>
            <c:if test="${not empty errorEmail}">
                <div class="error-message">${errorEmail}</div>
            </c:if>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
            <c:if test="${not empty errorPassword}">
                <div class="error-message">${errorPassword}</div>
            </c:if>

            <label for="confirmPassword">Confirm Password:</label>
            <input type="password" id="confirmPassword" name="confirmPassword" required>
            <c:if test="${not empty errorConfirmPassword}">
                <div class="error-message">${errorConfirmPassword}</div>
            </c:if>

            <input type="submit" value="Sign Up">
        </form>
    </div>
</body>
</html>