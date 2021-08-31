import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableTestSuite {
    WebDriver driver;

    @BeforeEach
    private void setup(){
        driver = new ChromeDriver();
    }

    @Test
    public void ItemsQuantitySubtotalTest(){
        driver.get("https://d21vtxezke9qd9.cloudfront.net/#/planets");
        HomePage homepage = new HomePage(driver);
        homepage.clickHomeMenu();
        var items = homepage.getRowItemsWebElements();

        for(var item : items){
            var price = item.findElement(By.cssSelector("td:nth-child(3)")).getText();
            var itemCount = item.findElement(By.cssSelector("input")).getAttribute("value");
            var subtotal = item.findElement(By.cssSelector("td:nth-child(4)")).getText();

            var priceFloat = Float.parseFloat(price.replaceAll("[^\\d.]",""));
            var itemCountInt = Integer.parseInt(itemCount.replaceAll("[^\\d.]",""));
            var subtotalFloat = Float.parseFloat(subtotal.replaceAll("[^\\d.]",""));

            //if(priceFloat == (float) 69.99){
                System.out.println("itemQty: " + itemCount + " price: " + price + " subtotal: " + subtotal);
                Assertions.assertEquals(itemCountInt * priceFloat, subtotalFloat);
            //}
        }
    }

    @Test
    public void checkListItemDialogBoxMessage(){
        driver.get("https://d21vtxezke9qd9.cloudfront.net/#/planets");
        HomePage homepage = new HomePage(driver);
        homepage.clickHomeMenu();
        homepage.clickUnorderedListItem(1);


    }


}
