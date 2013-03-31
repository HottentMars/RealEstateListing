package application.command;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import domain.model.RealEstate.House;
import domain.model.RealEstate.Room;
import domain.model.mapper.Mapper;

public class HouseDetails extends FrontCommand{

	public HouseDetails() {
        super();
    }
	@Override
	public String execute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		session = request.getSession();
		String house_id = request.getParameter("house_id");
		List<String> Search = new ArrayList<String>();
		Search.add("p.ree_id = "+"'"+house_id+"'");
		try {
			List<House> member_house = (List<House>)(List<?>)Mapper.find(house_id,"House");
			List<Room> member_room = (List<Room>)(List<?>)Mapper.advancedSearch(Search, "Room");
			session.setAttribute("member_house", member_house);
			request.setAttribute("member_house", member_house);
			session.setAttribute("member_room", member_room);
			request.setAttribute("member_room", member_room);
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
		return "/WEB-INF/jsp/HouseDetails.jsp";
	}

}
