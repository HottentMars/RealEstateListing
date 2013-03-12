package application.command;

import javax.servlet.http.HttpServletRequest;
/*import domain.model.house.mapper.DomainObjectNotFoundException;
import domain.model.house.House;
import domain.model.house.mapper.HouseMapper;*/

public class ViewHouse extends FrontCommand {
	
	public ViewHouse() {
        super();
    }

	public String execute(HttpServletRequest request) {
		/*try {
			long listingId = Long.parseLong(request.getParameter("listingId"));
			House house = HouseMapper.find(listingId);
			request.setAttribute("house", house);

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
