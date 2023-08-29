package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Element_Utils;

public class Homepage {
	
	
	WebDriver driver;
	Element_Utils elementUtils;
	
	public Homepage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		elementUtils = new Element_Utils(driver);
		
	}
	
	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountdropdown;
	
	@FindBy(linkText = "Login")
	private WebElement loginlink;
	
	@FindBy(linkText = "Register")
	private WebElement registerlink;
	
	
	public void clickOnMyAccountdrop() {
		
		elementUtils.clickOnElement(myAccountdropdown,5);
	}
	
	public Loginpage clickonLoginlink() {
		
		elementUtils.clickOnElement(loginlink,5);
		return new Loginpage(driver);
	}
	
	public Registerpage clickonRegisterlink() {
		
		elementUtils.clickOnElement(registerlink,5);
		return new Registerpage(driver);
	}
	
	
	
	
	
	

}
