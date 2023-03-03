package project2;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class twitterPage {
  @Test
  public void twitter() throws IOException, InterruptedException {
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
	    
	    
	    WebElement twitter = driver.findElement(By.xpath(props.getProperty("twitter")));
		  twitter.click();
		  Thread.sleep(7000);
		//SWITCHING TO NEWLY OPENED TAB(TWITTER PAGE) 
	      ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
	     driver.switchTo().window(newTb.get(1));
		  
		  
		  String twitterTitle = props.getProperty("twitterTitle");
			String actualTitle = driver.getTitle();
			Assert.assertEquals(twitterTitle, actualTitle);
		  
			
			driver.quit();
	   
  }
			}
  
  