package logic.controller.guicontroller.web;

import java.io.IOException;
import javax.servlet.http.HttpSession;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import logic.controller.appcontroller.ReviewAnArtist;
import logic.engclasses.bean.LoggedBean;
import logic.engclasses.exceptions.DuplicateReviewException;
import logic.engclasses.utils.Session;


@WebServlet("/SubmitReview")
public class SubmitReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SubmitReview() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String review = request.getParameter("story");
		HttpSession sessionsr = request.getSession();
		String artist = (String)sessionsr.getAttribute("artist2");
		Session ssr = (Session)sessionsr.getAttribute("session");
		LoggedBean lbsr = ssr.getLoggedBean();
		ReviewAnArtist rc = new ReviewAnArtist();
		try {
			rc.saveReview(lbsr.getUsername() , artist, review);
		} catch (DuplicateReviewException e) {
			e.printStackTrace();
		}
		sessionsr.setAttribute("session", ssr);
		RequestDispatcher dispatcher4 = request.getRequestDispatcher("/WEB-INF/views/Search.jsp");
	    dispatcher4.forward(request, response);
	}

}
