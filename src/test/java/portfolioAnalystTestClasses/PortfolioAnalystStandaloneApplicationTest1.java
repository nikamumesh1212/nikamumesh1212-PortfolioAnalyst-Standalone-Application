package portfolioAnalystTestClasses;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import portfolioAnalystBase.Base;
import portfolioAnalystPomClasses.LandingPage;
import portfolioAnalystPomClasses.NewAccountCreation;
import portfolioAnalystUtility.Utility;

@Listeners(portfolioAnalystTestClasses.Listeners.class)
public class PortfolioAnalystStandaloneApplicationTest1 extends Base{
	LandingPage home;
	 NewAccountCreation acc;
	 String emailAddress = "test" + new Random().nextInt(1000) + "@example.com";
     String username = "testing" + new Random().nextInt(10000);
     String password = "tester12";
	 
	@BeforeClass
	  public void beforeClass() throws IOException {
		LaunchUrl();
		 home = new LandingPage(driver);
		 acc = new NewAccountCreation(driver);
		}
	
	@BeforeMethod
	  public void beforeMethod() throws InterruptedException, EncryptedDocumentException, IOException  {
		Thread.sleep(5000);
		home.clickOnGetStartedBtn();
		portfolioAnalystUtility.Utility.wait(2000, driver);
		  home.CreatAccount();
		  Thread.sleep(2000);
          acc.enterEmail(emailAddress);
          acc.enterUsername(username);
          acc.enterPassword(password);
          acc.enterConfirmPassword(password, driver);
          acc.selectCountry("Indonesia", driver);
          acc.enterFirstName(Utility.readExcelSheet(1, 4));
          acc.enterLastName(Utility.readExcelSheet(1, 5));
          acc.enterDateOfBirth(Utility.readExcelSheet(1, 6));
          acc.selectSecurityQuestion1("What is your favorite cartoon character?", "Mogali");
          acc.selectSecurityQuestion2("What is your favorite place to shop?", "Mumbai");
          acc.selectSecurityQuestion3("What is the name of your favorite sports team?", "Mumbai Indians");
          acc.agreementLink();
          acc.clickAgree();
          acc.clickCreateNewBtn();
		  }
	
	@Test(priority = 1)
	  public void ValidateUrl() throws IOException, InterruptedException {
		   String ExpectedUrl = "https://ndcdyn.interactivebrokers.com/Universal/Application?pa=T";
		   Assert.assertEquals(acc.getCurrentUrl(driver), ExpectedUrl,"Actual & expected Url Not match");
		   }
	@Test(priority = 2)
	  public void ValidateAgreeButton()  {
	   boolean isDisplayed = acc.isAgreeButtonDisplayed();
	   Assert.assertTrue(isDisplayed, "Button is not displayed");
	  }
	
	@Test(priority = 3)
	  public void ValidateAgreementLink() throws InterruptedException  {
	   String ExpectedAgreement = "IBLLC - Standalone PortfolioAnalyst Subscriber Agreement";
		 Assert.assertEquals(acc.agreementLink(), ExpectedAgreement, "Agreement is not appear on webpage.");
	  }
	
		  
	@Test(priority = 4)
	  public void ValidateEmailConfirmation() throws InterruptedException, EncryptedDocumentException, IOException{
		String ConfirmationMsg="Check your email and confirm your email address";
		Assert.assertTrue(acc.getConfirmPage(driver).contains(ConfirmationMsg),"Entered & Confirmation Email not Match");
	}
	@AfterMethod
	public void Closemethod() {
		driver.close();
	}
}
