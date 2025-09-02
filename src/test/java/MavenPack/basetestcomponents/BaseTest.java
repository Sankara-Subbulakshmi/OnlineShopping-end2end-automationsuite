package MavenPack.basetestcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import MavenPack.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseTest
{  
	public WebDriver driver;
	public LandingPage lpage;
      
	public WebDriver initializeDriver(String browserName) throws IOException
	{
		
		//create global properties(on which browser our framework has to execute testcases)
		//properties class
		// Properties prop = new Properties();
		// FileInputStream ff = new FileInputStream(System.getProperty("user.dir")+"//src//main/java//MavenPack//resources//GlobalData.properties");
		 //FileInputStream ff = new FileInputStream("C:\\Eclipseworkproject\\SeleniumMavenFramework\\src\\main\\java\\MavenPack\\resources\\GlobalData.properties");
		 System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver-new\\chromedriver.exe" );
		 
		 //file to inputput stream
		// prop.load(ff); //parse the that file and extract key value pair from it.
		//String browserName =  prop.getProperty("browser");
		 
		 
	//	 String browserName  = System.getProperty("browser") !=null ? System.getProperty("browser") :prop.getProperty("browser");		 
		 if(browserName.equalsIgnoreCase("chrome"))
			{
			  driver = new ChromeDriver();			
			}
			if(browserName.equalsIgnoreCase("firefox"))
			{
			  driver = new FirefoxDriver();			
			}
			else if(browserName.equalsIgnoreCase("edge"))
			{
			  driver = new EdgeDriver();			
			}
			
			driver.manage().window().maximize();
			
			return driver;
	}
	
	
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException
	 {
		// FileUtils.readFileToString(new File("C:\\Eclipseworkproject\\SeleniumMavenFramework\\src\\test\\java\\MavenPack\\data\\PurchaseOrder.json ")); //read json to string
		 //read json to string
		 String jsonContent = FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
		 //string to hashmap jackson databind
		 
		 ObjectMapper mapper = new ObjectMapper();
		 List<HashMap<String , String>>  data= mapper.readValue(jsonContent, new TypeReference<List<HashMap<String ,String>>>()
		 {
		 });
		 
		 return data;
		 
		 //{map , map}
		 }
	
	public String  getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		
		TakesScreenshot ts =(TakesScreenshot)driver; 
		File source = ts.getScreenshotAs(OutputType.FILE);
		File ff = new File("C:\\Eclipseworkproject\\SeleniumMavenFramework\\Reports"+testCaseName+".png" );
		FileUtils.copyFile(source,ff);
		return "C:\\Eclipseworkproject\\SeleniumMavenFramework\\Reports"+testCaseName+".png";
	}
	
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException
	{
		driver = initializeDriver("chrome");
         lpage =new LandingPage(driver);
		//LandingPage lpage =new LandingPage(driver);
		 
		lpage.goTo();
		return lpage;		
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
		
	}
	
	
	
	
	
	
}
