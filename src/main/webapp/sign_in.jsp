<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <% response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");  
 %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <style>
        /* General body styling */
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #f0f0f0;
            background-image: url('image/signin.jpg');
            background-size: cover; /* Ensure the image covers the entire page */
            background-position: center; /* Center the image */
            background-repeat: no-repeat; /* Prevent repeating the image */
           
            image-rendering:smooth;
            height: 80vh; /* Ensure the body height is 100% of the viewport height */
     
        }
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

     /*    nav a {
            color: black;
            font-family: 'Times New Roman', serif;
            text-decoration: none;
            padding: 14px 20px;
            font-size: 30px;
            margin-right : auto ;
        }
           nav a:hover {
            color: black;
            background-color: orange;
            border-radius: 10px;
        } */


nav a {
     color: #333;
    border: none;
     font-family: 'Times New Roman', serif;
    padding: 14px 20px;
            font-size: 30px;
            text-decoration: none;
            
    cursor: pointer;
    transition: background-color 0.3s ease;
}

nav a:hover {
    background-color: rgba(255, 255, 255, 0.8); /* Slightly less transparent on hover */
border-radius: 20px;
}
        /* Form container styling */
        .form-container {
            /* background-color: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 300px;
            margin-left : auto;
            margin-right : 40px; */
            background-color: rgba(255, 255, 255, 0.5); /* White background with 50% opacity */
            padding: 30px;
            border-radius: 8px;
            border: 1px solid #ccc;
            max-width: 400px; /* Adjust as needed */
            margin: 20px auto; /* Center the form */
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
            width: 300px;
            margin-left : auto;
            margin-right : 40px; 
        }
        

        /* Form element styling */
        .form-container input[type="text"],
        .form-container input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        /* Button styling */
        .form-container input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }

        /* Button hover effect */
        .form-container input[type="submit"]:hover {
            background-color: #0056b3;
        }

        /* Label styling */
        .form-container label {
            font-weight: bold;
            display: block;
            margin-top: 10px;
        }
    </style>
</head>
<body>
<% 
    // Removing the session attribute if it exists
    if (session.getAttribute("print_search") != null) {
        session.removeAttribute("print_search");
    } 
%>
<nav>
        <a href="Home.jsp" id="logout">Home</a>
        <a href="sign_up.jsp" id="logout">Sign Up</a>
    </nav>
<div class="form-container">

 <div class="content">
    
        <h1>SIGN IN</h1>
    </div>
    <form action="Login" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required>

        <label for="pass">Password:</label>
        <input type="password" id="pass" name="pass" required>

        <input type="submit" value="Login">
    </form>
</div>
</body>
</html>
