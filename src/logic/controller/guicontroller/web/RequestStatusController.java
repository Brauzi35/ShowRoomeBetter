package logic.controller.guicontroller.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.controller.appcontroller.HostPrivateShow;
import logic.engclasses.utils.Credentials;


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
    	Credentials instance = Credentials.getInstance();
    	rac.hostSponsoredShow(title, artist, instance.getUsername(), instance.getActivity(), instance.getCapacity(), "no", description);
    	RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/views/RequestStatus.jsp");
		dispatcher2.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HostPrivateShow rac = new HostPrivateShow();
		rac.deleteRequest(null);
		RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/views/RequestStatus.jsp");
		dispatcher2.forward(request, response);
	}

}
