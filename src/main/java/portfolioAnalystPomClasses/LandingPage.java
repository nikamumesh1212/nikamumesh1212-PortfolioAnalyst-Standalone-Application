package portfolioAnalystPomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LandingPage {

	@FindBy(xpath=("//a[@class='btn btn-primary order-0 order-lg-1']")) private WebElement getStartBtn ;
	@FindBy(xpath=("(//a[@class='btn btn-primary'])[6]")) private WebElement CreatAccountBtn ;
	
	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnGetStartedBtn() throws InterruptedException {
	   Thread.sleep(5000);
		getStartBtn.click();
		
	}
	 public void CreatAccount() throws InterruptedException {
		 Thread.sleep(2000);
		 CreatAccountBtn.click();
		 
		 
		 
	 }
}
