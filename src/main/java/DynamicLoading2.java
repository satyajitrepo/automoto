import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoading2 {

	public static void main(String[] args) {

		String projectPath = System.getProperty("user.dir");

		System.setProperty("webdriver.chrome.driver", projectPath + "//drivers//chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();

		// implicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

		driver.findElement(By.xpath("//button[text()='Start']")).click();

		System.out.println(driver.findElement(By.xpath("(//h4)[2]")).getText());

		// System.out.println(driver.findElement(By.xpath("(//h4)[2]")).getText());

	}

}
