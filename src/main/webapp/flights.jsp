<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <% 
	
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
if(session.getAttribute("session_id")==null){
	
	response.sendRedirect("Home.jsp");
}  else {

%>
     <%@ page import = "java.util.*" %>
    <%@ page import = "bean.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flights</title>
<script>
	function confirmDelete(){
		return confirm("Are you sure sure you want to delete this flight");
	}
</script>
<style type="text/css">
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
	
	
	
	 body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        caption
        {
        font-size : 26px;
        		  font-family: 'Times New Roman', serif;
        margin-top:15px;
        font-weight : bold;
        margin-bottom : 10px;
        text-align : 10px;
        }
        .container {
            max-width: 1200px;
            margin: auto;
            padding: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        th, td {
            padding: 12px;
           border: 1px solid black;
            text-align: center;
        }
        th {
/*         #4CAF50 */
            background-color: #1E90FF;
            color: white;
        }
        tr:nth-child(odd) {
            background-color: #D3D3D3;
        }
        .button-container {
            text-align: center;
            margin-top: 20px;
            display:flex;
            gap:10px;
            justify-content:center;
        }
        .button-container button {
            padding: 10px 20px;
            margin: 0 10px;
            border: none;
            border-radius: 4px;
            color: white;
            background-color: #4CAF50;
            font-size: 16px;
        }
        .button-container button:hover {
            background-color: #45a049;
        }
</style>
</head>
<body>
	<nav>
		<a href="Admin_home.jsp">AdminHome</a>
  		<a href="carrier" class="carrier">Carrier details</a>
  		
  		
  	
  		<a href="logout">Logout</a>
  	</nav>
  	
  	<div class="container">
  	
    <table>
    <caption>Flight Details</caption>
        <thead>
            <tr>
                <th>Flight ID</th>
                <th>Carrier ID</th>
                <th>Origin</th>
                <th>Destination</th>
                <th>AirFare</th>
                <th>Economy class seats</th>
                <th>Business class seats</th>
                <th>Executive class seats</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
        </thead>
        <tbody>
        <%
       
    	List<Flight> flights = (List<Flight>) session.getAttribute("flights");    	
       
        if(flights.size() == 0 )
        {
        	out.println("No flight data available");
        }
  		else{
          	for(Flight c : flights){
    	%>
    	<tr>
               		<td><%= c.getFlightId() %></td>
                    <td><%= c.getCarrierId() %></td>
                    <td><%= c.getOrigin() %></td>
                    <td><%= c.getDestination() %></td>
                    <td><%= c.getAirfare() %></td>
                    <td><%= c.getSeatcapacityeconomyclass() %></td>
                    <td><%= c.getSeatcapacitybusinessclass() %></td>
                    <td><%= c.getSeatcapacityexecuteclass() %></td>
                    <td><form action="EditFlightServlet" >
  							<button  style= "font-size : 14px;color: white; background-color: #4CAF50; border: none ;border-radius:4px;" type="submit"  value="<%= c.getFlightId() %>" name = "editflight">Edit</button>
  						</form></td>
                    <td><form action="DeleteFlightServlet" onsubmit="return confirmDelete();" onsubmit="return confirmDelete();">
  							<button  style= "color: white;background-color:red; border-color:red;border-radius:4px;" type="submit"  name = "deleteflight" value = "<%=c.getFlightId()%>">Delete</button>
  						</form></td>
     	</tr>
     	<%}
        }%>
        </tbody>
    </table>

    <div class="button-container">
    
    	<form action="AddflightdummyServlet" >
  				<button type="submit"  value = "AddFlight">Add Flight</button>
  		</form>
        <!-- <button	type="button">Add</button>
        <button type="button">Edit</button>
        <button type="button">Delete</button> -->
    </div>
</div>
</body>
</html>
<%  }  %>