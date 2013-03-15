package application.command;


import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import domain.model.person.Owner;
import domain.model.mapper.Mapper;

public class OwnerUpdate extends FrontCommand {

	public OwnerUpdate() {
		super();
	}

	public String execute(HttpServletRequest request) {

		session = request.getSession();
		Owner aMember= (Owner) session.getAttribute("aMember");
		//String email = request.getParameter("Email");
		aMember.setFirstName(request.getParameter("Fname"));
		aMember.setLastName(request.getParameter("Lname"));
		aMember.setDOB( Date.valueOf(request.getParameter("DOB")) ) ;
		aMember.setPhoneNumber(Long.parseLong(request.getParameter("Phone")));
		
		
		//Owner aMember = new Person(email,Fname,Lname,DOB,phone);
		try {
			Mapper.update(aMember, "Owner");
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
