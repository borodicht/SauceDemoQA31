package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static tests.AllureUtils.takeScreenshot;

public class ProductsPage extends BasePage{

    private final By TITLE = By.className("title");
    private final String ADD_TO_CART_PATTERN = "//*[text()='%s']/ancestor::div[@class='inventory_item']" +
            "//button[text()='Add to cart']";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "inventory.html");
    }

    @Step("Страница ProductsPage открыта")
    public void isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Products']")));
    }

    public String getTitle() {
       return driver.findElement(TITLE).getText();
    }

    @Step("Добавление товара с именем: '{product}' в корзину")
    public void addToCart(String product) {
        driver.findElement(By.xpath(String.format(ADD_TO_CART_PATTERN, product))).click();
    }

    @Step("Нажатие на иконку Корзина")
    public void clickToCart() {
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();
    }
}
