import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MatchingFunctions {
    public static List<WebElement> getPlanetsWithRadiusGT4000(PlanetsPage planetspage) throws ParseException {

        List<WebElement> planetsWithRadiusGT4000 = new ArrayList<WebElement>();

        for(var planet: planetspage.getPlanets()){
            planetspage.getPlanet(planet.findElement(By.cssSelector("h2")).getText());
            if(planetspage.getRadius()>4000){
                planetsWithRadiusGT4000.add(planetspage.getPlanetElement());
            }
        }

        return planetsWithRadiusGT4000;
    }

    public static Predicate<PlanetsPage> getFilter() {
        return planetsPage -> {
            try {
                return planetsPage.getRadius()>4000;
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return false;
        };
    }
}
