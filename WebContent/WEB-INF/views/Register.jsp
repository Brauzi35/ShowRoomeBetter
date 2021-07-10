<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html  lang="it">
  <head>
    <title>ShoowRome</title>
  <body>
  <style>
body {
  background-image: url('https://github.com/Brauzi35/ShowRoome-ISPW2021/blob/main/Immagini/roma-2.jpg?raw=true');
}
</style>
  </head>
    <h1 style="margin-top: -45.5667px; margin-left: 115px;"> ShowRoome </h1>
    <p style="margin-top: -45.5667px; margin-left: 115px;"> </p>
    <h3 style=" margin-top: 150px;margin-left: 480px;">
     <form action="LoginControllerWeb" method="post">
      <ul>
       <form action="RegisterController" method="post">
        <input  value="Nome Utente" id="username" name="username" style="height: 25px; width: 225px;"

 

          type="text">
      </ul>
      <ul>
        <input  value="password" id="password" name="password"

 

          style="height: 25px; width: 225px;" type="text">
      </ul>
      <ul>
        <input  value="email" id="email" name="email" style="height: 25px; width: 225px;"

 

          type="text">
      </ul>
    </h3>
       
          <select value='TipoDiUtente'  id="tipoutente" name="tipoutente" style="margin-top: 25px; margin-left: 520px;" >

 

        <option value='1'>User</option>

 

        <option value='2'>Performer</option>
     <option value='3'>Sponsor</option>

 

        
 

    </select>
    

 

   

 

    <p style="height: 35px; width: 90px; margin-top: -20px; margin-left:220px;">
      </p>
    
      <button name="Informazioni" style="height: 35px; width: 90px; margin-top: 20px; margin-left: 595px; background-color: #4d4d4d;">Registrati</button>
      
      </form>
   
    
    
  </body>
</html>