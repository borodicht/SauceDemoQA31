import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void checkCart() {
        /*
        a. Залогиниться
        b. Добавить товар в корзину
        c. Перейти в корзину
        d. Проверить (assertEquals) стоимость товара и его имя в корзине
         */
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String title = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(title, "Products");
    }
}

