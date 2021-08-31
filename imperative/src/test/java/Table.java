import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Table {

    WebElement thisElement;

    public Table(WebElement element){
        this.thisElement = element;
    }

    public String getCellText(int rowIndex, int colIndex) {
        var rows = thisElement.findElements(By.tagName("tr"));
        var cols = rows.get(rowIndex).findElements(By.tagName("td"));

        return cols.get(colIndex).getText();
    }
}
