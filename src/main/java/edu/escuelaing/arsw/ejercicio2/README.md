# Ejercicio 2 - Lectura y Almacenamiento de Contenido Web

## Objetivo

Desarrollar una aplicación en Java capaz de solicitar una URL al usuario, acceder al contenido disponible en dicha dirección mediante flujos de datos de red y almacenar la información obtenida en un archivo HTML local para su posterior visualización en un navegador web.

---

## Marco Teórico

Java proporciona diversas utilidades para el trabajo en red a través del paquete `java.net`. Una de las clases más utilizadas es `URL`, la cual representa la ubicación de un recurso en Internet.

Una URL no solo permite identificar un recurso, sino también acceder a su contenido. Mediante el método `openStream()`, es posible abrir un flujo de entrada que permite leer la información proveniente de un servidor remoto de la misma manera que se leería información desde un archivo local o desde el teclado.

Los flujos (*streams*) constituyen un concepto fundamental en las operaciones de entrada y salida (I/O) de Java. En este ejercicio se utilizaron:

* `InputStream` para recibir datos desde un recurso remoto.
* `InputStreamReader` para convertir los datos recibidos en caracteres.
* `BufferedReader` para realizar una lectura eficiente línea por línea.
* `FileWriter` y `PrintWriter` para almacenar la información obtenida en un archivo local.

Este mecanismo es la base de múltiples aplicaciones distribuidas, clientes HTTP, navegadores web y sistemas que consumen recursos disponibles en Internet.

---

## Desarrollo del Ejercicio

Se implementó una aplicación en Java que realiza las siguientes acciones:

1. Solicita una URL al usuario.
2. Crea un objeto `URL` a partir de la dirección ingresada.
3. Abre un flujo de entrada hacia el recurso remoto.
4. Lee el contenido línea por línea utilizando un `BufferedReader`.
5. Almacena la información recuperada en un archivo denominado `resultado.html`.
6. Cierra correctamente todos los recursos utilizados.

### Código Implementado

```java
Scanner scanner = new Scanner(System.in);

System.out.print("Ingrese una URL: ");
String direccion = scanner.nextLine();

URL url = new URL(direccion);

BufferedReader reader =
        new BufferedReader(
                new InputStreamReader(url.openStream()));

PrintWriter writer =
        new PrintWriter(
                new FileWriter("resultado.html"));

String linea;

while ((linea = reader.readLine()) != null) {
    writer.println(linea);
}

reader.close();
writer.close();
```

---

## Análisis de Resultados

La aplicación logró establecer una conexión con el recurso web especificado, descargar su contenido HTML y almacenarlo correctamente en un archivo local denominado `resultado.html`.

Durante las pruebas realizadas se observó que:

* Las URLs válidas permitieron generar correctamente el archivo HTML.
* Las URLs mal formadas generaron excepciones del tipo `MalformedURLException`.
* Las URLs asociadas a dominios inexistentes generaron excepciones del tipo `UnknownHostException`, indicando un fallo en la resolución DNS.

Al abrir el archivo generado en un navegador web, el contenido descargado fue renderizado correctamente, demostrando que la aplicación logró recuperar y almacenar exitosamente la información proveniente del servidor remoto.

Este ejercicio evidencia cómo una aplicación Java puede consumir recursos disponibles en Internet utilizando flujos de datos y mecanismos básicos de entrada y salida.

---

## Evidencias

### Ejecución del Programa

![alt text](../Imagenes/Ev2.1.png)

### Visualización del Archivo Generado

![alt text](../Imagenes/Ev2.2.png)

---

## Conclusiones

1. La clase `URL` permite acceder de manera sencilla a recursos disponibles en Internet desde aplicaciones Java.
2. Los flujos de entrada pueden utilizarse para procesar información proveniente de servidores remotos de la misma forma que se procesan archivos locales.
3. Las clases de entrada y salida de Java facilitan la transferencia de información desde recursos web hacia archivos almacenados localmente.
4. El manejo adecuado de excepciones es fundamental al trabajar con recursos de red, debido a posibles errores de conexión, dominios inexistentes o direcciones mal formadas.
5. Este ejercicio constituye una base importante para comprender el funcionamiento de clientes HTTP y mecanismos más avanzados de comunicación cliente-servidor.

---

## Bibliografía

1. Benavides, L. D., & Gualtero, R. H. (2026). *Introducción a esquemas de nombres, redes, clientes y servicios con Java* [Guía de laboratorio]. Escuela Colombiana de Ingeniería Julio Garavito.

2. Benavides, L. D. (2026). *Connectors and Components (C&C) – Call and Return Styles* [Presentación de clase]. Escuela Colombiana de Ingeniería Julio Garavito.

3. OpenAI. (2026). *ChatGPT (GPT-5.5 version) [Large Language Model]*. https://chatgpt.com/ (Used primarily as a support tool).

4. Oracle. (s.f.). *Custom Networking Tutorial*. Oracle Documentation. https://docs.oracle.com/javase/tutorial/networking/index.html
