package project2;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sortByName {
  @Test
  public void sort() throws IOException, InterruptedException {
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
	    
	    Select sorting = new Select(driver.findElement(By.xpath(props.getProperty("sorting"))));
		  sorting.selectByValue(props.getProperty("nameD"));
		  
		//VERIFYING
		  WebElement product1 = driver.findElement(By.xpath(props.getProperty("lastProduct")));
		  String actProduct = product1.getText();
		  String expProduct = props.getProperty("expProduct");
		  Assert.assertTrue(actProduct.equals(expProduct));
		  
		  driver.close();
  }
}
