// Clase principal que inicia la interfaz de usuario en la consola
package com.challengejavabackend.proyectoconversordemonedas;

import com.challengejavabackend.proyectoconversordemonedas.servicio.ServicioConvertidorMonedas;
import com.challengejavabackend.proyectoconversordemonedas.ui.ConsoleUI;

public class Main {
    public static void main(String[] args) {
        // Crear el servicio de conversión de monedas
        ServicioConvertidorMonedas servicio = new ServicioConvertidorMonedas();

        // Crear la interfaz de usuario de consola y pasarle el servicio
        ConsoleUI ui = new ConsoleUI(servicio);

        // Iniciar la interfaz de usuario
        ui.iniciar();
    }
}
