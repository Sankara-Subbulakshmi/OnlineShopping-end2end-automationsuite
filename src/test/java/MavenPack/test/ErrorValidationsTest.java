package MavenPack.test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import MavenPack.basetestcomponents.BaseTest;
import MavenPack.basetestcomponents.Retry;
import MavenPack.pageobjects.CartPage;
import MavenPack.pageobjects.CheckoutPage;
import MavenPack.pageobjects.ConfirmationPage;
import MavenPack.pageobjects.LandingPage;
import MavenPack.pageobjects.ProductCatalogue;

public class ErrorValidationsTest extends BaseTest 
{

	//converted public static void main to testng test.
	@Test(groups= {"ErrorHandling"},retryAnalyzer =Retry.class )   
	public void  LoginErrorValidation() throws IOException, InterruptedException
	{
	
	   lpage.loginpage("keerthika@gmail.com", "Keerthika");//wrong password given
	    lpage.getErrorMessage();
	    Assert.assertEquals("Incorrect email  password.", lpage.getErrorMessage());
	   // Assert.assertEquals("Incorrect email or password.", lpage.getErrorMessage());
	    //use selector hub , copy relative xpath
   //div[@aria-label='Incorrect email or password.']
	  //expected,actual
   }
	
	@Test   
	public void  ProductErrorValidation() throws IOException, InterruptedException
	{
		String pdt ="ZARA COAT 3";
		//LandingPage lpage =launchApplication() ;
	    ProductCatalogue pdtcatpage =lpage.loginpage("saipallavi@gmail.com", "Iam_queen1");
		List<WebElement> Products = pdtcatpage.getProductList();
		pdtcatpage.addProductToCart(pdt);	
		CartPage cp = pdtcatpage.goToCartPage();
	    Boolean match = cp.VerifyProductDispaly("ZARA COAT 33");
	    Assert.assertFalse(match);
	}  
	
}
		
	//all error validation related to login page
    //(total 5 tc in login page error validation)@test,@test,@test,@test,@test
    //include those 5 tc in one file. 
	
	

//organize import , unneccessary imports are gone.