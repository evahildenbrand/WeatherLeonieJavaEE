package at.htl.wether.rest;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.util.List;

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

    public WeatherEndpoint() throws MalformedURLException {
    }

    @GET
    public Response actualWeather(){
        /*input = new InputStreamReader(url.getInputStream());
        br = new BufferedReader(input);

        for(int i = 0; i <= lineIndex){
            line = br.readLine();
            weatherArray = line.split(splitLine);

            System.out.println(weatherArray[town] + ": \n" +
                    "" + weatherArray[tempIndex] + " °C \n" +
                    "" + weatherArray[windSpeedIndex] + " km/h \n" +
                    "" + weatherArray[rainIndex] + " l/m² \n" +
                    "" + weatherArray[sunIndex] + " %");
        }*/

        JsonArrayBuilder array = Json.createArrayBuilder();
        JsonObjectBuilder object = Json.createObjectBuilder();

        try {
            URLConnection conn = url.openConnection();
            input = new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8);

            BufferedReader br = new BufferedReader(input);

            br.readLine();
            String line;
            while((line = br.readLine()) != null){
                weatherArray = line.split(splitLine);

                System.out.println(weatherArray[town] + ": \n" +
                        "" + weatherArray[tempIndex] + " °C \n" +
                        "" + weatherArray[windSpeedIndex] + " km/h \n" +
                        "" + weatherArray[rainIndex] + " l/m² \n" +
                        "" + weatherArray[sunIndex] + " %");

                object.add("Town", weatherArray[town]);
                object.add("Temperatur", weatherArray[tempIndex]);
                object.add("Windgeschwindigkeit", weatherArray[windSpeedIndex]);
                object.add("Regenmenge", weatherArray[rainIndex]);
                object.add("Sonnenschein", weatherArray[sunIndex]);

                array.add(object);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException ex){
            System.out.println("Mistake");
        }

        return Response.ok(array.build()).build();

    }
}
