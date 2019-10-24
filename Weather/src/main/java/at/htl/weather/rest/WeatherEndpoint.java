package at.htl.weather.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.io.BufferedReader;
import java.util.List;

@Path("/")
public class WeatherEndpoint {
    String csvFile = "http://www.zamg.ac.at/ogd/";
    BufferedReader br = null;
    String splitCsv = "/\r?\n|\r/";
    int lineIndex = 1;
    String splitLine = ";";
    int tempIndex = 5;
    int windSpeedIndex = 9;
    int rainIndex = 12;
    int sunIndex = 15;

    @GET
    public String actualWeather(){
        return "hello";
    }
}
