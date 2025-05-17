package org.example;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

public class main {
    public static void main(String[] args) {
        try {
            // Set desired capabilities
            UiAutomator2Options options = new UiAutomator2Options();
            options.setPlatformName("Android");
            options.setDeviceName("adb-29329398-abH7ll._adb-tls-connect._tcp");
            options.setUdid("adb-29329398-abH7ll._adb-tls-connect._tcp");
            options.setAutomationName("UiAutomator2");
            options.setAppPackage("gomechanic.retail");
            options.setAppActivity("gomechanic.retail.HomeActivity");
            options.setNoReset(true);
            options.setCapability("ignoreHiddenApiPolicyError", true);
            options.setNewCommandTimeout(Duration.ofSeconds(300));


            // Appium server URL
            URL serverURL = new URL("http://127.0.0.1:4723/");

            // Start driver
            AndroidDriver driver = new AndroidDriver(serverURL, options);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Actions with waits
            System.out.println("Find view");
            WebElement Periodic_service = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.TextView[@resource-id=\"gomechanic.retail:id/tvFeatureTitle\" and @text=\"AC Service & Repair\"]\n")));
            Periodic_service.click();
            System.out.println("success 1");

            WebElement Basic_service = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("(//android.widget.TextView[@resource-id=\"gomechanic.retail:id/tvAddService\"])[1]\n")));
            Basic_service.click();
            System.out.println("success 2");

//            driver.findElement(By.id("gomechanic.retail:id/clServiceViewCartBottom")).click();
            WebElement Add_to_cart = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("(//android.view.ViewGroup[@resource-id=\"gomechanic.retail:id/clStripLOSA\"])[2]\n")));
            Add_to_cart.click();
            System.out.println("success 3");
            WebElement checkout = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.TextView[@resource-id=\"gomechanic.retail:id/tvCheckOutCF\"]\n")));
            checkout.click();
            System.out.println("success 4");
            WebElement selectTime = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("(//android.view.ViewGroup[@resource-id=\"gomechanic.retail:id/clTimeView\"])[1]\n")));
            selectTime.click();

            WebElement paymentMethod = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("(//android.widget.ImageView[@resource-id=\"gomechanic.retail:id/ivRBPaymentHeaderLPCPF\"])[1]\n")));
            paymentMethod.click();
            WebElement payNow = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.TextView[@resource-id=\"gomechanic.retail:id/tvCheckOutCPF\"]\n")));
            payNow.click();
            Thread.sleep(16000);


            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destination = new File("screenshots/order6.png");

            try {
                Files.createDirectories(destination.getParentFile().toPath()); // Create directory if not exists
                Files.copy(screenshot.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("📸 Screenshot saved at: " + destination.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }


//
//            WebElement viewCart = wait.until(ExpectedConditions.elementToBeClickable(
//                    By.xpath("//android.view.ViewGroup[@resource-id=\"gomechanic.retail:id/clServiceViewCartBottom\"]")));
//            viewCart.click();
//            driver.findElement(By.xpath("//android.view.ViewGroup[@resource-id=\\\"gomechanic.retail:id/clServiceViewCartBottom\\")).click();
//
//            System.out.println("success");
//
//            WebElement serviceBottom = wait.until(ExpectedConditions.elementToBeClickable(
//                    By.xpath("//android.view.ViewGroup[@resource-id=\"gomechanic.retail:id/clServiceBottom\"]\n")));
//            serviceBottom.click();
//
//            System.out.println("success 1");
//
//            WebElement checkout = wait.until(ExpectedConditions.elementToBeClickable(
//                    By.xpath("//android.view.ViewGroup[@resource-id=\"gomechanic.retail:id/clServiceViewCartBottom\"]\n")));
//            checkout.click();
//            System.out.println("success 2");
//
//            WebElement timeSlot = wait.until(ExpectedConditions.elementToBeClickable(
//                    By.xpath("(//android.view.ViewGroup[@resource-id=\"gomechanic.retail:id/clTimeView\"])[1]")));
//            timeSlot.click();
//            driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id=\"gomechanic.retail:id/ivRBPaymentHeaderLPCPF\"])[1]\n")).click();
//            Thread.sleep(100);
//            driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"gomechanic.retail:id/tvCheckOutCPF\"]\n")).click();
//            Thread.sleep(500);
//            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//            File destination = new File("screenshots/homepage.png");
//
//            try {
//                Files.createDirectories(destination.getParentFile().toPath()); // Create directory if not exists
//                Files.copy(screenshot.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
//                System.out.println("📸 Screenshot saved at: " + destination.getAbsolutePath());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }


            // Close app
            driver.quit();

        } catch (MalformedURLException e) {
            System.out.println("Invalid Appium Server URL");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
