package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Contribute_Testcase {
    WebDriver driver;
	
	@BeforeMethod
	public void browswerSetting() {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver= new ChromeDriver();
        driver.get("https://www.qa.jbktest.com/online-exam#Testing");
        driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void verifyContributeFunc() {
        driver.findElement(By.linkText("Contribute")).click();
        driver.findElement(By.name("first_name")).sendKeys("RamPai");
        driver.findElement(By.name("email")).sendKeys("ram@gmail.com");
        driver.findElement(By.name("phone_number")).sendKeys("9867452376");
        WebElement dropdwn=driver.findElement(By.xpath("//select"));
        Select select = new Select(dropdwn);
        select.selectByIndex(0);
        driver.findElement(By.name("submit")).click();
        String expRes="https://www.qa.jbktest.com/contribute";
        String actRes=driver.getCurrentUrl();
        Assert.assertEquals(actRes, expRes);
	}
	
	
}
