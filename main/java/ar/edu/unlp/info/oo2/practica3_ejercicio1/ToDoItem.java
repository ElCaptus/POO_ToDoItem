package ar.edu.unlp.info.oo2.practica3_ejercicio1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ToDoItem {
	
	private String name;
	private State state;
	private long startTime;
	private Duration workedTime;
	private List<String> comments;
	
	public ToDoItem(String name) {
        	this.name = name;
        	state = new Pending(this);
        	this.comments = new ArrayList<String>();
        	this.startTime = 0;
    }

	public String getName() {
		return this.name;
	}
	
	public void setStartTime(long time) {
		this.startTime = time;
	}
	
	public long getStartTime() {
		return this.startTime;
	}
	
	public void setFinishTime(Duration time) {
		this.workedTime = time;
	}
	
	public Duration getFinishTime() {
		return this.workedTime;
	}
	
	public void changeState(State state) {
		this.state = state;
	}

    public void start() {
    	state.start();
    }

    public void togglePause() {
    	this.state.togglePause();
    }

    public void finish() {
    	this.state.finish();
    }

    public Duration workedTime() {
    	Duration time = this.state.workedTime();
    	System.out.println(time.toMillis());
		return time;
	}
    
    public String state() {
    	return state.name();
    }

    public List<String> getComments(){
    	return comments;
    }
    
	public void addComment(String comment) {
		this.state.addComent(comments,comment);
	}
    
}