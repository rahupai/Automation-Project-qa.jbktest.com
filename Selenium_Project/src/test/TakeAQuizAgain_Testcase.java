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

public class TakeAQuizAgain_Testcase {

	WebDriver driver;

	@BeforeMethod
	public void browserSetting() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.qa.jbktest.com/online-exam#Testing");
		driver.manage().window().maximize();
	}

	@Test(priority=1)
	public void verifyTakeAQuizAgainFunc() {
		driver.findElement(By.xpath("//*[text()=\"Manual Testing(ISTQB)\"]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("countbtn")).click();
		driver.findElement(By.id("loginmobile")).sendKeys("8734678910");
		driver.findElement(By.id("loginbtn")).click();

		for (int i = 0; i <= 8; i++) {
			WebElement next = driver.findElement(By.partialLinkText("Next"));
			JavascriptExecutor jsi = ((JavascriptExecutor) driver);
			jsi.executeScript("arguments[0].scrollIntoView(true);", next);
			next.click();
		}

		driver.findElement(By.partialLinkText("Submit")).click();
		driver.findElement(By.xpath("//div[@id=\"quizresult\"]/div[2]")).click();
		WebElement submitbtn = driver.findElement(By.xpath("//*[text()=\"Take a Quiz Again\"]"));
		JavascriptExecutor jsbtn = ((JavascriptExecutor) driver);
		jsbtn.executeScript("arguments[0].scrollIntoView(true);", submitbtn);
		submitbtn.click();
		
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		
		String expRes = "https://www.qa.jbktest.com/online-exam#";
		String actRes=driver.getCurrentUrl();
		Assert.assertEquals(actRes, expRes);

	}

}
