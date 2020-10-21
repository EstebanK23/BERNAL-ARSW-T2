/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arsw.OpenWeather.OpenWeatherControllers;

import edu.escuelaing.arsw.OpenWeather.OpenWeatherServices.OpenWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author esteb
 */
@RestController
@RequestMapping(value = "/openWeather")
public class OpenWeatherController {
    @Autowired
    @Qualifier("OpenWeatherServiceImplement")
    OpenWeatherService ows;
    
    @RequestMapping(path = "/{name}", method = RequestMethod.GET)
    public ResponseEntity<?> getWeatherByNameCity(@PathVariable(name = "name") String nombre) {
        try {
           System.out.println("Entro Controller");
            return new ResponseEntity<>(ows.WeatherByNameCity(nombre),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            return new ResponseEntity<>("400 bad request", HttpStatus.NOT_FOUND);
        }
    }
}
