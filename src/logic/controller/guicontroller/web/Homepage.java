package logic.controller.guicontroller.web;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import logic.controller.appcontroller.EditCommercialActivity;
import logic.controller.appcontroller.ViewProfile;
import logic.engclasses.bean.LoggedBean;
import logic.engclasses.utils.Session;

  

@WebServlet("/Homepage")
public class Homepage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Homepage() {
        super();
      
    	
   
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Session s5 = (Session)session.getAttribute("session");
		LoggedBean lb5 = s5.getLoggedBean();
		int cr = lb5.getId();
		if (cr==2){
			
			ViewProfile hac = new ViewProfile();
			
			hac.dismissLiveShow(lb5.getUsername());
			//dynamic button hiding
			session.setAttribute("Hosting", "noshow");
			RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/views/HomepageArtists.jsp");
			dispatcher2.forward(request, response);
		    }
		if (cr==3){
			//sponsor
			EditCommercialActivity hsc = new EditCommercialActivity();
			hsc.delete(lb5.getUsername());
			//dynamic button hiding
			session.setAttribute("HostingSponsor", "noshow");
			RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/views/Homepagesponsor.jsp");
			dispatcher2.forward(request, response);
		    }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session1 = request.getSession();
		Session s51 = (Session)session1.getAttribute("session");
		LoggedBean lb51 = s51.getLoggedBean();
		int cr1 = lb51.getId();
	    if (cr1==2){
	    RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/views/HomepageArtists.jsp");
		dispatcher2.forward(request, response);
	    }
	    if (cr1==3){
		    RequestDispatcher dispatcher3 = request.getRequestDispatcher("/WEB-INF/views/Homepagesponsor.jsp");
			dispatcher3.forward(request, response); 
	    }
	    else{
		RequestDispatcher dispatcher1 = request.getRequestDispatcher("/WEB-INF/views/HomepageUsers.jsp");
	    dispatcher1.forward(request, response);
		}
	}
	}

