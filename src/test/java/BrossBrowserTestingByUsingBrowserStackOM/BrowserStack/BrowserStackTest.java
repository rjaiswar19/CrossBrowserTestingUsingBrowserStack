package BrossBrowserTestingByUsingBrowserStackOM.BrowserStack;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowserStackTest {
	
	public static String BROWSERSTACK_USERNAME="ramashankarjaisw_XLeR0Y";
	public static String BROWSERSTACK_ACCESS_KEY="johZUipntpDfMK3sezfe";
	/*public static String URL="https://"+ USERNAME +":"+ ACCESSKEY +"@hub.browserhubstack.com/wd/hub";*/
	
	/*public static final String USERNAME = System.getenv("BROWSERSTACK_USERNAME");
	public static final String AUTOMATE_KEY = System.getenv("BROWSERSTACK_ACCESS_KEY");*/
	public static final String URL = "https://" + BROWSERSTACK_USERNAME + ":" + BROWSERSTACK_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

	
	@Test
	public void openSTM() throws MalformedURLException
	{
		DesiredCapabilities capabilities=new DesiredCapabilities();
		//capabilities.setPlatform(Platform.WIN10);
		capabilities.setBrowserName("firefox");
		//capabilities.setVersion("57");
		capabilities.setCapability("browserstack.local", true);
		
		
		java.net.URL browserStachURL=new java.net.URL(URL);
		
		WebDriver driver=new RemoteWebDriver(browserStachURL,capabilities);
		
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String actualURL=driver.getCurrentUrl();
		
		String expectedURl="https://www.google.com/";
		
		Assert.assertEquals(actualURL, expectedURl,"URLS are same ");
		
		
		
		
		
	}
	

}
