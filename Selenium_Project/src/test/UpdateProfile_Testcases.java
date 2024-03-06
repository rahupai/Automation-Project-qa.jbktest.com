package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UpdateProfile_Testcases {
     
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
        driver.findElement(By.id("loginmobile")).sendKeys("8745983478");
        driver.findElement(By.id("loginbtn")).click();
	}
	
	@Test(priority=1)
	public void checkValidUserProfile() {
        driver.findElement(By.partialLinkText("Account")).click();
        driver.findElement(By.xpath("//*[text()=\"View Profile \"]")).click();
        WebElement name =driver.findElement(By.id("name"));
        name.clear();
        name.sendKeys("Sel_Project_Batch238");
        WebElement email =driver.findElement(By.id("emailid"));
        email.clear();
        email.sendKeys("Sel_Project_Batch238");
        WebElement Mobile =driver.findElement(By.id("mobile"));
        Mobile.clear();
        Mobile.sendKeys("8745983478");
        driver.findElement(By.id("updatebtn")).click();
        String expRes="Profile successfully updated";
        WebElement msg=driver.findElement(By.xpath("//form[@id='profile']//following::div[1]"));
        String actRes=msg.getText();
        Assert.assertEquals(actRes,expRes);
	}
}
