package com.challengejavabackend.proyectoconversordemonedas.modelo;

import java.time.LocalDateTime;

public class TasaCambio {
    private final Moneda monedaOrigen;
    private final Moneda monedaDestino;
    private final double tasa;
    private final LocalDateTime timestamp;

    public TasaCambio(Moneda monedaOrigen, Moneda monedaDestino, double tasa) {
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.tasa = tasa;
        this.timestamp = LocalDateTime.now();  // Guardar la fecha y hora de la tasa
    }

    public Moneda getMonedaOrigen() {
        return monedaOrigen;
    }

    public Moneda getMonedaDestino() {
        return monedaDestino;
    }

    public double getTasa() {
        return tasa;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return String.format("1 %s = %.4f %s (fecha: %s)", monedaOrigen.obtenerCodigo(), tasa, monedaDestino.obtenerCodigo(), timestamp);
    }
}
