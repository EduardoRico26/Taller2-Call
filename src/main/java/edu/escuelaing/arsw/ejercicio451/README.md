# Ejercicio 4.5.1 - Servidor Web Secuencial

## Objetivo

Implementar un servidor web en Java capaz de atender múltiples solicitudes HTTP de manera secuencial y servir recursos estáticos como páginas HTML e imágenes solicitadas desde un navegador web.

---

## Marco Teórico

Este ejercicio se basa en los conceptos de sockets TCP trabajados en ejercicios anteriores y los extiende al protocolo HTTP.

HTTP (*HyperText Transfer Protocol*) es el protocolo utilizado para la comunicación entre navegadores web y servidores. Un cliente envía una solicitud HTTP y el servidor responde con el recurso solicitado junto con los encabezados correspondientes.

Un servidor web realiza generalmente las siguientes tareas:

1. Escucha conexiones entrantes en un puerto determinado.
2. Recibe e interpreta solicitudes HTTP.
3. Localiza el recurso solicitado.
4. Genera una respuesta HTTP válida.
5. Envía el contenido solicitado al cliente.

A diferencia de los ejercicios anteriores, este servidor permanece activo y puede procesar múltiples solicitudes consecutivas sin necesidad de reiniciarse.

---

## Desarrollo del Ejercicio

Se implementó un servidor web utilizando las clases `ServerSocket` y `Socket`.

El servidor escucha en el puerto `35000` y permanece ejecutándose continuamente mediante un ciclo de espera.

Cuando recibe una solicitud:

1. Extrae la ruta solicitada desde la petición HTTP.
2. Busca el archivo correspondiente dentro del directorio de recursos.
3. Determina el tipo de contenido del archivo.
4. Genera los encabezados HTTP adecuados.
5. Envía el recurso solicitado al navegador.

El servidor soporta:

* Archivos HTML (`.html`)
* Imágenes PNG (`.png`)
* Imágenes JPG/JPEG (`.jpg`, `.jpeg`)
* Otros recursos estáticos compatibles con la detección MIME del sistema operativo.

### Flujo de Solicitud

```text
Navegador
    |
    | GET /index.html
    |
Servidor Web
    |
    +--> Busca archivo
    |
    +--> Genera respuesta HTTP
    |
    +--> Envía contenido
```

---

## Comandos de Ejecución

### Compilación

```bash
javac src/main/java/edu/escuelaing/arsw/ejercicio451/WebServer.java
```

### Ejecutar el Servidor

```bash
java -cp src/main/java edu.escuelaing.arsw.ejercicio451.WebServer
```

### Acceso desde el Navegador

```text
http://localhost:35000
```

Ejemplos:

```text
http://localhost:35000/index.html
http://localhost:35000/img/logo.png
```

---

## Análisis de Resultados

El servidor implementado logró atender múltiples solicitudes HTTP consecutivas sin requerir reinicio.

Durante las pruebas realizadas se verificó que el navegador pudo solicitar y visualizar correctamente:

* Páginas HTML.
* Imágenes PNG.
* Recursos estáticos adicionales.

Asimismo, el servidor generó correctamente los encabezados HTTP necesarios para que el navegador interpretara adecuadamente cada recurso enviado.

Este ejercicio demuestra la relación entre los sockets TCP y el protocolo HTTP, proporcionando una implementación simplificada del funcionamiento básico de un servidor web moderno.

---

## Evidencias

### Ejecución del Servidor

![alt text](../Imagenes/451.1.png)

### Acceso desde el Navegador

![alt text](../Imagenes/451.2.png)

![alt text](../Imagenes/451.3.png)

### Entrega de Imágenes

![alt text](../Imagenes/451.4.png)

---

## Conclusiones

1. El protocolo HTTP puede implementarse directamente sobre sockets TCP.
2. Un servidor web es responsable de interpretar solicitudes y generar respuestas HTTP válidas.
3. Los recursos estáticos como páginas HTML e imágenes pueden ser servidos mediante aplicaciones Java personalizadas.
4. El procesamiento secuencial permite mantener el servidor activo para atender múltiples solicitudes consecutivas.
5. Este ejercicio constituye una base importante para comprender la arquitectura de servidores web y aplicaciones distribuidas modernas.

---

## Bibliografía

1. Benavides, L. D., & Gualtero, R. H. (2026). *Introducción a esquemas de nombres, redes, clientes y servicios con Java* [Guía de laboratorio]. Escuela Colombiana de Ingeniería Julio Garavito.

2. Benavides, L. D. (2026). *Connectors and Components (C&C) – Call and Return Styles* [Presentación de clase]. Escuela Colombiana de Ingeniería Julio Garavito.

3. OpenAI. (2026). *ChatGPT (GPT-5.5 version) [Large Language Model]*. https://chatgpt.com/ (Used primarily as a support tool).

4. Oracle. (s.f.). *Custom Networking Tutorial*. Oracle Documentation. https://docs.oracle.com/javase/tutorial/networking/index.html
