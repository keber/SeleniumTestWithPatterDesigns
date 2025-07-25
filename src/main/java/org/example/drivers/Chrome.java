package org.example.drivers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chrome implements DriverStrategy {
    @Override
    public WebDriver setStrategy() {
        
        WebDriverManager.chromedriver().setup();
        
        ChromeOptions options= new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
        options.addArguments("--no-sandbox");
        options.addArguments("--headless=new");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--lang=es-CL");

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("intl.accept_languages", "es-CL,es");
        options.setExperimentalOption("prefs", prefs);
 
        return new ChromeDriver(options);
    }
}
