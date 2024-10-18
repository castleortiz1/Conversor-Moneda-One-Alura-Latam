package com.challengejavabackend.proyectoconversordemonedas.servicio;

import com.challengejavabackend.proyectoconversordemonedas.api.ClienteTasaCambio;
import com.challengejavabackend.proyectoconversordemonedas.api.RespuestaTasaCambio;
import com.challengejavabackend.proyectoconversordemonedas.modelo.Moneda;
import com.challengejavabackend.proyectoconversordemonedas.modelo.TasaCambio;

import java.util.HashMap;
import java.util.Map;

public class ServicioConvertidorMonedas {
    private final ClienteTasaCambio cliente;
    private final Map<String, Moneda> monedas;
    private Map<String, TasaCambio> tasas;  // Este es el mapa de tasas de cambio

    public ServicioConvertidorMonedas() {
        this.cliente = new ClienteTasaCambio();  // Cliente que consulta las tasas de cambio
        this.monedas = inicializarMonedas();  // Inicializa las monedas disponibles
    }

    // Método para inicializar las monedas que se pueden convertir
    private Map<String, Moneda> inicializarMonedas() {
        Map<String, Moneda> mapa = new HashMap<>();
        mapa.put("USD", new Moneda("USD", "Dólar Estadounidense"));
        mapa.put("ARS", new Moneda("ARS", "Peso Argentino"));
        mapa.put("BOB", new Moneda("BOB", "Boliviano"));
        mapa.put("BRL", new Moneda("BRL", "Real Brasileño"));
        mapa.put("CLP", new Moneda("CLP", "Peso Chileno"));
        mapa.put("COP", new Moneda("COP", "Peso Colombiano"));
        return mapa;
    }

    // Método para actualizar las tasas de cambio usando un cliente API
    public void actualizarTasas() throws Exception {
        RespuestaTasaCambio respuesta = cliente.obtenerTasasRecientes();
        this.tasas = new HashMap<>();  // Inicializa el mapa de tasas

        for (Map.Entry<String, Double> entry : respuesta.getTasas().entrySet()) {
            Moneda monedaOrigen = monedas.get("USD");  // Asumimos que el USD es la moneda base
            Moneda monedaDestino = monedas.get(entry.getKey());

            if (monedaOrigen != null && monedaDestino != null) {
                tasas.put(entry.getKey(), new TasaCambio(monedaOrigen, monedaDestino, entry.getValue()));
            }
        }
    }

    // Método que devuelve el mapa de tasas de cambio
    public Map<String, TasaCambio> getTasas() {
        return tasas;
    }

    // Método para devolver el mapa de monedas
    public Map<String, Moneda> getMonedas() {
        return monedas;
    }

    // Método para convertir de una moneda a otra
    public double convertir(String codigoMonedaOrigen, String codigoMonedaDestino, double cantidad) {
        if (tasas == null) {
            throw new IllegalStateException("Las tasas de cambio no han sido inicializadas. Llama a actualizarTasas() primero.");
        }

        TasaCambio tasaOrigen = tasas.get(codigoMonedaOrigen);
        TasaCambio tasaDestino = tasas.get(codigoMonedaDestino);

        if (tasaOrigen == null || tasaDestino == null) {
            throw new IllegalArgumentException("Código de moneda no válido.");
        }

        return (cantidad / tasaOrigen.getTasa()) * tasaDestino.getTasa();
    }
}
