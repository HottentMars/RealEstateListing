<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="domain.model.person.Owner"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
function start() {
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
	myform.Fname.disabled = false; 
	myform.Lname.disabled = false;
	myform.DOB.disabled = false;
	myform.Phone.disabled = false;
}
</script>
<%
Owner mperson = (Owner)request.getAttribute("aMember");

String warning = (String)request.getAttribute("warning");
%>
<% if(warning != null) { %><b>Warning: </b> <%=warning %><br/> <% } %>

<form name="myform" action="BuddyAge?command=application.command.OwnerUpdate"
		method="post" onsubmit="enableText()">
		First Name: <input type="text" name="Fname" value="<%= mperson.getFirstName() %>" /><input type="checkbox" name="cb1" onchange="chgtx1();" /><br> 
		Last Name: <input type="text" name="Lname" value="<%= mperson.getLastName() %>" /><input type="checkbox" name="cb2" onchange="chgtx2();" /><br> 
		Date of birth: <input type="text" name="DOB" value="<%= mperson.getDOB() %>" /> <input type="checkbox" name="cb3" onchange="chgtx3();"/> <br> 
		Phone Number: <input type="text" name="Phone" value="<%= mperson.getPhoneNumber() %>" /> <input type="checkbox" name="cb4" onchange="chgtx4();"/> <br> 
		<input type="submit" value="Update" />
		<input type="button" name="cancel" value="Cancel" onClick="history.go(-1);return true;" /><br>
	</form>
</body>
</html>