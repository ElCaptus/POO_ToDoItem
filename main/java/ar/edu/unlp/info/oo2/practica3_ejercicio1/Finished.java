package ar.edu.unlp.info.oo2.practica3_ejercicio1;

import java.time.Duration;
import java.util.List;

public class Finished extends State{

	public Finished(ToDoItem item) {
		super(item);
	}
	
	@Override
	public String name() {
		return "finished";
	}

	@Override
	public void start() {
		// Ya esta iniciado, no hace nada
		
	}

	@Override
	public void togglePause() {
		throw new RuntimeException("El objeto ToDoItem no se encuentra en pause o in-progress");
	}

	@Override
	public void finish() {
		// No hago nada
	}

	@Override
	public Duration workedTime() {
		return item.getFinishTime();
	}
	
	@Override
	public void addComent(List<String> comments, String comment) {
		
	}
	
}
