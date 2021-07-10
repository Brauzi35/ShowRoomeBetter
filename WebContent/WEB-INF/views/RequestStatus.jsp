<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
    <%@page import = "logic.appcontroller.RSSApplicationController"  %>
    <%@page import = "logic.bean.RequestedShowBean"  %>
        <%@page import = "logic.utils.SessionSponsor"  %>
    
    <%
    RSSApplicationController rac = new RSSApplicationController();
    SessionSponsor ss = SessionSponsor.getInstance();
	String username = ss.getUsername();
    RequestedShowBean rsb = null;
    String control = "ok"; 
    String state = "idle";
    try{
    	rsb = rac.getPendingRequest();
    	rsb.getApprovedArtist();
    } catch(Exception e){
    	control = "no";
    }
    if(control.equals("ok")){
    state = rsb.getApprovedArtist();
    }
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
        <p style="margin-top:-74px;margin-left:-555px;"><input id="Submit" type="submit" name="Homepage" value="Homepage" style="height: 35px ; width: 95px; margin-top: -46px; margin-left: 570px; background-color: #4D4D4D;"></input>
        </p>
      </form>
      <form action="HostShowWebController" method="get">
        <p style="margin-top:-74px;margin-left:937px;"><input id="Submit" type="submit" name="Setting" value="Request" style="height: 35px ; width: 95px; margin-top: -48px; margin-left: 210px;background-color: #4D4D4D;color:white;"></input></p>
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
    
    <% if(control.equals("ok") ){ %>
    <h1 style="margin-top: 120px;" >Le tue richieste:</h1>
     <p style="margin-top: 210px; margin-left: 5px;"> <img alt="" src="https://www.focusjunior.it/content/uploads/2018/10/Michelangelo-Buonarroti.jpg"

 

         style="width: 235px; height: 155px; margin-left: -4px; margin-top: -357px;">
    </p>
    
   <p     style="margin-top: -190px; margin-left: 600px;"  >
       
<ul>
 

  <li  style=" list-style-type:none;">
      <h3 style=" margin-top: px;margin-left: 500px;">
        <ul>
          <textarea   readonly="readonly" value="Mimo al bar" id="Nome" name="Nome" style="resize:none;height: 25px; width: 300px;"

 

            type="text"><%= rsb.getTitle() %></textarea>
        </ul>
        <ul>
          <textarea   readonly="readonly" value="" id="Cognome" name="Cognome"

 

            style="resize:none;height: 80px; width: 300px;" type="text"><%= rsb.getDescription() %></textarea>
        </ul>
        <ul>
          <textarea  readonly="readonly"  value="" id="password" name="password"

 

            style="resize:none;height: 25px; width: 300px;" type="text"><%= rsb.getArtist() %></textarea>
            
        </ul>
        
           
      </h3>
    </li>
    </ul>
    <% if(state.equals("yes")){ %>
    <textarea  readonly="readonly" id="Submit" name="Profile" type="submit" value="Invia richiesta"  style="resize:none;height: 35px; width: 95px; margin-top: -600px; margin-left: 1050px;background-color:purple ;"> Richiesta accettata</textarea>
    <form action="RequestStatusController" method="get">
    <input  id="artist" name="artist" type="text" value=<%= rsb.getArtist() %>  style="display:none; resize:none;height: 35px; width: 102px; margin-top: -580px; margin-left: 1050px;background-color:pink ;"></input>
    <input  id="desc" name="desc" type="text" value=<%= rsb.getDescription() %>  style="display:none; resize:none;height: 35px; width: 102px; margin-top: -580px; margin-left: 1050px;background-color:pink ;"></input>
    <input  id="name" name="name" type="text" value=<%= rsb.getTitle() %>  style="display:none; resize:none;height: 35px; width: 102px; margin-top: -580px; margin-left: 1050px;background-color:pink ;"></input>
    
   	<input  id="Submit" name="Profile" type="submit" value="Inizia!"  style="resize:none;height: 35px; width: 102px; margin-top: -580px; margin-left: 1050px;background-color:pink ;"></input>
   	</form>
   <% }%>
   <% if(state.equals("no")){ %>
    <textarea  readonly="readonly" id="Submit" name="Profile" type="submit" value="Invia richiesta"  style="resize:none;height: 35px; width: 95px; margin-top: -600px; margin-left: 1050px;background-color:purple ;"> Richiesta inviata</textarea>
   <% }%>
   <% if(state.equals("refused")){ %>
    <textarea  readonly="readonly" id="Submit" name="Profile" type="submit" value="Invia richiesta"  style="resize:none;height: 35px; width: 95px; margin-top: -600px; margin-left: 1050px;background-color:purple ;"> Richiesta rifiutata</textarea>
   	<form action="RequestStatusController" method="post">
   	<input  id="Submit" name="Profile" type="submit" value="Cancella"  style="resize:none;height: 35px; width: 102px; margin-top: -580px; margin-left: 1050px;background-color:pink ;"></input>
   	</form>
   <% }%>
   </p>
   <% }%>
   
   <% if(control.equals("no")){ %>
   <h1 style="margin-top: 120px;">Le tue richieste:</h1>
     <p style="margin-top: 70px; margin-left: 600px;"  ><h1>Al momento non ci sono richieste effettuate</h1></p>
    
	   
   
   <% }%>
   
   
  </body>
</html>
   
   