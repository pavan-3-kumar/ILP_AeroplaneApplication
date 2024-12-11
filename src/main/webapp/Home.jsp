<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Airline Management System - User Page</title>
    <style>
        /* CSS for User Pages */

        /* Styling for the body */
        body {
            margin: 0;
            padding: 0;
             font-family: Arial, sans-serif;
                         background-color: #f0f0f0;
      
           background-image: url('image/home.jpg');
            background-size: cover; /* Ensure the image covers the entire page */
            background-position: center; /* Center the image */
            background-repeat: no-repeat; /* Prevent repeating the image */
          
            image-rendering:smooth;
            height: 80vh;  
                    }   
        
        /* Styling for the header */
        nav {
            background-color: transparent;
            border-color: transparent;
            overflow: hidden;
            padding: 10px;
            color: white;
            
            align-items: center;
            justify-content: space-between;
            position: fixed; /* Fix the header at the top */
            width: 100%; /* Ensure the header spans the full width */
            top: 0;
            left: 0;
            z-index: 1000; /* Ensure the header is on top of other content */
        }

        nav a {
            color: white;
            font-family: 'Times New Roman', serif;
            text-decoration: none;
            padding: 14px 20px;
            font-size: 26px;
            margin-right : auto ;
        }

        nav a:hover {
            color: #1E90FF;
            background-color: white;
            border-radius: 10px;
        }

        /* Styling for main content */
        .content {
            margin-top: 70px; /* Space for the fixed header */
            text-align: center;
            
            /* Color for text over the image */
        }

        .content h1 {
            font-size: 20vh;
            margin: 50px 10px 30px;
           padding:15px;
             font-family: 'Times New Roman', serif;
             color:white;
        }
    </style>
</head>
<body>
    <nav>
        <a href="sign_in.jsp" id="logout">Sign In</a>
        <a href="sign_up.jsp" id="logout">Sign Up</a>
    </nav>
    <div class="content">
    
        <h1>Welcome to Airline Management System</h1>
    </div>
</body>
</html>
