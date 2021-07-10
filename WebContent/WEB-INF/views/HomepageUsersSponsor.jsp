<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
   <%@page import = "logic.appcontroller.HostShowSponsorController"  %>
   <%@page import = "logic.appcontroller.HomepageUserController"  %>
   <%@page import = "logic.bean.ArtistBean"  %>
    <%@ page import = "java.util.List" %>
        <%@page import = "logic.utils.SessionSponsor"  %>
    
   
    <%
    HostShowSponsorController hssc = new HostShowSponsorController();
    List<String> artists = hssc.buildArtistStringArray();
    HomepageUserController huc = new HomepageUserController();
    SessionSponsor ss = SessionSponsor.getInstance();
	String username = ss.getUsername();
    %>
  
<!DOCTYPE html>
<html  lang="it">
  <head>
    <title>Prova</title>
  </head>
  <body style=" height: 512px; background-color: white;"><img src="https://github.com/Brauzi35/ShowRoome-ISPW2021/blob/main/Immagini/26362.png?raw=true"

 

      alt="" style="width: 93px; height: 73px; margin-left: -2px;"><br>
   
    <h1 style="margin-top: -45.5667px; margin-left: 115px;">ShowRoome Sponsor</h1>  
     <h1 style="margin-top:84px;margin-left:3px;">
      <form action="TastoProfile" method="post">
        <p style="margin-top:-74px;margin-left:400px;"><input id="Submit" name="Profile" type="submit" value="Organizza"  style="height: 35px; width: 95px; margin-top: -48px; margin-left: 160px;background-color: #4D4D4D;color:white;"></input></p>
      </form>
      
    
      <form action="Homepage" method="post">
        <p style="margin-top:-74px;margin-left:-555px;"><input id="Submit" type="submit" name="Homepage" value="Homepage" style="height: 35px ; width: 95px; margin-top: -46px; margin-left: 570px; background-color: #4D4D4D;"></input>
        </p>
      </form>
      <form action="HostShowWebController" method="get">
        <p style="margin-top:-74px;margin-left:937px;"><input id="Submit" type="submit" name="Setting" value="Request" style="height: 35px ; width: 95px; margin-top: -48px; margin-left: 210px;background-color: #4D4D4D;"></input></p>
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
   
    <p style="margin-top: 350px; margin-left: 5px;"> <img alt="" src="https://github.com/Brauzi35/ShowRoome-ISPW2021/blob/main/Immagini/chitarra%20duomo%20artisti%20strada-2.jpg?raw=true"

 

        h1="" style="width: 235px; height: 155px; margin-left: -4px; margin-top: -357px;">
    </p>
    <form action="ContattaArtista" method="post"  style=" margin-top: -50px;">
    <h2 style=" margin-top: -180px;margin-left: 300px;"> <label ><%= artists.get(0) %></input></h2>
    <h3 style=" margin-top: px;margin-left: 300px;"> <textarea id="story" name="story" style=" resize: none ;"rows="5" cols="80" readonly disabled="disabled">
<%=huc.getArtist(artists.get(0)).getDescription() %></textarea></h3>
<input id="name" name="name" value="<%= artists.get(0) %>"; style="display:none;"></input>
  <button name="Dona" style="height: 35px; width: 90px; margin-left: 1030px; background-color: #4d4d4d;">Contatta</button> </form>
     

 

    <hr style="align:left;size:1 ;width:1200px ;color:black; noshade;"></hr>

 

 

    
   
  
  
  
       <p style="margin-top: 300px; margin-left: 5px;"> <img alt="" src="https://github.com/Brauzi35/ShowRoome-ISPW2021/blob/main/Immagini/unnamed.jpg?raw=true"

 

         style="width: 235px; height: 155px; margin-left: -4px; margin-top: -357px;">
    </p>
     <form action="ContattaArtista" method="post"  style=" margin-top: -50px;">
    <h2 style=" margin-top: -180px;margin-left: 300px;"> <label ><%= artists.get(1) %></input></h2>
    <h3 style=" margin-top: px;margin-left: 300px;"> <textarea id="story" name="story" style=" resize: none ;"rows="5" cols="80" readonly disabled="disabled">
<%=huc.getArtist(artists.get(1)).getDescription() %></textarea></h3>
<input id="name" name="name" value="<%= artists.get(1) %>"; style="display:none;"></input>
  <button name="Dona" style="height: 35px; width: 90px; margin-left: 1030px; background-color: #4d4d4d;">Contatta</button> </form>
 
 

    <hr style="align:left;size:1 ;width:1200px ;color:black; noshade;"></hr>
  
  
  
  
  
  
  
    <p style="margin-top: 300px; margin-left: 5px;"> <img alt=""  src="https://github.com/Brauzi35/ShowRoome-ISPW2021/blob/main/Immagini/124232574-1befbb5d-1e7d-4a4d-bb09-411ee9b05c27.jpg?raw=true"

 

        h1="" style="width: 235px; height: 155px; margin-left: -4px; margin-top: -357px;">
    </p>
     <form action="ContattaArtista" method="post"  style=" margin-top: -50px;">
    <h2 style=" margin-top: -180px;margin-left: 300px;"> <label ><%= artists.get(2) %></input></h2>
    <h3 style=" margin-top: px;margin-left: 300px;"> <textarea id="story" name="story" style=" resize: none ;"rows="5" cols="80" readonly disabled="disabled">
<%=huc.getArtist(artists.get(2)).getDescription() %></textarea></h3>
<input id="name" name="name" value="<%= artists.get(2) %>"; style="display:none;"></input>
  <button name="Dona" style="height: 35px; width: 90px; margin-left: 1030px; background-color: #4d4d4d;">Contatta</button> </form>
 

 

    <hr style="align:left;size:1 ;width:1200px ;color:black; noshade;"></hr>
  
   <form action="&lt;%= request.getContextPath() %&gt;/register" method="post">
        <p style="margin-top:65px;margin-left:410px;"><button  disabled="true" name="Chart" style="height: 35px; width: 95px; margin-top: -48px; margin-left: 160px;background-color: #4D4D4D;">Vedi altri</button></p>
      </form>
  </body>
</html>
