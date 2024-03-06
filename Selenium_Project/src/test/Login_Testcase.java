package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login_Testcase {
    
    WebDriver driver;
	
	@BeforeMethod
	public void browserSetting() {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver= new ChromeDriver();
        driver.get("https://www.qa.jbktest.com/online-exam#Testing");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[text()=\"Manual Testing(ISTQB)\"]")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.id("countbtn")).click();
	}
	
	@Test(priority=1)
	public void checkvalidLogin() {
        driver.findElement(By.id("loginmobile")).sendKeys("8734678910");
        driver.findElement(By.id("loginbtn")).click();
        String expRes="Manual Testing(ISTQB) Quiz";
        WebElement QuizTitle=driver.findElement(By.xpath("//div[@id='questions']/h3"));
        String actRes=QuizTitle.getText();
        Assert.assertEquals(actRes, expRes);
	}
	
	@Test(priority=2)
	public void checkNotRegisteredLogin() {
        driver.findElement(By.id("loginmobile")).sendKeys("1122334488");
        driver.findElement(By.id("loginbtn")).click();
        String expRes="You have not registered with us. Please click signup tab to get registered";
        WebElement Loginerrmsg=driver.findElement(By.xpath("//div[@id='loginerr']"));
        String actRes=Loginerrmsg.getText(); 
        System.out.println(actRes);
        Assert.assertEquals(actRes, expRes);
	}
	
	@Test(priority=3)
	public void checkEmptyNumberLogin() {
	   driver.findElement(By.id("loginbtn")).click();
	   String expRes="Please enter valid mobile number, If you have not registered, please click signup tab to get registered.";
	   WebElement Loginerrmsg=driver.findElement(By.xpath("//div[@id='loginerr']"));
	   String actRes=Loginerrmsg.getText();
	   Assert.assertEquals(actRes, expRes);
	}
	
	@Test(priority=4)
	public void checkInvalidNumberRangeLogin() {
        driver.findElement(By.id("loginmobile")).sendKeys("112233448899890");
        driver.findElement(By.id("loginbtn")).click();
        String expRes="Please enter valid mobile number, If you have not registered, please click signup tab to get registered.";
        WebElement Loginerrmsg=driver.findElement(By.xpath("//div[@id='loginerr']"));
        String actRes=Loginerrmsg.getText();
        Assert.assertEquals(actRes, expRes); 
	}
	
	
	
}
