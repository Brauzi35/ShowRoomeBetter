<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html  lang="it">
  <head>
    <title>ShoowRome</title>
	<body>
	<style>
body {
  background-image: url('https://github.com/Brauzi35/ShowRoome-ISPW2021/blob/main/Immagini/Header.jpg?raw=true');
}
</style>
  </head>
    <h1 style="margin-top: px; margin-left: 115px;"> ShowRoome </h1>
    <p style="margin-top: -60px; margin-left: 115px;"> </p>
    <h3 style=" margin-top: 150px;margin-left: 480px;">
     <form action="LoginControllerWeb" method="post">
      <ul>
        <input  value="Nome Utente" id="username" name="username" style="height: 25px; width: 225px;"

 

          type="text">
      </ul>
      <ul>
        <input  value="password" id="password" name="password"

 

          style="height: 25px; width: 225px;" type="password">
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
      <input type="submit" name="login" value="login" style="height: 35px; width: 90px; margin-top: -130px; margin-left:443px; background-color: #4d4d4d;"></input>
      </p>
      </form>
    <form action="RegisterController" method="get">
      <button name="register" style="height: 35px; width: 90px; margin-top: 20px; margin-left: 595px; background-color: #4d4d4d;">Registrati</button></form>
    <form action="LoginControllerWeb" method="get">
      <button name="Informazioni" style="height: 35px; width: 90px; margin-top: 20px; margin-left: 595px; background-color: #4d4d4d;">Continua
        senza login</button></form>
    
    
 
  </body>
</html>
