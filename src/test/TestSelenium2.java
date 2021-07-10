package test;
//Gianmattia  Mignone
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;



import static org.junit.Assert.*;

public class TestSelenium2 {
   public static void main(String[] args) {
	   System.setProperty("webdriver.chrome.driver","Driver/chromedriver.exe");
	   WebDriver driver2 = new ChromeDriver();
	   driver2.get("http://localhost:8080/ShowRoomeFinal/");
	   driver2.findElement(By.xpath("//*[@id=\"username\"]")).clear();
	   driver2.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("Gimmy13");
	   driver2.findElement(By.xpath("//*[@id=\"password\"]")).clear();
	   driver2.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("password");
       driver2.findElement(By.xpath("/html/body/p[2]/input")).click();
       driver2.findElement(By.xpath("//*[@id=\"Submit\"]")).click();
       driver2.findElement(By.xpath("//*[@id=\"artist\"]")).clear();
       driver2.findElement(By.xpath("//*[@id=\"artist\"]")).sendKeys("Provino");
       driver2.findElement(By.xpath(" /html/body/h1[5]/form/input[2]")).click();
	   driver2.findElement(By.xpath("  //*[@id=\"story\"]")).clear();
	   driver2.findElement(By.xpath("  //*[@id=\"story\"]")).sendKeys("Una performer fantastica");
       driver2.findElement(By.xpath("  /html/body/form[2]/button")).click();


     driver2.close();

	  
   }
}


