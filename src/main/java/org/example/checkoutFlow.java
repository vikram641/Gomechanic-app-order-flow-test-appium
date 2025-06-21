package org.example;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class checkoutFlow extends loginToOrder {
    public static void checkOutToPaynow(AndroidDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));




        WebElement checkout1 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.TextView[@resource-id=\"gomechanic.retail:id/tvCheckOutCF\"]\n")));
        checkout1.click();
        System.out.println("success 4");
        WebElement selectTime1 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//android.view.ViewGroup[@resource-id=\"gomechanic.retail:id/clTimeView\"])[1]\n")));
        selectTime1.click();

        WebElement paymentMethod1 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//android.widget.ImageView[@resource-id=\"gomechanic.retail:id/ivRBPaymentHeaderLPCPF\"])[1]\n")));
        paymentMethod1.click();
//        WebElement element = RetryHelper.findElementWithRetry(
//                driver,
//                By.xpath("(//android.widget.ImageView[@resource-id=\\\"gomechanic.retail:id/ivRBPaymentHeaderLPCPF\\\"])[1]\\n"),
//                2,      // max retries
//                5       // wait seconds for each try
//        );


        System.out.println("success");
        WebElement payNow1 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.TextView[@resource-id=\"gomechanic.retail:id/tvCheckOutCPF\"]\n")));
        payNow1.click();

    }
}
