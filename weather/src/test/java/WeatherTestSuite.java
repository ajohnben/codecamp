import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class WeatherTestSuite {
    @Test
    public void CheckStatus200Test(){
        given().
            param("lat", -27.470125).
            param("lon", 153.021072).
            param("dt",1630116000).
            param("appid","9fbf5a6110ecf8030452087230aa3dfc").
        when().
                get("https://api.openweathermap.org/data/2.5/onecall/timemachine").
        then().
                statusCode(200);
                //System.out.println();
    }

    @Test
    public void GivenDate_CheckPropertyValues_Test() throws ParseException {
        float temp = (float) 22.63;
        int sunrise = (int) (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("28/08/2021 6:06:15").getTime() / 1000);

        given().
            param("lat", -27.470125).
            param("lon", 153.021072).
            param("dt",1630116000).
            param("appid","9fbf5a6110ecf8030452087230aa3dfc").
            param("units", "metric").
        when().
            get("https://api.openweathermap.org/data/2.5/onecall/timemachine").
        then().
            body("current.temp",equalTo(temp),
            "current.humidity", equalTo(33),
                    "current.sunrise", equalTo(sunrise));

    }
}
