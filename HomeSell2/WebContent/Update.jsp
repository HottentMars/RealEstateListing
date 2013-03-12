<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="domain.model.person.Person"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update</title>
</head>
<body>
<script type="text/javascript">
function start() {
myform.Email.disabled = true;
myform.Fname.disabled = true; 
myform.Lname.disabled = true;
myform.DOB.disabled = true;
myform.Phone.disabled = true;
}

onload = start;

function chgtx1() {
myform.Fname.disabled  = !myform.cb1.checked;}

function chgtx2() {
myform.Lname.disabled = !myform.cb2.checked;
}

function chgtx3() {
myform.DOB.disabled = !myform.cb3.checked;}

function chgtx4() {
myform.Phone.disabled = !myform.cb4.checked;
} 

function enableText()
{
	myform.Email.disabled = false;
	myform.Fname.disabled = false; 
	myform.Lname.disabled = false;
	myform.DOB.disabled = false;
	myform.Phone.disabled = false;
}
</script>
<%
String Email = request.getParameter("Email");
String Fname = request.getParameter("Fname");
String Lname = request.getParameter("Lname");
String DOB = request.getParameter("DOB");
String Phone = request.getParameter("Phone");


String warning = (String)request.getAttribute("warning");
%>
<% if(warning != null) { %><b>Warning: </b> <%=warning %><br/> <% } %>

<form name="myform" action="BuddyAge?command=application.command.Update"
		method="post" onsubmit="enableText()">
		Email Address: <input type="text" name="Email" value="<%= Email %>" /> <br> 
		First Name: <input type="text" name="Fname" value="<%= Fname %>" /><input type="checkbox" name="cb1" onchange="chgtx1();" /><br> 
		Last Name: <input type="text" name="Lname" value="<%= Lname %>" /><input type="checkbox" name="cb2" onchange="chgtx2();" /><br> 
		Date of birth: <input type="text" name="DOB" value="<%= DOB %>" /> <input type="checkbox" name="cb3" onchange="chgtx3();"/> <br> 
		Phone Number: <input type="text" name="Phone" value="<%= Phone %>" /> <input type="checkbox" name="cb4" onchange="chgtx4();"/> <br> 
		<input type="submit" value="Update" /><br>
	</form>
</body>
</html>