package com.pepo.steps;

import com.pepo.base.Base;
import com.pepo.base.PlatformAndroid;
//import com.pepo.base.PlatformIOS;
import com.pepo.base.PlatformIOS;
import constants.Constant;
import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import mamagers.ConfigDataManagers;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Hooks extends Base {


    private Base base;
    public Hooks(Base base) {
        this.base = base;
    }

    @Before
    public void startApp()
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(Constant.CAPABILTIES.DEVICENAME, ConfigDataManagers.platformOs.getdevice().deviceName);
        capabilities.setCapability(Constant.CAPABILTIES.PLATFORMVERSION, ConfigDataManagers.platformOs.getdevice().platformVersion);
        capabilities.setCapability(Constant.CAPABILTIES.PLATFORMNAME, ConfigDataManagers.data.platformName);
        capabilities.setCapability(Constant.CAPABILTIES.AUTOMATIONNAME, ConfigDataManagers.platformOs.getAutomationName());
        capabilities.setCapability(Constant.CAPABILTIES.APP, "/root/tmp/sample_apk/app_test_pepo.apk");
        capabilities.setCapability("setWebContentsDebuggingEnabled", "true");
        capabilities.setCapability("forceMjsonwp", true);


        System.out.println(capabilities.toString());


        try {
            launchApp(capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void launchApp(Capabilities capabilities) throws Exception {

        switch (ConfigDataManagers.data.platformName)
        {
            case Constant.ANDROID:
                base.driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                base.platform = new PlatformAndroid(base.driver);
                break;

            case Constant.ios:
                base.driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                base.platform = new PlatformIOS(base.driver);
                break;

            default:
                throw new NotFoundException("Platform OS not found");
        }

        base.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
}
