package at.htl.weather.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@Path("/")
public class WeatherEndpoint {

    @GET
    public String actualWeather(){
        return "hello";
    }
}
