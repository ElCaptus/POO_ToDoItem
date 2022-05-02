# OO2

Este repositorio al igual que todos los comenzados en POO_ estan hechos con el proposito de mostrar 
ejercicios hechos durante la materia OO2.
En esta materia enseñan y realizan ejercicios relacionados a los patrones de diseño.

Practica 3: Patrones **Strategy** y **State**

# Practica 3 Ejercicio 1: ToDoItem
Se desea definir un sistema de seguimiento de tareas similar a [Jira](https://es.atlassian.com/software/jira). 
En este sistema hay tareas en las cuales se puede definir el nombre y una serie de comentarios. Las tareas atraviesan diferentes etapas a lo largo de su ciclo de vida y ellas son: *pending, in-progress, paused y finished*. Cada tarea debe estar modelada mediante la clase ToDoItem con el siguiente protocolo: 

```java
public class ToDoItem {
/**
* Instancia un ToDoItem nuevo en estado pending con <name> como nombre.
*/
        public ToDoItem(String name)

   	/**
* Pasa el ToDoItem a in-progress (siempre y cuando su estado actual sea
* pending, si se encuentra en otro estado, no hace nada)
*/
        public void start()

	/**
* Pasa la tarea a paused si su estado es in-progress, o a in-progress si su
* estado es paused. Caso contrario (pending o finished) genera un error
* informando la causa específica del mismo
*/
        public void togglePause()


	/**
* Pasa el ToDoItem a finished (siempre y cuando su estado actual sea 
* in-progress o pausada, si se encuentra en otro estado, no hace nada)
*/
        public void finish()


	/**
* Retorna el tiempo que transcurrió desde que se inició la tarea (start)
* hasta que se finalizó. En caso de que no esté finalizada, el tiempo que
* haya transcurrido hasta el momento actual. Si la tarea no se inició,
* genera un error informando la causa específica del mismo.
*/
        public Duration workedTime()


/**
* Agrega un comentario a la tarea siempre y cuando no haya finalizado. Caso
* contrario no hace nada."
*/
        public void addComment(String comment)
}
```

### Nota: 
para generar o levantar un error debe utilizar la expresión 
```java
throw new RuntimeException("Este es mi mensaje de error");
```

El mensaje de error específico que se espera en este ejercicio debe ser descriptivo del caso. Por ejemplo, para el método togglePause() , el mensaje de error debe indicar que el ToDoItem no se encuentra en in-progress o paused: 
```java
	throw new RuntimeException("El objeto ToDoItem no se encuentra en pause o in-progress");
```

## Tareas:
1. Modele una solución orientada a objetos para el problema planteado utilizando un diagrama de clases UML. Si utilizó algún patrón de diseño indique cuáles son los participantes en su modelo de acuerdo a Gamma et al.
2. Implemente su solución en Java. Para comprobar cómo funciona recomendamos usar test cases.

- 

1. Se utiliza patron State.

![UML](/ToDoItemUML.png)

2. [Implementacion de solucion](/main/java/ar/edu/unlp/info/oo2/practica3_ejercicio1/). [Tests](/test/java/ar/edu/unlp/info/oo2/practica3_ejercicio1/)