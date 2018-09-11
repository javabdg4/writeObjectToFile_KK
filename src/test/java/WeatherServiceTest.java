import com.sda.writeObjectToFile.Weather;
import com.sda.writeObjectToFile.WeatherService;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class WeatherServiceTest {
    WeatherService ws=Mockito.mock(WeatherService.class);

    @Test
    public void getWeatherServiceTest(){
        Weather weatherTest=new Weather("Paris","//cdn.apixu.com/weather/64x64/day/113.png",24.0,24.6,"Sunny",48.87,2.33);

        WeatherService SUT=new WeatherService("http://api.apixu.com/v1/current.json","3a7c14511afc42169e4155255180709");
        Mockito.when(ws.getCityWeather("Paris")).thenReturn(SUT.getCityWeather("Paris"));

        assertEquals(weatherTest.getCity(),SUT.getCityWeather("Paris").getCity());
        assertEquals(weatherTest.getConditionText(),SUT.getCityWeather("Paris").getConditionText());
        assertEquals(weatherTest.getFeelslikeC(),SUT.getCityWeather("Paris").getFeelslikeC(),0.000004);
        assertEquals(weatherTest.getIconUrl(),SUT.getCityWeather("Paris").getIconUrl());
        assertEquals(weatherTest.getLat(),SUT.getCityWeather("Paris").getLat(),0.0000444);
        assertEquals(weatherTest.getLon(),SUT.getCityWeather("Paris").getLon(),0.000000005);
    }
}
