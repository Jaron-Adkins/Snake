package Snake_Game;
import javax.swing.*;
import java.awt.*;
import Snake_Game.Game;


public class Runner{
	public static void main(String[] args) {
		Game a = new Game();
		a.preview();
		
		System.out.println();
		a.preview();
		
		Display display = new Display();
		display.grid = a.giveMap();
		keyHandler mh = new keyHandler();
		
		display.addKeyListener(mh);
    	for (int i = 0; i < 9; i++) {
      		display.repaint();
      		System.out.print(i);
      		try {
       	  	Thread.sleep(1000);
      		} catch (InterruptedException e) {
      	   		e.printStackTrace();
			}
			a.changeDir(mh.dir);
			a.update(); 
    	}
   	 	display.gameOver = true;
    	display.repaint();
	}
}