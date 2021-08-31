import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickHomeMenu(){
        driver.findElement(By.cssSelector("div.v-toolbar__items [aria-label=home]")).click();
    }

    public List<WebElement> getRowItemsWebElements(){
        return driver.findElements(By.cssSelector("table.cart tbody tr"));
    }

    public List<WebElement> getUnorderedListItem(){
        return driver.findElements(By.cssSelector("list-item"));
    }

    public void clickUnorderedListItem(Integer index){
        getUnorderedListItem().get(index).click();
    }

}
