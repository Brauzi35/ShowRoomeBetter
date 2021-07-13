package logic.controller.guicontroller.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.controller.appcontroller.ViewProfile;








/**
 * Servlet implementation class updateInfo
 */
@WebServlet("/UpdateInfo")
public class UpdateInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public UpdateInfo() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//not used
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ViewProfile hac = new ViewProfile();
		String controllo = request.getParameter("Salva");
		
		String casella1post = request.getParameter("talent1");
		String casella2post= request.getParameter("email1");
		String casella3post = request.getParameter("descrizione1");
		
    if(controllo.equals("Salva")) {
    			hac.updateProfile(casella2post, casella1post, casella3post, casella3post);
	        	RequestDispatcher dispatcher1 = request.getRequestDispatcher("/WEB-INF/views/HomepageArtists.jsp");
	            dispatcher1.forward(request, response);
	    
	}

}
}
