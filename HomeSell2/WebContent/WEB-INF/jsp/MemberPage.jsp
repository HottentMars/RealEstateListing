<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="domain.model.person.Owner"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Owner mperson = (Owner)request.getAttribute("aMember");
String warning = (String)request.getAttribute("warning");
%>
<% if(warning != null) { %><b>Warning: </b> <%=warning %><br/> <% } %>
Welcome <%= mperson.getFirstName()%> <%= mperson.getLastName()%> (<a href="BuddyAge?command=application.command.OwnerLogout">Logout</a>)
<%request.setAttribute("mperson", mperson); %>
<br><a href="BuddyAge?command=application.command.HouseView">View your House(s)</a>
<br><a href="BuddyAge?command=application.command.OwnerProfileInformation">Update your profile</a>
<br><a href="BuddyAge?command=application.command.OwnerUnsubscribe">Unsubscribe</a>
<br><a href="index.html">Home page</a><br>

</body>
</html>