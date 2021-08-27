import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.ParseException;
import java.util.function.Predicate;

public class PlanetsUITestSuite {
    private WebDriver driver;

    @BeforeEach
    private void setup(){
        driver = new ChromeDriver();
        driver.get("https://d21vtxezke9qd9.cloudfront.net/#/planets");
    }

    @Test
    public void getPlanetTest() throws ParseException {
        System.out.println(new PlanetsPage(driver).getPlanet("Mercury").getRadius());

    }

    @Test
    public void clickExploreButtonTest(){
        new PlanetsPage(driver).clickExploreThenClickCloseButton();
    }


    @Test
    public void explorerModalTextTest(){
        Assertions.assertEquals("Exploring Mercury",new PlanetsPage(driver).getExplorerModalText("Mercury"));
    }

    @Test
    public void planetsWithRadiusGreaterThan4000() throws ParseException {

        var planets = new PlanetsPage(driver).getPlanetWithRadiusGreaterThan4000kms(MatchingFunctions.getFilter());

        for(WebElement planet : planets){
            System.out.println(planet.findElement(By.cssSelector("h2")).getText());
        }
    }


}
