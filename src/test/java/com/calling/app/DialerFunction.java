package com.calling.app;

import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class DialerFunction {
	@Test

	public void Search() throws MalformedURLException {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		caps.setCapability("appPackage", "com.android.dialer");
		caps.setCapability("appActivity", "com.android.dialer.DialtactsActivity");
		caps.setCapability("platformVersion", "7.1.1");
		caps.setCapability("autoLaunch", true);
		caps.setCapability("noReset", "true");
		// Initialize the Appium Driver
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
				new URL("http://127.0.0.1:4723/wd/hub"), caps);

		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.findElement(By.id("com.android.dialer:id/floating_action_button")).click();
		
	}

}
