package application.command;

import javax.servlet.http.HttpServletRequest;

import domain.model.person.Owner;

public class OwnerProfileInformation extends FrontCommand{

	public OwnerProfileInformation()
	{
		super();
	}
	@Override
	public String execute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		session = request.getSession();
		
		if(session.isNew())
		{
			return "/WEB-INF/jsp/Member.jsp";
		}else
		{
			Owner aMember= (Owner) session.getAttribute("aMember");
			request.setAttribute("aMember", aMember);
			return "/WEB-INF/jsp/ProfileInformation.jsp";
		}
		
		
	}
	

}
