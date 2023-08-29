package step_definitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import driver.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pages.Accountpage;
import pages.Homepage;
import pages.Loginpage;

public class Fuctionality_login {
	
	WebDriver driver;
	Loginpage loginpage;
	Accountpage accountpage;
	
	@Given("User navigates to login page")
	public void user_navigates_to_login_page(){
		
		driver = DriverFactory.getDriver();
		
		Homepage homepage = new Homepage(driver);
		homepage.clickOnMyAccountdrop();
		loginpage = homepage.clickonLoginlink();
		
		
		}
	
	@When("^user enters valid email (.+) and password (.+)$")
	public void user_enters_valid_email_and_password_(String email,String password){
		
		loginpage.enterinEmailfield(email);
		loginpage.enterinPasswordfield(password);
			
	}
	
	@And("clicks on login button")
	public void clicks_on_login_button() {
		
		accountpage = loginpage.clickOnLoginbutton();
		
		}
	
	@Then("user should logged in")
	public void user_should_logged_in() {
		
		
		Assert.assertTrue(accountpage.verifyEditAccountlink());
		
		
	}
	
	@When("user enters invalid email {string} and password {string}")
	public void user_enters_invalid_email_and_password(String email,String password) {
		
		loginpage.enterinEmailfield(email);
		loginpage.enterinPasswordfield(password);
		
	}
	
	@Then("User should get warning msg")
	public void user_should_get_warning_msg() {
		
		Assert.assertTrue(loginpage.verifyWarningmsg());	
	}
	
	@When("user enters valid email {string} and invalid password {string}")
    public void user_enters_valid_email_and_invalid_password(String val_email,String inv_password) {
	
		loginpage.enterinEmailfield(val_email);
		loginpage.enterinPasswordfield(inv_password);
}
	
	@When("user enters invalid email {string} and invalid password {string}")
	public void user_enters_invalid_email_and_invalid_password(String inv_email,String inv_password) {
		
		loginpage.enterinEmailfield(inv_email);
		loginpage.enterinPasswordfield(inv_password);
		
	}
	
}
	
	
	
	
	
	

	
	


