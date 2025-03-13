package com.projectthales.util;

import com.projectthales.exception.UnexpectedError;
import com.projectthales.model.compent.ResponseCode;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@Slf4j
public class UtilJson {

    private UtilJson() {
        throw new IllegalStateException(UtilJson.class.toString());
    }

    public static String getJsonResponse(String url) {
        try {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get(url);
            log.info("Driver =>> " + driver);
            WebElement preElement = driver.findElement(By.tagName("pre"));
            String jsonResponse = preElement.getText();
            log.info("Json =>> " + jsonResponse);
            driver.quit();

            return jsonResponse;
        } catch (Exception ex) {
            throw new UnexpectedError(ResponseCode.UNEXPECTED_ERROR.getMensaje() + " =>> " + ex.getMessage(), ResponseCode.UNEXPECTED_ERROR.getCodigo());
        }
    }
}
