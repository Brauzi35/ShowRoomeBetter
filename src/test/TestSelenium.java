package test;
//Valerio Brauzi
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.junit.Assert.*;

public class TestSelenium {
   public static void main(String[] args) {
	   System.setProperty("webdriver.chrome.driver","Driver/chromedriver.exe");
	   WebDriver driver1 = new ChromeDriver();
	   driver1.get("http://localhost:8080/ShowRoomeFinal/");
	   driver1.findElement(By.xpath("//*[@id=\"username\"]")).clear();
	   driver1.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("valerio");
	   driver1.findElement(By.xpath("//*[@id=\"password\"]")).clear();
	   driver1.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("valeprova");
	   
	   driver1.findElement(By.xpath("/html/body/p[2]/input")).click();
	   driver1.findElement(By.xpath("/html/body/h1[2]/form[2]/p/input")).click();
	   driver1.findElement(By.xpath("/html/body/form[2]/div/button[1]")).click();
	   String place = driver1.findElement(By.xpath("/html/body/div[1]/textarea[1]")).getText();
	   boolean check = false;
	   if(place.equals("Eur") || place.equals("there is no show here")) {
		   check = true;
	   }
	   assertEquals(true, check);
	   
	   driver1.close();
	  
   }
}


