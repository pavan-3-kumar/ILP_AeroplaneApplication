<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<% 
	
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
if(session.getAttribute("session_id")==null){
	
	response.sendRedirect("Home.jsp");
} else { 

%>

    <%@ page import="bean.*" %>
<%@ page import="java.util.*" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Booking Details</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: flex-start;
            min-height: 100vh;
            
             background-image: url('image/history.jfif');
            background-size: cover; /* Ensure the image covers the entire page */
            background-position: center; /* Center the image */
            background-repeat: no-repeat; /* Prevent repeating the image */
          
            image-rendering:smooth;
            height: 100%; 
        }

        .content {
            background-color: transparent;
            border-color: transparent;
            padding: 0px;
            border-radius: 8px;
           /*  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); */
            width: 80%;
            margin-bottom: auto;
            margin-top:50px;
            max-width: 1200px;
        }
       /*  .header{
        background-color : white;
        } */
        table {
            width: 100%;
             
            border-collapse: collapse;
            margin: 20px 0;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        table th, table td {
         border-radius: 20px;
            
            padding: 12px;
            text-align: center;
            /* border: 1px solid black; */
        }

        table th {
            background-color: #007bff;
            color: white;
        }
        #change_colour{
         background-color:red;	
        }
        #booked_colour{
        background-color : green;
        }
        table tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        table tr:hover {
            background-color: #ddd;
        }

        form {
            margin: 0;
        }

        .cancel-button {
            background-color: #dc3545;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .cancel-button:hover {
            background-color: #c82333;
        }
    </style>
</head>
<body>
    <div class="content">
        <% 
            ArrayList<Flightbookings> fb = (ArrayList<Flightbookings>) request.getAttribute("profile_printing");
            if (fb != null && !fb.isEmpty()) {
                for (Flightbookings i : fb) { 
        %>
            <table>
                <thead>
                    <tr>
                        <th>Booking ID</th>
                        <th>Flight ID</th>
                        <th>No. of Seats</th>
                        <th>Date of Travel</th>
                        <% if(i.getBooking_status().equals("Cancelled")) { %>
                        <th id = "change_colour">Booking Status</th>
                        <% } else { %>
                        <th id="booked_colour">Booking Status</th>
                        <%} %>
                        <th>Amount Paid</th>
                        <th>Action</th>
                    </tr>
                    <br>
                </thead>
                <br>
                <tbody>
                    <form action="delete_booking" method="post">
                        <tr>
                            <td><input type="hidden" name="bookingid" value="<%= i.getBooking_id() %>"><%= i.getBooking_id() %></td>
                            <td><input type="hidden" name="flightid" value="<%= i.getFlight_id() %>"><%= i.getFlight_id() %></td>
                            <td><input type="hidden" name="noofseats" value="<%= i.getNum_of_seats() %>"><%= i.getNum_of_seats() %></td>
                            <td><input type="hidden" name="DOT" value="<%= i.getDate_of_travel() %>"><%= i.getDate_of_travel() %></td>
                            <td><input type="hidden" name="status" value="<%= i.getBooking_status() %>"><%= i.getBooking_status() %></td>
                            <td><input type="hidden" name="amountpaid" value="<%= i.getBooking_Amount() %>"><%= i.getBooking_Amount() %></td>
                            <td>
                             <% if(i.getBooking_status().equals("Cancelled")) { %>
                            <button type="submit" value="Cancel" class="canceledbutton" disabled>Canceled</button>
                                <% } else {%>
                                 <input type="submit" value="Cancel" class="cancel-button">
                                <% }	 %>
                            </td>
                        </tr>
                    </form>
                </tbody>
            </table>
        <% }} %>
    </div>
</body>
</html>

<% }  %>
