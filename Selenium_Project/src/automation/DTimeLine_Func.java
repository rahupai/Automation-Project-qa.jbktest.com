package automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DTimeLine_Func {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.qa.jbktest.com/online-exam#Testing");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[text()=\"Manual Testing(ISTQB)\"]")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.id("countbtn")).click();
        driver.findElement(By.id("loginmobile")).sendKeys("8734678910");
        driver.findElement(By.id("loginbtn")).click();
        driver.findElement(By.partialLinkText("Account")).click();
        
        WebElement timeLinefunc =driver.findElement(By.xpath("//div[@class=\"card card-stats card-primary\"]//following::div[4]/a"));
        timeLinefunc.click();
        
	}

}


