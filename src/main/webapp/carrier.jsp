<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <% 
	
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
if(session.getAttribute("session_id")==null){
	
	response.sendRedirect("Home.jsp");
} else {
%>
    <%@ page  import = "java.util.*" %>
    <%@ page import="bean.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Carrier details</title>
<script>
	function confirmDelete(){
		return confirm("Are you sure sure you want to delete the selected carriers");
	}
</script>
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
	
	 body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .container {
       
           /*  max-width: 1200px;
            margin: auto;
            
            padding: 20px; */
            display: flex;
            max-width: 1200px;
             top-padding: 20px; 
            justify-content: center;
            margin : auto;
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
             background-color: #1E90FF;
            color: white;
        }
        tr:nth-child(odd) {
            background-color: #D3D3D3;
        }
        .button-container {
            text-align: center;
            margin-top: 20px;
           
            gap:10px;
            justify-content:center;
        }
        .button-container button {
            padding: 10px 20px;
            margin: 0 10px;
            border: none;
            border-radius: 10px;
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
  		<a href="Admin_home.jsp" class="Admin_home">Admin Home</a>
  		
  		<a href="FlightServlet">Flight details</a>
  		  	
  		
  		<a href="logout">Logout</a>
  	</nav>
	<!--<a href="Admin_home.jsp">Home page</a><br></br>  -->
	<div class="container">
    <table>
    <caption>Carrier Details</caption>
  
        <thead>
            <tr>
                <th>Carrier iD</th>
                <th>Carrier Name</th>
                <th>Discount for 30 Days</th>
                <th>Discount for 60 Days</th>
                <th>Discount for 90 Days</th>
                <th>Bulk Booking Discount</th>
                <th>Refund Percentage for 2 Days</th>
                <th>Refund Percentage for 10 Days</th>
                <th>Refund Percentage for 20 Days</th>
                <th>Silver User Discount</th>
                <th>Gold User Discount</th>
                <th>Platinum User Discount</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
        </thead>
        <tbody>
        <%
       
    	List<Carrier> carriers = (List<Carrier>) session.getAttribute("carriers");    	
       
        if(carriers.size() == 0 )
        {
        	out.println("No carrier data available");
        }
  		else{
          	for(Carrier c : carriers){
    	%>
    	<tr>
               		<td><%= c.getId() %></td>
                    <td><%= c.getCarrierName() %></td>
                    <td><%= c.getDiscount30Days() %></td>
                    <td><%= c.getDiscount60Days() %></td>
                    <td><%= c.getDiscount90Days() %></td>
                    <td><%= c.getBulkBookingDiscount() %></td>
                    <td><%= c.getRefund2Days() %></td>
                    <td><%= c.getRefund10Days() %></td>
                    <td><%= c.getRefund20Days() %></td>
                    <td><%= c.getSilverUserDiscount() %></td>
                    <td><%= c.getGoldUserDiscount() %></td>
                    <td><%= c.getPlatinumUserDiscount() %></td>
                    <td><form action="EditCarrierServlet" >
  							<button  style= "font-size : 14px;color: white; background-color: #4CAF50; border: none ;border-radius:4px;" type="submit"  value="<%= c.getId() %>" name = "editcarrier">Edit</button>
  						</form></td>
                    <td><form action="DeleteCarrierServlet" onsubmit="return confirmDelete();" >
  							<button  style= "color: white;background-color:red; border-color:red;border-radius:4px;" type="submit"  name = "deletecarrier" value = "<%=c.getId() %>">Delete</button>
  						</form></td>
     	</tr>
     	<%}
        }%>
        </tbody>
    </table>

    
</div>
<div class="button-container">
    
    	<form action="AddCarrier.jsp" >
  				<button type="submit"  value = "AddCarrier">Add Carrier</button>
  		</form>
        <!-- <button	type="button">Add</button>
        <button type="button">Edit</button>
        <button type="button">Delete</button> -->
    </div>
</body>
</html>


<% }  %>
