package ar.edu.unlp.info.oo2.practica3_ejercicio1;

import java.time.Duration;
import java.util.List;

public abstract class State {
	
	protected ToDoItem item; //es mejor ponerlo como parametro en cada metodo
	
	public State(ToDoItem item) {
		this.item = item;
	}
	
	public abstract void start();
	public abstract void togglePause();
	public abstract void finish();
	public abstract Duration workedTime();
	public abstract String name();

	public void addComent(List<String> comments, String comment) {
		comments.add(comment);
	}
	
}
