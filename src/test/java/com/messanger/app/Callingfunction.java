package com.messanger.app;

import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

@Test
public class Callingfunction {
	// Add TestNG Dependency Use the Version According to u r TestNG installed
	// Eclipse Version
	// Add Appium Dependency Latest Version

	@SuppressWarnings("deprecation")
	public void DeleteSMS() throws MalformedURLException {

		// Appium Code to launch the Messanger App

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		capabilities.setCapability("appPackage", "com.google.android.apps.messaging");
		capabilities.setCapability("appActivity", "com.google.android.apps.messaging.ui.ConversationListActivity");
		capabilities.setCapability("autoLaunch", true);

		// Initialize the Appium Driver
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
				new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// Verifying Calling Functionality from SMS App
		driver.findElementByXPath("//android.widget.TextView[@text='Deepak']").click();
		driver.findElementByXPath("//android.widget.TextView[@content-desc='Make a call']").click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		/*
		 * try { Thread.sleep(6000); } catch (InterruptedException e) {
		 * e.printStackTrace(); }
		 */
		driver.getKeyboard();
		driver.pressKeyCode(6);
		AndroidElement results = driver.findElementByXPath("//android.widget.TextView[@content-desc='Deepak']");
		// Check the calculated value on the edit box
		try {
			assert results.getText().equals("Deepak");
		} catch (Exception e) {
			System.out.println("Fail" + e.getMessage());
		}
		System.out.println("Actual value is : " + results.getText());
		driver.quit();
	}
}
