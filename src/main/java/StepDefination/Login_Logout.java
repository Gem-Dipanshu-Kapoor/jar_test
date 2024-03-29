package StepDefination;

import Objects.Locators;
import Objects.Script_PreConfig;
import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class Login_Logout {
    Logger logger = LoggerFactory.getLogger(StepDefination.class);

    @Given("Navigate to login-screen")
    public void navigate_login() {
        try {
            DriverAction.click(Locators.login_btn, "Login screen");
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED " + e, STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }


    
    @Then("Verify Logout button visibility")
    public void logout_visibility() {
        try {
            DriverAction.waitUntilElementAppear(Locators.homepage_username,5);
            DriverAction.hoverOver(Locators.homepage_username);
            if (DriverAction.isExist(Locators.logout_btn)) {
                GemTestReporter.addTestStep("verify logout button visibility", "Logout button Displayed successfully", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("verify logout button visibility", "Logout button not found", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED " + e, STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("Click and verify Logout button")
    public void verify_logout() {
        try {
            DriverAction.click(Locators.logout_btn, "Logout button");
            if (DriverAction.getCurrentURL().contains("login")) {
                GemTestReporter.addTestStep("Verifying user is logged out", "Log-out successful", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verifying user is logged out", "Log-out successful", STATUS.PASS, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Error!!", "SOME ERROR OCCURRED " + e, STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @When("Enter credentials for login")
    public void credentials() {
        DriverAction.typeText(Locators.user_name, Script_PreConfig.username);
        DriverAction.typeText(Locators.password, Script_PreConfig.password);
    }

    @And("Click login")
    public void login_button() {
        DriverAction.click(Locators.login_button, "Login Button");
    }


    @Then("Click not a user button and validate navigation to signup screen")
    public void notaUser_btn() {
        try {
            DriverAction.click(Locators.notauser_btn, "Not a User button");
            if (DriverAction.getCurrentURL().contains("signup")) {
                GemTestReporter.addTestStep("Validate Not a User button redirect", "Redirected to Signup page", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Validate Not a User button redirect", "Failed to redirect to Signup page", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("Validate login is successful")
    public void login_success() {
        try {
            System.out.println(DriverAction.getCurrentURL());
            System.out.println(DriverAction.getElementText(Locators.homepage_username));
            if (DriverAction.getCurrentURL().contains("home") && DriverAction.getElementText(Locators.homepage_username).equals(Script_PreConfig.username)) {
                GemTestReporter.addTestStep("Validate Login", "Login successful", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Validate Login", "Failed to login", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }
}
