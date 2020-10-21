/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var cliente = OpenWeatherClient;
var ciudad;

var OpenWeatherApp = (function () {
    function pintar(data) {
        if (data == null) {
            return new Error("No se encontro");
        }
        lista = [];
        var lista = data.map(function (pb) {
            return {weather: pb.weather.main, tempMax: pb.main.temp_max, tempMin: pb.main.temp_min, Cloud: pb.clouds.all}
        })

        lista.map(function (pb) {

            var fila = <tr><td id="weather"> ${pb.weather} </td><td id="tempMax">${pb.tempMax}</td><td id="tempMin"> ${pb.tempMin} </td><td id="Cloud"> ${pb.Cloud}</td> </tr>;
            $("#t01  tbody").append(fila);

        })
    }

    return {
        WeatherByNameCity: function (nombre) {
            cliente.WeatherByNameCity(nombre, pintar);
        },
    };

})();