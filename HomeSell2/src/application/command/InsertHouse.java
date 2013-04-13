package application.command;

import javax.servlet.http.HttpServletRequest;

public class InsertHouse extends FrontCommand{

	public InsertHouse()
	{
		super();
	}
	@Override
	public String execute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		session = request.getSession(false);
		if(session==null)
		{
			return "login.html";
		}
		else
		{
			return "addHouse.html";
		}
	}

}
