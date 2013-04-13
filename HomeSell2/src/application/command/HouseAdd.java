package application.command;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
 
import domain.model.mapper.Mapper;
import domain.model.person.Owner;
import domain.model.RealEstate.*;
import java.util.Collection;
import org.apache.log4j.Logger;


public class HouseAdd extends FrontCommand{

	private static Logger logger = Logger.getLogger(HouseAdd.class);
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
		
		//Create dir location for image
		String postal_code= request.getParameter("postal_code");
		String civic_number= request.getParameter("civic_number");
		String PC= postal_code + civic_number;
		String ImageDir = "/home/anakis/git/RealEstate/HomeSell2/WebContent/images/houses/"+PC+"/profile";
		File NewDir = (new File(ImageDir));
		NewDir.mkdirs();
		try {
			
		Part pic= request.getPart("picture");
		String Name = getFileName(pic);
		String ProfilePic = ImageDir+"/"+Name;
		pic.write(ProfilePic);
		
		RealEstate member_house= new House(null,1, aMember.getEmailAddress(),Integer.parseInt(civic_number),
				request.getParameter("street_name"),request.getParameter("city"),Province, request.getParameter("postal_code"),
				Date.valueOf(request.getParameter("YOC")), 0, ProfilePic, Long.parseLong( request.getParameter("price")),0);//
		
		
			Mapper.insert(member_house, "RealEstate"); //Insert Base class "RealEstate" in database
			member_house.setRealestate_id(Generatedkeymap.getInstance().get(1)) ; //Get last generated key from Mysql query
			Mapper.insert(member_house, "House");//Insert Derived Class "House" in database
			Long Houseid = member_house.getRealestate_id();
			for(int i=0;i<Integer.parseInt(request.getParameter("bedroom_number"));i++)
			{
				Room room= new Room(null,1,Houseid,"bedroom",0);
				Mapper.insert(room, "Room");
			}
			
			for(int i=0;i<Integer.parseInt(request.getParameter("bathroom_number"));i++)
			{
				Room room= new Room(null,1,Houseid,"bathroom",0);
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
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("aMember",aMember);
	
		return "/WEB-INF/jsp/MemberPage.jsp";
	}

	private String getFileName(Part part) {
	    String partHeader = part.getHeader("content-disposition");
	    logger.info("Part Header = " + partHeader);
	    for (String cd : part.getHeader("content-disposition").split(";")) {
	      if (cd.trim().startsWith("filename")) {
	        return cd.substring(cd.indexOf('=') + 1).trim()
	            .replace("\"", "");
	      }
	    }
	    return null;
	}
}
