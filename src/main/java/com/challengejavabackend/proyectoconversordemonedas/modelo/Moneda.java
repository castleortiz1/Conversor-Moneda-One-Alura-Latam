// Esta clase representa una moneda con su código y nombre
package com.challengejavabackend.proyectoconversordemonedas.modelo;

public class Moneda {
    private final String codigo;
    private final String nombre;

    // Constructor que inicializa la moneda con código y nombre
    public Moneda(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    // Métodos para obtener el código y nombre de la moneda
    public String obtenerCodigo() {
        return codigo;
    }

    public String obtenerNombre() {
        return nombre;
    }

    // Método que devuelve la moneda como cadena de texto
    @Override
    public String toString() {
        return codigo + " - " + nombre;
    }
}
