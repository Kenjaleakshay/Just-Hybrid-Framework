package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Element_Utils;

public class Loginpage {
	
	WebDriver driver;
	Element_Utils elementUtils;
	
	@FindBy(id = "input-email")
	private WebElement emailfield;
	
	@FindBy(id = "input-password")
	private WebElement passwordfield;
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginbutton;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement warningmsg;

	public Loginpage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		elementUtils = new Element_Utils(driver);
		}
	
	public void enterinEmailfield(String email) {
		
		elementUtils.typeTextInElement(emailfield,5,email);
		
	}
	
	public void enterinPasswordfield(String password) {
		
		elementUtils.typeTextInElement(passwordfield,5,password);
		
	}
	
	public Accountpage clickOnLoginbutton() {
		
		elementUtils.clickOnElement(loginbutton,5);
		return new Accountpage(driver);
	}
	
	public boolean verifyWarningmsg() {
		
		return elementUtils.displayStatusOfElement(warningmsg,5);
		//boolean val = warningmsg.isDisplayed();
		//return val;
	}
	
	
	
	
	
	
	
	
}
