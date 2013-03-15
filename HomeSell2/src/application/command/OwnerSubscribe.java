package application.command;

import java.sql.Date;
//import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;


import application.command.FrontCommand;
import domain.model.person.Owner;
//import domain.model.person.MemberPerson;
import domain.model.mapper.Mapper;

public class OwnerSubscribe extends FrontCommand {
	//private static final long serialVersionUID = 1L;

    public OwnerSubscribe() {
        super();
    }

	public String execute(HttpServletRequest request) {
		try {
			session = request.getSession();
			String email = request.getParameter("Email");
			String Fname = request.getParameter("Fname");
			String Lname = request.getParameter("Lname");
			Date DOB = Date.valueOf(request.getParameter("DOB"));
			Long phone = Long.parseLong(request.getParameter("Phone"));
			String password = request.getParameter("Password");
			
			Owner aMember = new Owner(email,password,Fname,Lname,DOB,phone);
			Mapper.insert(aMember, "Owner");
			session.setAttribute("aMember", aMember);
			request.setAttribute("aMember", aMember);
			
			return "/WEB-INF/jsp/MemberPage.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
