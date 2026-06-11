# Ejercicio 3.3.1 - Servidor de Cuadrados usando Sockets TCP

## Objetivo

Implementar una aplicación cliente-servidor utilizando sockets TCP en Java, donde el cliente envía un valor numérico al servidor y este calcula y retorna el cuadrado del número recibido.

---

## Marco Teórico

Los sockets son puntos finales de comunicación que permiten el intercambio de datos entre aplicaciones que se ejecutan en una red. En Java, la comunicación mediante sockets se implementa a través de las clases `Socket` y `ServerSocket` del paquete `java.net`.

El modelo cliente-servidor está compuesto por dos elementos principales:

* **Cliente:** inicia la comunicación y envía solicitudes.
* **Servidor:** permanece escuchando conexiones, procesa las solicitudes y genera respuestas.

El protocolo TCP (*Transmission Control Protocol*) proporciona una comunicación confiable garantizando la entrega y el orden de los mensajes intercambiados.

En este ejercicio se implementó un protocolo simple:

1. El cliente envía un número.
2. El servidor calcula el cuadrado del número recibido.
3. El servidor retorna el resultado al cliente.

---

## Desarrollo del Ejercicio

Se desarrollaron dos aplicaciones independientes:

### SquareServer

El servidor escucha en el puerto `35000`, acepta conexiones entrantes, recibe valores numéricos, calcula su cuadrado y envía el resultado al cliente.

### SquareClient

El cliente establece una conexión TCP con el servidor, envía un número ingresado por el usuario y presenta la respuesta recibida.

### Flujo de Comunicación

```text
Cliente  ----->  Número
Servidor ----->  Cuadrado(Número)
```

---

## Comandos de Ejecución

### Compilación

```bash
javac src/main/java/edu/escuelaing/arsw/ejercicio331/*.java
```

### Ejecutar el Servidor

```bash
java -cp src/main/java edu.escuelaing.arsw.ejercicio331.SquareServer
```

### Ejecutar el Cliente

```bash
java -cp src/main/java edu.escuelaing.arsw.ejercicio331.SquareClient
```

---

## Análisis de Resultados

El servidor logró aceptar conexiones entrantes mediante un socket TCP y procesar correctamente las solicitudes enviadas por el cliente.

Durante las pruebas realizadas se observó que:

* El cliente transmitió correctamente los valores numéricos.
* El servidor calculó adecuadamente el cuadrado de cada número recibido.
* Los resultados fueron enviados nuevamente al cliente mediante la conexión establecida.
* Las entradas inválidas fueron detectadas y gestionadas mediante validaciones apropiadas.

Este ejercicio demuestra la implementación básica de comunicación cliente-servidor mediante sockets TCP y evidencia cómo las aplicaciones Java pueden intercambiar información utilizando flujos de datos de red.

---

## Evidencias

### Ejecución del Servidor

![alt text](../Imagenes/3.3.1.1.png)

### Ejecución del Cliente

![alt text](../Imagenes/3.3.1.2.png)

---

## Conclusiones

1. Los sockets TCP proporcionan un mecanismo confiable para la comunicación entre aplicaciones distribuidas.
2. Las clases `Socket` y `ServerSocket` facilitan la implementación de arquitecturas cliente-servidor en Java.
3. Los flujos de entrada y salida permiten intercambiar información a través de conexiones de red.
4. El paradigma cliente-servidor constituye la base de numerosos sistemas distribuidos modernos.
5. Este ejercicio proporciona una base sólida para el desarrollo de servicios de red y protocolos de comunicación más avanzados.

---

## Bibliografía

1. Benavides, L. D., & Gualtero, R. H. (2026). *Introducción a esquemas de nombres, redes, clientes y servicios con Java* [Guía de laboratorio]. Escuela Colombiana de Ingeniería Julio Garavito.

2. Benavides, L. D. (2026). *Connectors and Components (C&C) – Call and Return Styles* [Presentación de clase]. Escuela Colombiana de Ingeniería Julio Garavito.

3. OpenAI. (2026). *ChatGPT (GPT-5.5 version) [Large Language Model]*. https://chatgpt.com/ (Used primarily as a support tool).

4. Oracle. (s.f.). *Custom Networking Tutorial*. Oracle Documentation. https://docs.oracle.com/javase/tutorial/networking/index.html
