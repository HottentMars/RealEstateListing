<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="domain.model.RealEstate.RealEstate"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%List<RealEstate> member_house = (List<RealEstate>)request.getAttribute("member_house");%>
<h2>Your house(s)</h2>
<% Iterator it = member_house.iterator();%> 
<%while(it.hasNext())
{
	RealEstate a= (RealEstate)it.next();%>
	<a href="BuddyAge?command=application.command.HouseDetails&house_id=<%=a.getRealestate_id()%>&version=<%=a.getVersion() %>">
	<%=a.getCivic_number()%>
	<%=a.getStreet() %>
	<%=a.getCity() %></a><br>
<%}%>
<form><input type="button" name="Back" value="Back" onClick="history.go(-1);return true;" /></form><br>
</body>
</html>