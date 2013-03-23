package application.command;

import javax.servlet.http.HttpServletRequest;

public class HouseAdd extends FrontCommand{

	public HouseAdd()
	{
		super();
	}
	@Override
	public String execute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		session = request.getSession();
		return null;
	}

	
}
