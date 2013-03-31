package application.command;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import domain.model.RealEstate.House;
import domain.model.RealEstate.Room;
import domain.model.mapper.Mapper;
//import domain.model.RealEstate.RealEstate;
import domain.model.person.Owner;


public class HouseUpdate extends FrontCommand {
	
	public HouseUpdate() {
        super();
    }

	public String execute(HttpServletRequest request) {
		session = request.getSession();
		//House
		List<House> member_house= (List<House>)session.getAttribute("member_house");
		Iterator it = member_house.iterator();
		House real = (House)it.next();
		real.setCivic_number(Integer.parseInt(request.getParameter("V1")));
		real.setStreet(request.getParameter("V2"));
		real.setCity(request.getParameter("V3"));
		
		//Room
		try {
			Mapper.update(real, "RealEstate");
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
		Owner aMember= (Owner) session.getAttribute("aMember");//Get the current session
		request.setAttribute("aMember",aMember);
		
		return "/WEB-INF/jsp/MemberPage.jsp";
	}

}
