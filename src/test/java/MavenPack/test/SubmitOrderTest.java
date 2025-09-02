package MavenPack.test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;


import MavenPack.basetestcomponents.BaseTest;
import MavenPack.pageobjects.CartPage;
import MavenPack.pageobjects.CheckoutPage;
import MavenPack.pageobjects.ConfirmationPage;
import MavenPack.pageobjects.LandingPage;
import MavenPack.pageobjects.OrderPage;
import MavenPack.pageobjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest {
	String productName ="ZARA COAT 3";
	
	//converted public static void main to testng test.
	@Test(dataProvider="getData",groups={"Purchase"})   
	//public void  submitOrder(String email,String password,String productName) throws IOException, InterruptedException
	public void  submitOrder(HashMap<String,String> input) throws IOException, InterruptedException
	{

		//LandingPage lpage =launchApplication() ;
		// ProductCatalogue pdtcatpage =lpage.loginpage(email, password);
	    ProductCatalogue pdtcatpage =lpage.loginpage(input.get("email"),input.get("password"));
		List<WebElement> products = pdtcatpage.getProductList();
		//pdtcatpage.addProductToCart(productName);	
		pdtcatpage.addProductToCart(input.get("product"));	
		CartPage cartPage= pdtcatpage.goToCartPage();
	    //Boolean match = cartPage.VerifyProductDispaly(productName);
	    Boolean match = cartPage.VerifyProductDispaly(input.get("product"));
	    Assert.assertTrue(match);
	    CheckoutPage CheckoutPage = cartPage.GotoCheckout();
	    CheckoutPage.SelectCountry("india");
	    ConfirmationPage  confirmpageobj =  CheckoutPage.submitOrder();
	    
	    String confirmMessage= confirmpageobj.getConfirmationMessage(); 
	  Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		//driver.close();		
	}
	
	//order history track check if the product is in the list
	@Test(dependsOnMethods= {"submitOrder"})
	public void OrderHistoryTest()
	{
		//ZARA COAT 3
	    ProductCatalogue pdtcatpage =lpage.loginpage("keerthika@gmail.com", "Keerthika_2014");
		 OrderPage op  = pdtcatpage.goToOrdersPage();
		Assert.assertTrue(op.VerifyMyOrderListdispaly(productName));	
	}
	
	
	
	
//pass multiple data ,testrun with multiple data set
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String,String>> data = getJsonDataToMap("C:\\Eclipseworkproject\\SeleniumMavenFramework\\src\\test\\java\\MavenPack\\data\\PurchaseOrder.json"); 
		return new Object[][] {{data.get(0)},{data.get(0)}};	
	
	}
	
	
	
	
	//@DataProvider
	//public Object[][] getData() throws IOException
	//{
		
	/*	HashMap<Object,Object>  map =new HashMap<Object,Object>();
		map.put("email", "keerthika@gmail.com");
		map.put("password","Keerthika_2014");
		map.put("product", "ZARA COAT 3");
		
		
		HashMap<Object,Object>  map1 =new HashMap<Object,Object>();
		map1.put("email","saipallavi@gmail.com"	);
		map1.put("password","Iam_queen1");
		map1.put("product", "ADIDAS ORIGINAL"); */
		
		//List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"src//test//java//MavenPack//data//PurchaseOrder.json"); 
	
		//return new Object[][] {{data.get(0)},{data.get(0)}}; 
		//return new Object[][] {{map},{map1}}; 
		
		//return new Object[][] {{"keerthika@gmail.com", "Keerthika_2014","ZARA COAT 3"},{"saipallavi@gmail.com", "Iam_queen1","ADIDAS ORIGINAL"}};
		
	//}
	
	
}
