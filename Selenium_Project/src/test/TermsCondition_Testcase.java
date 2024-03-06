package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TermsCondition_Testcase {

	WebDriver driver;
	
	@BeforeMethod
	public void browserSetting() {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver= new ChromeDriver();
        driver.get("https://www.qa.jbktest.com/online-exam#Testing");
        driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void verifyTermsConditionFunc() {
		driver.findElement(By.xpath("//*[text()=\"Manual Testing(ISTQB)\"]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("countbtn")).click();
		driver.findElement(By.id("signup-tab")).click();
		driver.findElement(By.linkText("Terms of Service and Privacy Policy.")).click();
		String expRes="https://www.qa.jbktest.com/terms-and-conditions";
		String actRes=driver.getCurrentUrl();
		Assert.assertEquals(actRes,expRes);
	}

}
