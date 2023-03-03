package project2;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class logout {
  @Test
  public void log() throws IOException, InterruptedException {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
	  
	  driver.manage().window().maximize();
	  
	 FileReader reader=new FileReader("C:\\Users\\kanna\\Downloads\\ITTalentHubSeleniumProject\\ITTalentHubSeleniumProject\\src\\test\\java\\project2\\testData.properties");
	 Properties props=new Properties();
	 props.load(reader);
	 
	     
	driver.get(props.getProperty("URL"));
	
	//VERIFYING LOGIN PAGE
	String loginTitle = props.getProperty("logintitle");
	String actualLoginTitle = driver.getTitle();
	Assert.assertEquals(loginTitle, actualLoginTitle);
	
	  WebElement userName = driver.findElement(By.xpath(props.getProperty("userName")));
	  userName.sendKeys(props.getProperty("user_Name"));
	  WebElement password = driver.findElement(By.xpath(props.getProperty("Password")));
	  password.sendKeys(props.getProperty("passwrd"));
	  WebElement loginButton = driver.findElement(By.xpath(props.getProperty("LoginButton")));
	  loginButton.click();
	  
	  //VERIFICATION OF PRODUCTS PAGE
	  boolean productsPage = driver.findElement(By.xpath(props.getProperty("productsPageVerif"))).isDisplayed();
	    System.out.println(props.getProperty("pageVerifedMsg")+productsPage);
	    Thread.sleep(3000);
	    
	 //SIDE MENU   
	    WebElement sideMenu = driver.findElement(By.id(props.getProperty("burgerMenu")));
		  sideMenu.click();
		  Thread.sleep(3000);
		WebElement logout = driver.findElement(By.id(props.getProperty("logoutLink")));
		  logout.click();
		
		//VERIFYING LOGOUT
			String loginTitle2 = props.getProperty("logintitle");
			String actualLoginTitle2 = driver.getTitle();
			Assert.assertEquals(loginTitle2, actualLoginTitle2);
		 
			
			driver.close();
}
}