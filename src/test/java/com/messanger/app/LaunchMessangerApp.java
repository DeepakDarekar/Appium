package com.messanger.app;

import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

@SuppressWarnings("deprecation")
public class LaunchMessangerApp {
	// Add TestNG Dependency Use the Version According to u r TestNG installed
	// Eclipse Version
	// Add Appium Dependency Latest Version

	@Test
	public void LaunchAppTest() throws MalformedURLException {

		// Appium Code to Launch the Calculator App without .apk File

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		capabilities.setCapability("appPackage", "com.google.android.apps.messaging");
		capabilities.setCapability("appActivity", "com.google.android.apps.messaging.ui.ConversationListActivity");
		capabilities.setCapability("autoLaunch", true);
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
				new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElementById("com.google.android.apps.messaging:id/start_new_conversation_button").click();

		List<AndroidElement> txtbox = driver.findElements(By.className("android.widget.MultiAutoCompleteTextView"));
		txtbox.get(0).sendKeys("Deepak");
		driver.pressKeyCode(AndroidKeyCode.ENTER);
		driver.findElementById("com.google.android.apps.messaging:id/action_add_more_participants");
		txtbox.get(0).sendKeys("9898787898");
		driver.pressKeyCode(AndroidKeyCode.ENTER);
		driver.findElementById("com.google.android.apps.messaging:id/action_confirm_participants").click();
		driver.findElementById("com.google.android.apps.messaging:id/compose_message_text")
				.sendKeys("Hello There How are you doing Today");
		driver.findElementById("com.google.android.apps.messaging:id/self_send_icon").click();
	}

}
