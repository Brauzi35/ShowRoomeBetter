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
import logic.engclasses.utils.Credentials;

  

@WebServlet("/Homepage")
public class Homepage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Homepage() {
        super();
      
    	
   
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Credentials cr = Credentials.getInstance();
		if (cr.getId()==2){
			ViewProfile hac = new ViewProfile();
			hac.dismissLiveShow();
			//dynamic button hiding
			HttpSession session = request.getSession();
			session.setAttribute("Hosting", "noshow");
			RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/views/HomepageArtists.jsp");
			dispatcher2.forward(request, response);
		    }
		if (cr.getId()==3){
			//sponsor
			EditCommercialActivity hsc = new EditCommercialActivity();
			hsc.delete();
			//dynamic button hiding
			HttpSession session = request.getSession();
			session.setAttribute("HostingSponsor", "noshow");
			RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/views/Homepagesponsor.jsp");
			dispatcher2.forward(request, response);
		    }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Credentials cr = Credentials.getInstance();
		
	    if (cr.getId()==2){
	    RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/views/HomepageArtists.jsp");
		dispatcher2.forward(request, response);
	    }
	    if (cr.getId()==3){
		    RequestDispatcher dispatcher3 = request.getRequestDispatcher("/WEB-INF/views/Homepagesponsor.jsp");
			dispatcher3.forward(request, response); 
	    }
	    else{
		RequestDispatcher dispatcher1 = request.getRequestDispatcher("/WEB-INF/views/HomepageUsers.jsp");
	    dispatcher1.forward(request, response);
		}
	}
	}

