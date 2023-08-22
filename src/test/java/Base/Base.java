package Base;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import UtilityClasses.Utility;


public class Base {
	protected WebDriver driver;
    public void LaunchUrl() throws IOException  {
		//  System.setProperty("webdriver.chrome.driver", "C:\\Users\\umesh\\eclipse-workspace\\PortfolioAnalyst_Standalone_Application2\\Drivers\\chromedriver.exe");
		 ChromeOptions opt = new ChromeOptions();
		 opt.addArguments("--remote-allow-origins=*");
		 driver = new ChromeDriver(opt);
		 driver.get(Utility.readPropertyFile("qaurl"));
		 //driver.get("https://unstop.com/");
	     driver.manage().window().maximize();
	     }
}


