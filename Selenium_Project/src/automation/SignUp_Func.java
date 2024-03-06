package automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignUp_Func {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.qa.jbktest.com/online-exam#Testing");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[text()=\"Manual Testing(ISTQB)\"]")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.id("countbtn")).click();
        driver.findElement(By.id("signup-tab")).click();
        driver.findElement(By.id("name")).sendKeys("Selinium_Batch238");
        driver.findElement(By.id("emailid")).sendKeys("Selinium_Batch238@gmail.com");
        driver.findElement(By.id("mobile")).sendKeys("8734678910");
        driver.findElement(By.id("agree")).click();
        WebElement proceed=driver.findElement(By.id("emailbtn"));
        JavascriptExecutor jsi = ((JavascriptExecutor) driver);
		jsi.executeScript("arguments[0].scrollIntoView(true);", proceed);
        proceed.click();
	}

}
