package logic.controller.guicontroller.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic.controller.appcontroller.HostPrivateShow;
import logic.engclasses.bean.LoggedBean;
import logic.engclasses.utils.Session;



/**
 * Servlet implementation class RequestStatusController
 */
@WebServlet("/RequestStatusController")
public class RequestStatusController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RequestStatusController() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("name");
		String description = request.getParameter("desc");
		String artist = request.getParameter("artist");
		HostPrivateShow rac = new HostPrivateShow();
		HttpSession session11 = request.getSession();
		Session s53 = (Session)session11.getAttribute("session");
		LoggedBean lb53 = s53.getLoggedBean();
    	rac.hostSponsoredShow(title, artist, lb53.getUsername(), lb53.getActivity(), lb53.getCapacity(), "no", description);
    	RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/views/RequestStatus.jsp");
		dispatcher2.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HostPrivateShow rac = new HostPrivateShow();
		HttpSession session19 = request.getSession();
		Session s59 = (Session)session19.getAttribute("session");
		LoggedBean lb59 = s59.getLoggedBean();
		rac.deleteRequest(lb59.getUsername());
		RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/views/RequestStatus.jsp");
		dispatcher2.forward(request, response);
	}

}
