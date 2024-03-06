package automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Download_Func {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.qa.jbktest.com/online-exam#Testing");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[text()=\"Manual Testing(ISTQB)\"]")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.id("countbtn")).click();
        driver.findElement(By.id("loginmobile")).sendKeys("4321765238");
        driver.findElement(By.id("loginbtn")).click();
        
		WebElement element = driver.findElement(By.xpath("//div[@id = \"choices\"]/div/label/div"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
		driver.findElement(By.partialLinkText("Next")).click();
        
		WebElement questionNum2 = driver.findElement(By.xpath("(//div[@id = \"choices\"])[2]/div/label/div"));
		JavascriptExecutor js2 = ((JavascriptExecutor) driver);
		js2.executeScript("arguments[0].scrollIntoView(true);", questionNum2);
		questionNum2.click();
		driver.findElement(By.partialLinkText("Next")).click();

		WebElement questionNum3 = driver.findElement(By.xpath("(//div[@id = \"choices\"])[3]/div/label/div"));
		JavascriptExecutor js3 = ((JavascriptExecutor) driver);
		js3.executeScript("arguments[0].scrollIntoView(true);", questionNum3);
		questionNum3.click();
		driver.findElement(By.partialLinkText("Next")).click();

		WebElement questionNum4 = driver.findElement(By.xpath("(//div[@id = \"choices\"])[4]/div/label/div"));
		JavascriptExecutor js4 = ((JavascriptExecutor) driver);
		js4.executeScript("arguments[0].scrollIntoView(true);", questionNum4);
		questionNum4.click();
		driver.findElement(By.partialLinkText("Next")).click();

		WebElement questionNum5 = driver.findElement(By.xpath("(//div[@id = \"choices\"])[5]/div/label/div"));
		JavascriptExecutor js5 = ((JavascriptExecutor) driver);
		js5.executeScript("arguments[0].scrollIntoView(true);", questionNum5);
		questionNum5.click();
		driver.findElement(By.partialLinkText("Next")).click();

		WebElement questionNum6 = driver.findElement(By.xpath("(//div[@id = \"choices\"])[6]/div/label/div"));
		JavascriptExecutor js6 = ((JavascriptExecutor) driver);
		js6.executeScript("arguments[0].scrollIntoView(true);", questionNum6);
		questionNum6.click();
		driver.findElement(By.partialLinkText("Next")).click();

		WebElement questionNum7 = driver.findElement(By.xpath("(//div[@id = \"choices\"])[7]/div/label/div"));
		JavascriptExecutor js7 = ((JavascriptExecutor) driver);
		js7.executeScript("arguments[0].scrollIntoView(true);", questionNum7);
		questionNum7.click();
		driver.findElement(By.partialLinkText("Next")).click();

		WebElement questionNum8 = driver.findElement(By.xpath("(//div[@id = \"choices\"])[8]/div/label/div"));
		JavascriptExecutor js8 = ((JavascriptExecutor) driver);
		js8.executeScript("arguments[0].scrollIntoView(true);", questionNum8);
		questionNum8.click();
		driver.findElement(By.partialLinkText("Next")).click();

		WebElement questionNum9 = driver.findElement(By.xpath("(//div[@id = \"choices\"])[9]/div/label/div"));
		JavascriptExecutor js9 = ((JavascriptExecutor) driver);
		js9.executeScript("arguments[0].scrollIntoView(true);", questionNum9);
		questionNum9.click();
		driver.findElement(By.partialLinkText("Next")).click();

		WebElement questionNum10 = driver.findElement(By.xpath("(//div[@id = \"choices\"])[10]/div/label/div"));
		JavascriptExecutor js10 = ((JavascriptExecutor) driver);
		js10.executeScript("arguments[0].scrollIntoView(true);", questionNum10);
		questionNum10.click();
		
		WebElement submitbutton = driver.findElement(By.partialLinkText("Submit"));
		JavascriptExecutor js11 = ((JavascriptExecutor) driver);
		js11.executeScript("arguments[0].scrollIntoView(true);", element);
		submitbutton.click();

		driver.findElement(By.linkText("Download Your Certificate")).click();
	}

}