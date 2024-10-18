// Esta clase se encarga de hacer la solicitud a la API de tasas de cambio
package com.challengejavabackend.proyectoconversordemonedas.api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClienteTasaCambio {
    // Llave para acceder a la API (debes colocar tu propia API Key)
    private static final String CLAVE_API = "a56913d4635f86d1045d5f27";
    // URL base de la API donde se obtienen las tasas de cambio
    private static final String URL_BASE = "https://v6.exchangerate-api.com/v6/" + CLAVE_API + "/latest/USD";

    private final HttpClient clienteHttp;
    private final Gson gson;

    // Constructor que inicializa el cliente HTTP y el convertidor JSON
    public ClienteTasaCambio() {
        this.clienteHttp = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    // Método que obtiene las tasas de cambio más recientes
    public RespuestaTasaCambio obtenerTasasRecientes() throws Exception {
        // Crear la solicitud HTTP
        HttpRequest solicitud = HttpRequest.newBuilder()
                .uri(URI.create(URL_BASE))
                .build();

        // Enviar la solicitud y obtener la respuesta
        HttpResponse<String> respuesta = clienteHttp.send(solicitud, HttpResponse.BodyHandlers.ofString());

        // Si la respuesta no es exitosa, lanza un error
        if (respuesta.statusCode() != 200) {
            throw new RuntimeException("Error al obtener tasas de cambio: Código de error HTTP " + respuesta.statusCode());
        }

        // Convertir la respuesta JSON a un objeto
        JsonObject jsonRespuesta = gson.fromJson(respuesta.body(), JsonObject.class);
        return new RespuestaTasaCambio(jsonRespuesta);
    }
}
