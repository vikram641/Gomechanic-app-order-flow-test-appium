package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.bson.Document;
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

public class loginToOrder {
    public static void main(String[] args){
        String randomNumber = randomNum.generateValidTenDigitNumber();

        //adb-29329398-abH7ll._adb-tls-connect._tcp
        try {
            UiAutomator2Options options = new UiAutomator2Options();
            options.setPlatformName("Android");
            options.setDeviceName("adb-29329398-abH7ll._adb-tls-connect._tcp");
            options.setUdid("adb-29329398-abH7ll._adb-tls-connect._tcp");
            options.setAutomationName("UiAutomator2");
            options.setAppPackage("gomechanic.retail");
            options.setAppActivity("gomechanic.retail.HomeActivity");
            options.setNoReset(true);
            options.setCapability("enforceXPath1", true);

            options.setCapability("ignoreHiddenApiPolicyError", true);
            options.setNewCommandTimeout(Duration.ofSeconds(300));
            URL serverURL = new URL("http://127.0.0.1:4723/");
            // Start driver
            AndroidDriver driver = new AndroidDriver(serverURL, options);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            System.out.println("Open app");
            System.out.println("input number");
            WebElement Otp_input = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.EditText[@resource-id=\"gomechanic.retail:id/mobile_number\"]\n")));
            Otp_input.sendKeys(randomNumber);
            System.out.println("click get otp button");

            WebElement otp_button = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.TextView[@resource-id=\"gomechanic.retail:id/btNext\"]\n")));
            otp_button.click();



            String getOtp = mongoOps.getOtpByPhone(randomNumber);
            String s1 = String.valueOf(getOtp.charAt(0));
            String s2 = String.valueOf(getOtp.charAt(1));
            String s3 = String.valueOf(getOtp.charAt(2));
            String s4 = String.valueOf(getOtp.charAt(3));
            Thread.sleep(200);
            System.out.println("fill otp");
            WebElement otp1 = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.LinearLayout[@resource-id=\"gomechanic.retail:id/editText_layout\"]/android.widget.EditText[1]\n")));
            otp1.sendKeys(s1);
            WebElement otp2 = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.LinearLayout[@resource-id=\"gomechanic.retail:id/editText_layout\"]/android.widget.EditText[2]\n")));
            otp2.sendKeys(s2);
            WebElement otp3 = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.LinearLayout[@resource-id=\"gomechanic.retail:id/editText_layout\"]/android.widget.EditText[3]\n")));
            otp3.sendKeys(s3);
            WebElement otp4 = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.LinearLayout[@resource-id=\"gomechanic.retail:id/editText_layout\"]/android.widget.EditText[4]\n")));
            otp4.sendKeys(s4);
            Thread.sleep(100);

//            WebElement icChooseCar = wait.until(ExpectedConditions.elementToBeClickable(
//                    By.xpath("//android.widget.AppCompatImageVies[@resource-id=\"gomechanic.retail:id/icChooseCar\"]\n")));
//            icChooseCar.click();
            System.out.println("Select vehical type");
            driver.findElement(By.xpath("//*[@resource-id='gomechanic.retail:id/icChooseCar']")).click();
            System.out.println("select brand");
            WebElement BrandSelect = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("(//android.widget.ImageView[@resource-id=\"gomechanic.retail:id/ivBrandImageOSCFIV\"])[1]\n")));
            BrandSelect.click();
            System.out.println("select model");
            WebElement modelSelect = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("(//android.widget.ImageView[@resource-id=\"gomechanic.retail:id/ivCarImageOSCFIV\"])[2]\n")));
            modelSelect.click();
            System.out.println("select fuel type");
            WebElement fuelType = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.TextView[@resource-id=\"gomechanic.retail:id/tvPatrol\"]\n")));
            fuelType.click();

            Thread.sleep(1000);


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
            WebElement topAssistRemove1 = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("(//android.widget.ImageView[@resource-id=\"gomechanic.retail:id/tvCartItemRemove\"])[2]\n")));
            topAssistRemove1.click();
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
            System.out.println("success");
            WebElement payNow = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.TextView[@resource-id=\"gomechanic.retail:id/tvCheckOutCPF\"]\n")));
            payNow.click();

            Thread.sleep(16000);
            WebElement popCut = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.ImageView[@resource-id=\"gomechanic.retail:id/imgClose\"]\n")));
            popCut.click();

            WebElement orderDetailPageCut = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.ImageView[@resource-id=\"gomechanic.retail:id/imgBackToolbarODPF\"]\n")));
            orderDetailPageCut.click();
            WebElement perodic_service = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("(//android.widget.ImageView[@resource-id=\"gomechanic.retail:id/ivFeatureImage\"])[1]\n")));
            perodic_service.click();
            WebElement add = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("(//android.widget.TextView[@resource-id=\"gomechanic.retail:id/tvAddService\"])[1]\n")));
            add.click();
            WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.view.ViewGroup[@resource-id=\"gomechanic.retail:id/clServiceBottom\"]\n")));
            addToCart.click();
            WebElement viewCart = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("(//android.view.ViewGroup[@resource-id=\"gomechanic.retail:id/clStripLOSA\"])[2]\n")));
            viewCart.click();
            WebElement topAssistRemove = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("(//android.widget.ImageView[@resource-id=\"gomechanic.retail:id/tvCartItemRemove\"])[2]\n")));
            topAssistRemove.click();
            Thread.sleep(100);
            checkoutFlow.checkOutToPaynow(driver);
            Thread.sleep(16000);
            WebElement popCut1 = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.ImageView[@resource-id=\"gomechanic.retail:id/imgClose\"]\n")));
            popCut1.click();

            WebElement orderDetailPageCut1 = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.ImageView[@resource-id=\"gomechanic.retail:id/imgBackToolbarODPF\"]\n")));
            orderDetailPageCut1.click();
            WebElement accountClick = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.FrameLayout[@content-desc=\"Account\"]\n")));
            accountClick.click();
            WebElement orderHistory = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.ImageView[@resource-id=\"gomechanic.retail:id/ivOrderListUAF\"]\n")));
            orderHistory.click();

//            WebElement checkout1 = wait.until(ExpectedConditions.elementToBeClickable(
//                    By.xpath("//android.widget.TextView[@resource-id=\"gomechanic.retail:id/tvCheckOutCF\"]\n")));
//            checkout1.click();
//            System.out.println("success 4");
//            WebElement selectTime1 = wait.until(ExpectedConditions.elementToBeClickable(
//                    By.xpath("(//android.view.ViewGroup[@resource-id=\"gomechanic.retail:id/clTimeView\"])[1]\n")));
//            selectTime1.click();
//
//            WebElement paymentMethod1 = wait.until(ExpectedConditions.elementToBeClickable(
//                    By.xpath("(//android.widget.ImageView[@resource-id=\"gomechanic.retail:id/ivRBPaymentHeaderLPCPF\"])[1]\n")));
//            paymentMethod1.click();
//            System.out.println("success");
//            WebElement payNow1 = wait.until(ExpectedConditions.elementToBeClickable(
//                    By.xpath("//android.widget.TextView[@resource-id=\"gomechanic.retail:id/tvCheckOutCPF\"]\n")));
//            payNow1.click();



            Thread.sleep(300);


            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);


            File destination = new File("screenshots/1.png");

            try {
                Files.createDirectories(destination.getParentFile().toPath()); // Create directory if not exists
                Files.copy(screenshot.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("📸 Screenshot saved at: " + destination.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }






        }
        catch (MalformedURLException e) {
            System.out.println("Invalid Appium Server URL");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
//    public static void checkOutToPaynow(AndroidDriver driver ){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//
//
//
//        WebElement checkout1 = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//android.widget.TextView[@resource-id=\"gomechanic.retail:id/tvCheckOutCF\"]\n")));
//        checkout1.click();
//        System.out.println("success 4");
//        WebElement selectTime1 = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("(//android.view.ViewGroup[@resource-id=\"gomechanic.retail:id/clTimeView\"])[1]\n")));
//        selectTime1.click();
//
//        WebElement paymentMethod1 = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("(//android.widget.ImageView[@resource-id=\"gomechanic.retail:id/ivRBPaymentHeaderLPCPF\"])[1]\n")));
//        paymentMethod1.click();
//        System.out.println("success");
//        WebElement payNow1 = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//android.widget.TextView[@resource-id=\"gomechanic.retail:id/tvCheckOutCPF\"]\n")));
//        payNow1.click();
//
//    }

}
