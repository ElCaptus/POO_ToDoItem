package ar.edu.unlp.info.oo2.practica3_ejercicio1;

import java.time.Duration;
import java.time.temporal.TemporalUnit;

public class InProgress extends State{

	public InProgress(ToDoItem item) {
		super(item);
	}

	@Override
	public String name() {
		return "in progress";
	}
	
	@Override
	public void start() {
		// Ya esta iniciado, no hace nada
	}

	@Override
	public void togglePause() {
		item.changeState(new Paused(item));
	}

	@Override
	public void finish() {
		item.setFinishTime(this.workedTime());
		item.changeState(new Finished(item));
		
	}

	@Override
	public Duration workedTime() {
		return Duration.ofSeconds(System.currentTimeMillis()-item.getStartTime());
	}
	
}
