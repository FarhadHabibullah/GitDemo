package PlaintTest;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Planit.base;
import pageObject.ContactPage;
import pageObject.LandingPage;

public class TestCase3 extends base {
	public WebDriver driver;
	@Test (dataProvider = "getData2")
	public void planitAssessment3(String UserName,String Email,String Text) throws IOException {

		driver = initializerDriver();
		Logger log = LogManager.getLogger(base.class.getName());
		
		
		driver.get(prop.getProperty("url"));
		log.info("navigate to homepage");
		
		
		// from the home page go to contact page
		LandingPage lp = new LandingPage(driver);
		lp.getContactButton().click();
		log.info("clicking contact button");
		
		
		// populate mandatory fields with invalid data
		ContactPage cp = new ContactPage(driver);
		cp.getForeName().sendKeys(UserName);
		cp.getEmail().sendKeys(Email);
		cp.getMessage().sendKeys(Text);
		log.info("sending invalid data");
		
		//validate errors
		String maid = cp.getMessageAfterInvalidData().getText();
		Assert.assertEquals(maid, "We welcome your feedback - but we won't get it unless you complete the form correctly.");	
		log.info("validate error");
		
		driver.close();
		
	} 
	
	@DataProvider
	public Object[][] getData2() {
		
		Object[][] data = new Object[1][3];
		data[0][0] = "1234";
		data[0][1] = "farhad.inaus@gmail.";
		data[0][2] = "Invalid input";
		
		
		return data;
	
	}
}
