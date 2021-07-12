package logic.controller.guicontroller.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.controller.appcontroller.CheckPersonalMessages;


@WebServlet("/ArtistRequestController")
public class ArtistRequestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ArtistRequestController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value = request.getParameter("button");
		String title = request.getParameter("nome");
		CheckPersonalMessages rac = new CheckPersonalMessages();
		if(value.equals("Accetta")) {
			rac.acceptRequest(title, "yes");
		}
		else if(value.equals("Rifiuta")) {
			rac.acceptRequest(title, "refused");
		}
		RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/views/ArtistRequest.jsp");
		dispatcher2.forward(request, response);
	}

}
