package application.command;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public abstract class FrontCommand {
	protected HttpSession session = null;
	public abstract String execute(HttpServletRequest req);
}

