package SamplePackage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class EnrollmentID {
    private static final String App = "C://Users//pmalviya//Downloads//snappqa_3_2_0_Dev_Build_1502.apk";
    private static final String AppiumServerUrl = "http://localhost:4723/wd/hub";

    private AndroidDriver driver;
    private AndroidTouchAction touchAction;



    @BeforeTest
    public void SetUP() throws Exception {
        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability(MobileCapabilityType.APP,App);
        dc.setCapability(MobileCapabilityType.FULL_RESET, true);
        dc.setCapability(MobileCapabilityType.NO_RESET, false);
        dc.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "net.soti.snap");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".ui.activities.SplashActivity");

        driver = new AndroidDriver<>(new URL(AppiumServerUrl), dc);
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        Thread.sleep(2000);

    }

    @Test(priority = 0)
    public void SwipeLandingPage()  {

        touchAction = new AndroidTouchAction(driver);
        touchAction.press(PointOption.point(824, 1080)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(536))).moveTo(PointOption.point(63, 1080)).release().perform();
        touchAction.press(PointOption.point(957, 1080)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(536))).moveTo(PointOption.point(63, 993)).release().perform();
        touchAction.press(PointOption.point(948, 1100)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(536))).moveTo(PointOption.point(63, 993)).release().perform();
        touchAction.press(PointOption.point(957, 1100)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(536))).moveTo(PointOption.point(63, 993)).release().perform();
    }

    @Test (priority = 1)
    public void EnrollDevice() {

        driver.findElement(By.id("input_user_name")).sendKeys("10AF86332E");

        driver.findElement(By.id("layout_continue_Button")).click();

    }

    @Test(priority = 2)
    public void UnEnrollDevice()
    {
        driver.findElement(By.id("more")).click();
        driver.findElement(By.xpath("//*[@text='Manage Channels']")).click();
        driver.findElement(By.id("deleteTenantButton")).click();
        driver.findElement(By.id("text_button_positive")).click();

    }
//    @AfterTest
//    public void TearDown()
//    {
//        driver.quit();
//    }
}
