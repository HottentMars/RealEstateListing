package application.command;

import javax.servlet.http.HttpServletRequest;
/*import domain.model.house.mapper.DomainObjectNotFoundException;
import domain.model.house.mapper.LostUpdateException;
import domain.model.house.House;
import domain.model.house.mapper.HouseMapper;*/

public class EditHouse extends FrontCommand {
	
	public EditHouse() {
        super();
    }

	public String execute(HttpServletRequest request) {
		//House house = null;
		/*try {
			long listingId = Long.parseLong(request.getParameter("listingId"));
			int version = Integer.parseInt(request.getParameter("version"));
			String address = request.getParameter("address");
			int ownerId = Integer.parseInt(request.getParameter("ownerId"));
			int price = Integer.parseInt(request.getParameter("price"));
			int yearOfConstruction = Integer.parseInt(request.getParameter("yearOfConstruction"));
			int lotSize = Integer.parseInt(request.getParameter("lotSize"));
			int totalLivingArea = Integer.parseInt(request.getParameter("totalLivingArea"));
			String heating = request.getParameter("heating");
			boolean cooling = Boolean.parseBoolean(request.getParameter("cooling"));
			String garage = request.getParameter("garage");
			String driveway = request.getParameter("driveway");
			int drivewayCars = Integer.parseInt(request.getParameter("drivewayCars"));
			String siding = request.getParameter("siding");
			String windowType = request.getParameter("windowType");
			boolean yard = Boolean.parseBoolean(request.getParameter("yard"));
			boolean garden = Boolean.parseBoolean(request.getParameter("garden"));
			String notes = request.getParameter("notes");
			
			house = HouseMapper.find(listingId);
			house.setVersion(version);
			house.setAddress(address);
			house.setOwnerId(ownerId);
			house.setPrice(price);
			house.setYearOfConstruction(yearOfConstruction);
			house.setLotSize(lotSize);
			house.setTotalLivingArea(totalLivingArea);
			house.setHeating(heating);
			house.setCooling(cooling);
			house.setGarage(garage);
			house.setDriveway(driveway);
			house.setDrivewayCars(drivewayCars);
			house.setSiding(siding);
			house.setWindowType(windowType);
			house.setYard(yard);
			house.setGarden(garden);
			house.setNotes(notes);
			
			HouseMapper.update(house);
			
			request.setAttribute("house", house);
			return "/WEB-INF/jsp/ViewHouse.jsp";
		} catch (LostUpdateException e) {
			request.setAttribute("warning", e.getMessage());
			return "/WEB-INF/jsp/ViewHouse.jsp";
		} catch (DomainObjectNotFoundException e) {
			request.setAttribute("warning", e.getMessage());
			return "/WEB-INF/jsp/ViewHouse.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}*/
		return null;
	}

}
