package Snake_Game;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI.KeyHandler;
class keyHandler implements KeyListener
{
  String dir = "right";
  public void keyPressed(KeyEvent k)
   {
      if(k.getKeyCode() == 37) dir = "left";
      if(k.getKeyCode() == 38) dir = "up";
      if(k.getKeyCode() == 39) dir = "right";
      if(k.getKeyCode() == 40) dir = "down";   
      getDir(dir);
   }

   public String getDir(String dir) {
      System.out.println(dir);
      return dir;
   }


  public void keyTyped(KeyEvent k)
   {
   }
  public void keyReleased(KeyEvent k)
   {
   }
   
}
class trackKeyEvent
 {
   public static void main(String arg[])
    {
	  JFrame jf=new JFrame ("Mouse Event ");
	  jf.setSize(400,400);
	  jf.setVisible(true);
	  jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  // Create object of listener class
	  keyHandler mh=new keyHandler();
	  
	  
	  // Registering Mouse listener for frame.
     jf.addKeyListener(mh);
	}  
 } 