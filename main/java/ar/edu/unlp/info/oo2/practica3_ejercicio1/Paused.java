package ar.edu.unlp.info.oo2.practica3_ejercicio1;

import java.time.Duration;

public class Paused extends State{

	public Paused(ToDoItem item) {
		super(item);
	}

	@Override
	public String name() {
		return "paused";
	}
	
	@Override
	public void start() {
		// Ya esta iniciado, no hace nada
		
	}

	@Override
	public void togglePause() {
		item.changeState(new InProgress(item));
		
	}

	@Override
	public void finish() {
		item.setFinishTime(this.workedTime());
		item.changeState(new Finished(item));
		
	}

	@Override
	public Duration workedTime() {
		return Duration.ofHours(System.currentTimeMillis()-item.getStartTime());
	}
	
}
