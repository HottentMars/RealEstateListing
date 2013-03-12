package application.command;
import javax.servlet.http.HttpServletRequest;
//import domain.model.house.mapper.HouseMapper;

public class BrowseHouses extends FrontCommand {
	
	public BrowseHouses() {
        super();
    }

	public String execute(HttpServletRequest request) {
		try {
			//request.setAttribute("houses", HouseMapper.findAll());
			return "/WEB-INF/jsp/BrowseHouses.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
