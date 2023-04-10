package portfolioAnalystTestClasses;

import java.io.IOException;
import java.util.Random;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import portfolioAnalystBase.Base;
import portfolioAnalystPomClasses.LandingPage;
import portfolioAnalystPomClasses.NewAccountCreation;
import portfolioAnalystPomClasses.RegistrationFormPage;
import portfolioAnalystUtility.Utility;

public class PortfolioAnalystStandaloneApplicationTest2 extends Base {
	LandingPage home;
	 RegistrationFormPage reg;
	NewAccountCreation acc;
	String emailAddress = "test" + new Random().nextInt(1000) + "@example.com";
    String username = "testing" + new Random().nextInt(10000);
    String password = "tester12";
	
	 
	@BeforeClass
	  public void beforeClass() throws IOException {
		LaunchUrl();
		 home = new LandingPage(driver);
		 reg = new RegistrationFormPage(driver);
		 acc = new NewAccountCreation(driver);
	}
	@BeforeMethod
	  public void beforeMethod() throws InterruptedException, EncryptedDocumentException, IOException  {
		Thread.sleep(5000);
		home.clickOnGetStartedBtn();
		portfolioAnalystUtility.Utility.wait(2000, driver);
		  home.CreatAccount();
		  }
	 
	 @Test
		public void testEmailAddressField() throws InterruptedException {
		 reg.enterEmailAddress("user@domain");
		   Assert.assertTrue(reg.isEmailErrorDisplayed(),"Error Message is not Displayed on web Page");
		}
	
	 @Test
    public void ValidatePasswordMatch() {
        Assert.assertTrue(reg.PasswordMatch(),"Password & Confirm Password not Match please enter same");
    }
	 @Test
	    public void testDefaultCountrySelection() {
	    	Assert.assertEquals(reg.getSelectedCountry(driver), "United States","No Default country set to Dropdown list");
	    } 

	 @Test
	    public void testFirstNameIsRequired() throws InterruptedException {
		 acc.enterEmail(emailAddress);
         acc.enterUsername(username);
         acc.enterPassword(password);
         acc.enterConfirmPassword(password, driver);
         acc.selectCountry("Indonesia", driver); 
         Thread.sleep(10000);
         acc.clickCreateNewBtn();
	        Assert.assertTrue(reg.isFirstNameErrorDisplayed(driver),"Error Message is not Displayed on First Name field");
	    }
	 @Test
	    public void testCountryIsRequired() throws InterruptedException {
		 acc.clickCreateNewBtn();
       Utility.wait(3000, driver);
       String actualCountryError = "Required";
	   Assert.assertTrue(reg.isCountryErrorDisplayed().contains(actualCountryError));   
	 }
	 
	 @Test
	    public void testCountryIsRequired(WebDriver driver) throws InterruptedException {
	       Assert.assertEquals(reg.isCountryErrorDisplayed(),"Error Message is not Displayed on Country field");
	    } 
	@Test
	    public void testInvalidEmailAddress() throws InterruptedException {
		 reg.enterEmailAddress("user@domain");
		   Assert.assertTrue(reg.isEmailErrorDisplayed(),"Error Message is not Displayed on web Page");
	   }
	
	@AfterMethod
		public void Closemethod() {
			driver.close();
		}
}

