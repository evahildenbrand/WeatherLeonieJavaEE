package at.htl.weather.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Path("/")
public class WeatherEndpoint {
    String csvFile = "http://www.zamg.ac.at/ogd/";
    BufferedReader br = null;
    int lineIndex = 1;
    String line = "";
    String splitLine = ";";
    int tempIndex = 5;
    int windSpeedIndex = 9;
    int rainIndex = 12;
    int sunIndex = 15;
    String[] weatherArray;

    @GET
    public String actualWeather(){
//        try {
//            br = new BufferedReader(new FileReader(csvFile));
//            line = br.readLine();
//
//            weatherArray= line.split(splitLine);
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found " + e.getMessage());
//        } catch (IOException e) {
//            System.out.println("IOException " + e.getMessage());
//        }
        return "adskjlf";
    }
}
