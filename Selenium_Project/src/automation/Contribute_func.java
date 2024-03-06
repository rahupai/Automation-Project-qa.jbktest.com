package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Contribute_func {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.qa.jbktest.com/online-exam#Testing");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Contribute")).click();
        driver.findElement(By.name("first_name")).sendKeys("RamPai");
        driver.findElement(By.name("email")).sendKeys("ram@gmail.com");
        driver.findElement(By.name("phone_number")).sendKeys("9867452376");
        WebElement dropdwn=driver.findElement(By.xpath("//select"));
        Select select = new Select(dropdwn);
        select.selectByIndex(0);
        driver.findElement(By.name("submit")).click();
	}

}








