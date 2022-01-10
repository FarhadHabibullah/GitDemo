package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShopPage {
	
	public WebDriver driver;
	
	private By shopButton = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]");
	private By funnyCow = By.xpath("//*[@id=\"product-6\"]/div/p/a");
	private By fluffyBunny = By.xpath("//*[@id=\"product-4\"]/div/p/a");
	private By cartButton = By.xpath("//*[@id=\"nav-cart\"]/a");
	private By funnyCowInCart = By.xpath("//tr[@ng-repeat='item in cart.items()'][1]/td[1]");
	private By fluffyBunnyInCart = By.xpath("//tr[@ng-repeat='item in cart.items()'][2]/td[1]");
	
	
	public ShopPage(WebDriver driver) {
		this.driver = driver;
	}




	public WebElement getShopButton() {
		return driver.findElement(shopButton);
	}
	
	
	public WebElement funnyCowBuyButton() {
		return driver.findElement(funnyCow);
	}
	
	public WebElement fluffyBunnyBuyButton() {
		return driver.findElement(fluffyBunny);
	}
	
	public WebElement getCartButton() {
		return driver.findElement(cartButton);
	}
	
	public WebElement getFunnyCowInCart() {
		return driver.findElement(funnyCowInCart);
	}
	
	public WebElement getFluffyBunnyInCart() {
		return driver.findElement(fluffyBunnyInCart);
	}

}
