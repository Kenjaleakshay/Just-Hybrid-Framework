package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Element_Utils {
	
	WebDriver driver;
	
	public Element_Utils(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public WebElement waitForElement(WebElement element,long duration) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(duration));
		
		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(element));
		
		return ele;
	}
	
	public void clickOnElement(WebElement element,long duration) {
		
		WebElement ele = waitForElement(element,duration);
		
		ele.click();
		
	}
	
	public void typeTextInElement(WebElement element,long duration,String text) {
		
		WebElement ele = waitForElement(element,duration);
		
		ele.clear();
		ele.sendKeys(text);
		
	}
	
	public void selectOptionInDropdown(WebElement element,long duration,String option) {
		
		WebElement ele = waitForElement(element,duration);
		Select sel = new Select(ele);
		
		sel.selectByVisibleText(option);
		}
	
	public void mouseHoverAndClick(WebElement element, long duration) {
		
		WebElement ele = waitForElement(element,duration);
		Actions act = new Actions(driver);
		
		act.moveToElement(ele).click().build().perform();
		
		}
	
    public Alert waitForAlert(long duration) {
    	
    	Alert alert = null;
    	try {
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(duration));
    	
    	 alert = wait.until(ExpectedConditions.alertIsPresent());
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return alert;
    	
    }
    
    public void acceptAlert(long duration) {
    	
    	Alert alert = waitForAlert(duration);
    	
    	alert.accept();
    }
    
    public void javascriptClick(WebElement element,long duration) {
    	
    	WebElement ele = waitForElement(element,duration);
    	
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
    	
    	jse.executeScript("arguments[0].click();",ele);
    	
    	 }
    
    public void javascriptTypeText(WebElement element,long duration,String textToBeTyped) {
    	
    	WebElement ele = waitForElement(element,duration);
    	
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
    	jse.executeScript("arguments[0].value='"+textToBeTyped+"'",ele);
    	
    }
    
    public WebElement waitForVisibility(WebElement element,long duration) {
    	
    	WebElement ele = null;
    	try {
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(duration));
    	 ele = wait.until(ExpectedConditions.visibilityOf(element));
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return ele;
    }
    
    public String getElementText(WebElement element,long duration) {
    	
    	WebElement ele = waitForVisibility(element,duration);
    	return ele.getText();
    }
    
    public boolean displayStatusOfElement(WebElement element,long duration) {
    	
    	try {
    	WebElement ele = waitForVisibility(element,duration);
    	return ele.isDisplayed();
    }catch(Exception e) {
    	return false;
    }
    
    }
    
    
    
    
}
