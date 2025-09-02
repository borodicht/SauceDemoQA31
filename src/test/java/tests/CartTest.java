package tests;

import com.google.common.collect.Ordering;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class CartTest extends BaseTest {

    @Test (groups = {"smoke"})
    public void checkCart() {

        String product = "Sauce Labs Bike Light";
        /*
        a. Залогиниться
        b. Добавить товар в корзину
        c. Перейти в корзину
        d. Проверить (assertEquals) стоимость товара и его имя в корзине
         */
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.isPageOpened();
        productsPage.addToCart(product);
        productsPage.clickToCart();
        Assert.assertTrue(cartPage.isProductInCart(product),
                "Товар отсутствует в корзине");
        Assert.assertEquals(cartPage.getProductNameFromCart(0),
                product,
                "Товар отсутствует в корзине");
    }

    @Test
    public void test() {
        List<String> names = Arrays.asList("Vlad", "Timoifei", "Alisa");

        boolean isSorted = Ordering.natural().reverse().isOrdered(names);
        Assert.assertTrue(isSorted);
    }
}

