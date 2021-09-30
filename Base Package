package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadExcel;


public class ProjectSpecificMethods {

	
	public ChromeDriver driver;
	public String excelFileName;
	//public static Properties prop;
	public static ExtentHtmlReporter reporter;
	public static ExtentReports  extent;
	public static ExtentTest test, node;
	
	public String testName, testDescription, testAuthor, testCategory;
	
	
	@BeforeSuite
	public void startReport() {	
		reporter = new ExtentHtmlReporter("./reports/results.html");
		reporter.setAppendExisting(true);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		
	}
	@BeforeClass
	public void testDetails() {
		// add testcase information: testcase name and description
		
		test = extent.createTest(testName,testDescription);		
		// add category and author info to testCase
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);		
	}
	
	public int takeSnap() throws IOException{
		
		int ranNum = (int) (Math.random() *9999);
		File source = driver.getScreenshotAs(OutputType.FILE);
		File target = new File("./snaps/img" +ranNum+ ".png");
		FileUtils.copyFile(source, target);
		return ranNum;
	}
	
	public void reportStep(String msg, String status) throws IOException {
		if(status.equalsIgnoreCase("pass")) {			
			node.pass(msg, MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img" +takeSnap()+  ".jpg").build());
		}
		else if(status.equalsIgnoreCase("fail")) {
			node.fail(msg, MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img" +takeSnap()+  ".jpg").build());
			throw new RuntimeException();
		}
		
	}
	
	
	@DataProvider(name = "fetchData")
	public String[][] sendData() throws IOException {
		return ReadExcel.excelRead(excelFileName);
	}
	
	@Parameters({"url"})
	@BeforeMethod
	public void startApp(String url) throws IOException {
		
		node = test.createNode(testName);
		/*FileInputStream fis = new FileInputStream("./src/main/resources/english.properties");							
		Properties prop = new Properties();
		prop.load(fis);*/
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@AfterMethod
	public void closeBrowser() {		
		driver.close();
	}
	
	@AfterSuite
	public void endReport() {		
		extent.flush();
	}
	
}
