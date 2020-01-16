package com.messanger.app;

import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class MenubarFunction {
	@Test

	public void Menubar() throws MalformedURLException {

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
		driver.findElement(By.xpath("//android.widget.ImageView[@content-desc = 'More options']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text = 'Archived']")).click();
		driver.findElement(By.className("android.widget.ImageButton")).click();
		driver.findElement(By.xpath("//android.widget.ImageView[@content-desc = 'More options']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text = 'Blocked contacts']")).click();
		driver.findElementById("com.android.server.telecom:id/add_blocked").click();
		driver.findElementById("com.android.server.telecom:id/add_blocked_number").sendKeys("9999998888");
		driver.findElementByXPath("//android.widget.Button[@text='CANCEL']").click();
		driver.findElementById("com.android.server.telecom:id/add_blocked").click();
		driver.findElementById("com.android.server.telecom:id/add_blocked_number").sendKeys("9999998888");
		driver.findElementByXPath("//android.widget.Button[@text='BLOCK']").click();
		AndroidElement results = driver.findElementByXPath("//android.widget.TextView[@text ='(999) 999-8888']");
		try {
			assert results.getText().equals("(999) 999-8888");
		} catch (Exception e) {
			System.out.println("Fail" + e.getMessage());
		}
		System.out.println("Actual value is : " + results.getText());
		driver.quit();
	}
}
