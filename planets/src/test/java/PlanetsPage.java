import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class PlanetsPage {
    private final WebDriver driver;

    @BeforeEach
    private void setup(){
        driver.get("https://d1iw6mb9di5l9r.cloudfront.net/#/planets");
    }

    public PlanetsPage(WebDriver driver) {
        this.driver = driver;
    }

    public Planet checkByNameAndReturnPlanet(String name){
        var property = new MatchName();
        var planet = new Planet(driver).getPlanet(name);
        return property.match(planet) ? planet.getPlanet(name) : null;
    }

//    public Planet checkByRadiusAndReturnPlanet(float radius){
//        var property = new MatchRadius();
//        var planet = new Planet(driver).getPlanet(radius);
//        return property.match(planet) ? planet.getPlanet(radius) : null;
//    }
}
