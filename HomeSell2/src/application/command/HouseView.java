package application.command;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
/*import domain.model.house.mapper.DomainObjectNotFoundException;
import domain.model.house.House;
import domain.model.house.mapper.HouseMapper;*/

import domain.model.RealEstate.House;
import domain.model.RealEstate.RealEstate;
import domain.model.mapper.Mapper;
import domain.model.person.Owner;

public class HouseView extends FrontCommand {
	
	public HouseView() {
        super();
    }

	public String execute(HttpServletRequest request) {
		session = request.getSession(false);
		if(session==null)
		{
			return "login.html";
		}
		else
		{
			session = request.getSession();
			Owner aMember= (Owner) session.getAttribute("aMember");//Get the current session
			
			List<String> Search = new ArrayList<String>();
			Search.add("p.email_address = "+"'"+aMember.getEmailAddress()+"'");
			try {
				List<RealEstate> member_house;// = (List<House>)Mapper.find(aMember.getEmailAddress(), "House");
				member_house = (List<RealEstate>)(List<?>)Mapper.advancedSearch(Search,"RealEstate");
				session.setAttribute("member_house", member_house);
				request.setAttribute("member_house", member_house);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "/WEB-INF/jsp/HouseView.jsp";
		}
	}

}
