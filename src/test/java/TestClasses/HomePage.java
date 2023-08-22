package TestClasses;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.Base;
import UnstopPomClasses.LandingPage;

public class HomePage extends Base {
	LandingPage lp;
		@BeforeMethod
		public void Launch() throws IOException, InterruptedException {
			Thread.sleep(5000);
			LaunchUrl();
		lp = new LandingPage(driver);
	}
	  @Test
	  public void logo() throws IOException, InterruptedException {
		 AssertJUnit.assertTrue(lp.LogoVisibility());
		 }
	  @Test
	  public void seach() throws IOException, InterruptedException {
		 AssertJUnit.assertTrue(lp.searchVisibility());
		 }
	  @Test
	  public void learn() throws IOException, InterruptedException {
		 AssertJUnit.assertTrue(lp.LearnVisibility());
		 }
	  @Test
	  public void practice() throws IOException, InterruptedException {
		 AssertJUnit.assertTrue(lp.PracticeVisibility());
		 }
	   @Test
	  public void  mentership() throws IOException, InterruptedException {
		 AssertJUnit.assertTrue(lp.MentorshipVisibility());
		 }@Test
	  public void compete() throws IOException, InterruptedException {
		 AssertJUnit.assertTrue(lp.CompeteVisibility());
		 }
		 @Test
	  public void jobs() throws IOException, InterruptedException {
		 AssertJUnit.assertTrue(lp.jobsVisibility());
		 }@Test
	  public void host() throws IOException, InterruptedException {
		 AssertJUnit.assertTrue(lp.HostVisibility());
		 }@Test
	  public void login() throws IOException, InterruptedException {
		 AssertJUnit.assertTrue(lp.LoginBtnVisibility());
		 }
	  
	  @AfterMethod
	  public void closeBrower() {
		  driver.close();
	  }
	}
