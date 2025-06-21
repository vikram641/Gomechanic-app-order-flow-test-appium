package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class RetryHelper {

    public static WebElement findElementWithRetry(WebDriver driver, By locator, int maxRetries, int waitTimeSeconds) {
        int attempt = 0;
        while (attempt < maxRetries) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeSeconds));
                return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            } catch (WebDriverException e) {
                System.out.println("Attempt " + (attempt + 1) + " failed: " + e.getMessage());
                attempt++;
                try {
                    Thread.sleep(1000); // Optional: wait before retrying
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        throw new NoSuchElementException("Element not found after " + maxRetries + " attempts: " + locator.toString());
    }
}
