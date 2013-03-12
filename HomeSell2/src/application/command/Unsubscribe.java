package application.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;


import domain.model.person.Person;
import domain.model.mapper.Mapper;

public class Unsubscribe  extends FrontCommand {

	public Unsubscribe() {
        super();
    }
	public String execute(HttpServletRequest request) {
		
		//<a href="BuddyAge?command=application.command.Unsubscribe&Email=<%=mperson.getEmailAddress()%>">Un-subscribe</a>
		String email = request.getParameter("Email");
		//Person aMember = new Person(email,null,null,null,0);
		try {
			Mapper.delete(email, "Person");
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return "/index.html";
	}

}
