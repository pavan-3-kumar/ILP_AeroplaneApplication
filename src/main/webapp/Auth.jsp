<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 
	
	if(session.getAttribute("session_id")==null){
		
		response.sendRedirect("Home.jsp");
	};
	
%>  
