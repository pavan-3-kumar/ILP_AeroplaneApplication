<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 
    response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
    if(session.getAttribute("session_id")==null){
        response.sendRedirect("Home.jsp");
    } else {
%>
<%@ page import="bean.*, java.util.*" %>
<%@ include file="header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking Details</title>
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background-color: #f8f9fa;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
    }

    .container {
        background: #ffffff;
        padding: 30px;
        border-radius: 10px;
        box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
        width: 90%;
        max-width: 800px;
        margin: 20px;
    }

    .form-header {
        background: #007bff;
        color: #ffffff;
        padding: 15px;
        border-radius: 10px 10px 0 0;
        text-align: center;
        font-size: 1.5em;
        margin-bottom: 20px;
    }

    .form-group {
        margin-bottom: 20px;
    }

    .form-group label {
        display: block;
        font-weight: bold;
        margin-bottom: 5px;
    }

    .form-group input[type="number"], 
    .form-group input[type="text"],
    .form-group input[type="email"] {
        width: 100%;
        padding: 10px;
        border-radius: 5px;
        border: 1px solid #ced4da;
        box-sizing: border-box;
        margin-bottom: 10px;
    }

    .form-group input[type="submit"] {
        background-color: #007bff;
        color: #ffffff;
        border: none;
        padding: 12px 20px;
        border-radius: 5px;
        cursor: pointer;
        font-size: 16px;
        transition: background-color 0.3s;
        display: block;
        width: 100%;
        margin-top: 20px;
    }

    .form-group input[type="submit"]:hover {
        background-color: #0056b3;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }

    table th, table td {
        padding: 12px;
        text-align: left;
        border: 1px solid #dee2e6;
    }

    table th {
        background-color: #007bff;
        color: #ffffff;
    }

    table tr:nth-child(even) {
        background-color: #f8f9fa;
    }

    table tr:hover {
        background-color: #e2e6ea;
    }

    .center-button {
        text-align: center;
        margin-top: 30px;
    }

    #confirmbutton {
        padding: 12px 20px;
        background-color: #007bff;
        color: #ffffff;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: 16px;
        transition: background-color 0.3s;
    }

    #confirmbutton:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
    <div class="container">
        <% if (session.getAttribute("display_search") != null) {
            combination_user_search i = (combination_user_search) session.getAttribute("display_search");
        %>
        <div class="form-header">Flight Booking Details</div>
        <form action="calculate_price" method="post">
            <div class="form-group">
                <label for="flightid">Flight ID:</label>
                <input type="hidden" name="flightid" value="<%= i.getFlight_id() %>"> <%= i.getFlight_id() %>
            </div>
            <div class="form-group">
                <label for="carrierid">Carrier ID:</label>
                <input type="hidden" name="carrierid" value="<%= i.getCarrier_id() %>"> <%= i.getCarrier_id() %>
            </div>
            <div class="form-group">
                <label for="origin">Origin:</label> <%= i.getOrigin() %>
            </div>
            <div class="form-group">
                <label for="destination">Destination:</label> <%= i.getDestination() %>
            </div>
            <div class="form-group">
                <label for="airfare">AirFare:</label>
                <input type="hidden" name="airfare" value="<%= i.getAirFare() %>"> <%= i.getAirFare() %>
            </div>
            <div class="form-group">
                <label for="DOT">Date of Travel:</label>
                <input type="hidden" name="DOT" value="<%= i.getDateOfTravel() %>"> <%= i.getDateOfTravel() %>
            </div>
            <div class="form-group">
                <label for="EconomyClass_Seats">Number of Economy Class Seats:</label>
                <input type="number" name="EconomyClass_Seats" min="0">
            </div>
            <div class="form-group">
                <label for="BusinessClass_Seats">Number of Business Class Seats:</label>
                <input type="number" name="BusinessClass_Seats" min="0">
            </div>
            <div class="form-group">
                <label for="ExecutiveClass_Seats">Number of Executive Class Seats:</label>
                <input type="number" name="ExecutiveClass_Seats" min="0">
            </div>
            <div class="form-group">
                <input type="submit" value="Book">
            </div>
        </form>
        
        <% } 
        if (session.getAttribute("total_price") != null) { 
            ArrayList<Integer> pricedetails = (ArrayList<Integer>) session.getAttribute("total_price");
        %>
        <div class="form-header">Price Details</div>
        <form action="confirm_booking" method="post">
            <table>
                <tr>
                    <th>Total Amount</th>
                    <td><%= pricedetails.get(7) %></td>
                </tr>
                <% if (pricedetails.get(0) != 0) { %>
                <tr>
                    <td>Discount for Advance Booking (before 30 days):</td>
                    <td><%= pricedetails.get(0) %></td>
                </tr>
                <% } else if (pricedetails.get(1) != 0) { %>
                <tr>
                    <td>Discount for Advance Booking (before 60 days):</td>
                    <td><%= pricedetails.get(1) %></td>
                </tr>
                <% } else if (pricedetails.get(2) != 0) { %>
                <tr>
                    <td>Discount for Advance Booking (before 90 days):</td>
                    <td><%= pricedetails.get(2) %></td>
                </tr>
                <% } 
                if (pricedetails.get(3) != 0) { %>
                <tr>
                    <td>Discount for Bulk Bookings (more than 10 tickets):</td>
                    <td><%= pricedetails.get(3) %></td>
                </tr>
                <% } 
                if (pricedetails.get(4) != 0) { %>
                <tr>
                    <td>Silver User Discount:</td>
                    <td><%= pricedetails.get(4) %></td>
                </tr>
                <% } else if (pricedetails.get(5) != 0) { %>
                <tr>
                    <td>Gold User Discount:</td>
                    <td><%= pricedetails.get(5) %></td>
                </tr>
                <% } else { %>
                <tr>
                    <td>Platinum User Discount:</td>
                    <td><%= pricedetails.get(6) %></td>
                </tr>
                <% } %>
                <tr>
                    <th>Final Amount</th>
                    <td><input type="hidden" name="finalamount" value="<%= pricedetails.get(8) %>"> <%= pricedetails.get(8) %></td>
                </tr>
            </table>
            <div class="center-button">
                <input type="submit" value="Confirm Booking" id="confirmbutton">
            </div>
        </form>
        <% } %>
    </div>
</body>
</html>
<% } %>
