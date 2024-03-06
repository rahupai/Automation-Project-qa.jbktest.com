package automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Video_Func {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.qa.jbktest.com/online-exam#Testing");
        driver.manage().window().maximize();
        driver.findElement(By.partialLinkText("Home")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.switchTo().frame("webform");
        driver.findElement(By.xpath("//div[@id='webform_preview']/div")).click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame(0);
        WebElement playvid=driver.findElement(By.className("ytp-cued-thumbnail-overlay"));
        JavascriptExecutor jsi = ((JavascriptExecutor) driver);
		jsi.executeScript("arguments[0].scrollIntoView(true);", playvid);
		driver.findElement(By.xpath("//div[@class=\"ytp-cued-thumbnail-overlay\"]/button")).click();
	
	}

}

		
		