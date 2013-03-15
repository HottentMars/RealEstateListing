package application.command;

import javax.servlet.http.HttpServletRequest;

public class OwnerLogout extends FrontCommand{

	public OwnerLogout() {
		super();
	}
	@Override
	public String execute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		session = request.getSession();
		session.invalidate();
		return "index.html";
	}

}
