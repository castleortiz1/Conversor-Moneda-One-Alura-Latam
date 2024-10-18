Conversor de Monedas

Descripción

Este proyecto es una aplicación en Java que permite convertir entre distintas monedas latinoamericanas y el dólar estadounidense. 
Utiliza una API externa para obtener las tasas de cambio actualizadas y permite realizar conversiones mediante una interfaz de consola interactiva.

Características
Conexión a una API externa para obtener tasas de cambio en tiempo real.
Conversión de las siguientes monedas: USD, ARS, BOB, BRL, CLP, COP.
Interfaz de usuario sencilla a través de consola.
Actualización dinámica de las tasas de cambio.

Requisitos
Java 11 o superior
Biblioteca Gson para procesar JSON.
API de ExchangeRate API (es necesario obtener una clave API).
Instalación
Clona este repositorio en tu máquina local:

Gitbash
https://github.com/castleortiz1/Conversor-Moneda-One-Alura-Latam
Importa el proyecto en tu IDE de preferencia (Eclipse, IntelliJ, etc.).

Añade la librería Gson al proyecto. Puedes descargarla desde aquí o usar un sistema de gestión de dependencias como Maven o Gradle.

Obtén una clave API gratuita desde ExchangeRate API y reemplázala en el archivo ExchangeRateClient.java:

java
private static final String API_KEY = "TU_CLAVE_API";
Ejecuta el proyecto desde la clase Main.java.

Uso
Al iniciar la aplicación, se presentará un menú donde podrás elegir entre diferentes opciones de conversión de monedas.
Ingresa la cantidad que deseas convertir y obtendrás el resultado junto con la tasa de cambio actual.

Menú de opciones:

Convertir de ARS a USD

Convertir de BOB a USD

Convertir de BRL a USD

Convertir de CLP a USD

Convertir de COP a USD

Convertir de USD a otra moneda

Salir

Ejemplo de Ejecución
--- Conversor de Monedas ---
1. ARS a USD
2. BOB a USD
3. BRL a USD
4. CLP a USD
5. COP a USD
6. USD a otra moneda
7. Salir
   
Elija una opción: 1

Ingrese la cantidad a convertir: 100

100.00 ARS = 0.25 USD

Tasa de cambio: 1 USD = 396.50 ARS (as of 2024-10-17T10:30:00)

Contribuir
Las contribuciones son bienvenidas. Puedes hacer un fork del repositorio, 
crear una nueva rama con tus cambios, y enviar un Pull Request.
