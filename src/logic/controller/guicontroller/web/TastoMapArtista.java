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


import logic.controller.appcontroller.BookAPlaceAndCreateAnEvent;
import logic.engclasses.bean.LoggedBean;
import logic.engclasses.bean.PlaceBean;
import logic.engclasses.exceptions.DescriptionTooLongException;
import logic.engclasses.exceptions.EmptyFieldException;
import logic.engclasses.utils.Session;


@WebServlet("/TastoMapArtista")
public class TastoMapArtista extends HttpServlet {
	private static final long serialVersionUID = 1L;
    int ringbell=0;
    String mapartistjsp = "/WEB-INF/views/MapArtist.jsp";
    String book= "already booked";
    
    public TastoMapArtista() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("text1");
		String desc = request.getParameter("text2");
		String place = request.getParameter("plc");
		String control = request.getParameter("plc6");
		if (control==null) {
		String value = request.getParameter("action");
		BookAPlaceAndCreateAnEvent mc = new BookAPlaceAndCreateAnEvent();
		List<PlaceBean> freePlaces = mc.freePlaces();
		
		HttpSession session = request.getSession();
		
		for(int i=0; i<freePlaces.size(); i++) {
        	if(freePlaces.get(i).getName().equals(value)) {
        		session.setAttribute("Posto", freePlaces.get(i).getName());
        		session.setAttribute("Indirizzo", freePlaces.get(i).getAddress());
        		session.setAttribute("Capienza", freePlaces.get(i).getCapacity());
        		ringbell = 1;
        	}
        }
		
		if(ringbell==0) {
			session.setAttribute("Posto", book);
    		session.setAttribute("Indirizzo", book);
    		session.setAttribute("Capienza", 0);
		}
		ringbell=0;
		RequestDispatcher dispatcherN = request.getRequestDispatcher( mapartistjsp);
    	dispatcherN.forward(request, response);
		}
		
		else {
			BookAPlaceAndCreateAnEvent mc = new BookAPlaceAndCreateAnEvent();
			try {
				HttpSession session2 = request.getSession();
				Session stma2 = (Session)session2.getAttribute("session");
				LoggedBean lbtma2 = stma2.getLoggedBean();
				String uname = lbtma2.getUsername();
				mc.submitEvent(uname ,name, place, desc);
				} catch (DescriptionTooLongException e) {
					
					e.printStackTrace();
				}
				  catch (EmptyFieldException e) {
				e.printStackTrace();
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("Hosting", name);
			RequestDispatcher dispatcherN = request.getRequestDispatcher( mapartistjsp);
	    	dispatcherN.forward(request, response);
	    	
		}
	}
	

}
