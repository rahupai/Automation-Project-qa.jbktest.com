package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ViewAnswer_Testcase {
    
	WebDriver driver;
	
	@BeforeMethod
	public void browserSetting() {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver= new ChromeDriver();
        driver.get("https://www.qa.jbktest.com/online-exam#Testing");
        driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void checkViewAnswerFunc() {
        driver.findElement(By.xpath("//*[text()=\"Manual Testing(ISTQB)\"]")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.id("countbtn")).click();
        driver.findElement(By.id("loginmobile")).sendKeys("9767723975");
        driver.findElement(By.id("loginbtn")).click();
        
        for(int i=0;i<=8;i++) {
			WebElement next =driver.findElement(By.partialLinkText("Next"));
			JavascriptExecutor jsi = ((JavascriptExecutor) driver);
			jsi.executeScript("arguments[0].scrollIntoView(true);", next);
			next.click();
		}
		
		driver.findElement(By.partialLinkText("Submit")).click();
		driver.findElement(By.xpath("//div[@id=\"quizresult\"]/div[2]")).click();
		String expRes="Check Your Answers";
		WebElement ViewAnsTitle=driver.findElement(By.xpath("//div[@id='quizanswer']/h3"));
		String actRes=ViewAnsTitle.getText();
		Assert.assertEquals(actRes, expRes);
	}
	
}
