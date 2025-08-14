package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LocatorsTest extends BaseTest {

    @Test
    public void checkLocators() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name"));
        driver.findElement(By.name("user-name"));
        driver.findElement(By.className("login_wrapper-inner"));
        driver.findElement(By.tagName("div"));
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();


        /*
        логинитесь и попадаете на следующую страницу
         */


    }
}
