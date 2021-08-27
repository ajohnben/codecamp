import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;

public class Planet {

    private final WebDriver driver;
    private int distance;
    private float radius;
    private String name;
    private WebElement planetElement;

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public Planet(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getPlanets(){
        var planets = driver.findElements(By.className("planet"));

        return planets;
    }

    public Planet getPlanet(String planetName){

        setName(planetName);

        for(var planet : getPlanets()){
            if(getPlanetName(planet).equals(getName())){
                this.planetElement = planet;
            }
        }

        return this;
    }

    public String getPlanetName(WebElement planet){
        return planet.findElement(By.cssSelector("h2")).getText();
    }

    public float getRadius() throws ParseException {
        var radius = this.planetElement.findElement(By.className("radius")).getText();

        return NumberFormat.getNumberInstance().parse(radius.split(" ")[0]).floatValue();
    }

    public long getDistance() throws ParseException {
        var distance = this.planetElement.findElement(By.className("distance")).getText();

        return NumberFormat.getNumberInstance().parse(distance).longValue();
    }


//    public int getPlanetFurthestFromTheSun() throws ParseException {
//
//        var planetDistance = 0;
//
//        for(var planet : getPlanets()){
//            var distanceString = planet.findElement(By.className("distance")).getText();
//            var distance = NumberFormat.getNumberInstance().parse(distanceString).intValue();
//
//            if(planetDistance > distance){
//                planetDistance = distance;
//            }
//        }
//
//        return planetDistance;
//    }
}
