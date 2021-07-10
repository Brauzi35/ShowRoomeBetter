<!DOCTYPE html>
<html  lang="it">
  <head>
    <title>Prova</title>
  </head>
  <body style="    height: 512px; background-color: white;"><img src="https://github.com/Brauzi35/ShowRoome-ISPW2021/blob/main/Immagini/26362.png?raw=true"

      alt="" style="width: 93px; height: 73px; margin-left: -2px;"><br>
    <h1 style="margin-top: -45.5667px; margin-left: 115px;"> ShowRoome Sponsor </h1>
    <h1 style="margin-top: -60px; margin-left: 1000px;"> <input value="" size="18"

        maxlength="40" type="text"> </h1>
    <h1 style="margin-top:-58px; margin-left: 1150px;">
      <form action="&lt;%= request.getContextPath() %&gt;/register" method="post">
        <input value="Search artist" size="15" maxlength="40" ;style="background-color:"

#993300="" type="submit"></form>
    </h1>
    <h1 style="margin-top:84px;margin-left:3px;">
      <form action="TastoProfile" method="post">
        <p style="margin-top:-74px;margin-left:674px;"><input id="Submit" name="Profile" type="submit" value="Profile" style="height: 35px; width: 95px; margin-top: -48px; margin-left: 160px;background-color: #4D4D4D;color:white;"></input></p>
      </form>
      <form action="TastoChart" method="post">
        <p style="margin-top:-74px;margin-right:2200;"><input id="Submit" name="Artisti" type="submit" value="Artisti" style="height: 35px ; width: 95px; margin-top: -48px; margin-left: 390px;background-color: #4D4D4D;"></input>
        </p>
      </form>
     
      <form action="Homepage" method="post">
        <p style="margin-top:-74px;margin-left:-555px;"><input id="Submit" name="Homepage" type="submit" value="Homepage" style="height: 35px ; width: 95px; margin-top: -46px; margin-left: 570px;background-color: #4D4D4D;"></input>
        </p>
      </form>
      <form action="Tasto2servlet" method="post">
        <p style="margin-top:-74px;margin-left:937px;"><input id="Submit" name="Settings" type="submit" value="Settings" style="height: 35px ; width: 95px; margin-top: -48px; margin-left: 210px;background-color: #4D4D4D;"></input></p>
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
    <h1 style="margin-top: -159px; margin-left: 1170px;">
      <form action="Login" method="post"><input

value="Login" size="65" maxlength="40" ;style="background-color:" #10030f="" type="submit"></form>
    </h1>
    <!-- Primo artista  -->
    <p style="margin-top: 300px; margin-left: 5px;"> <img alt="" src="https://www.cosafarearoma.it/wp-content/uploads/2014/06/Trinity-College-Irish-Pub-Roma.jpg"
   style="width: 235px; height: 155px; margin-left: -4px; margin-top: -357px;">
    </p>
    <h2 style=" margin-top: -180px;margin-left: 300px;"> <label ></label></h2>
    <ul>
    <li>
      <h3 style=" margin-top: px;margin-left: 500px;">
        <ul>
          <input readonly="readonly" value="Er Pubetto de zona" id="Nome" name="Nome" style="height: 25px; width: 225px;"

            type="text">
        </ul>
        <ul>
          <input readonly="readonly" value="Francesco Girardi" id="Cognome" name="Cognome"

            style="height: 25px; width: 225px;" type="text">
        </ul>
        <ul>
          <input readonly="readonly" value="3347544448" id="password" name="password"

            style="height: 25px; width: 225px;" type="text">
            
        </ul>
        
           
      </h3>
    </li>
     </ul>
    <form action="&lt;%= request.getContextPath() %&gt;/register" method="post">
      <button name="Dona" style="height: 35px; width: 90px; margin-top: -150px; margin-left: 615px; background-color: #4d4d4d;">Modifica</button>
    </form>
    <form action="&lt;%= request.getContextPath() %&gt;/register" method="post">
      <button name="Informazioni" style="height: 35px; width: 90px; margin-top: 20px; margin-left: 70px; background-color: #4d4d4d;">Modifica
        foto</button></form>
    
  </body>
</html>
