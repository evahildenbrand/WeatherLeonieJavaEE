package at.htl.wether.rest;

import javax.ws.rs.Path;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

@Path("/")
public class WeatherEndpoint {
    String csvFile = "http://www.zamg.ac.at/ogd/";
    URL url = new URL(csvFile);
    BufferedReader br = null;
    InputStreamReader input = null;
    int lineIndex = 1;
    String line = "";
    String splitLine = ";";
    int town = 1;
    int tempIndex = 5;
    int windSpeedIndex = 9;
    int rainIndex = 12;
    int sunIndex = 15;
    String[] weatherArray;

}
