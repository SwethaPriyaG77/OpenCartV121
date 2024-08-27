package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{
	
	
	
	@Test(groups ={"Sanity" ,"Master"})
	public void verify_login() {
		
		logger.info("******Starting TC_002_LoginTest*****" );
		
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link");
		hp.clickLogin();
		logger.info("Clicked on Login Link");
		
		
		LoginPage lp = new LoginPage(driver);
		logger.info("Entering the valid Details");
		lp.setEmail(prop.getProperty("email"));
		lp.setPassword(prop.getProperty("password"));
		lp.clickLogin();
		
		logger.info("Validating My Account Page");
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetPage =macc.isMyAccountPageExists();
		
		Assert.assertEquals(targetPage, true, "LoginFailed");
		
		}
		catch(Exception e)
		{
		Assert.fail();
		
		}
		logger.info("******Executed TC_002_LoginTest*****" );
	}
	
	
	
	

}
