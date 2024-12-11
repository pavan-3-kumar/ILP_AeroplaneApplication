<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <% 
	
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
if(session.getAttribute("session_id")==null){
	
	response.sendRedirect("Home.jsp");
	
} 
  
else {
	String s = session.getAttribute("session_id").toString();
	if(s.equals("admin"))
	{
		response.sendRedirect("Home.jsp");	
	}
%>
    <%@ page import="bean.*" %>
<%@ page import="java.util.*" %>
<%@ include file="header.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flight Search</title>
    <style>
        body {
           font-family: 'Times New Roman', serif;
            background: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
             background-color: #f0f0f0;
            background-image: url('image/user.jpg');
            background-size: cover; /* Ensure the image covers the entire page */
            background-position: center; /* Center the image */
            background-repeat: no-repeat; /* Prevent repeating the image */
           
            image-rendering:smooth;
            height: 80vh;
             
        }

        .content {
            background: white;
            padding: 20px;
            border-radius: 8px;
            background-color: transparent; 
            border : none;
            width: 80%;
            max-width: 1200px;
        }
         .content label{
         font-size : 20px;
         }
        form {
            margin-bottom: 20px;
        }

        form input[type="text"] {
            padding: 10px;
            margin: 5px;
            background-color: transparent; 
            border : none;
           border: 2px solid white; 
            border-radius: 5px;
            font-size: 16px;
            width: 200px;
        }

        form input[type="submit"] {
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            background-color: #007bff;
            color: white;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        form input[type="submit"]:hover {
            background-color: #0056b3;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        table th, table td {
            padding: 12px;
            text-align: center;
            border: 1px solid #ddd;
        }

        table th {
            background-color: #007bff;
            color: white;
        }

        table tr:nth-child(even) {
            background-color: #f2f2f2;
            
            
        }

        table tr:hover {
            background-color: #ddd;
        }
        label{
        font-size : 20px;
        		  font-family: 'Times New Roman', serif;
        		  font-weight : bold;
        }
        .book-button {
            background-color: #28a745;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .book-button:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
    <div class="content">
   
        <form action="Searchflight" method="post">
            <label for="origin">Origin:</label>
            <input type="text" id="origin" name="origin" placeholder="Enter origin" required>
            
            <label for="destination">Destination:</label>
            <input type="text" id="destination" name="destination" placeholder="Enter destination" required>
            
            <label for="journey_date">Date:</label>
            <input type="text" id="journey_date" name="journey_date" placeholder="DD-MM-YYYY" required>
            
            <input type="submit" value="Search">
        </form>

        <% if (session.getAttribute("print_search") != null) { %>
            <table>
                <thead>
                    <tr>
                        <th>Flight ID</th>
                        <th>Carrier ID</th>
                        <th>Origin</th>
                        <th>Destination</th>
                        <th>Air Fare</th>
                        <th>Date of Travel</th>
                        <th>Economy Class Booked Count</th>
                        <th>Business Class Booked Count</th>
                        <th>Executive Class Booked Count</th>
                        <th>Book Ticket</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                        ArrayList<combination_user_search> ans = (ArrayList<combination_user_search>) session.getAttribute("print_search");
                        for (combination_user_search i : ans) { 
                    %>
                        <tr>
                            <td><%= i.getFlight_id() %></td>
                            <td><%= i.getCarrier_id() %></td>
                            <td><%= i.getOrigin() %></td>
                            <td><%= i.getDestination() %></td>
                            <td><%= i.getAirFare() %></td>
                            <td><%= i.getDateOfTravel() %></td>
                            <td><%= i.getEconomyClassBookedCount() %></td>
                            <td><%= i.getBusinessClassBookedCount() %></td>
                            <td><%= i.getExecutiveClassBookedCount() %></td>
                            <td>
                                <form action="bookingpage" method="post">
                                    <input type="hidden" name="combinationid" value="<%= i.getCombination_ID() %>">
                                    <input type="submit" value="Book" class="book-button">
                                </form>
                            </td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
        <% } %>
    </div>
</body>
</html>
<% }  %>