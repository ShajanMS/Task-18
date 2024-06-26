package guvSele;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task18_1 {

	public static void main(String[] args) {
		
		// Set the path to the ChromeDriver executable
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver-win64\\chromedriver.exe");
		
		// Initialize a new instance of the ChromeDriver
		
		WebDriver driver = new ChromeDriver();
		
		try {
			
			// 1.Navigate to Facebook
			
			driver.get("https://www.facebook.com/");
			
			// 2.Maximize the browser window
			
			driver.manage().window().maximize();
			
			// 3.Verify that the website has been redirected to the Facebook homepage
			
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='fb_logo _8ilh img']")));
			
			System.out.println("Facebook homepage loaded successfully");
			
			//Thread.sleep(2000);
			
			 // 4.Click on the "Create new account" button
			
			WebElement Newaccount = driver.findElement(By.xpath("//div[@class='_6ltg']//a"));
			
			Newaccount.click();
			
			// 5.Enter the first name and last name
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name("firstname")));
			
			WebElement firstname = driver.findElement(By.name("firstname"));
			
			WebElement lastname = driver.findElement(By.name("lastname"));
			
			firstname.sendKeys("Guvi");
			
			lastname.sendKeys("Cat");
			
			// 6. Select DOB
			
			WebElement Date = driver.findElement(By.id("day"));
			
			Select select = new Select(Date);
			
			select.selectByIndex(10);
			
			WebElement Month = driver.findElement(By.id("month"));
			
			Select select2 = new Select(Month);
			
			select2.selectByVisibleText("May");
			
			WebElement Year = driver.findElement(By.id("year"));
			
			Select select3 = new Select(Year);
			
			select3.selectByValue("1985");
			
			// 7. Select the gender
			
			WebElement Radio = driver.findElement(By.xpath("//label[text()='Male']"));
			
			Radio.click();
			
			// 8. Enter a valid email address
			
			WebElement email = driver.findElement(By.xpath("//input[@name='reg_email__']"));
			
			email.sendKeys("hcat12123@gmail.com");
			
			 // 9. Confirm email field appears
			
			WebElement Reenter = driver.findElement(By.name("reg_email_confirmation__"));
			
			wait.until(ExpectedConditions.visibilityOf(Reenter));
			
			Reenter.sendKeys("hcat12123@gmail.com");
			
			// 10. Enter a strong password 
			
			WebElement Pass  =driver.findElement(By.name("reg_passwd__"));
			
			wait.until(ExpectedConditions.visibilityOf(Pass));
			
			Pass.sendKeys("StrongPassword123!");
			
			// 11. Click on the "Sign Up" button
			
			WebElement Sign = driver.findElement(By.name("websubmit"));
			
			Sign.click();
			
			// 12 Verify that the user is successfully registered
			
			wait.until(ExpectedConditions.urlContains("https://www.facebook.com/"));
			
			System.out.println("User registration successful, redirected to Facebook homepage");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			System.out.println("User registration failed or not redirected to Facebook homepage");
			
		
		}
			
		

	}

}
