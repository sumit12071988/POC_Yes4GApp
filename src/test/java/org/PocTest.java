package org;
import static org.testng.Assert.assertTrue;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;

@SuppressWarnings("rawtypes")
public class PocTest {	
	
	AppiumDriver driver;
	
	@BeforeClass
	public void setUp() throws Exception {
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
		driver = new AppiumDriver(url,dc);		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test
	public void myPOC() throws Exception {
		By yesIDTxt = MobileBy.id("my.yes.yes4g:id/edtLoginYesID");
		By pwdBtn = MobileBy.id("my.yes.yes4g:id/loginUsingPasswordLayout");
		By pwdTxt = MobileBy.id("my.yes.yes4g:id/edtLoginPassword");
		By loginBtn = MobileBy.id("my.yes.yes4g:id/loginLayout");
		By moreTab = MobileBy.id("my.yes.yes4g:id/ivMore");
		By logoutBtn = MobileBy.xpath("//*[@text='Logout']");
		By confirmYesBtn = MobileBy.id("android:id/button1");		
		
		enter(yesIDTxt, "01117050039@yes.my")
		 	.tap(pwdBtn)
		 	.enter(pwdTxt, "Testpoc_1234")
		 	.tap(loginBtn)
		 	.tap(moreTab)
		 	.tap(logoutBtn)
		 	.tap(confirmYesBtn);		
		
		assertTrue(driver.findElement(pwdBtn).isDisplayed());
	}
	
	private PocTest enter(By locator, String txt) {
		driver.findElement(locator).sendKeys(txt);
		return this;
	}
	private PocTest tap(By locator) {
		new TouchAction(driver)
			.tap(TapOptions.tapOptions().withElement(ElementOption.element(driver.findElement(locator))))
			.perform();
		return this;
	}
	
	
}
