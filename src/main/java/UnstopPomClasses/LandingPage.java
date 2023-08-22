package UnstopPomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LandingPage {

	@FindBy(xpath=("//*[@id=\"s_menu\"]/app-root/div/app-menubar/div[1]/header/div[1]/div[1]/div[1]/img")) private WebElement Logo;
	@FindBy(xpath=("//*[@id=\"s_menu\"]/app-root/div/app-menubar/div[1]/header/div[1]/div[1]/div[2]/input")) private WebElement SearchBar;
	@FindBy(xpath=("//div[text()='Learn']")) private WebElement LearnTab;
	@FindBy(xpath=("//div[text()='Practice']")) private WebElement Practice;
	@FindBy(xpath=("//div[text()='Mentorship']")) private WebElement Mentorship;
	@FindBy(xpath=("//div[text()=' Compete ']")) private WebElement Compete;
	@FindBy(xpath=("//div[text()=' Jobs ']")) private WebElement jobs;
	@FindBy(xpath=("//div[text()=' Host ']")) private WebElement Host;
	@FindBy(xpath=("(//div[text()=' Login '])[1]")) private WebElement loginBtn;
	
	
	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public  boolean LogoVisibility() throws InterruptedException {
	  return Logo.isDisplayed();
     }
	public  boolean searchVisibility() throws InterruptedException {
		  return SearchBar.isDisplayed();
	     }
	public  boolean LearnVisibility() throws InterruptedException {
		  return LearnTab.isDisplayed();
	     }
	public  boolean PracticeVisibility() throws InterruptedException {
		  return Practice.isDisplayed();
	     }
	public  boolean MentorshipVisibility() throws InterruptedException {
		  return Mentorship.isDisplayed();
	     }
	public  boolean CompeteVisibility() throws InterruptedException {
		  return Compete.isDisplayed();
	     }
	public  boolean jobsVisibility() throws InterruptedException {
		  return jobs.isDisplayed();
	     }
	public  boolean HostVisibility() throws InterruptedException {
		  return Host.isDisplayed();
	     }
	public  boolean LoginBtnVisibility() throws InterruptedException {
		  return loginBtn.isDisplayed();
	     }
	 
}
