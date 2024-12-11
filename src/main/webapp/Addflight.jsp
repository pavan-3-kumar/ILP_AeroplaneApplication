<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% 
	
	response.setHeader("Cache-Control", "no-cache,no-store,must revalidate");
if(session.getAttribute("session_id")==null){
	
	response.sendRedirect("Home.jsp");
}
else {
%>
    
     <%@ page import="java.util.*" %>
    <%@ page import="bean.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add flight</title>
<style>
nav.carrier{
		flex:1;
		text-align:center;
		font-size:18px;
	}
	nav{
	background-color: #1E90FF; 
		overflow: hidden;
		padding : 10px;
		color:white;
		display:flex;
		align-items:center;
		justify-content: space-between;
	}
	nav a{
		color: white;
		  font-family: 'Times New Roman', serif;
		
		text-decoration: none;
		padding: 14px 20px;
		font-size: 26px;
		float: right;
	}
	nav a.profile{
		float: left;
	}
	nav a:hover{
	 color : #1E90FF;
		background-color: white;
		background-radius: 4px;
		border-radius : 10px; 
		
	}
        .form-container {
            width: 400px; /* Set a fixed width for the form */
            margin: 0 auto; /* Center the form horizontally */
            background-color: #f0f0f0; /* Light gray background */
            padding: 20px;
            border-radius: 8px; /* Rounded corners */
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Subtle shadow */
        }

        .form-container h2 {
            text-align: center;
            margin-bottom: 20px;
        }
.form-container select {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .form-group {
            margin-bottom: 15px;
        }

        .form-group label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }

        .form-group input {
            width: calc(100% - 20px); /* Full width input with some padding */
            padding: 8px;
            font-size: 14px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .form-buttons {
            text-align: center;
        }

        .form-buttons button {
            padding: 10px 20px;
            background-color: #007bff; /* Blue color */
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 14px;
            margin: 5px;
        }

        .form-buttons button:hover {
            background-color: #0056b3; /* Darker blue on hover */
        }
    </style>
</head>
<body>

<nav>
  		<a href="Admin_home.jsp" class="Admin_home">Admin Home</a>
  		
  		<a href="flights.jsp">Flight details</a>
  		  	
  		
  		<a href="logout">Logout</a>
  	</nav>
<div class="form-container">
	<h2>Add Flights for the Carrier</h2>
	<form action="AddFlightDetails" method="get">
		<label for="carrier">Select Carrier:</label>
		<select name="carrierId" id="carrierId" required>
		<%
			List<Carrier> carriers = (List<Carrier>)request.getAttribute("carrierlist");
			for(Carrier carrier:carriers){
		%>
		<option id="carriername"value="<%=carrier.getId()%>"><%=carrier.getCarrierName() %></option>
	
			<%
		}%>
		</select><br><br>
		
		 <div class="form-group">
            <label for="flightid">Flight Id:</label>
            <input type="text" id="flightid" name="flightid" required><br><br>
        </div> 
        <div class="form-group">
            <label for="origin">Origin:</label>
            <input type="text" id="origin" name="origin" required><br><br>
        </div>
        <div class="form-group">
            <label for="destination">Destination:</label>
            <input type="text" id="destination" name="destination" required>
        </div>
        <div class="form-group">
            <label for="airfare">Airfare:</label>
            <input type="text" id="airfare" name="airfare" >
        </div>
        <div class="form-group">
            <label for="economyclass">seats for economy class:</label>
            <input type="text" id="economyclass" name="economyclass" required>
        </div>
        <div class="form-group">
            <label for="businessclass">seats for business class:</label>
            <input type="text" id="businessclass" name="businessclass" required>
        </div>
        <div class="form-group">
            <label for="executiveclass">seats for executive class:</label>
            <input type="text" id="executiveclass" name="executiveclass" required>
        </div>
        <div class="form-buttons">
            <button type="submit">Submit</button>
            <button type="reset">Reset</button>
        </div>
	</form>
	</div>
</body>
</html>

<% } %>