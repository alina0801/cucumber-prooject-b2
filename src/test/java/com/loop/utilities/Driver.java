package com.loop.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {
    /*
    Creating the private constructor so this class's object is not reachable from outside  , use your get method and call only one browser at one time , otherwise you will have all your code , run on different windows, your second test cant run until 1 running
     */

    private Driver(){
    }

    /*
    making driver instance private
    static - run before everything else and also use in static method
     */

    //private static WebDriver driver;
    //implement threadLocal to achieve multi thread locally
    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();


    //static WebDriver driver;

    /*
    reusable method that will return the same driver instance every time called  , make your constructor private
     */

    /**
     * singleton pattern
     * @return driver
     * @author alina
     */
    public static WebDriver getDriver(){
        if(driverPool.get()==null){
            String browserType = ConfigurationReader.getProperty("browser");
            switch (browserType.toLowerCase()){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
            }
        }
        return driverPool.get();
    }

    /**
     * closing driver
     * @author nadir
     */
    public static void closeDriver(){
        if(driverPool.get() != null){
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}