<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="domain.model.RealEstate.House"%>
<%@page import="domain.model.RealEstate.Room"%>
<%@page import="java.util.*"%>
<!DOCTYPE HTML>
<html>
<head>
<meta name="description" content="website description" />
<meta name="keywords" content="website keywords, website keywords" />
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">

<link rel="stylesheet" type="text/css" id="theme" href="css/style.css" />
  <!-- modernizr enables HTML5 elements and feature detects -->
  <script type="text/javascript" src="js/modernizr-1.5.min.js"></script>
<title>Home Sell</title>


<!-- ****** -->

<!-- ****** -->


</head>
<body>
<script language="javascript" src="update.js">
</script>
<div id="main">
		<header>
			<div id="logo">
		        <div id="logo_text">
		          <!-- class="logo_colour", allows you to change the colour of the text -->
		          <h1><a href="index.html">Real Estate<span class="logo_colour">Listings</span></a></h1>
		          <h2>Add listing, photos, with more details.</h2>
		        </div>
		        <form method="post" action="#" id="search">
		          <input class="search" type="text" name="search_field" value="search....." onclick="javascript: document.forms['search'].search_field.value=''" />
		          <input name="search" type="image" style="float: right;border: 0; margin: 20px 0 0 0;" src="images/search.png" alt="search" title="search" />
		        </form>
	      	</div>
	      	<nav>
		      	<ul class="sf-menu" id="nav">
	          		<li ><a href="index.html">Home</a></li>
		          	<li><a href="#">listings</a></li>
		          	<li class="current"><a href="BuddyAge?command=application.command.SessionCheck">Member area</a>
				        <ul>
				           <li><a href="BuddyAge?command=application.command.HouseView">View your house(s)</a></li>
				           <li><a href="BuddyAge?command=application.command.InsertHouse">Add House</a></li>
				           <li><a href="BuddyAge?command=application.command.OwnerProfileInformation">Member Profile</a></li>
				        </ul>
			        </li>
	          		<li><a href="#">Contact Us</a></li>
	        	</ul>
<!-- 				<a href="subscribe.html">Subscribe</a><br> -->
<!-- 				<a href="login.html">Login</a><br> -->
<!-- 				<a href="BuddyAge?command=application.command.BrowsePeople">BrowsePeople</a><br> -->
			</nav><!-- END of nav -->
		</header><!-- END of header -->
	    <div id="site_content">
      <div id="sidebar_container">
        <div class="sidebar">
          <h3>Latest News</h3>
          <div class="sidebar_item">
            <!-- insert your sidebar items here -->
            <h4>New Website Launched</h4>
            <h5>January 1st, 2012</h5>
            <p>2012 sees the redesign of our website. Take a look around and let us know what you think.<br /><a href="#">Read more</a></p>
          </div>
          <div class="sidebar_base"></div>
        </div>
      </div>
      <div class="content">
        <h1>House details</h1>
        <div class="content_item">
        	
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
				<div class="form_settings">
					<form name="myform" action="BuddyAge?command=application.command.HouseUpdate" method="post" onsubmit="enableText()">
						<p><span>Street number</span> <input type="text" name="V1" value="<%= a.getCivic_number() %>" /><input type="checkbox" name="cb1" onchange="chgtx1();" /></p><br> 
						<p><span>Street name</span> <input type="text" name="V2" value="<%= a.getStreet() %>" /><input type="checkbox" name="cb2" onchange="chgtx2();" /></p><br> 
						<p><span>City</span><input type="text" name="V3" value="<%= a.getCity() %>" /> <input type="checkbox" name="cb3" onchange="chgtx3();"/></p> <br> 
						<p><span>Number of bedrooms</span> <input type="text" name="V4" value="<%= CountBed %>" /> <input type="checkbox" name="cb4" onchange="chgtx4();"/></p> <br>
						<p><span>Number of bathrooms</span> <input type="text" name="V5" value="<%= CountBath %>" /> <input type="checkbox" name="cb5" onchange="chgtx5();"/></p> <br>
						<input class="submit" type="submit" value="Update" />
						<input class="submit" type="button" name="cancel" value="Cancel" onClick="history.go(-1);return true;" /><br>
					</form>
				</div>
			
			<%}%>
        </div>
      </div>
      
    </div>
    <footer>
      <p><a href="index.html">Home</a> | <a href="#">Listings</a> | <a href="BuddyAge?command=application.command.SessionCheck">Member area</a> | <a href="#">Contact Us</a></p>
<!--       <p>Copyright &copy; CSS3_one | <a href="http://www.css3templates.co.uk">design from css3templates.co.uk</a></p> -->
    </footer>
  </div>
  <!-- javascript at the bottom for fast page loading -->
  <script type="text/javascript" src="js/jquery.js"></script>
  <script type="text/javascript" src="js/jquery.easing-sooper.js"></script>
  <script type="text/javascript" src="js/jquery.sooperfish.js"></script>
  <script type="text/javascript">
    $(document).ready(function() {
      $('ul.sf-menu').sooperfish();
    });
  </script>

</body>
</html>