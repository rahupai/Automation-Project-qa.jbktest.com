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

public class ContactUs_TestCase {
		
	WebDriver driver;

	@BeforeMethod
	public void browserSetting() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.qa.jbktest.com/online-exam#Testing");
		driver.manage().window().maximize();
	}
	
	@Test(priority = 1)
	public void checkContactUs() {
		driver.findElement(By.partialLinkText("Home")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame("webform");
		driver.findElement(By.xpath("//div[@id='webform_preview']/div")).click();
		driver.switchTo().defaultContent();
		WebElement contact = driver.findElement(By.xpath("//div[@class=\"subscribe row\"]//following::input"));
		JavascriptExecutor jsi = ((JavascriptExecutor) driver);
		jsi.executeScript("arguments[0].scrollIntoView(true);", contact);
		contact.sendKeys("Seli_Batch238@gmail.com");
		WebElement button = driver.findElement(By.name("mailUs"));
		button.click();
		
		String expRes="Mail Sent. We will contact you shortly."; 
		WebElement message=driver.findElement(By.xpath("//div[@class='mail-success']")); 
		String actRes=message.getText(); 
		Assert.assertEquals(actRes, expRes);
		 
	}

	@Test(priority = 2)
	public void checkEmptyEmail() {
		driver.findElement(By.partialLinkText("Home")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame("webform");
		driver.findElement(By.xpath("//div[@id='webform_preview']/div")).click();
		driver.switchTo().defaultContent();
		WebElement contact = driver.findElement(By.xpath("//div[@class=\"subscribe row\"]//following::input"));
		JavascriptExecutor jsi = ((JavascriptExecutor) driver);
		jsi.executeScript("arguments[0].scrollIntoView(true);", contact);
		WebElement button = driver.findElement(By.name("mailUs"));
		button.click();
		
		String expRes = "required";
		WebElement message = driver.findElement(By.xpath("//input[@name='email-mailUs']//following::span"));
		String actRes = message.getText();
		Assert.assertEquals(actRes, expRes);
	}

	@Test(priority = 3)
	public void checkInvalidEmail() {
		driver.findElement(By.partialLinkText("Home")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame("webform");
		driver.findElement(By.xpath("//div[@id='webform_preview']/div")).click();
		driver.switchTo().defaultContent();
		WebElement contact = driver.findElement(By.xpath("//div[@class=\"subscribe row\"]//following::input"));
		JavascriptExecutor jsj = ((JavascriptExecutor) driver);
		jsj.executeScript("arguments[0].scrollIntoView(true);", contact);
		contact.sendKeys("12345697562125451");
		WebElement button = driver.findElement(By.name("mailUs"));
		button.click();
		
		String expRes = "Mail Sent. We will contact you shortly.";
		WebElement message = driver.findElement(By.xpath("//div[@class='mail-success']"));
		String actRes = message.getText();
		Assert.assertEquals(actRes, expRes);
	}

}
