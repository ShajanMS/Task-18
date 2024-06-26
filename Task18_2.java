package guvSele;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task18_2 {

	public static void main(String[] args) {

		// Set the path to the ChromeDriver executable

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver-win64\\chromedriver.exe");

		// Initialize a new instance of the ChromeDriver

		WebDriver driver = new ChromeDriver();

		try {

			// 1.Navigate to JQuery

			driver.get("https://jqueryui.com/droppable/");

			// 2.Maximize the browser window

			driver.manage().window().maximize();

			// 3. Wait until the frame is visible and switch to it

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			WebElement frame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='demo-frame']")));

			driver.switchTo().frame(frame);

			// 4. Locate the source and target elements

			WebElement Drag = driver.findElement(By.id("draggable"));

			WebElement Drop = driver.findElement(By.id("droppable"));

			// 5. Perform the drag and drop operation

			Actions actions = new Actions(driver);

			actions.dragAndDrop(Drag, Drop).perform();

			// 6. Verify the text of the target element has changed to "Dropped!"

			String Text = Drop.findElement(By.xpath("//div[@id='droppable']")).getText();

			if ("Dropped!".equals(Text)) {

				System.out.println("Drag and drop operation successful");

			} else {

				System.out.println("Drag and drop operation failed");

			}

			// 7. Verify the color property of the target element's CSS

			String Color = Drop.getCssValue("background-color");

			System.out.println("Target element color after drop: " + Color);

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		finally {

			// Close the browser

			driver.quit();
		}

	}

}
