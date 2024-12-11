<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ include file="Auth.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <title>Booking Confirmation</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .container {
            text-align: center;
        }

        .message {
            font-size: 24px;
            color: #007bff;
            margin-bottom: 20px;
        }

        .redirect-info {
            font-size: 18px;
            color: #333;
        }
    </style>
    <script>
        function popup() {
            alert("Booking completed successfully");
            window.location.href = "User_page.jsp";
        }
    </script>
</head>
<body onload="popup();">
    <div class="container">
        <div class="message">Your booking was successful!</div>
        <div class="redirect-info">You will be redirected shortly...</div>
    </div>
</body>
</html>
