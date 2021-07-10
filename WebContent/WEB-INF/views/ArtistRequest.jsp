<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
    <%@page import = "logic.appcontroller.RequestsArtistController"  %>
    <%@page import = "logic.bean.RequestedShowBean"  %>
    <%@ page import = "java.util.List" %>
            <%@page import = "logic.utils.SessionArtist"  %>
    
    <%
    RequestsArtistController rac = new RequestsArtistController();	
    List<String> list = rac.buildRequestsStringArray();
    String state = "good";
    RequestedShowBean show = null;
    SessionArtist instanceA = SessionArtist.getInstance();
    String username = instanceA.getUsername();
    try{
    	show = rac.getRequestedShowBean(list.get(0));
       } catch (Exception e){
    	  state = "no requests found";
      	
       }
    
    %>
 
<!DOCTYPE html>
<html  lang="it">

  <head>
    <title>Prova</title>
  </head>
  <body style=" height: 512px; background-color: white;"><img src="https://github.com/Brauzi35/ShowRoome-ISPW2021/blob/main/Immagini/26362.png?raw=true"

 

      alt="" style="width: 93px; height: 73px; margin-left: -2px;"><br>
   
    <h1 style="margin-top: -45.5667px; margin-left: 115px;">  ShowRoome Performer</h1>  

 


 

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
        <p style="margin-top:-74px;margin-left:-555px;"><button name="Profile" style="height: 35px ; width: 95px; margin-top: -46px; margin-left: 570px;background-color: #4D4D4D;">Homepage</button>
        </p>
      </form>
      <form action="HostShowWebController" method="get">
        <p style="margin-top:-74px;margin-left:937px;"><button name="Proposte" style="height: 35px ; width: 95px; margin-top: -48px; margin-left: 210px;background-color: #4D4D4D; color:white;">Proposte</button></p>
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
    

<% if(state.equals("no requests found")){ %>
 <h1 style="margin-top: 110px;">Le tue Proposte:</h1>
	<p style="margin-top: 110px; margin-left: 600px;"><h1>Al momento non ci sono proposte</h1></p>
<% }%>

<!--              qui mettere if   -->
<% if (!state.equals("no requests found") && show.getApprovedArtist().equals("no")){ %>
 <h1 style="margin-top: 110px;">Le tue Proposte:</h1>
 <p style="margin-top: 200px; margin-left: 5px;"> <img alt="" src="https://www.cosafarearoma.it/wp-content/uploads/2014/06/Trinity-College-Irish-Pub-Roma.jpg"

 

        style="width: 235px; height: 155px; margin-left: -4px; margin-top: -357px;">
    </p>
    
   <p     style="margin-top: -190px; margin-left: 600px;"  >
         <form action="ArtistRequestController" method="post">

 <ul>

  <li  style=" list-style-type:none;">
      <h3 style=" margin-top: 100px;margin-left: 500px;">
        <ul>
          <textarea   readonly="readonly" value="nome" id="nome" name="nome" style="resize:none;height: 25px; width: 300px;" type="text"><%= list.get(0) %></textarea>
        </ul>
        
        
        <ul>
          <textarea   readonly="readonly"  id="Cognome" name="Cognome" style="resize:none;height: 80px; width: 300px;" type="text"><%= show.getDescription() %></textarea>
        </ul>
        <ul>
          <textarea  readonly="readonly"   id="password" name="password"  style="resize:none;height: 25px; width: 300px;" type="text"><%= show.getHost() %></textarea>
            
        </ul>
        
           
      </h3>
    </li>
    </ul>
    <input readonly="readonly" id="Submit" name="button" type="submit" value="Accetta"  style="resize:none;height: 35px; width: 95px; margin-top: -600px; margin-left: 1050px;background-color:purple ;"> 
      <input readonly="readonly" id="Submit" name="button" type="submit" value="Rifiuta"  style="resize:none;height: 35px; width: 95px; margin-top: -600px; margin-left: 950px;background-color:purple ;"> 
  
   </p>

<% }%>

 
<% if(!state.equals("no requests found") && show.getApprovedArtist().equals("refused")){ %>
 <h1 style="margin-top: 110px;">Le tue Proposte:</h1>
	<p style="margin-top: 90px; margin-left: 600px;"  ><h1>La richiesta e' stata rifiutata, attendi che l'host la dismetta</h1></p>
<% }%>

<% if(!state.equals("no requests found") && show.getApprovedArtist().equals("yes")){ %>
 <h1 style="margin-top: 110px;">Le tue Proposte:</h1>
	<p style="margin-top: 90px; margin-left: 600px;"  ><h1>La richiesta e' stata accettata, attendi che l'host dia il via allo show</h1></p>
<% }%>
   
  <!--              qui mettere else -->
  
  
  
  
   
   
   </form>
   

 

  </body>
</html>
   