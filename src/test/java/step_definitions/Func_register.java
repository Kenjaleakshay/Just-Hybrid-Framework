package step_definitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driver.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.Accountpage;
import pages.Homepage;
import pages.Registerpage;

public class Func_register {

	WebDriver driver;
	Registerpage registerpage; 
	Accountpage accountpage;
	
	@Given("User navigates to register page")
	public void User_navigates_to_register_page() {
		
	driver = DriverFactory.getDriver();
	Homepage homepage = new Homepage(driver);
	homepage.clickOnMyAccountdrop();
	registerpage = homepage.clickonRegisterlink();
	
	}
	
	@When("user enters below details")
	public void user_enters_below_details(DataTable data) {
		
		Map<String,String> table = data.asMap();
		
		registerpage.enterinFirstNamefield(table.get("firstname"));
		registerpage.enterinLastNamefield(table.get("lastname"));
		registerpage.enterinEmailfield(table.get("email"));
		registerpage.enterinTelephonefield(table.get("telephone"));
		registerpage.enterinPasswordfield(table.get("password"));
		registerpage.enterinConfirmPasswordfield(table.get("confirmpassword"));
				
}
	
	@And("clicks on privacy policy checkbox")
	public void clicks_on_privacy_policy_checkbox() {
		
		registerpage.clickonPrivacycheckbox();
		
	}
	
	@And("clicks on continue button")
	public void clicks_on_continue_button() {
		
		accountpage = registerpage.clickonContinuebtn();
		
	}
	
	@Then("new account should get created")
	public void new_account_should_get_created() {
		
		Assert.assertTrue(accountpage.verifyAccountCreatedtext());
		
	}
	
	@And("clicks on yes radio button")
	public void clicks_on_yes_radio_button() {
		
		registerpage.clickonYesradiobutton();
		
		}
	
	@Then("user should get warning msg")
	public void user_should_get_warning_msg() {
		
		
		Assert.assertTrue(registerpage.verifyWarningmsg());
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
