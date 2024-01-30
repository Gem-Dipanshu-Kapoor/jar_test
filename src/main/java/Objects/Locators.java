package Objects;

import org.openqa.selenium.By;

public class Locators {

    public static By user_name = By.xpath("//input[@placeholder='Username']");
    public static By password = By.xpath("//input[@placeholder='Password']");
    public static By login_button = By.xpath("//button[text()='Login']");
    public static By home_button = By.xpath("//div[text()='Home']");
    public static By logout_btn = By.xpath("//div[text()='Logout']");
    public static By bridge_token = By.xpath("(//div[text()='Bridge Token'])[2]");
    public static By copy_bridge_token = By.xpath("//div[@class='copyIcon col-2 d-flex justify-content-center align-items-center']");
    public static By change_token = By.xpath("//div[text()='Change Token']");
    public static By date_tab = By.xpath("//div[@class='createdOn mt-3']");
    public static By card_two = By.xpath("(//div[@class='mt-3 cardName'])[6]");
    public static By content_card_two = By.xpath("(//div[@class='mt-1 appCardContent'])[6]");
    public static By login_btn = By.xpath("//span[text()='Log in']");

    public static By homepage_username = By.xpath("//div[contains(@class,'profileUsername')]");
    public static By notauser_btn = By.xpath("//a[text()='Signup']");
}

