// Esta clase convierte la respuesta de la API en un formato que podamos usar
package com.challengejavabackend.proyectoconversordemonedas.api;

import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;

public class RespuestaTasaCambio {
    // Mapa para almacenar las tasas de cambio
    private final Map<String, Double> tasas;

    // Constructor que inicializa el mapa con las tasas de la API
    public RespuestaTasaCambio(JsonObject jsonRespuesta) {
        this.tasas = new HashMap<>();
        JsonObject tasasDeConversion = jsonRespuesta.getAsJsonObject("conversion_rates");
        // Añadimos las tasas para monedas específicas (ARS, BOB, etc.)
        for (String moneda : new String[]{"ARS", "BOB", "BRL", "CLP", "COP", "HNL", "USD"}) {
            if (tasasDeConversion.has(moneda)) {
                tasas.put(moneda, tasasDeConversion.get(moneda).getAsDouble());
            }
        }
    }

    // Método para obtener las tasas de cambio
    public Map<String, Double> obtenerTasas() {
        return tasas;
    }

    public Map<String, Double> getTasas() {
        return tasas;
    }
}
