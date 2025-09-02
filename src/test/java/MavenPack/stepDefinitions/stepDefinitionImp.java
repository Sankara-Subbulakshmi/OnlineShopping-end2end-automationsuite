package MavenPack.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import MavenPack.basetestcomponents.BaseTest;
import MavenPack.pageobjects.CartPage;
import MavenPack.pageobjects.CheckoutPage;
import MavenPack.pageobjects.ConfirmationPage;
import MavenPack.pageobjects.LandingPage;
import MavenPack.pageobjects.ProductCatalogue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinitionImp extends BaseTest
{
    public LandingPage lpage;
    public  ProductCatalogue pdtcatpage;
    public  ConfirmationPage  confirmpageobj;
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException 
	
	{
		lpage =launchApplication();	
	}
	
	
	 @Given("^Logged in with username (.+) and password (.+)$")
	 public void logged_in_username_and_password(String username , String password)
	 {
		pdtcatpage =lpage.loginpage(username,password); 	 
	 }
	 
	 @When("^I add the product(.+) to Cart$")
	 public void I_add_product_to_cart(String productName) throws InterruptedException
	 {
			List<WebElement> products = pdtcatpage.getProductList();
			pdtcatpage.addProductToCart(productName);	 
	 }
	@When("^Checkout (.+) and submit the order $")
	public void checkout_submit_order(String productName )
	{
		CartPage cartPage= pdtcatpage.goToCartPage();
	    Boolean match = cartPage.VerifyProductDispaly(productName);
	    Assert.assertTrue(match);
	    CheckoutPage CheckoutPage = cartPage.GotoCheckout();
	    CheckoutPage.SelectCountry("india");
	   confirmpageobj =  CheckoutPage.submitOrder();	
	}
	
	@Then("{string} message is displayed on Confirmation Page")
	public void message_displayed_confirmationPage(String string)
	{
	      String confirmMessage= confirmpageobj.getConfirmationMessage(); 
		  Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		  driver.close();
	}
	@Then("{string} message is displayed")
	public void errror_msg_display(String str)
	{
		  Assert.assertEquals("Incorrect email  password.", lpage.getErrorMessage());
		  driver.close();
	}
	
}
