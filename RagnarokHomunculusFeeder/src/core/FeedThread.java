package core;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FeedThread extends Thread {
	private Dimension p1, p2;
	private int delay;
	
	public FeedThread(Dimension p1, Dimension p2) {
		this.p1 = p1;
		this.p2 = p2;
		
		this.delay = 10 * 60 * 1000; //10 minutos
//		this.delay = 1000;
	}
	
	@Override
	public void run() {
		try {
			Robot robot = new Robot();
			
			while(true){
				robot.mouseMove(p1.width, p1.height);
				robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				robot.delay(500);
				robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				
				robot.delay(2000); //2 segundos de delay
				
				robot.mouseMove(p2.width, p2.height);
				robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				robot.delay(500);
				robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				
				//Log (Para controle)
				Date now = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss dd/mm/yyyy");
				System.out.println("Alimentado às "+sdf.format(now));
				
				Thread.sleep(delay);
			}
		} catch (AWTException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
