package com.messanger.app;

import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class ContactMenuBarFunction {
	@Test

	public void Search() throws MalformedURLException {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		caps.setCapability("appPackage", "com.google.android.apps.messaging");
		caps.setCapability("appActivity", "com.google.android.apps.messaging.ui.ConversationListActivity");
		caps.setCapability("platformVersion", "7.1.1");
		caps.setCapability("autoLaunch", true);
		caps.setCapability("noReset", "true");
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
				new URL("http://127.0.0.1:4723/wd/hub"), caps);
		driver.findElementByXPath("//android.widget.TextView[@text='Deepak']").click();
		driver.findElement(By.xpath("//android.widget.ImageView[@content-desc = 'More options']")).click();
		driver.findElementByXPath("//android.widget.TextView[@text='People & options']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Notifications']").click();
		driver.findElementByXPath("//android.widget.Switch[@text='OFF']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Vibrate']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Block (589) 636-5899']").click();
		driver.findElementByXPath("//android.widget.Button[@text='CANCEL']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Block (589) 636-5899']").click();
		driver.findElementByXPath("//android.widget.Button[@text='BLOCK']").click();

	}
}
