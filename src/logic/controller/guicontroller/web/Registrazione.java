package logic.controller.guicontroller.web;

 

import java.io.IOException;

 

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import logic.controller.appcontroller.login.Register;
import logic.engclasses.exceptions.DuplicateUsernameException;


 

/**
 * Servlet implementation class Registrazione
 */
@WebServlet("/Registrazione")
public class Registrazione extends HttpServlet {
    private static final long serialVersionUID = 1L;
    String loginjsp="/WEB-INF/views/Login.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registrazione() {
        super();
    }

 

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //inserire metodo registrazione
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String description = request.getParameter("descrizione");
        String param1 = request.getParameter("param1");
        String param2 = request.getParameter("param2");
        String id2 = request.getParameter("ids");
        Register rac = new Register();
       if(id2.equals("User")) {
    	   try {
			rac.userReg(username, password);
		} catch (DuplicateUsernameException e) {
			e.printStackTrace();
		}
    	   RequestDispatcher dispatcher1 = request.getRequestDispatcher(loginjsp);
           dispatcher1.forward(request, response); 
       }
       else if(id2.equals("Performer")) {
    	   rac.artistReg(username, password, param1, description, param2);
    	   RequestDispatcher dispatcher1 = request.getRequestDispatcher(loginjsp);
           dispatcher1.forward(request, response); 
       }
       else if(id2.equals("Sponsor")) {
    	   rac.sponsorReg(username, password, param1, param2, description);
    	   RequestDispatcher dispatcher1 = request.getRequestDispatcher(loginjsp);
           dispatcher1.forward(request, response); 
       }
      //gestire errore 
    }

 

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        HttpSession session = request.getSession();
        session.setAttribute("id_reg", id);
        if(id.equals("User")) {
            RequestDispatcher dispatcher1 = request.getRequestDispatcher("/WEB-INF/views/RegistrazioneUser.jsp");
            dispatcher1.forward(request, response);    
            
        }
        if(id.equals("Performer")) {
            RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/views/RegistrazioneArtista.jsp");
            dispatcher2.forward(request, response);    
            
        }
        else {
            RequestDispatcher dispatcher3 = request.getRequestDispatcher("/WEB-INF/views/RegistrazioneSponsor.jsp");
            dispatcher3.forward(request, response);    
            
        }
    
    }

 

}
