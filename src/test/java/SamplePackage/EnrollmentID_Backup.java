package SamplePackage;

import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class EnrollmentID_Backup extends BaseClass {
    @BeforeTest
    public void SetUp() throws Exception {
        DeviceSetup();
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
