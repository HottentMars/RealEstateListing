package application.command;

import java.sql.Date;
//import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;


import application.command.FrontCommand;
import domain.model.person.Person;
//import domain.model.person.MemberPerson;
import domain.model.mapper.Mapper;

public class Subscribe extends FrontCommand {
	//private static final long serialVersionUID = 1L;

    public Subscribe() {
        super();
    }

	public String execute(HttpServletRequest request) {
		try {
			String email = request.getParameter("Email");
			String Fname = request.getParameter("Fname");
			String Lname = request.getParameter("Lname");
			Date DOB = Date.valueOf(request.getParameter("DOB"));
			Long phone = Long.parseLong(request.getParameter("Phone"));
			
			Person aMember = new Person(email,Fname,Lname,DOB,phone);
			Mapper.insert(aMember, "Person");
			
			request.setAttribute("aMember", aMember);
			
			return "/WEB-INF/jsp/MemberPage.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
