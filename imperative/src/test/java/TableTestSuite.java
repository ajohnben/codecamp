import io.restassured.internal.common.assertion.Assertion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TableTestSuite {

    WebDriver driver;

    @BeforeEach
    private void setup(){
        driver = new ChromeDriver();
    }

    @Test
    public void tableItemsCellValueTest(){
        HomePage table = new HomePage(driver);
        driver.get("https://d21vtxezke9qd9.cloudfront.net/#/");
        Assertions.assertEquals("Lev 501s classic denim",table.getTable().getCellText(1,1));
    }
}
