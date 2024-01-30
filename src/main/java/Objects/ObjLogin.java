package Objects;

import org.openqa.selenium.By;

public class ObjLogin {
    public static By loginBtn = By.xpath("//button[text()='Login']");
    public static By notAUserBtn = By.xpath("//a[text()='Signup']");
    public static By username = By.xpath("//input[@placeholder='Username']");
    public static By password = By.xpath("//input[@placeholder='Password']");
}
