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

public class invalidLogin {
  @Test
  public void invalidLoginn() throws IOException {
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
	  userName.sendKeys(props.getProperty("inv_username"));
	  WebElement password = driver.findElement(By.xpath(props.getProperty("Password")));
	  password.sendKeys(props.getProperty("inv_passwrd"));
	  WebElement loginButton = driver.findElement(By.xpath(props.getProperty("LoginButton")));
	  loginButton.click();
	  
	  //VERIFICATION OF ERROR MESSAGE
	  boolean errorMsg = driver.findElement(By.xpath(props.getProperty("inv_login_error"))).isDisplayed();
	   System.out.println("Invalid login"+errorMsg);
	    
	   
	   driver.close();
  }
}
