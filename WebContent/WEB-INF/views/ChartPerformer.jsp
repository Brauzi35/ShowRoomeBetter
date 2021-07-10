<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import = "logic.appcontroller.ReviewController"%>
    <%@page import = "logic.bean.ReviewBean"%>
    <%@ page import = "java.util.List" %>
    <%@page import = "logic.utils.SessionUser"  %>
        <%@page import = "logic.utils.SessionArtist"  %>
    
    <%
    ReviewController rc = new ReviewController();
    SessionUser instance = SessionUser.getInstance();
    List<ReviewBean> lrb =rc.getReviews(instance.getUsername());
    String control = "ok";
    SessionArtist instanceA = SessionArtist.getInstance();
    String username = instanceA.getUsername();
    %>
    
<!DOCTYPE html>
<html  lang="it">
  <head>
    <title>Prova</title>
  </head>
  <body style=" height: 512px; background-color: white;"><img src="https://github.com/Brauzi35/ShowRoome-ISPW2021/blob/main/Immagini/26362.png?raw=true"

      alt="" style="width: 93px; height: 73px; margin-left: -2px;"><br>
    <h1 style="margin-top: -45.5667px; margin-left: 115px;"> ShowRoome Performer </h1>
    <h1 style="margin-top: -60px; margin-left: 1000px;"> 
    <h1 style="margin-top:84px;margin-left:3px;">
       <form action="TastoChart" method="post">
        <p style="margin-top:-74px;margin-left:160px;"><button name="Profile" style="height: 35px ; width: 95px; margin-top: -48px; margin-left: 570px;background-color: #4D4D4D; color:white;">Chart</button>
        </p>
      </form>
      <form action="TastoMap" method="post">
        <p style="margin-top:-74px;margin-left:-180px;"><button name="Profile" style="height: 35px ; width: 95px; margin-top: -48px; margin-left: 570px;background-color: #4D4D4D;">Map</button>
        </p>
      </form>
      <form action="Homepage" method="post">
        <p style="margin-top:-74px;margin-left:-555px;"><button name="Profile" style="height: 35px ; width: 95px; margin-top: -46px; margin-left: 570px;background-color: #4D4D4D;">Homepage</button>
        </p>
      </form>
      <form action="HostShowWebController" method="get">
        <p style="margin-top:-74px;margin-left:937px;"><button name="Proposte" style="height: 35px ; width: 95px; margin-top: -48px; margin-left: 210px;background-color: #4D4D4D;">Proposte</button></p>
      </form>
    </h1>
    <h1 style="margin-top: -74px;margin-left:px ;background-color: white;">
      <style>
#rectangle {
    width: 1250px;
    height: 50px;
    background: #10030F;
}
</style> <div id="rectangle"></div>
    </h1>
                  <h1 style="margin-top: -159px; margin-left: 1100px;"> <input value=<%=username %> size="65" maxlength="40" ;style="background-color:" #10030f="" type="submit"> </h1>
         <form action="Logout" method="post">          <h1 style="margin-left: 1190px;margin-top: -57px;" > <input value="logout" size="65" maxlength="40" ;style="background-color:" #10030f="" type="submit"> </h1></form> 
   
    <!-- Primo artista  -->
   
       <p style="margin-top: 300px; margin-left: 5px;"> <img alt="" src="https://www.focusjunior.it/content/uploads/2018/10/Michelangelo-Buonarroti.jpg"

        style="width: 235px; height: 155px; margin-left: -4px; margin-top: -357px;">
    </p>
    <h1 style=" margin-top: -180px;margin-left: 300px;"> <label form="Descrizione artista">Le tue recensioni</label></h1>
    
   <ul> 
   <li style="list-style: none"> <h3 style=" margin-top: px;margin-left: 300px;"><ul>
   
      <% try{
    	  lrb.get(0).getReview();
      } catch(Exception e){
        control="no";
      }
    	  %>
      <%if (control=="ok"){ %>
     <textarea readonly="readonly" style="width : 400px; height: 60px; resize: none;"   form="Descrizione artista"><%= lrb.get(0).getReview() %></textarea ><label  style="margin-top:90px;margin-left:100px;"><%= lrb.get(0).getAuthor() %></label >
     </ul><ul><textarea readonly="readonly"   style="width: 400px; height: 60px; resize: none;"  form="Descrizione artista">-Borioso e arrogante non merita un soldo *</textarea ><label  style="margin-top:90px;margin-left:100px;">Valerietto</label>
     </ul><ul><textarea readonly="readonly"  style="width: 400px; height: 60px; resize: none;"  form="Descrizione artista">-Borioso e arrogante non merita un soldo *</textarea><label style="margin-top:90px;margin-left:100px;">Giorgiette Magritte</label></ul></h3></li>
  <form action="&lt;%= request.getContextPath() %&gt;/register" method="post">   <button  disabled="true" name="Informazioni" style="height: 35px; width: 90px; margin-top: 100px; margin-left: 480px; background-color: #4d4d4d;">Vedi altre</button></form>
  
  <%} %>
      
      </ul>  
    
  
  </body>
</html>

