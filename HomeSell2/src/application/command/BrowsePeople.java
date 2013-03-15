package application.command;

import javax.servlet.http.HttpServletRequest;

import application.command.FrontCommand;
import domain.model.mapper.Mapper;

public class BrowsePeople extends FrontCommand{
	//private static final long serialVersionUID = 1L;

    public BrowsePeople() {
        super();
    }

	public String execute(HttpServletRequest request) {
		try {
			//session = request.getSession(true);
			//session.invalidate();
			request.setAttribute("people", Mapper.findAll("Owner"));
			return "/WEB-INF/jsp/BrowsePeopleTV.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
