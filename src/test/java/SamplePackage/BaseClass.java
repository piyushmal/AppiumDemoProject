package SamplePackage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseClass
{
    private static final String App = "C://Users//pmalviya//Downloads//snappqa_3_2_0_Dev_Build_1502.apk";
    private static final String AppiumServerUrl = "http://localhost:4723/wd/hub";
    public static AndroidDriver driver ;
    public static AndroidTouchAction touchAction;

    public static void DeviceSetup() throws InterruptedException, MalformedURLException {

        try {
            DesiredCapabilities dc = new DesiredCapabilities();

            dc.setCapability(MobileCapabilityType.APP, App);
            dc.setCapability(MobileCapabilityType.FULL_RESET, true);
            dc.setCapability(MobileCapabilityType.NO_RESET, false);
            dc.setCapability(MobileCapabilityType.UDID, "emulator-5554");
            dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "net.soti.snap");
            dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".ui.activities.SplashActivity");

            driver = new AndroidDriver<>(new URL(AppiumServerUrl), dc);
            driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
            Thread.sleep(2000);
        }
        catch(Exception e){
            System.out.println("Cause is :" + e.getCause());
            System.out.println("Message is :" + e.getMessage());
            e.printStackTrace();
        }

    }
}
