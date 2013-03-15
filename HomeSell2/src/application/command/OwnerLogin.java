package application.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;


import domain.model.person.Owner;
import domain.model.mapper.Mapper;

public class OwnerLogin extends FrontCommand {
	// private static final long serialVersionUID = 1L;

	public OwnerLogin() {
		super();
	}

	public String execute(HttpServletRequest request) {
		session = request.getSession();
		System.out.println("The session id is: "+session.getId());
		String email = request.getParameter("Email");
		// String pass = request.getParameter("Password");
		Owner aMember = null;//= new Person(email, null, null, null, 0);
		try {
			aMember = (Owner) Mapper.find(email, "Owner");
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//String password = request.getParameter("password");
		if(aMember.getpassword().equals(request.getParameter("password")))
		{
			session.setAttribute("aMember", aMember);
			request.setAttribute("aMember", aMember);
			return "/WEB-INF/jsp/MemberPage.jsp";
		}else
		{
			return "login.html";
		}

	}

}
