
    
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
    <%@page import = " logic.bean.SponsoredShowBean" %>
    <%@page import = " logic.appcontroller.SSUserController" %>
    <%@ page import = "java.util.List" %>
     <%@ page import = "java.util.ArrayList" %>
         <%@page import = " logic.utils.SessionUser" %>
     
<%
SSUserController ssuc = new SSUserController();
SessionUser su = SessionUser.getInstance();
String username = su.getUsername();
List<String> titles = ssuc.buildShowStringArray();
String empty = "no";
try{
	titles.get(0);
} catch(Exception e){
	empty = "yes";
}


List<SponsoredShowBean> lssb = new ArrayList<>();
if(empty != "yes"){
for (int i=0; i<titles.size(); i++){
	SponsoredShowBean ssb = ssuc.getSponsoredShow(titles.get(i));
	lssb.add(ssb);

 }
}
%>
    
<!DOCTYPE html>
<html  lang="it">


  <head>
   




 
 
    <title>Prova</title>
  </head>
  <body style=" height: 512px; background-color: white;"><img src="https://github.com/Brauzi35/ShowRoome-ISPW2021/blob/main/Immagini/26362.png?raw=true"


      alt="" style="width: 93px; height: 73px; margin-left: -2px;"><br>
   
    <h1 style="margin-top: -45.5667px; margin-left: 115px;">  ShowRoome</h1>  
    


       </h1>
     <h1 style="margin-top:84px;margin-left:3px;">
     
      <form action="TastoChart" method="post">
        <p style="margin-top:-74px;margin-left:170px;"><input id="Submit" name="Chart" type="submit" value="Chart" " style="height: 35px ; width: 95px; margin-top: -48px; margin-left: 570px;background-color: #4D4D4D;"></input>
        </p>
      </form>
      <form action="TastoMap" method="post">
        <p style="margin-top:-74px;margin-left:-170px;"><input id="Submit" name="Map" type="submit" value="Map"  style="height: 35px ; width: 95px; margin-top: -48px; margin-left: 570px;background-color: #4D4D4D;"></input>
        </p>
      </form>
      <form action="Homepage" method="post">
        <p style="margin-top:-74px;margin-left:-555px;"><input id="Submit" type="submit" name="Homepage" value="Homepage" style="height: 35px ; width: 95px; margin-top: -46px; margin-left: 570px; background-color: #4D4D4D;"></input>
        </p>
      </form>
      <form action="HostShowWebController" method="get">
        <p style="margin-top:-74px;margin-left:937px;"><input id="Submit" type="submit" name="Setting" value="Sponsored" style="height: 35px ; width: 95px; margin-top: -48px; margin-left: 210px;color: white; background-color: #4D4D4D;"></input></p>
      </form>
    </h1>
    <h1 style="margin-top: -74px;margin-left:px ;background-color: white;">
      <style>
#rectangle {​​​​​​​
    width: 1250px;
    height: 50px;
    background: #10030F;
}​​​​​​​
</style> <div id="rectangle"></div>
    </h1>
                      <h1 style="margin-top: -159px; margin-left: 1100px;"> <input value=<%=username %> size="65" maxlength="40" ;style="background-color:" #10030f="" type="submit"> </h1>
             <form action="Logout" method="post">          <h1 style="margin-left: 1190px;margin-top: -57px;" > <input value="logout" size="65" maxlength="40" ;style="background-color:" #10030f="" type="submit"> </h1></form> 
    
<%   
String ok1 = "ok";
try{
	titles.get(0);
} catch(Exception e){
	ok1 = "no";
} %>
   
    <!-- Primo artista  -->
    
   <% if(ok1=="ok"){ %>
    <p style="margin-top: 300px; margin-left: 5px;"> <img alt="" src="https://github.com/Brauzi35/ShowRoome-ISPW2021/blob/main/Immagini/churchill_arms.jpg?raw=true*/36"


        h1="" style="width: 235px; height: 155px; margin-left: -4px; margin-top: -357px;">
    </p>
    <h2 style=" margin-top: -180px;margin-left: 300px;"> <label><%= lssb.get(0).getTitle() %></label></h2>
    <h3 style=" margin-top: px;margin-left: 300px;"> <textarea id="story" name="story" style=" resize: none ;"rows="5" cols="80" readonly disabled="disabled"><%= lssb.get(0).getDescription() %></textarea></h3>

 <label style=" margin-top: px;margin-left: 300px;"><%= lssb.get(0).getArtist() %></label>
     <label  style=" margin-top: px;margin-left: 50px;"><%= lssb.get(0).getLocation() %></label>


    <hr style="align:left;size:1 ;width:1200px ;color:black; noshade;"></hr>




    <% } %>
 <!--   <form action="&lt;%= request.getContextPath() %&gt;/register" method="post">  <button name="Dona" style="height: 35px; width: 90px; margin-top: -90px; margin-left: 1030px; background-color: #4d4d4d;">Dona</button> </form>  --> 
  
  <%   
String ok2 = "ok";
try{
	titles.get(1);
} catch(Exception e){
	ok2 = "no";
} %>
  
  <% if(ok2=="ok"){%>
       <p style="margin-top: 300px; margin-left: 5px;"> <img src="https://www.focusjunior.it/content/uploads/2018/10/Michelangelo-Buonarroti.jpg"


         h1="" style="width: 235px; height: 155px; margin-left: -4px; margin-top: -357px;">
    </p>
    <h2 style=" margin-top: -180px;margin-left: 300px;"> <label form="Descrizione artista">ciao</label></h2>
    <h3 style=" margin-top: px;margin-left: 300px;"> <textarea id="story" name="story" style=" resize: none ;"rows="5" cols="80" readonly disabled="disabled">
Artista molto affermato nella puglia Borbonica gestiva uno spaccio di minori e prostituzione nei bordelli di tutta la cittÃ  noto anche con il nome di Scintilla O mast munnezz.
</textarea></h3>

 <label form="Strada artista" style=" margin-top: px;margin-left: 300px;"></label>
     <label form="Tipo di artista" style=" margin-top: px;margin-left: 50px;"></label>
         <label form="Tipo di artista" style=" margin-top: px;margin-left: 50px;"></label>


    <hr style="align:left;size:1 ;width:1200px ;color:black; noshade;"></hr>
  
  
  <% } %>
  
  
 <%  
 String ok3 = "ok";
 try{
	titles.get(2);
} catch(Exception e){
	ok3 = "no";
} %>
  
  <% if(ok3=="ok"){%> 
    <p style="margin-top: 300px; margin-left: 5px;"> <img alt="" src="https://www.focusjunior.it/content/uploads/2018/10/Michelangelo-Buonarroti.jpg"


         h1="" style="width: 235px; height: 155px; margin-left: -4px; margin-top: -357px;">
    </p>
    <h2 style=" margin-top: -180px;margin-left: 300px;"> <label form="Descrizione artista"></label></h2>
    <h3 style=" margin-top: px;margin-left: 300px;"> <textarea id="story" name="story" style=" resize: none ;"rows="5" cols="80" readonly disabled="disabled">
Artista molto affermato nella puglia Borbonica gestiva uno spaccio di minori e prostituzione nei bordelli di tutta la cittÃ  noto anche con il nome di Scintilla O mast munnezz.
</textarea></h3>

 <label form="Strada artista" style=" margin-top: px;margin-left: 300px;"></label>
     <label form="Tipo di artista" style=" margin-top: px;margin-left: 50px;"></label>
         <label form="Tipo di artista" style=" margin-top: px;margin-left: 50px;"></label>


    <hr style="align:left;size:1 ;width:1200px ;color:black; noshade;"></hr>
  <% } %>
   <form action="&lt;%= request.getContextPath() %&gt;/register" method="post">
        <p style="margin-top:65px;margin-left:410px;"><button  disabled="true" name="Chart" style="height: 35px; width: 95px; margin-top: -48px; margin-left: 160px;background-color: #4D4D4D;">Vedi altri</button></p>
      </form>
    <h3 style="margin-top: -1225px; margin-left: 1000px;"></h3>
  



 
  
  </body>
</html>
 











