// Clase para la interfaz de usuario basada en consola
package com.challengejavabackend.proyectoconversordemonedas.ui;

import com.challengejavabackend.proyectoconversordemonedas.modelo.Moneda;
import com.challengejavabackend.proyectoconversordemonedas.modelo.TasaCambio;
import com.challengejavabackend.proyectoconversordemonedas.servicio.ServicioConvertidorMonedas;

import java.util.Scanner;

public class ConsoleUI {
    private final ServicioConvertidorMonedas servicio;  // Servicio de conversión
    private final Scanner scanner;  // Escáner para recibir datos del usuario

    // Constructor que inicializa el servicio de conversión y el escáner
    public ConsoleUI(ServicioConvertidorMonedas servicio) {
        this.servicio = servicio;
        this.scanner = new Scanner(System.in);
    }

    // Método que inicia la interfaz de usuario en consola
    public void iniciar() {
        try {
            // Actualizar las tasas de cambio antes de comenzar
            servicio.actualizarTasas();
            while (true) {
                // Mostrar el menú
                mostrarMenu();
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea

                // Salir si la opción es 7
                if (opcion == 7) {
                    System.out.println("Gracias por usar el conversor de monedas. ¡Hasta luego!");
                    break;
                }

                // Manejar la opción elegida
                manejarOpcion(opcion);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Método que muestra el menú de opciones
    private void mostrarMenu() {
        System.out.println("\n--- Conversor de Monedas ---");
        System.out.println("1. ARS a USD");
        System.out.println("2. BOB a USD");
        System.out.println("3. BRL a USD");
        System.out.println("4. CLP a USD");
        System.out.println("5. COP a USD");
        System.out.println("6. USD a otra moneda");
        System.out.println("7. Salir");
        System.out.print("Elija una opción: ");
    }

    // Método para manejar la opción seleccionada por el usuario
    private void manejarOpcion(int opcion) {
        String codigoMonedaOrigen;
        String codigoMonedaDestino = "USD";  // Por defecto, convertir a USD

        // Determinar la moneda de origen según la opción elegida
        switch (opcion) {
            case 1:
                codigoMonedaOrigen = "ARS";
                break;
            case 2:
                codigoMonedaOrigen = "BOB";
                break;
            case 3:
                codigoMonedaOrigen = "BRL";
                break;
            case 4:
                codigoMonedaOrigen = "CLP";
                break;
            case 5:
                codigoMonedaOrigen = "COP";
                break;
            case 6:
                codigoMonedaOrigen = "USD";
                System.out.print("Ingrese la moneda de destino (ARS, BOB, BRL, CLP, COP): ");
                codigoMonedaDestino = scanner.nextLine().toUpperCase();  // Leer y convertir a mayúsculas
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }

        // Solicitar la cantidad a convertir
        System.out.print("Ingrese la cantidad a convertir: ");
        double cantidad = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea

        // Realizar la conversión y mostrar el resultado
        try {
            double resultado = servicio.convertir(codigoMonedaOrigen, codigoMonedaDestino, cantidad);
            Moneda monedaOrigen = servicio.getMonedas().get(codigoMonedaOrigen);
            Moneda monedaDestino = servicio.getMonedas().get(codigoMonedaDestino);
            TasaCambio tasa = servicio.getTasas().get(codigoMonedaDestino);

            System.out.printf("%.2f %s = %.2f %s%n", cantidad, monedaOrigen, resultado, monedaDestino);
            System.out.println("Tasa de cambio: " + tasa);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
