import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.text.ParseException;

public class WebUITestSuite {
    WebDriver driver;

    @BeforeEach
    private void setup(){
        driver = new ChromeDriver();
    }

//    @Test
//    public void checkPlanetAttributesTest(){
//
//        driver.get("https://d1iw6mb9di5l9r.cloudfront.net/#/planets");
//        var planets = driver.findElements(By.className("planet"));
//
//        for(var planet: planets){
//            var planetElement = planet.findElement(By.cssSelector("h2"));
//
//            var name = planetElement.getText();
//
//            if(name.equals("Mercury")) {
//                System.out.println(name);
//
//                var distance = planet.findElement(By.className("distance")).getText();
//                Assertions.assertEquals("57,910,000 km", distance);
//
//                var radius = planet.findElement(By.className("radius")).getText();
//                Assertions.assertEquals("2,439.7 km", radius);
//            }
//        }
//    }

    @Test
    public  void checkPlanetPropertiesTest() throws ParseException {
        driver.get("https://d1iw6mb9di5l9r.cloudfront.net/#/planets");
        Assertions.assertEquals(57910000, new Planet(driver).getPlanet("Mercury").getDistance());

    }

    @Test
    public void checkIfPlanetNameExist(){
        driver.get("https://d1iw6mb9di5l9r.cloudfront.net/#/planets");
        System.out.println(new PlanetsPage(driver).checkByNameAndReturnPlanet("Mercury").getName());

        //Assertions.assertEquals("Mercury", new PlanetsPage(driver).checkByNameAndReturnPlanet("Mercury").getName());
    }

//    @Test
//    public void checkPlanetFurthestFromTheSun() throws ParseException {
//        driver.get("https://d1iw6mb9di5l9r.cloudfront.net/#/planets");
//        System.out.println(new Planet(driver).getPlanetFurthestFromTheSun());
//    }
}
