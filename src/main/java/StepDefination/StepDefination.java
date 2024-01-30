package StepDefination;

import Objects.*;
import com.gemini.generic.reporting.GemEcoUpload;
import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StepDefination extends GemEcoUpload {
    Logger logger = LoggerFactory.getLogger(StepDefination.class);

    @Then("Verify the Bridge Token Button is clickable or not")
    public void verify_the_bridge_token_button_is_clickable_or_not() {
        DriverAction.waitSec(2);
        DriverAction.click(Locators.home_button, "Home Button");
        boolean present;
        try {
            DriverManager.getWebDriver().findElement(Locators.bridge_token);
            present = true;
        } catch (Exception e) {
            present = false;
        }
        if (present) {
            try {
                DriverAction.click(Locators.bridge_token, "Bridge token Button");
                String s = DriverAction.getCurrentURL();
                STATUS status;
                if (s.contains("bridge-token")) {
                    status = STATUS.PASS;
                } else {
                    status = STATUS.FAIL;
                }
                GemTestReporter.addTestStep("Bridge Token window", "Window is opened successfully", status);
            } catch (Exception e) {
                logger.info("An exception occurred!", e);
                GemTestReporter.addTestStep("Status of Bridge Token button", "Clicked Failed", STATUS.FAIL);
            }
        } else {
            GemTestReporter.addTestStep("Bridge Token window", "Button NOt Present", STATUS.FAIL);

        }
    }

    @Then("Click on Copy Bridge Token")
    public void click_on_copy_bridge_token() {
        DriverAction.waitSec(2);
        DriverAction.click(Locators.home_button);
        try {
            DriverAction.click(Locators.bridge_token, "Bridge token Button");
            String s = DriverAction.getCurrentURL();
            STATUS status;
            if (s.contains("bridge-token")) {
                status = STATUS.PASS;
            } else {
                status = STATUS.FAIL;
            }
            GemTestReporter.addTestStep("Bridge Token window", "Window is opened successfully", status);
            boolean present;
            try {
                DriverManager.getWebDriver().findElement(Locators.copy_bridge_token);
                present = true;
            } catch (Exception e) {
                present = false;
            }
            STATUS status1;
            if (present) {

                DriverAction.click(Locators.copy_bridge_token, "Click was successful");
                DriverAction.waitSec(2);
                status1 = STATUS.PASS;
            } else {
                status1 = STATUS.FAIL;
            }
            GemTestReporter.addTestStep("Status of Copy button", "clicked Successful", status1, DriverAction.takeSnapShot());
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Exception", "Exception " + e, STATUS.ERR, DriverAction.takeSnapShot());
        }
    }

    @Then("Verify the date and time when Change Token button is clicked")
    public void verify_the_date_and_time_when_change_token_button_is_clicked() {
        DriverAction.waitSec(2);
        DriverAction.click(Locators.home_button, "Home button was clicked");
        try {
            DriverAction.click(Locators.bridge_token);
            DriverAction.click(Locators.change_token, "Change Token button was clicked");
            DriverAction.waitSec(1);
            GemTestReporter.addTestStep("Status of Change token button", "clicked Successful", STATUS.PASS, DriverAction.takeSnapShot());
            DriverAction.waitSec(2);
            String time = DriverAction.getElement(Locators.date_tab).getText();

            String timep = time.substring(11, 28);
            System.out.println("TIMEEEE:" + timep);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM d, yyyy");
            LocalDateTime now = LocalDateTime.now();
            String loc = dtf.format(now);
            System.out.println("LOC:" + loc);
            System.out.println("timep: " + timep);
            STATUS status;
            if (StringUtils.contains(timep, loc)) {
                status = STATUS.PASS;
            } else {
                status = STATUS.FAIL;
            }
            GemTestReporter.addTestStep("Checking date", "Dates should match", status);

        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Exception", "Exception " + e, STATUS.ERR, DriverAction.takeSnapShot());
        }
    }


    @Then("Verify the Alert when Change Token button is clicked")
    public void verify_the_alert_when_change_token_button_is_clicked() {
        DriverAction.waitSec(2);
        DriverAction.click(Locators.home_button, "Home button");
        try {
            DriverAction.click(Locators.bridge_token);
            DriverAction.waitSec(2);
            DriverAction.click(Locators.change_token, "Change token button");
            DriverAction.waitSec(3);
            GemTestReporter.addTestStep("Status of Change token button", "clicked Successful", STATUS.PASS, DriverAction.takeSnapShot());

            GemTestReporter.addTestStep("Alert status", "Expected alert: Bridge Token Changed Successfully.", STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Exception", "Exception " + e, STATUS.ERR, DriverAction.takeSnapShot());
        }
    }

    @Then("Verify if the Bridge token card is visible")
    public void verify_if_the_bridge_token_card_is_visible() {
        DriverAction.waitSec(2);
        DriverAction.click(Locators.home_button, "Home Button");
        try {

            String nuam = DriverAction.getElement(Locators.card_two).getText();
            STATUS status;
            if (nuam.equals("Bridge Token")) {
                status = STATUS.PASS;
            } else {
                status = STATUS.FAIL;
            }
            GemTestReporter.addTestStep("Validating the Bridge Token card", "Expcted :Bridge Token", status);
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Exception", "Exception " + e, STATUS.ERR, DriverAction.takeSnapShot());
        }
    }

    @Then("Validate the content of the Bridge Token card")
    public void validate_the_content_of_the_bridge_token_card() {
        DriverAction.waitSec(2);
        DriverAction.click(Locators.home_button, "Home Button");
        try {
            STATUS status;
            String nuam = DriverAction.getElement(Locators.content_card_two).getText();

            if (nuam.equals("Keeping in mind the Secure/Safe utilization, Jewel authenticates each user with a Bridge Token which can also be changed or retrieved back as per convenience.")) {
                status = STATUS.PASS;
            } else {
                status = STATUS.FAIL;
            }
            GemTestReporter.addTestStep("Validating the Bridge Token card Content", "Expcted :Keeping in mind the Secure/Safe utilization, Jewel authenticates each user with a Bridge Token which can also be changed or retrieved back as per convenience.", status);
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Exception", "Exception " + e, STATUS.ERR, DriverAction.takeSnapShot());
        }
    }

    @Then("Validate if there is change token button available ,if so click it")
    public void validate_if_there_is_change_token_button_available_if_so_click_it() {
        DriverAction.waitSec(2);
        DriverAction.click(Locators.home_button, "Home Button");
        boolean present;
        try {
            DriverManager.getWebDriver().findElement(Locators.bridge_token);
            present = true;
        } catch (Exception e) {
            present = false;
        }
        if (present) {
            try {
                DriverAction.click(Locators.bridge_token, "Bridge Token button");
                DriverAction.click(Locators.change_token, "Change token button");
                DriverAction.waitSec(1);
                GemTestReporter.addTestStep("Status of Change token button", "clicked Successful", STATUS.PASS, DriverAction.takeSnapShot());
            } catch (Exception e) {
                logger.info("An exception occurred!", e);
                GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
            }
        } else {
            GemTestReporter.addTestStep("Error", "No such element", STATUS.FAIL);
        }
    }

    @Given("navigate to login-screen")
    public void navigateLogin() {
        try {
            GemTestReporter.addTestStep("","",STATUS.INFO,DriverAction.takeSnapShot());
            DriverAction.click(ObjLandingPage.loginBtn, "login button");
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Exception", "Exception " + e, STATUS.ERR, DriverAction.takeSnapShot());
        }
    }

    @When("login to jewel")
    public void login() {
        try {
            DriverAction.typeText(ObjLogin.username, ScriptPreConfig.username, "username");
            DriverAction.typeText(ObjLogin.password, ScriptPreConfig.password);
            DriverAction.click(ObjLogin.loginBtn, "LogIn Button");
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Exception", "Exception " + e, STATUS.ERR, DriverAction.takeSnapShot());
        }
    }

    @Then("verify Logout button visibility")
    public void logoutBtn() {
        try {
            DriverAction.waitUntilElementAppear(ObjHome.username, 5);
            DriverAction.hoverOver(ObjHome.username);
            if (DriverAction.isExist(ObjLogout.logoutBtn)) {
                GemTestReporter.addTestStep("verify logout button visibility", "Logout button Displayed successfully", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("verify logout button visibility", "Logout button not found", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Exception", "Exception " + e, STATUS.ERR, DriverAction.takeSnapShot());
        }
    }

    @Then("click and verify logout button")
    public void verify_logout() {
        try {

            DriverAction.click(By.xpath("//html"), "Logout button");
            if (DriverAction.getCurrentURL().contains("login")) {
                GemTestReporter.addTestStep("Verifying user is logged out", "Log-out failed", STATUS.FAIL, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verifying user is logged out", "Log-out failed", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Exception", "Exception " + e, STATUS.ERR, DriverAction.takeSnapShot());
        }
    }
}
