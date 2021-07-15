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
import logic.engclasses.utils.Session;

  

/**
 * Servlet implementation class TastoChart
 */
@WebServlet("/TastoChart")
public class TastoChart extends HttpServlet {
	private static final long serialVersionUID = 1L;
    String tipoutente;
    String artist;

    public TastoChart() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		artist = request.getParameter("artist");
		HttpSession session = request.getSession();
		Session stc = (Session) session.getAttribute("session");
		session.setAttribute("artist2", artist);
		session.setAttribute("session", stc);
		RequestDispatcher dispatcher4 = request.getRequestDispatcher("/WEB-INF/views/Chart.jsp");
	    dispatcher4.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session2 = request.getSession();
		Session stc2 = (Session) session2.getAttribute("session");
		LoggedBean lbtc2 = stc2.getLoggedBean();

		session2.setAttribute("session", stc2);
		
	    if (lbtc2.getId()==2){
	    RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/views/ChartPerformer.jsp");
		dispatcher2.forward(request, response);
	    }
	    if (lbtc2.getId()==3){
		    RequestDispatcher dispatcher3 = request.getRequestDispatcher("/WEB-INF/views/Homepagesponsor.jsp");
			dispatcher3.forward(request, response); 
	    }
	    else{
		RequestDispatcher dispatcher1 = request.getRequestDispatcher("/WEB-INF/views/Search.jsp");
	    dispatcher1.forward(request, response);
		}
		
	}
	}

