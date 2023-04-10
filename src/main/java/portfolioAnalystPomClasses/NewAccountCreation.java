package portfolioAnalystPomClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import portfolioAnalystUtility.Utility;

public class NewAccountCreation {

	
	@FindBy(xpath=("//input[@id='emailAddress']"))
	private WebElement emailInput;
	
	@FindBy(xpath=("//input[@id='username']"))
	private WebElement usernameInput;
	
	@FindBy(xpath=("//input[@id='password']"))
	private WebElement passwordInput;
	
	@FindBy(xpath=("//input[@id='password2']")) 
	private WebElement confirmPasswordInput;
	
	@FindBy(xpath=("//span[normalize-space()='Choose One']"))
	private WebElement countryDropdown;
	
	@FindBy(xpath=("//input[@id='firstName']"))
	private WebElement firstNameInput;
	
	@FindBy(xpath=("//input[@id='lastName']"))
	private WebElement lastNameInput;
	
	@FindBy(xpath=("//input[@id='date']")) 
	private WebElement dateOfBirthInput;
	
	@FindBy(xpath=("//select[@id='question0']"))
	private WebElement SecurityQ1;
	
	@FindBy(xpath=("//input[@id='answer0']"))
	private WebElement Q1_Ans;
	
	@FindBy(xpath=("//select[@id='question1']"))
	private WebElement SecurityQ2;
	
	@FindBy(xpath=("//input[@id='answer1']")) 
	private WebElement Q2_Ans;
	
	@FindBy(xpath=("//select[@id='question2']")) 
	private WebElement SecurityQ3;
	
	@FindBy(xpath=("//input[@id='answer2']"))
	private WebElement Q3_Ans;
	
	@FindBy(xpath=("//a[contains(text(),'IBLLC - Standalone PortfolioAnalyst Subscriber Agr')]"))
	private WebElement AgreementValue;
	
	@FindBy(xpath=("//button[@id='paAgreement_positive']")) 
	private WebElement AgreeBtn;
	
	@FindBy(xpath=("//button[@id='accountCreationButton']")) 
	private WebElement CreateAcc;
	
	@FindBy(xpath=("//strong[normalize-space()='Check your email and confirm your email address']"))
	 private WebElement EmailConfirmPage;
	
	
	
	public NewAccountCreation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		
        public String getCurrentUrl(WebDriver driver) {
            Utility.wait(1000, driver);
            return driver.getCurrentUrl();
        }

        public void enterEmail(String emailAddress) {
            emailInput.sendKeys(emailAddress);
        }

        public void enterUsername(String username) {
            usernameInput.sendKeys(username);
        }

        public void enterPassword(String password) {
            passwordInput.sendKeys(password);
        }

        public void enterConfirmPassword(String password,WebDriver driver) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].removeAttribute('disabled')", confirmPasswordInput);
            confirmPasswordInput.sendKeys(password);
        }

        public void selectCountry(String country,WebDriver driver) {
            Actions act = new Actions(driver);
            act.click(countryDropdown);
            act.sendKeys(country).perform();
            act.sendKeys(Keys.ENTER).perform();
        }

        public void enterFirstName(String firstName) {
            firstNameInput.sendKeys(firstName);
        }

        public void enterLastName(String lastName) {
            lastNameInput.sendKeys(lastName);
        }

        public void enterDateOfBirth(String dateOfBirth) {
            dateOfBirthInput.sendKeys(dateOfBirth);
        }

        public void selectSecurityQuestion1(String question, String answer) {
        Select s1 = new Select(SecurityQ1);
		s1.selectByValue("In what city were you married?");
		Q1_Ans.sendKeys("Delhi");
		
        }
		
		public void selectSecurityQuestion2(String question, String answer) {
		Select s2 = new Select(SecurityQ2);
		s2.selectByValue("What was the name of your first pet?");
		Q2_Ans.sendKeys("Sweetu");
		}
		
		public void selectSecurityQuestion3(String question, String answer) {
		Select s3 = new Select(SecurityQ3);
		s3.selectByValue("What is your favorite cartoon character?");
		Q3_Ans.sendKeys("ninja Hatodi");
	}
		
        public boolean isAgreeButtonDisplayed() {
	    boolean AgreeBtnResult = AgreeBtn.isDisplayed();
		return AgreeBtnResult ;
	}
		
		
		public String agreementLink() throws InterruptedException {
			AgreementValue.click();
			String agreetext = AgreementValue.getText();
			return agreetext;
			}
		
		public void clickAgree() throws InterruptedException {
		AgreeBtn.click();
		}
		
		public  boolean confirmationOfAccount() {
			return EmailConfirmPage.isDisplayed();
		}
		public void clickCreateNewBtn() throws InterruptedException {
			CreateAcc.click();
			}
		
		public String getConfirmPage(WebDriver driver) {
			Utility.wait(5000, driver);
	        return EmailConfirmPage.getText();
	    }
		
		
	}
	 
