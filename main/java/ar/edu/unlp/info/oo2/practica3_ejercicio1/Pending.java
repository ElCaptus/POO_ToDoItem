package ar.edu.unlp.info.oo2.practica3_ejercicio1;

import java.time.Duration;

public class Pending extends State {
	
	public Pending(ToDoItem item) {
		super(item);
	}
	
	@Override
	public String name() {
		return "pending";
	}
	
	@Override
	public void start() {
		item.setStartTime(System.currentTimeMillis());
		item.changeState(new InProgress(item));
	}

	@Override
	public void togglePause() {
		throw new RuntimeException("El objeto ToDoItem no se encuentra en pause o in-progress.");
	}

	@Override
	public void finish() {
		// No hago nada
	}

	@Override
	public Duration workedTime() {
		throw new RuntimeException("El objeto ToDoItem no se encuentra iniciado.");
	}
}
