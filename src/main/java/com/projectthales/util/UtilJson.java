package com.projectthales.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

@Slf4j
public class UtilJson {

    private UtilJson() {
        throw new IllegalStateException(UtilJson.class.toString());
    }

    public static String getJsonResponse(String url) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement preElement = driver.findElement(By.tagName("pre"));
        String jsonResponse = preElement.getText();
        log.info(jsonResponse);
        driver.quit();

        return jsonResponse;
    }
}
