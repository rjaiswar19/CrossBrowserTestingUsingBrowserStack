package BrossBrowserTestingByUsingBrowserStackOM.BrowserStack;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParallelCrossBrowserTesting {

	public static WebDriver driver;
	public static String BROWSERSTACK_USERNAME="ramashankarjaisw_XLeR0Y";
	public static String BROWSERSTACK_ACCESS_KEY="johZUipntpDfMK3sezfe";
	public static final String URL = "https://" + BROWSERSTACK_USERNAME + ":" + BROWSERSTACK_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
    
	@Test(dataProvider="EnvironmentDetails")
	public void TestGoogleURL(Platform platform,String BrowserName,String browserVersion) throws MalformedURLException
	{
		DesiredCapabilities capibilities=new DesiredCapabilities();
		capibilities.setBrowserName(BrowserName);
		capibilities.setPlatform(platform);
		capibilities.setVersion(browserVersion);
		capibilities.setCapability("browserstack.local", true);
		
		
		java.net.URL browserStachURL=new java.net.URL(URL);
		
		WebDriver driver=new RemoteWebDriver(browserStachURL,capibilities);
		
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

		
		@DataProvider(name="EnvironmentDetails",parallel=true)
		public Object[][] getData()
		{
			Object[][] testData=new Object[][]{
					{Platform.MAC, "chrome", "62.0"},
					{Platform.WIN8, "chrome", "62.0"},
					{Platform.WINDOWS, "firefox", "57"},
					{Platform.ANDROID,"Galaxy S21 Ultra","11.0"},
					{Platform.ANDROID,"Pixel 5","11"}
					
			};
			return testData;
		
		}
}
