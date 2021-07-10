<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import = "logic.appcontroller.SessionArtistController"  %>
<%@page import = "logic.utils.SessionArtist"  %>
<%@page import = "logic.appcontroller.HomepageArtistController"  %>
<%@page import = "logic.bean.EventBean" %>


<% 
    HomepageArtistController hac = new HomepageArtistController();
    
	SessionArtistController sac = new SessionArtistController();
	sac.sessionArtistSetup();
	SessionArtist instanceA = SessionArtist.getInstance();
    String username = instanceA.getUsername();
    EventBean eventname = hac.getLiveEventWeb();

 %>


<!DOCTYPE html>
<html  lang="it">
  <head>
    <title>ShoowRome</title>
  </head>
  <body style="    height: 512px; background-color: white;"><img src="https://github.com/Brauzi35/ShowRoome-ISPW2021/blob/main/Immagini/26362.png?raw=true"

 

      alt="" style="width: 93px; height: 73px; margin-left: -2px;"><br>
    <h1 style="margin-top: -45.5667px; margin-left: 115px;"> ShowRoome Performer </h1>
    
    <h1 style="margin-top:-58px; margin-left: 1150px;">
      
    </h1>
    <h1 style="margin-top:84px;margin-left:3px;">
       <form action="TastoChart" method="post">
        <p style="margin-top:-74px;margin-left:160px;"><button name="Profile" style="height: 35px ; width: 95px; margin-top: -48px; margin-left: 570px;background-color: #4D4D4D;">Chart</button>
        </p>
      </form>
      <form action="TastoMap" method="post">
        <p style="margin-top:-74px;margin-left:-180px;"><button name="Profile" style="height: 35px ; width: 95px; margin-top: -48px; margin-left: 570px;background-color: #4D4D4D;">Map</button>
        </p>
      </form>
      <form action="Homepage" method="post">
        <p style="margin-top:-74px;margin-left:-555px;"><button name="Profile" style="height: 35px ; width: 95px; margin-top: -46px; margin-left: 570px;background-color: #4D4D4D;color:white;">Homepage</button>
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
      <form action="Logout" method="post" >          <h1 style="margin-left: 1190px;margin-top: -57px;" > <input value="logout" size="65" maxlength="40" ;style="background-color:" #10030f="" type="submit"> </h1></form> 
    
    <h1 style="margin-top: -20px; margin-left: 1170px;">
     
    </h1>
    <!-- Primo artista  -->
    <p style="margin-top: 300px; margin-left: 5px;"> <img  alt="" src="https://github.com/Brauzi35/ShowRoome-ISPW2021/blob/main/Immagini/funny-male-mime-artist-with-makeup-gloves-hat_266732-7744.jpg?raw=true"

 

        style="width: 235px; height: 155px; margin-left: -4px; margin-top: -357px;">
    </p>
    <h2 style=" margin-top: -180px;margin-left: 300px;"> <label form="Descrizione artista"></label></h2>
    <ul>
    <li style="list-style: none">
      <h3 style=" margin-top: 120px;margin-left: 400px;">
        <ul>
                             <button name="Dona" style="height: 35px; width: 90px; margin-top: -200px; margin-left:75px; background-color: #4d4d4d;"id="modifica" onClick="modifica()">Modifica</button>
      
        <form action="UpdateInfo" method="post" style="margin-top: 10px;">
          <input disabled="true"value=<%= instanceA.getUsername() %> id="Nome" name="Nome" style="height: 25px; width: 225px;"

 

            type="text">
        </ul>
        <ul>
          <input disabled="true" value=<%= instanceA.getTalent() %> id="talent1" name="talent1"

 

            style="height: 25px; width: 225px;" type="text">
        </ul>
        <ul>
          <input disabled="true" value=<%= instanceA.getEmail() %> id="email1" name="email1"

 

            style="height: 25px; width: 225px;" type="text"></input>
            
        </ul>
         <input disabled="true" value=<%= instanceA.getDescription() %> id="descrizione1" name="descrizione1"

 

            style="height: 25px; width: 225px;margin-left:40px;" type="text"></input>
           
      </h3>
    </li>
    </ul>
    
    
    
              <input  type="submit" disabled="true"  value ="Salva"  name="Salva" id="Salva" style="height: 35px; width: 90px; margin-top: 30px; margin-left:550px; background-color: #4d4d4d;"id="salva" ></button>
            
              <input  value=<%= instanceA.getEmail() %> id="email" name="email"

            style="height: 25px; width: 225px;margin-left:40px;display:none;" type="text"></input>
              <input  value=<%= instanceA.getTalent()%> id="talent" name="talent"

            style="height: 25px; width: 225px;margin-left:40px;display:none;" type="text"></input>
              <input  value=<%= instanceA.getDescription() %> id="descrizione" name="descrizione"

            style="height: 25px; width: 225px;margin-left:40px;display:none;" type="text"></input>
            
            
            </form>
            
             
              <button  disabled="true"  name="Dona" style="height: 35px; width: 90px; margin-top: 30px; margin-left:550px; background-color: #4d4d4d;"id="annulla" onClick="annulla()">Annulla</button>
    
  
    <h2 style="margin-left:950px;margin-top: -380px;">Le tue prenotazioni:</h2>
      
    
    <%if ((String)session.getAttribute("Hosting") != "noshow"){ %>
    <form action="Homepage" method="get">
      <h3 style="margin-left:960px;margin-top: 0px;"><%=eventname.getName() %></h3>
    <button name="Informazioni" style="height: 45px; width: 110px; margin-left: 1100px; background-color: #4d4d4d;margin-top: -80px;">Dismiss</button>
    </form>
    <% }%>	
 


<script> 
   
   function  modifica(){
	     
	

	     document.getElementById("descrizione1").disabled =false;
	     document.getElementById("email1").disabled =false;
	     document.getElementById("talent1").disabled =false;
	     document.getElementById("annulla").disabled =false;
	     document.getElementById("Salva").disabled =false;



   }
		 </script>
		
<script> 
   
   function  annulla(){
	location.reload();



   }
		 </script>



 </body>
</html>















 

 
 