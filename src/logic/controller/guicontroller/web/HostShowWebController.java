package logic.controller.guicontroller.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic.engclasses.bean.LoggedBean;
import logic.engclasses.dao.SponsorDao;
import logic.engclasses.exceptions.PendingRequestException;
import logic.engclasses.utils.Session;




@WebServlet("/HostShowWebController")
public class HostShowWebController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    
    public HostShowWebController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session11 = request.getSession();
		Session s53 = (Session)session11.getAttribute("session");
		LoggedBean cr = s53.getLoggedBean();
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
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session11 = request.getSession();
		Session s35 = (Session)session11.getAttribute("session");
		LoggedBean cr3 = s35.getLoggedBean();
		
		String artist = request.getParameter("artista");
		String title = request.getParameter("titolo");
		String desc = request.getParameter("descrizione");
		
		SponsorDao sd = new SponsorDao();
   	    try {
			sd.createSSQueue(cr3.getUsername() ,title, artist, "no", desc);
		} catch (PendingRequestException e) {
			e.printStackTrace();
		}
   	    
   	    RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/views/RequestStatus.jsp");
		dispatcher2.forward(request, response);
	}

}
