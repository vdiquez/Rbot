# Rbot
Robot Virtual Controlado a Distancia (Java3D)

Software resultado de la tesis de grado de Victor Ocanto y Ronald Verenzuela en el año 2007 en el Instituto Universitario Experimental de Tecnología de La Victoria (IUTLV), actualmente UPTA.

Tutores:
- Ing. Andrés Castillo.
- Ing. Felipe Pacheco.

Instalación necesaria:
- Java SE Development Kit 8 Downloads. http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
- Java 3D 1.5.1. http://www.oracle.com/technetwork/java/javasebusiness/downloads/java-archive-downloads-java-client-419417.html#java3d-1.5.1-oth-JPR

Para poder compilar correctamente debe agregarse el .jar ubicada en la carpeta "Rbot\loader\portfolio" con nombre "portfolio.jar" en el IDE con el que estes trabajando (este proyecto fue abierto en Intellij Idea 2017.1).

Se debe ejecutar la clase "VentanaTodo". En esta clase se levantan dos hilos.
  * VentanaTodo(), carga el universo virtual donde se situa el robot.
	* ProgramaChat(), carga la camara virtual del robot y control de mando.
  
En ambas ventanas se tiene el menú "Ubicacion y Destino", el cual debe abrirse y tipear en los campos correspondientes a la ip y puerto, de la otra ventana.

Para mover el Rbot se presionan las teclas de direccionamiento, Arriba, Abajo, Derecha, Izquierda.
Para mover la cámara deben presionarse los Spinner de la ventana de mando.
