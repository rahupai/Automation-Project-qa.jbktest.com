package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TakeAQuiz_TestCase {
	WebDriver driver;

	@BeforeMethod
	public void browserSetting() {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver= new ChromeDriver();
        driver.get("https://www.qa.jbktest.com/online-exam#Testing");
        driver.manage().window().maximize();
	}
	
	@Test(priority = 1)
	public void checkTakeAQuiz() {
		driver.findElement(By.xpath("//*[text()=\"Manual Testing(ISTQB)\"]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("countbtn")).click();
		driver.findElement(By.id("loginmobile")).sendKeys("9767723975");
		driver.findElement(By.id("loginbtn")).click();
		String expRes="Manual Testing(ISTQB) Quiz";
        WebElement QuizTitle=driver.findElement(By.xpath("//div[@id='questions']/h3"));
        String actRes=QuizTitle.getText();
        Assert.assertEquals(actRes, expRes);
	}

	@Test(priority = 2)
	public void checkNoQuestionQuiz() {
		driver.findElement(By.xpath("//*[text()='Listeners']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("countbtn")).click();
		driver.findElement(By.id("loginmobile")).sendKeys("9767723975");
		driver.findElement(By.id("loginbtn")).click();
		String expRes="Sorry!!! No Questions Found";
        WebElement QuizTitleError=driver.findElement(By.xpath("//div[@id='noquestion']/h3"));
        String actRes=QuizTitleError.getText();
        Assert.assertEquals(actRes, expRes);
	}
}
