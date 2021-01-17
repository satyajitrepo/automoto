import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseInteraction {

	public static void main(String[] args) {

		String projectPath = System.getProperty("user.dir");

		System.setProperty("webdriver.chrome.driver", projectPath + "//drivers//chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		WebElement elem = driver.findElement(By.id("mousehover"));

		// scroll with javascript & seleium
		// this will scroll the page till the element is found
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", elem);

		// Mouse interactions
		Actions actions = new Actions(driver);
		actions.moveToElement(elem).build().perform();
		
		driver.findElement(By.linkText("Reload")).click();

	}

}
