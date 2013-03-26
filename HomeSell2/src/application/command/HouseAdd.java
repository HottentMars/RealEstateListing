package application.command;

import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import domain.model.mapper.Mapper;
import domain.model.person.Owner;
import domain.model.RealEstate.*;

public class HouseAdd extends FrontCommand{

	public HouseAdd()
	{
		super();
	}
	@Override
	public String execute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		session = request.getSession();
		String Province = "Quebec";
		Owner aMember= (Owner) session.getAttribute("aMember");//Get the current session
		
		RealEstate member_house= new House(null,1, aMember.getEmailAddress(),Integer.parseInt(request.getParameter("civic_number")),
				request.getParameter("street_name"),request.getParameter("city"),Province, request.getParameter("postal_code"),
				Date.valueOf(request.getParameter("YOC")),0,0);
		
		try {
			Mapper.insert(member_house, "RealEstate"); //Insert Base class "RealEstate" in database
			member_house.setRealestate_id(Generatedkeymap.getInstance().get(1)) ; //Get last generated key from Mysql query
			Mapper.insert(member_house, "House");//Insert Derived Class "House" in database
			
			for(int i=0;i<Integer.parseInt(request.getParameter("bedroom_number"));i++)
			{
				Room room= new Room(null,1,member_house.getRealestate_id(),"bedroom",0);
				Mapper.insert(room, "Room");
			}
			
			for(int i=0;i<Integer.parseInt(request.getParameter("bathroom_number"));i++)
			{
				Room room= new Room(null,1,member_house.getRealestate_id(),"bathroom",0);
				Mapper.insert(room, "Room");
			}
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
		request.setAttribute("aMember",aMember);
	
		return "/WEB-INF/jsp/MemberPage.jsp";
	}

	
}
