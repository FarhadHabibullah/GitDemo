package PlaintTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Planit.base;
import pageObject.ShopPage;

public class TestCase4 extends base{
	public WebDriver driver;
	
	@Test
	public void planitAssessment4() throws IOException {
		
		
		driver = initializerDriver();
		driver.get(prop.getProperty("url"));
		//from the home page go to shop page
		ShopPage sp = new ShopPage(driver);
		sp.getShopButton().click();
		
		
		//click buy button twice on "funny cow"
		WebElement fcb = sp.funnyCowBuyButton();
		for (int i = 1; i < 3; i++) {
			fcb.click(); 
		}
		
		
		//click buy button once on "fluffy bunny"
		sp.fluffyBunnyBuyButton().click();
			
		
		//click the cart menu
		sp.getCartButton().click();
		
		
		//verify items are in the cart
		
		String gfci = sp.getFunnyCowInCart().getText();
		Assert.assertEquals(gfci, "Funny Cow&^%$#@!");
		
		String gfbi = sp.getFluffyBunnyInCart().getText();
		Assert.assertEquals(gfbi, "Fluffy Bunny");
		
		driver.close();
		
	}
	
}
