package driver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	static WebDriver driver;
	
	public static WebDriver initializeBrowser(String browsername) {
		
		if(browsername.equals("chrome")) {
			
			 driver = new ChromeDriver();
		}else if(browsername.equals("firefox")) {
			 driver =  new FirefoxDriver(); 
		}else if(browsername.equals("edge")) {
			 driver = new EdgeDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		return driver;
		
		}
	
	
	public static WebDriver getDriver() {
		
		return driver;
	}

}
