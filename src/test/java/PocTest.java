import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.remote.MobileCapabilityType;

public class PocTest {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "android11");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
		dc.setCapability("autoGrantPermissions","true");
		dc.setCapability(MobileCapabilityType.NO_RESET, true);
		dc.setCapability("newCommandTimeout", 300);
		dc.setCapability(MobileCapabilityType.UDID,"emulator-5554");
		
		dc.setCapability("appPackage", "my.yes.yes4g");
		dc.setCapability("appActivity", "my.yes.myyes4g.HomeActivity");
		
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		AppiumDriver driver = new AppiumDriver(url,dc);		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		By yesIDTxt = MobileBy.id("my.yes.yes4g:id/edtLoginYesID");
		
		driver.findElement(yesIDTxt).sendKeys("a0102593394@yes.my");
		
		Thread.sleep(4000);
		driver.quit();
		
	}

}
