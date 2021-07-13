package logic.controller.guicontroller.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.engclasses.dao.SponsorDao;
import logic.engclasses.exceptions.PendingRequestException;
import logic.engclasses.utils.Credentials;



@WebServlet("/HostShowWebController")
public class HostShowWebController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public HostShowWebController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Credentials cr = Credentials.getInstance();
		if(cr.getId()==2) {
			RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/views/ArtistRequest.jsp");
			dispatcher2.forward(request, response);
		}
		if(cr.getId()==3) {
			RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/views/RequestStatus.jsp");
			dispatcher2.forward(request, response);
		}
		if(cr.getId()==1) {
			RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/views/UserSponsoredEvents.jsp");
			dispatcher2.forward(request, response);
		}
		else {
			RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/views/RequestStatus.jsp");
			dispatcher2.forward(request, response);
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String artist = request.getParameter("artista");
		String title = request.getParameter("titolo");
		String desc = request.getParameter("descrizione");
		
		SponsorDao sd = new SponsorDao();
   	    try {
			sd.createSSQueue(title, artist, "no", desc, desc);
		} catch (PendingRequestException e) {
			e.printStackTrace();
		}
   	    
   	    RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/views/RequestStatus.jsp");
		dispatcher2.forward(request, response);
	}

}
