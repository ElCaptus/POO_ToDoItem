package ar.edu.unlp.info.oo2.practica3_ejercicio1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestToDoItem {

	ToDoItem itemPending;
	ToDoItem itemStarted;
	ToDoItem itemPaused;
	ToDoItem itemFinished;
	
	
	@BeforeEach
    void setUp() throws Exception {
		itemPending = new ToDoItem("Proyecto de Tesis");
		itemStarted = new ToDoItem("Proyecto de Accenture");
		itemPaused = new ToDoItem("Proyecto de Globant");
		itemFinished = new ToDoItem("Proyecto de Hexacta");
		
		itemStarted.start();
		
		itemPaused.start();
		itemPaused.togglePause();
		
		itemFinished.start();
		itemFinished.finish();
		
		itemPending.addComment("uola");
		itemPending.addComment("Testing some comments1");
		itemPending.addComment("Testing some comments2");
		itemPending.addComment("Testing some comments3");
		
		itemStarted.addComment("Testing some comments1");
		itemStarted.addComment("Testing some comments2");
		itemStarted.addComment("Testing some comments3");
		itemStarted.addComment("Testing some comments4");
		itemStarted.addComment("Testing some comments5");
		
		itemPaused.addComment("Testing some comments1");
		itemPaused.addComment("Testing some comments2");
		itemPaused.addComment("Testing some comments3");
		itemPaused.addComment("Testing some comments4");
		itemPaused.addComment("Testing some comments5");
		
		itemFinished.addComment("Testing some comments1");
		itemFinished.addComment("Testing some comments2");
		itemFinished.addComment("Testing some comments3");
		itemFinished.addComment("Testing some comments4");
		itemFinished.addComment("Testing some comments5");
	}
	
	@Test
	public void creationOfItems() {
		assertFalse(itemPending.getStartTime() == System.currentTimeMillis());
		assertEquals(itemPending.state(), "pending");
		
		assertEquals(itemStarted.state(), "in progress");
		
		assertEquals(itemPaused.state(), "paused");
		
		assertEquals(itemFinished.state(), "finished");
		
	}
	
	@Test
	public void consolePrints() {
		try {
			itemPending.togglePause();;
		}
		catch(Exception e) {
			System.out.println(e.getMessage()+"(\""+ itemPending.getName() +"\" PENDING...)");
		}

		try {
			itemPending.workedTime();;
		}
		catch(Exception e) {
			System.out.println(e.getMessage()+"(\""+ itemPending.getName() +"\" PENDING...)");
		}
		
		try {
			itemFinished.togglePause();;
		}
		catch(Exception e) {
			System.out.println(e.getMessage()+"(\""+ itemFinished.getName() +"\" FINISHED...)");
		}
	}
	
	@Test
	public void startAndFinishInitialTime() {
		assertEquals(itemPending.getStartTime(), 0);

		assertFalse(itemStarted.getStartTime() == 0);
		assertEquals(null, itemStarted.getFinishTime());
		
		assertFalse(itemPaused.getStartTime() == 0);
		assertEquals(null, itemPaused.getFinishTime());
		
		assertFalse(itemFinished.getStartTime() == 0);
		assertEquals(0, itemFinished.getFinishTime().toSeconds());
	}
	
	@Test
	public void changingStates() {
		assertEquals(itemStarted.state(), "in progress");
		itemStarted.togglePause();
		assertEquals(itemStarted.state(), "paused");
		itemStarted.finish();
		assertEquals(itemStarted.state(),"finished");

		assertEquals(itemPaused.state(), "paused");
		itemPaused.togglePause();
		assertEquals(itemPaused.state(), "in progress");
		itemPaused.finish();
		assertEquals(itemPaused.state(),"finished");
	}
	
	@Test
	public void doingNothing() {
		itemPending.finish();
		assertEquals(itemPending.state(),"pending");
		
		itemStarted.start();
		assertEquals(itemStarted.state(),"in progress");
		
		itemPaused.start();
		assertEquals(itemPaused.state(),"paused");
		
		itemFinished.start();
		assertEquals(itemFinished.state(),"finished");
		itemFinished.finish();
		assertEquals(itemFinished.state(),"finished");
	}
	
	@Test
	public void comments() {
		assertEquals(itemPending.getComments().get(0), "uola");
		assertEquals(itemPending.getComments().size(), 4);
		
		assertEquals(itemStarted.getComments().size(), 5);
		assertEquals(itemPaused.getComments().size(),5);
		
		assertEquals(itemFinished.getComments().size(),0);
	}
}
