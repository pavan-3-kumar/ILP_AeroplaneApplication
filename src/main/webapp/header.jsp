<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="Auth.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title>Insert title here</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
        }

            /* Styling for the header */
        .header {
            position: fixed; /* Fix the header at the top */
            top: 0;
            width: 100%;
              background-color: transparent;
            border-color: transparent;
          /*   background-color: #1E90FF; */ /* Blue background for the header */
            padding: 10px;
            display: flex;
            justify-content: flex-end; 
           /*  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); 
            */ z-index: 1000; 
        }

        /* Container for header buttons */
        .button-container {
            display: flex;
            gap: 10px;
        }

        /* Styling for header buttons */
        .top-right-button {
            padding: 10px 25px;
            font-size: 16px;
            cursor: pointer;
            background-color: #ffffff; /* White background */
            color: #1E90FF; /* Blue text */
            border: none;
            border-radius: 5px; /* Rounded corners */
            transition: background-color 0.3s; /* Smooth transition */
        }

        /* Hover effect for header buttons */
        .top-right-button:hover {
            background-color: #f1f1f1; /* Light gray on hover */
        }
    </style>
</head>
<body>
    <header class="header">
        <div class="button-container">
            <form action="signout" method="get">
                <button class="top-right-button" type="submit">Sign Out</button>
            </form>
            <form action="user_profile" method="get">
                <button class="top-right-button" type="submit">Profile</button>
            </form>
            <form action="User_page.jsp" >
            <button class="top-right-button">Home</button>
            </form>
        </div>
    </header>
</body>
</html>
