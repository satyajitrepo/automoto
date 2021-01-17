import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleMultipleWindows {

	public static void main(String[] args) {
		
		String projectPath = System.getProperty("user.dir");

		System.setProperty("webdriver.chrome.driver", projectPath + "//drivers//chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://the-internet.herokuapp.com/windows");
		
		driver.findElement(By.linkText("Click Here")).click();
		
		String parentWindowID = driver.getWindowHandle();
		
		System.out.println("Parent window ID :"+ parentWindowID);
		
		Set<String> ids = driver.getWindowHandles();
		
		for(String id : ids) {
			System.out.println(id);
		}
		
		for(String id : ids) {
			if(!id.equals(parentWindowID)) {
				driver.switchTo().window(id);
			}
		}
		
		System.out.println(driver.getTitle());
		
		driver.switchTo().window(parentWindowID);
		
		driver.findElement(By.linkText("Click Here")).click();
		
		ids = driver.getWindowHandles();
		
		for(String id : ids) {
			System.out.println(id);
		}
	}

}
