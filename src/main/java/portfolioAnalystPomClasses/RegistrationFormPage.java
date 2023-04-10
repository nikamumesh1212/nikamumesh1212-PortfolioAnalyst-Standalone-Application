package portfolioAnalystPomClasses;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationFormPage {
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
	
	@FindBy(xpath=("//p[normalize-space()='Invalid']")) 
	private WebElement EmailError;

	@FindBy(xpath=("//body//div[@class='main-wrapper']//div[@class='row']//div[@class='row']//div[2]//p[1]")) 
     private WebElement CountryError;
	
	@FindBy(xpath=("//div[13]//div[1]//div[1]//div[1]//p[1]")) 
	private WebElement FirstNameError;
	
	
	
	public RegistrationFormPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void enterEmailAddress(String email) throws InterruptedException {
        emailInput.clear();
        emailInput.sendKeys(email);
        emailInput.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }

    public boolean isEmailErrorDisplayed() {
      return EmailError.isDisplayed();
    }

    
    public String getSelectedCountry(WebDriver driver) {
    	Actions actions = new Actions(driver);
        actions.moveToElement(countryDropdown).click().sendKeys("United States").sendKeys(Keys.ENTER).perform();
        String selectedCountry = countryDropdown.getAttribute("value");
        return selectedCountry;
  }

    public boolean isFirstNameErrorDisplayed(WebDriver driver) throws InterruptedException {    
      return FirstNameError.isDisplayed();
    }
    public String isCountryErrorDisplayed(){
       return CountryError.getText();
   }
//
//    public void enterLastName(String lastName) {
//        WebElement lastNameInput = driver.findElement(By.id("last-name"));
//        lastNameInput.clear();
//        lastNameInput.sendKeys(lastName);
//    }
//
//    public boolean isLastNameErrorDisplayed() {
//        WebElement lastNameError = driver.findElement(By.id("last-name-error"));
//        return lastNameError.isDisplayed();
//    }
//
//    public void enterDateOfBirth(String dateOfBirth) {
//        WebElement dateOfBirthInput = driver.findElement(By.id("date-of-birth"));
//        dateOfBirthInput.clear();
//        dateOfBirthInput.sendKeys(dateOfBirth);
//    }
//
//    public boolean isDateOfBirthErrorDisplayed() {
//        WebElement dateOfBirthError = driver.findElement(By.id("date-of-birth-error"));
//        return dateOfBirthError.isDisplayed();
//    }
//
//    public void enterSecurityQuestionOne(String question) {
//        WebElement securityQuestionOneSelect = driver.findElement(By.id("security-question-one"));
//        Select questionSelect = new Select(securityQuestionOneSelect);
//        questionSelect.selectByVisibleText(question);
//    }
//
//    public void enterSecurityQuestionOneAnswer(String answer) {
//        WebElement securityQuestionOneAnswerInput = driver.findElement(By.id("security-question-one-answer"));
//        securityQuestionOneAnswerInput.clear();
//        securityQuestionOneAnswerInput.sendKeys(answer);
//    }
//
//    public void enterSecurityQuestionTwo(String question) {
//        WebElement securityQuestionTwoSelect = driver.findElement(By.id("security-question-two"));
//        Select questionSelect = new Select(securityQuestionTwoSelect);
//        questionSelect.selectByVisibleText(question);
//    }
//    public void enterSecurityQuestionThree(String question) {
//        WebElement securityQuestionOneSelect = driver.findElement(By.id("security-question-one"));
//        Select questionSelect = new Select(securityQuestionOneSelect);
//        questionSelect.selectByVisibleText(question);
//    }
//
//    public void enterSecurityQuestionThreeAnswer(String answer) {
//     //   WebElement securityQuestionOneAnswerInput = driver.findElement(By.id("security-question-one-answer"));
//        securityQuestionOneAnswerInput.clear();
//        securityQuestionOneAnswerInput.sendKeys(answer);
//    }
    
        public  boolean PasswordMatch() {
        	return passwordInput.getText().contains(confirmPasswordInput.getText());
        }
		

}