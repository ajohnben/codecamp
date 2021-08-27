import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class MatchRadius implements Matchable{

    WebDriver driver;

    @BeforeEach
    public void setup(){
        //driver.get("https://d1iw6mb9di5l9r.cloudfront.net/#/planets");
    }

    @Override
    public boolean match(Planet planetParam) {
        var planet = new Planet(driver);

        return planet.getPlanets().contains(planet);
    }

}
