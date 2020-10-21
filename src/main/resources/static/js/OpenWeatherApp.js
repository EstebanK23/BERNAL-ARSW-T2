/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var OpenWeatherApp = (function () {
    function pintar(data) {
        data = JSON.parse(data);
        if (data == null) {
            return new Error("No se encontro");
        }
        var datos_tabla = "<tr><td id=\"city\">" + data.name + "<td id=\"description\">" + data.weather[0].description + "<td id=\"city\">" + data.main.temp + "</td><td id=\"tempMax\">" + data.main.temp_max + "</td><td id=\"tempMin\">" + data.main.temp_min + "</td><td id=\"Cloud\">" + data.clouds.all + "</td> </tr>";
        $("#t01  tbody").append(datos_tabla);
    }

    return {
        WeatherByNameCity: function (nombre) {
            OpenWeatherClient.WeatherByNameCity(pintar, nombre);
        },
    };

})();