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
import logic.engclasses.exceptions.DuplicateReviewException;


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
		HttpSession session = request.getSession();
		String artist = (String)session.getAttribute("artist2");
		ReviewAnArtist rc = new ReviewAnArtist();
		try {
			rc.saveReview(artist, review, artist);
		} catch (DuplicateReviewException e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher4 = request.getRequestDispatcher("/WEB-INF/views/Search.jsp");
	    dispatcher4.forward(request, response);
	}

}
