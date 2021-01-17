import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleFrames {

	void switchToParentFrame(int index) {
		
	}
	
	public static void main(String[] args) {
		
		String projectPath = System.getProperty("user.dir");

		System.setProperty("webdriver.chrome.driver", projectPath + "//drivers//chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://the-internet.herokuapp.com/nested_frames");
		
		driver.manage().deleteAllCookies();
		
		// Handle Frames
		//WebElement elemBottonFrame = driver.findElement(By.xpath("//frame[@name='frame-bottom']"));
		
		// driver.switchTo().frame(elemBottonFrame);
		
		driver.switchTo().frame(0);
		
		driver.switchTo().frame(1);
		
		System.out.println(driver.findElement(By.id("content")).getText());
		
		driver.switchTo().defaultContent();
		
		
		
		//driver.switchTo().parentFrame();
		
		// driver.switchTo().frame("frame-bottom");
		
		// System.out.println(driver.findElement(By.tagName("body")).getText());
		
		driver.close();
	}

}
