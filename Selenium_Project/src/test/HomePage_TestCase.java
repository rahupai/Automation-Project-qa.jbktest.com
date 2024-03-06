package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePage_TestCase {

	WebDriver driver;

	@BeforeMethod
	public void browserSetting() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.qa.jbktest.com/online-exam#Testing");
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void checkHomePageFunc() {
		driver.findElement(By.partialLinkText("Home")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.switchTo().frame("webform");
		WebElement email = driver.findElement(By.name("webform[email]"));
		email.sendKeys("selen@gmail.com");
		driver.findElement(By.xpath("//*[text()=\"SEND ME STUDY STUFF!\"]")).click();
		String expRes = "https://www.qa.jbktest.com/";
		String actRes = driver.getCurrentUrl();
		Assert.assertEquals(actRes, expRes);
	}
	
	@Test(priority = 2)
	public void checkInvalidEmailField() {
		driver.findElement(By.partialLinkText("Home")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.switchTo().frame("webform");
		WebElement email = driver.findElement(By.name("webform[email]"));
		email.sendKeys("1238#$%^^&0977");
		driver.findElement(By.xpath("//*[text()=\"SEND ME STUDY STUFF!\"]")).click();
		String expRes = "Email address is invalid.";
		WebElement emailErrMsg =driver.findElement(By.xpath("//*[text()='Email address is invalid.']"));
		String actRes = emailErrMsg.getText();
		Assert.assertEquals(actRes, expRes);
	}

	@Test(priority = 3)
	public void checkEmptyEmailField() {
		driver.findElement(By.partialLinkText("Home")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.switchTo().frame("webform");
		driver.findElement(By.xpath("//*[text()=\"SEND ME STUDY STUFF!\"]")).click();
		String expRes = "Email address is invalid.";
		WebElement emailErrMsg =driver.findElement(By.xpath("//*[text()='Email address is invalid.']"));
		String actRes = emailErrMsg.getText();
		Assert.assertEquals(actRes, expRes);
	}
	
	@Test(priority = 4)
	public void checkHomePageSyllabus() {
		driver.findElement(By.partialLinkText("Home")).click();
		WebElement syllabus = driver.findElement(By.linkText("Syllabus"));
		syllabus.click();
		String expRes = "Syllabus page";
		String actRes=driver.getTitle();
	    Assert.assertEquals(actRes, expRes);
	}

	@Test(priority=5)
	public void checkHomePageInterviewQuestion() {
		driver.findElement(By.partialLinkText("Home")).click();
		WebElement question = driver.findElement(By.linkText("Interview Question"));
		question.click();
		String expRes = "Interview Question";
		String actRes=driver.getTitle();
	    Assert.assertEquals(actRes, expRes);
	}

	@Test(priority=6)
	public void checkHomePageContactUs() {
		driver.findElement(By.partialLinkText("Home")).click();
		WebElement contactUs = driver.findElement(By.linkText("Contact Us"));
		contactUs.click();
		String expRes = "Contact Us page";
		String actRes=driver.getTitle();
	    Assert.assertEquals(actRes, expRes);
	}

	@Test(priority=7)
	public void checkHomePageLiveVidos() {
		driver.findElement(By.partialLinkText("Home")).click();
		WebElement livevid = driver.findElement(By.linkText("Live Videos"));
		livevid.click();
		String expRes = "Live Videos page";
		String actRes=driver.getTitle();
	    Assert.assertEquals(actRes, expRes);
	}

	@Test(priority=8)
	public void checkHomePageTutorails() {
		driver.findElement(By.partialLinkText("Home")).click();
		WebElement tutorial = driver.findElement(By.linkText("Tutorials"));
		tutorial.click();
		String expRes = "Tutorials page";
		String actRes=driver.getTitle();
	    Assert.assertEquals(actRes, expRes);
	}

}



