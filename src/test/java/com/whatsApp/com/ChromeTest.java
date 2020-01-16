package com.whatsApp.com;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class ChromeTest {

	public static void main(String[] args) throws MalformedURLException {

		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); // Give Device ID of your mobile phone
		//caps.setCapability(MobileCapabilityType.DEVICE_NAME, "c3e9a82e");
		//caps.setCapability("platformVersion", "7.1.1");
		caps.setCapability("browserName", "browser");
		caps.setCapability("noReset", true);
		caps.setCapability("autoLaunch", true);

		// Set ChromeDriver location
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
				new URL("http://127.0.0.1:4723/wd/hub"), caps);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Open URL in Chrome Browser
		driver.get("https://www.google.com");
	}
}
