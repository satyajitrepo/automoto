import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LimitingWebDriverScope {

	public static void main(String[] args) {

		String projectPath = System.getProperty("user.dir");

		System.setProperty("webdriver.chrome.driver", projectPath + "//drivers//chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();

		try {
			driver.manage().window().maximize();

			driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

			List<WebElement> elems = driver.findElements(By.xpath("//a"));

			int count = elems.size();
			System.out.println(count);

			// Limiting webdriver scope
			WebElement elemDiv = driver.findElement(By.xpath("//div[@id='gf-BIG']"));
			WebElement elemFirstTD = elemDiv.findElement(By.xpath(".//td[1]"));		
			List<WebElement> desiredLinks = elemFirstTD.findElements(By.xpath(".//a"));

			boolean flag = true;

			for (WebElement elem : desiredLinks) {
				if (flag) {
					flag = false;
					continue;
				}

				String strKeys = Keys.chord(Keys.CONTROL, Keys.ENTER);
				elem.sendKeys(strKeys);
			}

			Set<String> ids = driver.getWindowHandles();

			for (String id : ids) {
				driver.switchTo().window(id);
				System.out.println(driver.getTitle());
			}

		} finally {
			driver.quit();
		}
	}

}
