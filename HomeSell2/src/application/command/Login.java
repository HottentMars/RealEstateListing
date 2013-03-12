package application.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;


import domain.model.person.Person;
import domain.model.mapper.Mapper;

public class Login extends FrontCommand {
	// private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	public String execute(HttpServletRequest request) {
		String email = request.getParameter("Email");
		// String pass = request.getParameter("Password");
		Person aMember = null;//= new Person(email, null, null, null, 0);
		try {
			aMember = (Person) Mapper.find(email, "Person");
			//Mapper.find(aMember, "Person");
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//session=request.getSession();
		//session.setAttribute("aMember", aMember);
		request.setAttribute("aMember", aMember);

		// MemberPerson aMember = new MemberPerson(id,name,pass);

		return "/WEB-INF/jsp/MemberPage.jsp";

	}

}
