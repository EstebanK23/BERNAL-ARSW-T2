/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

OpenWeatherClient = (function () {
    return {
        WeatherByNameCity: function (callback, name) {
            jQuery.ajax({
                url: "openWeather/" + name,
                success: function (result) {
                    callback(result);
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert("No se encontró el nombre solicitado");
                },
                async: true
            });
        }
    };
})();
