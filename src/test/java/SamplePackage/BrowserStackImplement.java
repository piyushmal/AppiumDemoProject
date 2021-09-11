package SamplePackage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BrowserStackImplement
{

    private AndroidDriver driver;
    private AndroidTouchAction touchAction;
    @BeforeTest
    public void Setup() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", "piyushmalviya1");
        caps.setCapability("browserstack.key", "WZAwPZdbpgx5cQsPQUhx");

        // Set URL of the application under test
        caps.setCapability("app", "bs://980baff4099cba712056de5ccbcc2c47042ec075");

        // Specify device and os_version for testing
        caps.setCapability("device", "Google Pixel 3");
        caps.setCapability("os_version", "9.0");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "Java Android");
        caps.setCapability("name", "first_test");

        driver = new AndroidDriver<AndroidElement>(
                new URL("http://hub.browserstack.com/wd/hub"), caps);

        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        Thread.sleep(3000);
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

}

