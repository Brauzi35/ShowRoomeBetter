package logic.controller.guicontroller.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic.controller.appcontroller.FindLiveEvent;
import logic.engclasses.bean.EventBean;
import logic.engclasses.bean.LoggedBean;
import logic.engclasses.utils.Session;


/**
 * Servlet implementation class Map
 */
@WebServlet("/TastoMap")
public class TastoMap extends HttpServlet {
	private static final long serialVersionUID = 1L;
    String tipoutente;
    static String se = "session";
	String message ="there is no show here";
	static String mapartistjsp = "/WEB-INF/views/MapArtist.jsp";
	int ringbell = 0;
	
    public TastoMap() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String result =request.getParameter("action");
        
        FindLiveEvent mc = new FindLiveEvent();
        List<EventBean> leb = mc.liveEventsList();
        
        HttpSession session = request.getSession();
        Session stm = (Session) session.getAttribute(se);
        LoggedBean lbtm = stm.getLoggedBean();
        //ringbell is the variable that serves to understand if the targetted show is live
        
        for(int i=0; i<leb.size(); i++) {
        	if(leb.get(i).getPlace().equals(result)) {
        		session.setAttribute("mapPlace", leb.get(i).getPlace());
        		session.setAttribute("mapArtist", leb.get(i).getArtist());
        		session.setAttribute("mapDescription", leb.get(i).getDescription());
        		ringbell = 1;
        	}
        }
        
        if(ringbell==0) {
        	session.setAttribute("mapPlace", message);
    		session.setAttribute("mapArtist", message);
    		session.setAttribute("mapDescription",message);
        }
        session.setAttribute(se, stm);
        ringbell=0;
        if(lbtm.getId()==2) {
        	RequestDispatcher dispatcherN = request.getRequestDispatcher(mapartistjsp);
        	dispatcherN.forward(request, response);
        }
        if(lbtm.getId()==3) {
        	RequestDispatcher dispatcherM = request.getRequestDispatcher(mapartistjsp);
        	dispatcherM.forward(request, response);
        }
        else {
        	RequestDispatcher dispatcherJ = request.getRequestDispatcher("/WEB-INF/views/Map.jsp");
        	dispatcherJ.forward(request, response);
        }
        
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session1 = request.getSession();
	        Session stm1 = (Session) session1.getAttribute(se);
	        LoggedBean lbtm1 = stm1.getLoggedBean();
		
	    if (lbtm1.getId()==2){
	    RequestDispatcher dispatcher2 = request.getRequestDispatcher(mapartistjsp);
		dispatcher2.forward(request, response);
	    }
	    if (lbtm1.getId()==3){
		    RequestDispatcher dispatcher3 = request.getRequestDispatcher("/WEB-INF/views/Homepagesponsor.jsp");
			dispatcher3.forward(request, response); 
	    }
	    else{
		RequestDispatcher dispatcher1 = request.getRequestDispatcher("/WEB-INF/views/Map.jsp");
	    dispatcher1.forward(request, response);
		}
		
		
		
	   
	}
	}

