<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
            <%@page import = "logic.utils.SessionSponsor"  %>
    
    <%
    String artist = (String)session.getAttribute("artistNameSponsor");
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
   
    <h1 style="margin-top: -45.5667px; margin-left: 115px;">  ShowRoome Sponsor</h1>  
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
    <h1 style="margin-top: 140px;">Stai contattando <%= artist %></h1>
     <p style="margin-top: 210px; margin-left: 5px;"> <img alt="" src="https://github.com/Brauzi35/ShowRoome-ISPW2021/blob/main/Immagini/1019.jpg?raw=true"   h1="" style="width: 235px; height: 155px; margin-left: -4px; margin-top: -357px;">
    </p>
     <form action="TastoProfile" method="post">
        <p style="margin-top:-30px;margin-left:900px;"><input id="Submit" name="Profile" type="submit" value="Indietro"  style="height: 35px; width: 95px; margin-top: -48px; margin-left: 160px;background-color: #4D4D4D;"></input></p>
      </form>
    
   <p     style="margin-top: -140px; margin-left: 600px;"  >
         <form action="HostShowWebController" method="post">

 <h3 style="margin-top: -180px; margin-left: 580px;">  Compila richiesta:  </h3>
<ul>
  <li  style=" list-style-type:none;">
      <h3 style=" margin-top: px;margin-left: 500px;">
        <ul>
          <textarea  value="titolo" id="titolo" name="titolo" style="height: 25px; width: 300px; resize: none;">titolo</textarea>
        </ul>
        <ul>
          <textarea  value="descrizione" id="descrizione" name="descrizione" style="height: 80px; width: 300px; resize: none;" >descrizione</textarea>
        </ul>
        <ul>
          <input value="<%= artist %>" id="artista" name="artista" style="display:none; height: 25px; width: 300px;" type="text">
            
        </ul>
        
           
      </h3>
    </li>
   </ul>
    <input id="Submit" name="Profile" type="submit" value="Invia richiesta"  style="height: 35px; width: 95px; margin-top: 80px; margin-left: 650px;background-color: #4D4D4D;"></input>
   
   </p>
   
   
   
   </form>
   
   
   
   
   
   
  </body>
</html>
   
   