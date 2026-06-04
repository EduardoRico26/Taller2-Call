# Ejercicio 1 - Reconocimiento de los componentes de una URL en Java

## Objetivo

Comprender la estructura de una URL y familiarizarse con la clase `URL` del paquete `java.net`, identificando y extrayendo sus diferentes componentes mediante los métodos proporcionados por Java.

---

## Marco Teórico

Una URL (*Uniform Resource Locator*) es una dirección utilizada para localizar recursos en una red, generalmente Internet. Una URL está compuesta por diferentes partes que permiten identificar el protocolo de comunicación, el servidor que aloja el recurso y la ubicación específica del mismo.

La estructura general de una URL es:

```text
<protocolo>://<servidor>:<puerto>/<ruta>?<consulta>#<referencia>
```

Por ejemplo:

```text
http://www.ejemplo.com:80/docs/index.html?curso=arsw#capitulo1
```

La clase `URL` del paquete `java.net` permite representar una dirección URL y proporciona métodos para acceder a cada uno de sus componentes:

| Método           | Descripción                                  |
| ---------------- | -------------------------------------------- |
| `getProtocol()`  | Obtiene el protocolo utilizado.              |
| `getAuthority()` | Obtiene la autoridad (host y puerto).        |
| `getHost()`      | Obtiene el nombre del servidor.              |
| `getPort()`      | Obtiene el puerto especificado.              |
| `getPath()`      | Obtiene la ruta del recurso.                 |
| `getQuery()`     | Obtiene los parámetros de consulta.          |
| `getFile()`      | Obtiene la ruta junto con la consulta.       |
| `getRef()`       | Obtiene la referencia o fragmento de la URL. |

---

## Desarrollo del Ejercicio

Se implementó una aplicación en Java que crea un objeto `URL` utilizando una dirección de ejemplo y posteriormente consulta cada uno de los métodos estudiados para mostrar sus valores por consola.

### Código implementado

```java
URL url = new URL(
    "http://www.eduardorico.com:80/docs/index.html?curso=arsw#ejercicio1"
);

System.out.println("Protocol: " + url.getProtocol());
System.out.println("Authority: " + url.getAuthority());
System.out.println("Host: " + url.getHost());
System.out.println("Port: " + url.getPort());
System.out.println("Path: " + url.getPath());
System.out.println("Query: " + url.getQuery());
System.out.println("File: " + url.getFile());
System.out.println("Ref: " + url.getRef());
```

---

## Análisis de Resultados

Al ejecutar el programa se observó que cada método retorna correctamente una sección específica de la URL.

Por ejemplo:

* El protocolo retornado fue `http`.
* El host identificado fue `www.eduardorico.com`.
* El puerto correspondió al valor `80`.
* La ruta del recurso fue `/docs/index.html`.
* La consulta recuperada fue `curso=arsw`.
* La referencia obtenida fue `ejercicio1`.

Esto demuestra que la clase `URL` permite descomponer una dirección web en sus elementos fundamentales, facilitando su procesamiento dentro de aplicaciones Java que interactúan con recursos de red.

---

## Evidencias

### Ejecución del programa

**Figura 1.** Resultado de la ejecución del ejercicio en consola.

![Ejecución Ejercicio 1](Taller2-Call/src/main/java/edu/escuelaing/arsw/ejercicio1/imagenes/ev1.png)

---

## Conclusiones

1. La clase `URL` del paquete `java.net` proporciona mecanismos sencillos para manipular y analizar direcciones web.
2. Una URL está compuesta por múltiples elementos que pueden ser consultados de manera independiente mediante métodos específicos.
3. El conocimiento de la estructura de una URL es fundamental para el desarrollo de aplicaciones cliente-servidor y servicios distribuidos.
4. Este ejercicio constituye la base para comprender posteriormente la comunicación mediante HTTP y la lectura de recursos disponibles en Internet.

---

## Bibliografía

Oracle. (2025). *Custom Networking Tutorial*. Java Documentation.

https://docs.oracle.com/javase/tutorial/networking/index.html
