package pages;

import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 
public class Accountpage {
	
	WebDriver driver;
	
	@FindBy(linkText = "Edit your account information")
	private WebElement editAccountlink;
	
	@FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
	private WebElement accountcreatedtext;
	
	public Accountpage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public boolean verifyEditAccountlink() {
		
		boolean val = editAccountlink.isDisplayed();
		return val;
	}
	
	public boolean verifyAccountCreatedtext() {
		
		boolean val = accountcreatedtext.getText().contains("Your Account Has Been Created!");
		return val;
	}

}
