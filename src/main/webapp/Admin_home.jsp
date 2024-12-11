<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<% 
response.setHeader("Cache-Control", "no-cache,no-store,must revalidate");
if(session.getAttribute("session_id") == null){
    response.sendRedirect("Home.jsp");
} else {
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home Page</title>
<style>
    nav.welcome {
        flex: 1;
        text-align: center;
        font-size: 18px;
    }
    nav {
        background-color: transparent;
        border-color: transparent;
        overflow: hidden;
        padding: 10px;
        color: white;
        display: flex;
        align-items: center;
        justify-content: space-between;
    }
    nav a {
        color: white;
        font-family: 'Times New Roman', serif;
        text-decoration: none;
        padding: 14px 20px;
        font-size: 26px;
        float: right;
    }
    #logout {
        margin-left: auto;
    }
    nav a:hover {
        color: #1E90FF;
        background-color: white;
        border-radius: 10px;
    }
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
        background-image: url('image/admin.png');
        background-size: cover;
        background-position: center;
        background-repeat: no-repeat;
        height: 80vh;
    }
    .container {
        max-width: 1200px;
        margin: auto;
        padding: 20px;
    }
    .displaybutton {
        font-size: 20px;
        font-family: 'Times New Roman', serif;
        text-decoration: none;
    }
    .card {
        background-color: transparent;
        border-color: transparent;
        padding: 20px;
        margin: 20px;
        text-align: center;
        display: flex;
        flex-direction: column;
        justify-content: space-between;
        height: 150px;
        transition: transform 0.2s;
    }
    .card:hover {
        background-color: #D3D3D3;
        transform: scale(1.05);
    }
    .button-container {
        display: flex;
        justify-content: space-between;
        width: 100%;
    }
    .cards {
        display: flex;
        justify-content: space-around;
        flex-wrap: wrap;
        margin: 0 auto;
        width: 100%;
    }
    .card h2 {
        margin-top: 0;
        color : #1E90FF;
        font-family: 'Times New Roman', serif;
            text-decoration: none;
        
    }
    .card a {
        display: inline-block;
        margin-top: 10px;
        padding: 10px 20px;
        color: white;
        background-color: #4CAF50;
        text-decoration: none;
        border-radius: 4px;
    }
    .card a:hover {
        background-color: red;
    }
    .welcome-message {
        /* text-align: center;
        margin: 20px 0;
        font-size: 24px;
        color: #333;
        font-weight: bold; */
        font-size: 10vh;
            text-align: center;
        margin: 20px 0;
             font-family: 'Times New Roman', serif;
             color:white;
    }
</style>
</head>
<body>
    <nav>
        <a href="logout" id="logout">Logout</a>
    </nav>
    <div class="welcome-message">
        Welcome to Admin's Page
    </div>
    <div class="cards">
        <div class="card" id="card1">
            <h2>Carrier Details</h2>
            <div class="button-container">
                <form action="carrier" method="get">
                    <button type="submit" class="displaybutton" value="viewDetails">View Details</button>
                </form>
            </div>
        </div>
        <div class="card">
            <h2>Flight Details</h2>
            <div class="button-container">
                <form action="FlightServlet" method="get">
                    <button type="submit" class="displaybutton" name="action" value="viewDetails">View Details</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
<% } %>
