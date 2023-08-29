package hookmethods;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class Hooks {
	
	WebDriver driver;
	
	@Before
	public void setup() {
		
		Properties prop = ConfigReader.initializeconfig();
		driver = DriverFactory.initializeBrowser(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
		
		}
	
	@After
	public void teardown(Scenario scenario) {
		
		String scenarioname = scenario.getName().replace(" ","_");
		
		if(scenario.isFailed()) {
			TakesScreenshot ts =(TakesScreenshot)driver;
			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot,"image/png",scenarioname);
		}
		
		driver.quit();
	}

}
