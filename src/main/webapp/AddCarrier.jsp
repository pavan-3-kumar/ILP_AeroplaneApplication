<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% 
	
	response.setHeader("Cache-Control", "no-cache,no-store,must revalidate");
if(session.getAttribute("session_id")==null){
	
	response.sendRedirect("Home.jsp");
}
else {
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add carrier details</title>
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
  		
  		<a href="carrier.jsp">Carrier details</a>
  		  	
  		
  		<a href="logout">Logout</a>
  	</nav>
	<div class="form-container">
    <h2>Add Carrier Details</h2>
    <form action="add" method="post">
        <div class="form-group">
            <label for="carrierName">Carrier Name:</label>
            <input type="text" id="carrierName" name="carrierName" required>
        </div>
        <div class="form-group">
            <label for="discount30">Discount for 30 Days:</label>
            <input type="text" id="discount30" name="discount30">
        </div>
        <div class="form-group">
            <label for="discount60">Discount for 60 Days:</label>
            <input type="text" id="discount60" name="discount60">
        </div>
        <div class="form-group">
            <label for="discount90">Discount for 90 Days:</label>
            <input type="text" id="discount90" name="discount90">
        </div>
        <div class="form-group">
            <label for="bulkBookingDiscount">Bulk Booking Discount:</label>
            <input type="text" id="bulkBookingDiscount" name="bulkBookingDiscount">
        </div>
        <div class="form-group">
            <label for="refund2">Refund Percentage for 2 Days:</label>
            <input type="text" id="refund2" name="refund2">
        </div>
        <div class="form-group">
            <label for="refund10">Refund Percentage for 10 Days:</label>
            <input type="text" id="refund10" name="refund10">
        </div>
        <div class="form-group">
            <label for="refund20">Refund Percentage for 20 Days:</label>
            <input type="text" id="refund20" name="refund20">
        </div>
        <div class="form-group">
            <label for="silverDiscount">Silver User Discount:</label>
            <input type="text" id="silverDiscount" name="silverDiscount">
        </div>
        <div class="form-group">
            <label for="goldDiscount">Gold User Discount:</label>
            <input type="text" id="goldDiscount" name="goldDiscount">
        </div>
        <div class="form-group">
            <label for="platinumDiscount">Platinum User Discount:</label>
            <input type="text" id="platinumDiscount" name="platinumDiscount">
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