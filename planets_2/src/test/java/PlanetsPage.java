import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PlanetsPage {

    private WebDriver driver;
    private int distance;
    private float radius;
    private WebElement planetElement;
    private String planetName;

    public PlanetsPage(WebDriver driver) {
        this.driver = driver;
    }

    @BeforeEach
    private void setup(){
        this.driver = new ChromeDriver();
    }

    public List<WebElement> getPlanets(){
        var planets = driver.findElements(By.className("planet"));

        return planets;
    }

    public PlanetsPage getPlanet(String planetName){

        for(var planet : getPlanets()){
            if(getPlanetName(planet).equals(planetName)){
                this.planetElement = planet;
            }
        }

        return this;
    }

    public WebElement getPlanetElement(){
        return this.planetElement;
    }

    public float getRadius() throws ParseException {
        var radius = this.planetElement.findElement(By.className("radius")).getText();

        return NumberFormat.getNumberInstance().parse(radius.split(" ")[0]).floatValue();
    }

    private String getPlanetName(WebElement planet) {
        return planet.findElement(By.cssSelector("h2")).getText();
    }

    private void setName(String planetName) {
        this.planetName = planetName;
    }

    public void clickExploreThenClickCloseButton(){

        for(var planet: getPlanets()){
            if(planet.findElement(By.cssSelector(".v-btn__content")).getText().equals("EXPLORE")){

                planet.findElement(By.cssSelector(".v-btn__content")).click();

                WebElement explorerModal = driver.findElement(By.cssSelector(".v-snack__wrapper"));
                new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(explorerModal));

                WebElement closeExplorerModalBtn = driver.findElement(By.cssSelector("[aria-label=close]"));
                closeExplorerModalBtn.click();
            }

        }
    }

    public String getExplorerModalText(String planetName){

        getPlanet(planetName);

        this.planetElement.findElement(By.cssSelector(".v-btn__content")).click();

        WebElement explorerModal = driver.findElement(By.cssSelector(".v-snack__wrapper"));
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(explorerModal));

        return driver.findElement(By.cssSelector(".snackbar")).getText();
    }

    public List<WebElement> getPlanetWithRadiusGreaterThan4000kms(Predicate<PlanetsPage> filter) throws ParseException {

        List<WebElement> planetsWithRadiusGT4000 = new ArrayList<WebElement>();

        for(var planet: getPlanets()){
            getPlanet(planet.findElement(By.cssSelector("h2")).getText());
            if(filter.test(this)){
                 planetsWithRadiusGT4000.add(this.planetElement);
            }


        }
        return planetsWithRadiusGT4000;
    }


//
//    public float getRadius(){
//
//    }
//
//    public long getDistance(){
//
//    }

}
