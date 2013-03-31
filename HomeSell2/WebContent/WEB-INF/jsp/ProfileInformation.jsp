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
<script language="javascript" src="update.js">
</script>
<%
Owner mperson = (Owner)request.getAttribute("aMember");

String warning = (String)request.getAttribute("warning");
%>
<% if(warning != null) { %><b>Warning: </b> <%=warning %><br/> <% } %>

<form name="myform" action="BuddyAge?command=application.command.OwnerUpdate"
		method="post" onsubmit="enableText()">
		First Name: <input type="text" name="V1" value="<%= mperson.getFirstName() %>" /><input type="checkbox" name="cb1" onchange="chgtx1();" /><br> 
		Last Name: <input type="text" name="V2" value="<%= mperson.getLastName() %>" /><input type="checkbox" name="cb2" onchange="chgtx2();" /><br> 
		Date of birth: <input type="text" name="V3" value="<%= mperson.getDOB() %>" /> <input type="checkbox" name="cb3" onchange="chgtx3();"/> <br> 
		Phone Number: <input type="text" name="V4" value="<%= mperson.getPhoneNumber() %>" /> <input type="checkbox" name="cb4" onchange="chgtx4();"/> <br> 
		<input type="submit" value="Update" />
		<input type="button" name="cancel" value="Cancel" onClick="history.go(-1);return true;" /><br>
	</form>
</body>
</html>