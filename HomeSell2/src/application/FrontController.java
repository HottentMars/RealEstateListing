package application;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.command.FrontCommand;

public class FrontController extends HttpServlet {

	@Override
	public void init() throws ServletException {
		super.init();
		prepareDbRegistry("");
	}

	public static void prepareDbRegistry(String db_id) {

	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FrontCommand fc = getFrontCommand(request);
		if(fc != null) {
			String dispatch = fc.execute(request);
			
			if(dispatch != null) {
				request.getRequestDispatcher(dispatch).forward(request, response);
			}
		}
		
	}

	private FrontCommand getFrontCommand(HttpServletRequest request) {
		try {
			String command = request.getParameter("command");
			if(command == null || command.isEmpty()) {
				command = "application.command.BrowseHouses";
			}
			return (FrontCommand) Class.forName(command).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		preProcessRequest(request, response);
		try {
			processRequest(request, response);
		} finally {
			postProcessRequest(request, response);
		}
	}

	protected void preProcessRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void postProcessRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
}
