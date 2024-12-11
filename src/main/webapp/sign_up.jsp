<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate"); 
%>
<% if(session.getAttribute("session_id")!=null){
	
	response.sendRedirect("Home.jsp");
	
} else{
   %>

<!DOCTYPE html>
<html>
<head>
    <title>Sign-Up Page</title>
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
            height: 150vh; /* Ensure the body height is 100% of the viewport height */
     
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
                        margin-top: auto;
            opacity:0;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 350px; */
            background-color: rgba(255, 255, 255, 0.5); /* White background with 50% opacity */
            padding: 20px;
           
            border-radius: 8px;
            border: 1px solid #ccc;
            max-width: 400px; /* Adjust as needed */
            margin: 20px auto; /* Center the form */
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
        }

        /* Form element styling */
        .form-container input[type="text"],
        .form-container input[type="password"],
        .form-container input[type="email"],
        .form-container select {
            width: calc(100% - 16px); /* Adjust width to match padding */
            padding: 8px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box; /* Ensures padding doesn't affect total width */
        }

        /* Button styling */
        .form-container button {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            margin-top: 10px;
        }

        /* Button hover effect */
        .form-container button:hover {
            background-color: #0056b3;
        }

        /* Label styling */
        .form-container label {
            font-weight: bold;
            display: block;
        }
    </style>
</head>
<body>
<nav>
        <a href="Home.jsp" id="logout">Home</a>

        <a href="sign_in.jsp" id="logout">Sign In</a>
    </nav>
<div class="form-container">
<h1 style="text-align : center;">SIGN UP</h1>

    <form action="Register" method="post">
         <label for="role">Role:</label>
	   <select id="role" name="Role">
	            <option value="Admin">Admin</option>
	            <option value="Customer">Customer</option>
	        </select> 

        <label for="category">Category:</label>
        <select id="category" name="Category">
            <option value="Silver">Silver</option>
            <option value="Gold">Gold</option>
            <option value="Platinum">Platinum</option>
        </select>

        <label for="name">Name:</label>
        <input type="text" id="name" name="name">

        <label for="pass">Password:</label>
        <input type="password" id="pass" name="pass">

        <label for="phone">Phone Number:</label>
        <input type="text" id="phone" name="phone">

        <label for="emailid">Email ID:</label>
        <input type="email" id="emailid" name="emailid">

        <label for="address1">Address Line 1:</label>
        <input type="text" id="address1" name="address1">

        <label for="city">City:</label>
        <input type="text" id="city" name="city">

        <label for="state">State:</label>
        <input type="text" id="state" name="state">

        <label for="country">Country:</label>
        <input type="text" id="country" name="country">

        <label for="zipcode">Zip Code:</label>
        <input type="text" id="zipcode" name="zipcode">

        <label for="dob">Date of Birth:</label>
        <input type="text" id="dob" name="DOB">

        <button type="submit">SIGN-UP</button>     
    </form>
</div>
</body>
</html>
<% } %>

