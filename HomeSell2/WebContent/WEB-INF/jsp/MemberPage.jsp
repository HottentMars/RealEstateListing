<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="domain.model.person.Person"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Person mperson = (Person)request.getAttribute("aMember");
String warning = (String)request.getAttribute("warning");
%>
<% if(warning != null) { %><b>Warning: </b> <%=warning %><br/> <% } %>
Welcome <%= mperson.getFirstName()%> <%= mperson.getLastName()%>
<%request.setAttribute("mperson", mperson); %>

<br><a href="BuddyAge?command=application.command.Unsubscribe&Email=<%=mperson.getEmailAddress()%>">Un-subscribe</a>
 <%--<a href="Update.jsp?Email=<%=mperson.getEmailAddress()%>&Fname=<%=mperson.getFirstName()%>&Lname=<%=mperson.getLastName()%>&DOB=<%=mperson.getDOB()%>&Phone=<%=mperson.getPhoneNumber()%>">Update</a>--%>
<br><a href="index.html">Menu</a><br>
</body>
</html>