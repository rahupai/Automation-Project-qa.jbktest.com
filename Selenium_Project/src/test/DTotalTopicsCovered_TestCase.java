package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DTotalTopicsCovered_TestCase {

	WebDriver driver;
	
	@BeforeMethod
	public void browserSetting() {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver= new ChromeDriver();
        driver.get("https://www.qa.jbktest.com/online-exam#Testing");
        driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void checkTotalTopicsCoveredFunc() {
        driver.findElement(By.xpath("//*[text()=\"Manual Testing(ISTQB)\"]")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.id("countbtn")).click();
        driver.findElement(By.id("loginmobile")).sendKeys("8734678910");
        driver.findElement(By.id("loginbtn")).click();
        driver.findElement(By.partialLinkText("Account")).click();
        WebElement TotalTopics =driver.findElement(By.xpath("//div[@class=\"card card-stats card-pink\"]//following::div[4]/a"));
        TotalTopics.click();
        String expRes="https://www.qa.jbktest.com/topics-covered";
        String actRes=driver.getCurrentUrl();
        Assert.assertEquals(actRes, expRes);
	}
}








