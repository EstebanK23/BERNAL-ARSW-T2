/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arsw.OpenWeather.OpenWeatherServices.implement;

import edu.escuelaing.arsw.OpenWeather.OpenWeatherServices.OpenWeatherService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.springframework.stereotype.Service;

/**
 *
 * @author esteb
 */

@Service("OpenWeatherServiceImplement")
public class OpenWeatherServiceImplement implements OpenWeatherService{

    @Override
    public String WeatherByNameCity(String name) throws IOException {
        String USER_AGENT = "Mozilla/5.0";
        String GET_URL = "https://api.openweathermap.org/data/2.5/weather?q="+name+"&appid=aa65af396b5bbca9d2a344ba26d95e5f";
        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {

                response.append(inputLine);
            }
            in.close();

            return response.toString();
        } else {

            return "GET request not worked";
        }

    }
}
