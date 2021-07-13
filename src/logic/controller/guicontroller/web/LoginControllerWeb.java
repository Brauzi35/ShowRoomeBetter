package logic.controller.guicontroller.web;

 

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import logic.controller.appcontroller.ViewProfile;
import logic.controller.appcontroller.login.Login;
import logic.engclasses.bean.EventBean;

 

/**
 * Servlet implementation class logincontroller
 */
@WebServlet("/LoginControllerWeb")
public class LoginControllerWeb extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginControllerWeb() {
        super();
    }

 

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher dispatcher4 = request.getRequestDispatcher("/WEB-INF/views/HomepageSenzaLogin.jsp");
        dispatcher4.forward(request, response);
    }

 

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idUsername = request.getParameter("username");
        String idPassword = request.getParameter("password");
        String idTipoartista = request.getParameter("tipoutente");
        int id = Integer.parseInt(idTipoartista);
        Login lc = new Login();
        if (id == 1) {
            try {
    			lc.setupCredentials(id, idUsername, idPassword);
    			RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/views/Map.jsp");
                dispatcher2.forward(request, response);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
           }
        
        if (id == 2) {
        try {
			lc.setupCredentials(id, idUsername, idPassword);
			HttpSession session = request.getSession();
			session.setAttribute("Capienza", 0); //questo serve perch� altrimenti al primo avvio mapArtist va in errore
			ViewProfile hac = new ViewProfile();
			EventBean eb = hac.getLiveEventWeb(idTipoartista); // if the current artist is hosting any show eb won't be null
		    if (eb != null) {
		    	session.setAttribute("Hosting", eb.getName());
		    }
		    else {
		    	session.setAttribute("Hosting", "noshow");
		    }
			RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/views/HomepageArtists.jsp");
            dispatcher2.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
       }
        
        if (id == 3) {
            try {
    			lc.setupCredentials(id, idUsername, idPassword);
    			RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/views/Homepagesponsor.jsp");
                dispatcher2.forward(request, response);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
           }
    }

 

}
 
