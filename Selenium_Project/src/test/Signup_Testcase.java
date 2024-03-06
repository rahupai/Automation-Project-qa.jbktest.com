package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Signup_Testcase {

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
        driver.findElement(By.id("signup-tab")).click();
	}
	
	@Test(priority=1)
	public void checkValidSignup(){
        driver.findElement(By.id("name")).sendKeys("Selenium_Automation_Project_Batch238");
        driver.findElement(By.id("emailid")).sendKeys("Selinium_Project_automations_Batch238@gmail.com");
        driver.findElement(By.id("mobile")).sendKeys("3388226644");
        driver.findElement(By.id("agree")).click();
        WebElement proceed=driver.findElement(By.id("emailbtn"));
        JavascriptExecutor jsi = ((JavascriptExecutor) driver);
		jsi.executeScript("arguments[0].scrollIntoView(true);", proceed);
        proceed.click();
        String expRes="Manual Testing(ISTQB) Quiz";
        WebElement quizcon=driver.findElement(By.xpath("//div[@id='questions']/h3"));
        String actRes=quizcon.getText();
        Assert.assertEquals(actRes,expRes);
	}
	
	@Test(priority=2)
	public void checkInvalidName() {
        driver.findElement(By.id("name")).sendKeys("1234567890");
        driver.findElement(By.id("emailid")).sendKeys("Selinum_Project_Automated_Batch238@gmail.com");
        driver.findElement(By.id("mobile")).sendKeys("2299884466");
        driver.findElement(By.id("agree")).click();
        WebElement proceed=driver.findElement(By.id("emailbtn"));
        JavascriptExecutor jsi = ((JavascriptExecutor) driver);
		jsi.executeScript("arguments[0].scrollIntoView(true);", proceed);
        proceed.click();
        String expRes="Manual Testing(ISTQB) Quiz";
        WebElement quizcon=driver.findElement(By.xpath("//div[@id='questions']/h3"));
        String actRes=quizcon.getText();
        Assert.assertEquals(actRes,expRes);
	}
	
	@Test(priority=3)
	public void checkEmptyName() {
        driver.findElement(By.id("emailid")).sendKeys("Selinum_Project_Automat_Batch238@gmail.com");
        driver.findElement(By.id("mobile")).sendKeys("1034067091");
        driver.findElement(By.id("agree")).click();
        WebElement proceed=driver.findElement(By.id("emailbtn"));
        JavascriptExecutor jsi = ((JavascriptExecutor) driver);
		jsi.executeScript("arguments[0].scrollIntoView(true);", proceed);
        proceed.click();
        String expRes="Manual Testing(ISTQB) Quiz";
        WebElement quizcon=driver.findElement(By.xpath("//div[@id='questions']/h3"));
        String actRes=quizcon.getText();
        Assert.assertEquals(actRes,expRes);
	}
	
	@Test(priority=4)
	public void checkNameRangeSignup() {
        driver.findElement(By.id("name")).sendKeys("dtvydgfvdgvcgyvhfgryvyevgyeuceurvycyryerhurbrbyurryrhb");
        driver.findElement(By.id("emailid")).sendKeys("Selinum_Project_quiz_automat_Batch238@gmail.com");
        driver.findElement(By.id("mobile")).sendKeys("5599820163");
        driver.findElement(By.id("agree")).click();
        WebElement proceed=driver.findElement(By.id("emailbtn"));
        JavascriptExecutor jsi = ((JavascriptExecutor) driver);
		jsi.executeScript("arguments[0].scrollIntoView(true);", proceed);
        proceed.click();
        String expRes="Manual Testing(ISTQB) Quiz";
        WebElement quizcon=driver.findElement(By.xpath("//div[@id='questions']/h3"));
        String actRes=quizcon.getText();
        Assert.assertEquals(actRes,expRes);
	}
	
	@Test(priority=5)
	public void checkInvalidEmail() {
        driver.findElement(By.id("name")).sendKeys("Selenium_a_Project_Batch238");
        driver.findElement(By.id("emailid")).sendKeys("Selinum_Project_Batch238gmail.com");
        driver.findElement(By.id("mobile")).sendKeys("9933445566");
        driver.findElement(By.id("agree")).click();
        WebElement proceed=driver.findElement(By.id("emailbtn"));
        JavascriptExecutor jsi = ((JavascriptExecutor) driver);
		jsi.executeScript("arguments[0].scrollIntoView(true);", proceed);
        proceed.click();
        String expRes="Please enter valid email";
        WebElement quizcon=driver.findElement(By.xpath("//div[@id='emailerr']"));
        String actRes=quizcon.getText();
        Assert.assertEquals(actRes,expRes);
        //blank email gives the above error should be considered in same or new one
	}
	
	@Test(priority=6)
	public void checkRegisteredEmailSignup() {
        driver.findElement(By.id("name")).sendKeys("Selenium_aut_Project_Batch238");
        driver.findElement(By.id("emailid")).sendKeys("Selinium_Project_automations_Batch2381@gmail.com");
        driver.findElement(By.id("mobile")).sendKeys("9933445566");
        driver.findElement(By.id("agree")).click();
        WebElement proceed=driver.findElement(By.id("emailbtn"));
        JavascriptExecutor jsi = ((JavascriptExecutor) driver);
		jsi.executeScript("arguments[0].scrollIntoView(true);", proceed);
        proceed.click();
        String expRes="Email Address already exists, please login with mobile number associated with this email. [check your inbox for welcome email]";
        WebElement quizcon=driver.findElement(By.xpath("//*[text()='Email Address already exists, please login with mobile number associated with this email. [check your inbox for welcome email]']"));
        String actRes=quizcon.getText();
        Assert.assertEquals(actRes,expRes);
	}

	@Test(priority=7)
	public void checkInvalidMobileSignup() {
        driver.findElement(By.id("name")).sendKeys("Selenium_automat_Project12_Batch238");
        driver.findElement(By.id("emailid")).sendKeys("Selinum_Project_automat_Batch238741@gmail.com");
        driver.findElement(By.id("mobile")).sendKeys("Rahulpatil");
        driver.findElement(By.id("agree")).click();
        WebElement proceed=driver.findElement(By.id("emailbtn"));
        JavascriptExecutor jsi = ((JavascriptExecutor) driver);
		jsi.executeScript("arguments[0].scrollIntoView(true);", proceed);
        proceed.click();
        String expRes="Mobile number already exists, please login with this mobile number";
        WebElement quizcon=driver.findElement(By.xpath("//div[@id='mobileerr']"));
        String actRes=quizcon.getText();
        Assert.assertEquals(actRes,expRes);
	}
	
	@Test(priority=8)
	public void checkRegisteredMobileSignup() {
		driver.findElement(By.id("name")).sendKeys("rahul123");
        driver.findElement(By.id("emailid")).sendKeys("prahul728@gmail.com");
        driver.findElement(By.id("mobile")).sendKeys("3388226644");
        driver.findElement(By.id("agree")).click();
        WebElement proceed=driver.findElement(By.id("emailbtn"));
        JavascriptExecutor jsi = ((JavascriptExecutor) driver);
		jsi.executeScript("arguments[0].scrollIntoView(true);", proceed);
        proceed.click();
        String expRes="Mobile number already exists, please login with this mobile number";
        WebElement quizcon=driver.findElement(By.xpath("//div[@id='mobileerr']"));
        String actRes=quizcon.getText();
        Assert.assertEquals(actRes,expRes);   
	}
	
	@Test(priority=9)
	public void checkInvalidNumberRangeSignup() {
		driver.findElement(By.id("name")).sendKeys("Selenium_automate_Project123_Batch238");
	    driver.findElement(By.id("emailid")).sendKeys("Selinum_Project_automat_Batch238@gmail.com");
	    driver.findElement(By.id("mobile")).sendKeys("99887766332215");
	    driver.findElement(By.id("agree")).click();
	    WebElement proceed=driver.findElement(By.id("emailbtn"));
	    JavascriptExecutor jsi = ((JavascriptExecutor) driver);
		jsi.executeScript("arguments[0].scrollIntoView(true);", proceed);
	    proceed.click();
	    String expRes="Please enter a valid number!";
	    WebElement quizcon=driver.findElement(By.xpath("//div[@id='mobileerr']"));
	    String actRes=quizcon.getText();
	    Assert.assertEquals(actRes,expRes);
	}
	
	@Test(priority=10)
	public void checkCheckBoxSelected() {
        driver.findElement(By.id("name")).sendKeys("Selenium_aut_Project_Batch238");
        driver.findElement(By.id("emailid")).sendKeys("Selinum_Project_auto_Batch238@gmail.com");
        driver.findElement(By.id("mobile")).sendKeys("8734678910");
        WebElement proceed=driver.findElement(By.id("emailbtn"));
        JavascriptExecutor jsi = ((JavascriptExecutor) driver);
		jsi.executeScript("arguments[0].scrollIntoView(true);", proceed);
        proceed.click();
        String expRes="Please select terms and condition checkbox.";
        WebElement quizcon=driver.findElement(By.xpath("//div[@id='agreeerr']"));
        String actRes=quizcon.getText();
        Assert.assertEquals(actRes,expRes);
	}
	
	
}




