<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
    <%@page import = " java.util.*"%>  
    <%@page import = " logic.bean.EventBean" %>
    <%@page import = " logic.bean.ArtistBean" %>
    <%@ page import = "java.util.List" %>
        <%@page import = " logic.appcontroller.HomepageUserController" %>
    <%	HomepageUserController huc = new HomepageUserController(); %>
<%		List<EventBean> events = huc.liveEventsList();
    String artist1 = "";
    String artist2 = "";
    String artist3= "";
    String control="";
    String name = "";
    String description = "";
    String place= "";
    String talent="";
    int size = events.size();
%>
<!DOCTYPE html>
<html  lang="it">

  <head>
   <script src="https://www.paypal.com/sdk/js?currency=EUR&client-id=ASMN00dOM4cH1cFqKX7v1J9auNbG9yaEt2g31rZ4ID8RE8RWmNxdFrT3UEaXWUgS1x510P4QH2SJj7eX"> </script>
      <div style="background-color: green; display: none" id="transition">Grazie per il tuo pagamento!</div>

    <title>Prova</title>
  </head>
  <body style=" height: 512px; background-color: white;"><img src="https://github.com/Brauzi35/ShowRoome-ISPW2021/blob/main/Immagini/26362.png?raw=true"

      alt="" style="width: 93px; height: 73px; margin-left: -2px;"><br>
   
    <h1 style="margin-top: -45.5667px; margin-left: 115px;">ShowRoome</h1>  
                                    
    <h1 style="margin-top:84px;margin-left:3px;">
     
     
     
        <p style="margin-top:-74px;margin-left:-555px;"><input id="Submit" type="submit" name="Homepage" value="Homepage" style="height: 35px ; width: 95px; margin-top: -46px; margin-left: 570px;color:white; background-color: #4D4D4D;"></input>
        </p>
     
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
         <form action="Logout" method="post">          <h1 style="margin-left: 1190px;margin-top: -140px;" > <input value="Login" size="65" maxlength="40" ;style="background-color:" #10030f="" type="submit"> </h1></form> 

  <%     try{
	artist1 = events.get(0).getArtist();
     } catch (Exception e){
    	 artist1 = "no artist found";
     }
    %> 
    <%if(artist1.equals("no artist found")){ %>
    
    <% }%>
        <%if(!artist1.equals("no artist found")){ %>
    <!-- Primo artista  -->
<%     try{
	artist1 = events.get(0).getArtist();
     } catch (Exception e){
    	 artist1 = "no review found";
     }
    %> 
    <p style="margin-top: 300px; margin-left: 5px;"> <img alt="" src="https://www.focusjunior.it/content/uploads/2018/10/Michelangelo-Buonarroti.jpg"

      style="width: 235px; height: 155px; margin-left: -4px; margin-top: -357px;">
    
    </p>
 
    <h2 style=" margin-top: -180px;margin-left: 300px;"> <label form="Descrizione artista">    <%=events.get(0).getArtist() %>
    </label></h2>
    <h3 style=" margin-top: px;margin-left: 300px;"> <textarea id="story" name="story" style=" resize: none ;"rows="5" cols="80" readonly disabled="disabled">
<%=events.get(0).getDescription() %>
</textarea></h3>

      <input type="text" id="payInput0"  style="height: 35px; width: 90px; margin-top: -90px; margin-left: 1030px; "  /><button id="Dona0" onClick="generatePayment0(document.getElementById('payInput0').value)">Dona</button></input>
      <button  style="display:none;margin-top: -20x; margin-left: 1128px;" id="cancella" onClick="cancella()">Cancella</button> 
 <label form="Strada artista" style=" margin-top: px;margin-left: 300px;">-<%=huc.getPlace(events.get(0).getPlace()).getAddress()  %></label>
     <label form="Tipo di artista" style=" margin-top: px;margin-left: 50px;"><%=huc.getArtist(events.get(0).getArtist()).getTalent() %></label>
         <label form="Tipo di artista" style=" margin-top: px;margin-left: 50px;"></label>

    <hr style="align:left;size:1 ;width:1200px ;color:black; noshade;"></hr>
<% }%>


<%     try{
	artist2 = events.get(1).getArtist();
     } catch (Exception e){
    	 artist2 = "no artist found";
     }
    %> 
    <%if(artist2.equals("no artist found")){ %>
    
    <% }%>
        <%if(!artist2.equals("no artist found")){ %>

<!-- secondo artista --> 

   <p style="margin-top: 280px; margin-left: 5px;"> <img alt="" src="https://www.focusjunior.it/content/uploads/2018/10/Michelangelo-Buonarroti.jpg"

        h1="" style="width: 235px; height: 155px; margin-left: -4px; margin-top: -357px;">
    
    </p>
 
    <h2 style=" margin-top: -180px;margin-left: 300px;"> <label form="Descrizione artista">    <%=events.get(1).getArtist() %>
    </label></h2>
    <h3 style=" margin-top: px;margin-left: 300px;"> <textarea id="story" name="story" style=" resize: none ;"rows="5" cols="80" readonly disabled="disabled">
<%=events.get(1).getDescription() %>
</textarea></h3>
      <input type="text" id="payInput1"  style="height: 35px; width: 90px; margin-top: -90px; margin-left: 1030px; "  /><button id="Dona1" onClick="generatePayment1(document.getElementById('payInput1').value)">Dona</button></input> 
        <button  style="display:none;margin-top: -20x; margin-left: 1128px;" id="cancella1" onClick="cancella()">Cancella</button> 
  
 <label form="Strada artista" style=" margin-top: px;margin-left: 300px;">-<%=huc.getPlace(events.get(1).getPlace()).getAddress()  %></label>
     <label form="Tipo di artista" style=" margin-top: px;margin-left: 50px;"><%=huc.getArtist(events.get(1).getArtist()).getTalent() %></label>
         <label form="Tipo di artista" style=" margin-top: px;margin-left: 50px;"></label>

    <hr style="align:left;size:1 ;width:1200px ;color:black; noshade;"></hr>
    <% }%>
 
  <!-- terzo artista  -->
  
  <%     try{
	artist3 = events.get(2).getArtist();
     } catch (Exception e){
    	 artist3 = "no artist found";
     }
    %> 
    <%if(artist3.equals("no artist found")){ %>
    
    <% }%>
        <%if(!artist3.equals("no artist found")){ %>
    
   <p style="margin-top: 250px; margin-left: 5px;"> <img alt="" src="https://www.focusjunior.it/content/uploads/2018/10/Michelangelo-Buonarroti.jpg"

        h1="" style="width: 235px; height: 155px; margin-left: -4px; margin-top: -357px;">
    
    </p>
    <h2 style=" margin-top: -180px;margin-left: 300px;"> <label form="Descrizione artista">    <%=events.get(2).getArtist() %>
    </label></h2>
    <h3 style=" margin-top: px;margin-left: 300px;"> <textarea id="story" name="story" style=" resize: none ;"rows="5" cols="80" readonly disabled="disabled">
<%=events.get(2).getDescription() %>
</textarea></h3>
       <input type="text" id="payInput2"  style="height: 35px; width: 90px; margin-top: -90px; margin-left: 1030px; "  /><button id="Dona2" onClick="generatePayment2(document.getElementById('payInput2').value)">Dona</button></input> 
        <button  style="display:none;margin-top: -20x; margin-left: 1128px;" id="cancella" onClick="cancella()">Cancella</button> 
  
 <label  style=" margin-top: px;margin-left: 300px;">-<%=huc.getPlace(events.get(2).getPlace()).getAddress()  %></label>
     <label  style=" margin-top: px;margin-left: 50px;"><%=huc.getArtist(events.get(2).getArtist()).getTalent() %></label>
         <label form="Tipo di artista" style=" margin-top: px;margin-left: 50px;"></label>

    <hr style="align:left;size:1 ;width:1200px ;color:black; noshade;"></hr>
 
   <form action="&lt;%= request.getContextPath() %&gt;/register" method="post">
        <p style="margin-top:65px;margin-left:410px;"><button  disabled="true" name="Chart" style="height: 35px; width: 95px; margin-top: -48px; margin-left: 160px;background-color: #4D4D4D;">Vedi altri</button></p>
      </form>
      <%} %>
    <h3 style="margin-top: -1225px; margin-left: 1000px;"></h3>

  
     <div id="paypal-button-container0"  style="margin-top: 650px; margin-left: 1000px; width: 115px;height: 85px; fundingicons: 'true';"fundingicons: 'true'> </div>
      <div id="paypal-button-container1"  style="margin-top:300px; margin-left: 1000px; width: 115px;height: 85px; fundingicons: 'true';"fundingicons: 'true'> </div>
      <div id="paypal-button-container2"  style="margin-top:60px; margin-left: 1000px; width: 115px;height: 85px; fundingicons: 'true';"fundingicons: 'true'> </div>
 
  <script> 
   
   function  cancella(){
		
	     document.getElementById("paypal-button-container0").style.display="none";
		 document.getElementById("paypal-button-container1").style.display="none";
		 document.getElementById("paypal-button-container2").style.display="none";
		 document.getElementById("Dona0").disabled = false;
		 document.getElementById("payInput0").disabled = false;
		 document.getElementById("Dona1").disabled = false;
		 document.getElementById("payInput1").disabled = false;
		 document.getElementById("Dona2").disabled = false;
		 document.getElementById("payInput2").disabled = false;
		 document.getElementById("cancella").style.display="none";
		 
		
		 history.go(0);

   }
		 </script>
   
   
   
   
   
   
   
   
   
   
   
   
   <script>
  function  generatePayment0(value){
		 document.getElementById("paypal-button-container0").style.display="block";

    if(value==""){
	alert("inserire un importo");
	return;
	}
	paypal.Buttons({
		 style: {
			  layout: 'horizontal',
			  fundingicons: 'true',
		  },
	createOrder: function(data, actions){
	return actions.order.create({
	purchase_units: [{
	  amount: {
	  value : value
	  }
	  }]
	  });
	  },
	  onApprove : function(data, actions){
	  return actions.order.capture().then(function(details){
	    document.getElementById("transition").style.display = "block";
	  });
	  }
	 
	  }).render('#paypal-button-container0');
	 document.getElementById("Dona0").disabled = true;
	 document.getElementById("payInput0").disabled = true;
	 document.getElementById("cancella").style.display="block";
	   

	  }
	  </script>
 
   <script>
  function  generatePayment1(value){
    if(value==""){
	alert("inserire un importo");
	return;
	}
	paypal.Buttons({
		 style: {
			  layout: 'horizontal',
			  fundingicons: 'true',
		  },
	createOrder: function(data, actions){
	return actions.order.create({
	purchase_units: [{
	  amount: {
	  value : value
	  }
	  }]
	  });
	  },
	  onApprove : function(data, actions){
	  return actions.order.capture().then(function(details){
	    document.getElementById("transition").style.display = "block";
	  });
	  }
	 
	  }).render('#paypal-button-container1');
	 document.getElementById("Dona1").disabled = true;
	 document.getElementById("payInput1").disabled = true;
	 document.getElementById("cancella1").style.display="block";

	  }
	  </script>
  
  
  <script>
  function  generatePayment2(value){
    if(value==""){
	alert("inserire un importo");
	return;
	}
	paypal.Buttons({
		 style: {
			  layout: 'horizontal',
			  fundingicons: 'true',
		  },
	createOrder: function(data, actions){
	return actions.order.create({
	purchase_units: [{
	  amount: {
	  value : value
	  }
	  }]
	  });
	  },
	  onApprove : function(data, actions){
	  return actions.order.capture().then(function(details){
	    document.getElementById("transition").style.display = "block";
	  });
	  }
	 
	  }).render('#paypal-button-container2');
	 document.getElementById("Dona2").disabled = true;
	 document.getElementById("payInput2").disabled = true;
	 document.getElementById("cancella2").style.display="block";

	  }
	  </script>
  
  </body>
</html>
