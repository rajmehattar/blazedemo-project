package base;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.blazedemo.utils.DriverFactory;

public class BaseTest {
	
	public static WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		driver = DriverFactory.createDriver();
		driver.manage().window().maximize();
		driver.get("https://blazedemo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterMethod
	public void tearDown() {
		
		if(driver != null) {
			driver.quit();
		}
	}
	
	public String captureScreenshot(String screenshotName) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);

		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

		String destPath = System.getProperty("user.dir") + "/screenShot/" + screenshotName + "_" + timestamp + ".png";

		File dest = new File(destPath);
		dest.getParentFile().mkdirs();

		try {
			Files.copy(src.toPath(), dest.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return destPath;
	}
}
