package MavenPack.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import MavenPack.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent 
{
	    WebDriver driver;
	   @FindBy(css =".cartSection h3")
	    private List<WebElement> cartProducts;
	    
	    @FindBy(css =".totalRow button")
	    WebElement checkoutele;
	    
	public CartPage(WebDriver driver)
	{
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}
		
	public Boolean VerifyProductDispaly(String productName)
	{
	
		   Boolean match = cartProducts.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
		   return match;
	}
	
	public CheckoutPage GotoCheckout()
	{
		checkoutele.click();
		return new CheckoutPage(driver);
		
	}
	
}
