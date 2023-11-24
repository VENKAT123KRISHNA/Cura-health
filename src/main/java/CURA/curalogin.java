package CURA;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.bouncycastle.util.test.TestResult;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.aventstack.extentreports.model.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class curalogin {
  
	//WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	
	public  void valid() {
		
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
		driver.findElement(By.id("txt-username")).sendKeys("John Doe");
		driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
		driver.findElement(By.id("btn-login")).click();
		}
		
	@Test
	
	public void	invalids() throws IOException {
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
		driver.findElement(By.id("txt-username")).sendKeys("John Doe");
		driver.findElement(By.id("txt-password")).sendKeys("John Doe");//ThisIsNotAPassword
		driver.findElement(By.id("btn-login")).click();
		}
	
	@AfterMethod
	
	public void takeScreenshotOnFailure() {
		
		if(TestResult.getStatus()==ITestResult.FAILURE)
		{	
			
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("Errorscreenshots\\" +TestResult.getname() + "-"+".png"));
	}
	
	
}	
}
