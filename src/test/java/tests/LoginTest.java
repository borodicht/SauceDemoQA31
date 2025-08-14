package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test(testName = "Проверка входа в магазин с позитвными данными",
            description = "Проверка входа в магазин с позитвными данными",
            priority = 1, groups = {"smoke"})
    public void checkPositiveLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(),
                "Products",
                "Логин не выполнен");
    }

    @Test(enabled = false)
    public void checkLoginWithEmptyPassword() {
        loginPage.open();
        loginPage.login("standard_user", "");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Password is required",
                "Сообщение об ошибке не соотвествует");
    }

    @Test(testName = "Проверка входа в магазин с пустым именем пользователя",
            priority = 2, groups = {"regression"}, dependsOnMethods = "checkPositiveLogin")
    public void checkLoginWithEmptyLogin() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username is required",
                "Сообщение об ошибке не соотвествует");
    }

    @Test(testName = "Проверка входа в магазин с пустым паролем",
            priority = 3, retryAnalyzer = Retry.class)
    public void checkLoginWithNegativeCred() {
        loginPage.open();
        loginPage.login("test", "test");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Сообщение об ошибке не соотвествует");
    }

    @DataProvider(name = "Проверка логина с негативными данными")
    public Object[][] loginData() {
        return new Object[][]{
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"test", "test", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test(dataProvider = "Проверка логина с негативными данными")
    public void paramNegativeTest(String user, String password, String expectedErrorMessage) {
        loginPage.open();
        loginPage.login(user, password);
        assertEquals(loginPage.getErrorMessage(),
                expectedErrorMessage,
                "Сообщение об ошибке не соотвествует");
    }
}
