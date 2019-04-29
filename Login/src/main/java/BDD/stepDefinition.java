package BDD;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepDefinition {
public static WebDriver driver;

	@Given("^User is on home page$")
	public void user_is_on_home_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe"); 
driver=new ChromeDriver();
	  driver.get("https://thewarehouse.co.nz");
	}

	@When("^user enters username and password$")
	public void user_enters_username_and_password(DataTable credentials) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/header/div[2]/div/div/div/div/div[4]/ul/li[3]/a/span")).click();
		for(Map <String,String> data : credentials.asMaps(String.class,String.class)) {
		  driver.findElement(By.xpath("//*[contains(@id,'dwfrm_login_username')]")).sendKeys(data.get("username"));
			driver.findElement(By.xpath("//*[@id='dwfrm_login_password']")).sendKeys(data.get("password"));
		}	
	}

	@When("^clicks login  button$")
	public void clicks_login_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@value='Log In']")).click();
	}

	@Then("^login is successful$")
	public void login_is_successful() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("CONGRATULATIONS... LOGIN SUCCESSFUL");
	    driver.quit();
	}
}
