package application.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;


//import domain.model.person.Person;
import domain.model.mapper.Mapper;
import domain.model.person.Owner;

public class OwnerUnsubscribe  extends FrontCommand {

	public OwnerUnsubscribe() {
        super();
    }
	public String execute(HttpServletRequest request) {
		
		session = request.getSession();
		Owner aMember= (Owner) session.getAttribute("aMember");

		try {
			Mapper.delete(aMember.getEmailAddress(), "Owner");
			Mapper.delete(aMember.getEmailAddress(), "Person");
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return "/index.html";
	}

}
