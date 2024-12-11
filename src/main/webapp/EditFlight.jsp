<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <% 
	
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
if(session.getAttribute("session_id")==null){
	
	response.sendRedirect("Home.jsp");
} else {
%>
    <%@ page import="java.util.*" %>
    <%@ page import="bean.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        .form-container {
            background-color: #ffffff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
            width: 400px;
        }

        .form-container h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        .form-container label {
            display: block;
            margin-bottom: 8px;
            color: #333;
        }

        .form-container input[type="text"],
        .form-container input[type="datetime-local"],
        .form-container input[type="number"],
        .form-container select {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
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
<% 
	Flight f = (Flight)request.getAttribute("flightdetailid");

%>
<body>
<div class="form-container">
	<form action="UpdateFlightDetails" method="get">
		<div class="form-group">
            <label for="flightid">Flight Id:</label>
            <input type="text" id="flightid" name="flightid" value="<%=f.getFlightId() %>" readonly><br><br>
        </div>
        <div class="form-group">
            <label for="carrierid">Carrier Id:</label>
            <input type="text" id="carrierid" name="carrierid" value="<%=f.getCarrierId() %>" readonly><br><br>
        </div>
        <div class="form-group">
            <label for="origin">Origin:</label>
            <input type="text" id="origin" name="origin" value="<%=f.getOrigin() %>"required><br><br>
        </div>
        <div class="form-group">
            <label for="destination">Destination:</label>
            <input type="text" id="destination" name="destination" value="<%= f.getDestination() %>"required>
        </div>
        <div class="form-group">
            <label for="airfare">Airfare:</label>
            <input type="text" id="airfare" name="airfare" value="<%=f.getAirfare() %>">
        </div>
        <div class="form-group">
            <label for="economyclass">seats for economy class:</label>
            <input type="text" id="economyclass" name="economyclass" value="<%=f.getSeatcapacityeconomyclass() %>" required>
        </div>
        <div class="form-group">
            <label for="businessclass">seats for business class:</label>
            <input type="text" id="businessclass" name="businessclass" value="<%=f.getSeatcapacitybusinessclass() %>" required>
        </div>
        <div class="form-group">
            <label for="executiveclass">seats for executive class:</label>
            <input type="text" id="executiveclass" name="executiveclass" value="<%=f.getSeatcapacityexecuteclass() %>" required>
        </div>
        <div class="form-buttons">
            <button type="submit">Submit</button>
            <button type="reset">Reset</button>
        </div>
		
	</form>
	</div>
</body>
</html>

<%  } %> 