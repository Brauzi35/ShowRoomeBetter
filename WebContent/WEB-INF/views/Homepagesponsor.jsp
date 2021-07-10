<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
    <%@page import = "logic.utils.SessionSponsor"  %>
    <%@page import = "logic.appcontroller.SessionSponsorController"  %>
 <%
 SessionSponsorController ssc = new SessionSponsorController();
	ssc.sessionSponsorSetup();
	SessionSponsor ss = SessionSponsor.getInstance();
	String username = ss.getUsername();
	String activity = ss.getActivity();
	String capacity = ss.getCapacity();
	String description = ss.getDescription();
 
 %>
<!DOCTYPE html>
<html  lang="it">
  <head>
    <title>Prova</title>
  </head>
  <body style=" height: 512px; background-color: white;"><img src="https://github.com/Brauzi35/ShowRoome-ISPW2021/blob/main/Immagini/26362.png?raw=true"

 

      alt="" style="width: 93px; height: 73px; margin-left: -2px;"><br>
   
    <h1 style="margin-top: -45.5667px; margin-left: 115px;">  ShowRoome Sponsor</h1>  

 


 

    <h1 style="margin-top:84px;margin-left:3px;">
      <form action="TastoProfile" method="post">
        <p style="margin-top:-74px;margin-left:400px;"><input id="Submit" name="Profile" type="submit" value="Organizza"  style="height: 35px; width: 95px; margin-top: -48px; margin-left: 160px;background-color: #4D4D4D;"></input></p>
      </form>
      
    
      <form action="Homepage" method="post">
        <p style="margin-top:-74px;margin-left:-555px;"><input id="Submit" type="submit" name="Homepage" value="Homepage" style="height: 35px ; width: 95px; margin-top: -46px; margin-left: 570px;color:white; background-color: #4D4D4D;"></input>
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
    <p style="margin-top: 110px; margin-left: 5px;"><h2><%= username %></h2></p> 
   
    <p style="margin-top: 200px; margin-left: 5px;"> <img alt="" src="https://github.com/Brauzi35/ShowRoome-ISPW2021/blob/main/Immagini/paddy-s-irish-pub.jpg?raw=true"

 

         style="width: 235px; height: 155px; margin-left: -4px; margin-top: -357px;">
    </p>
    <h2 style=" margin-top: -180px;margin-left: 300px;"> <label form="Descrizione artista"><%= activity %></label></h2>
    <h3 style=" margin-top: px;margin-left: 300px;"> </h3>
    <%if ((String)session.getAttribute("HostingSponsor") != "noshow"){ %>
        <form action="Homepage" method="get">  <button name="Dona" style="height: 45px; width: 105px; margin-top: -50px; margin-left: 1030px; background-color: #4d4d4d;">Dismiss show</button> </form>
    
    <% }%>
 <label  style=" margin-top: px;margin-left: 300px;"></label>
     <label  style=" margin-top: px;margin-left: 50px;"></label>
         <label  style=" margin-top: px;margin-left: 50px;"></label>
          <h3 style=" margin-top: -20px;margin-left: 300px;"> <textarea id="story" name="story" style=" resize: none ;"rows="5" cols="80" readonly disabled="disabled"><%= description %></textarea></h3>
<label style=" margin-top: px;margin-left: 300px;">capacita':   <%= capacity %></label>
 

    
	
 

 

    
   
  
  
  </body>
</html>
