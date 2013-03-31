<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="domain.model.RealEstate.House"%>
<%@page import="domain.model.RealEstate.Room"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script language="javascript" src="update.js">
</script>
<% List<Room> member_room = (List<Room>)(List<?>)request.getAttribute("member_room"); %>
<%List<House> member_house = (List<House>)(List<?>)request.getAttribute("member_house");%>
  
<% Iterator it = member_house.iterator();
Iterator it2 = member_room.iterator();

int CountBath=0;
int CountBed=0;
while(it2.hasNext())
{
	Room b = (Room)it2.next();
	if(b.getRoom_type().equals("bedroom"))
		CountBed++;
	
	CountBath++;
}
%> 
<%while(it.hasNext())
{
	House a= (House)it.next();%>
	<form name="myform" action="BuddyAge?command=application.command.HouseUpdate" method="post" onsubmit="enableText()">
		Street number: <input type="text" name="V1" value="<%= a.getCivic_number() %>" /><input type="checkbox" name="cb1" onchange="chgtx1();" /><br> 
		Street Name: <input type="text" name="V2" value="<%= a.getStreet() %>" /><input type="checkbox" name="cb2" onchange="chgtx2();" /><br> 
		City: <input type="text" name="V3" value="<%= a.getCity() %>" /> <input type="checkbox" name="cb3" onchange="chgtx3();"/> <br> 
		Number of bedrooms: <input type="text" name="V4" value="<%= CountBed %>" /> <input type="checkbox" name="cb4" onchange="chgtx4();"/> <br>
		Number of bathrooms: <input type="text" name="V5" value="<%= CountBath %>" /> <input type="checkbox" name="cb5" onchange="chgtx5();"/> <br>
		<input type="submit" value="Update" />
		<input type="button" name="cancel" value="Cancel" onClick="history.go(-1);return true;" /><br>
	</form>

<%}%>
</body>
</html>