package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Element_Utils;

public class Registerpage {

	WebDriver driver;
	Element_Utils elementUtils;
	
	@FindBy(id = "input-firstname")
	private WebElement firstnamefield;
	
	@FindBy(id = "input-lastname")
	private WebElement lastnamefield;
	
	@FindBy(id = "input-email")
	private WebElement emailfield;
	
	@FindBy(id = "input-telephone")
	private WebElement telephonefield;
	
	@FindBy(id = "input-password")
	private WebElement passwordfield;
	
	@FindBy(id = "input-confirm")
	private WebElement confirmpasswordfield;
	
	@FindBy(xpath = "//input[@value='1'][@name='newsletter']")
	private WebElement yesradiobtn;
	
	@FindBy(xpath = "//input[@value='1'][@name='agree']")
	private WebElement privacycheckbox;
	
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continuebtn;
	
	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	private WebElement warningmsg;
	

	public Registerpage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		elementUtils = new Element_Utils(driver);
	}
	
	public void enterinFirstNamefield(String fname) {
		
		elementUtils.typeTextInElement(firstnamefield,5,fname);
	}
	
	public void enterinLastNamefield(String lname) {
		
		elementUtils.typeTextInElement(lastnamefield,5,lname);
	}
	
	public void enterinEmailfield(String email) {
		
		elementUtils.typeTextInElement(emailfield,5,email);	
	}
	
	public void enterinTelephonefield(String tele) {
		
		telephonefield.sendKeys(tele);
	}
	
	public void enterinPasswordfield(String pass) {
		
		passwordfield.sendKeys(pass);
	}
	
	public void enterinConfirmPasswordfield(String confirm) {
		
		confirmpasswordfield.sendKeys(confirm);
	}
	
	public void clickonYesradiobutton() {
		
		yesradiobtn.click();
	}
	
	public void clickonPrivacycheckbox() {
		
		privacycheckbox.click();
	}
	
	public Accountpage clickonContinuebtn() {
		
		continuebtn.click();
		return new Accountpage(driver);
	}
	
	public boolean verifyWarningmsg() {
		
		String text = elementUtils.getElementText(warningmsg,5);
		boolean  val = text.contains("First Name must be between 1 and 32 characters!");
		return val;
	}
	
	
	
	
}
