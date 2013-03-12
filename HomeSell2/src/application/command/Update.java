package application.command;


import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import domain.model.person.Person;
import domain.model.mapper.Mapper;

public class Update extends FrontCommand {

	public Update() {
		super();
	}

	public String execute(HttpServletRequest request) {

		// <a
		// href="BuddyAge?command=application.command.Unsubscribe&Email=<%=mperson.getEmailAddress()%>">Un-subscribe</a>
		String email = request.getParameter("Email");
		String Fname = request.getParameter("Fname");
		String Lname = request.getParameter("Lname");
		Date DOB = Date.valueOf(request.getParameter("DOB"));
		Integer phone = Integer.parseInt(request.getParameter("Phone"));
		
		
		Person aMember = new Person(email,Fname,Lname,DOB,phone);
		try {
			Mapper.update(aMember, "Person");
			request.setAttribute("aMember", aMember);
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return "/WEB-INF/jsp/MemberPage.jsp";
	}

}
