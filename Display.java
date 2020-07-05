/*
can't set background color
To create a "real" 500x500 screensize, the setSize needs to be (514, 538) and anything drawen must be offset by (7, 31).
*/
package Snake;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

public class Display extends JFrame {
  int xOffSet = 7;
  int yOffSet = 31;
  int snakeSize = 50;
  int[][] grid;
  boolean gameOver = true;
  public Display() {
    super("Snake");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(514, 538);
    setResizable(false);
    setLocationRelativeTo(null);
    setVisible(true);
    setFont(new Font("Courier", Font.BOLD, 75));
  }
  public void paint(Graphics g){
    g.fillRect(0, 0, 600, 600);
    g.setColor(Color.GREEN);
    for (int i = 0; i < grid.length; i++) {
      g.fillRect(grid[i][0] * snakeSize + xOffSet, grid[i][1] * snakeSize + yOffSet, 50, 50);
    }
    if(gameOver) {
      g.setColor(Color.RED);
      g.drawString("Game Over", 60, 250);
    }
  }
}
/*
public class Display extends JFrame {
  int xOffSet = 7;
  int yOffSet = 31;
  int snakeSize = 50;
  ArrayList<int[]> grid;
  public Display() {
    super("Snake");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(514, 538);
    setResizable(false);
    setLocationRelativeTo(null);
    setVisible(true);
  }
  public void paint(Graphics g){
    g.fillRect(0, 0, 600, 600);
    display(g);
  }
  public void display(Graphics g) {
    g.setColor(Color.GREEN);
    for (int i = 0; i < grid.size(); i++) {
      g.fillRect(grid.get(i)[0] * snakeSize + xOffSet, grid.get(i)[1] * snakeSize + yOffSet, 50, 50);
    }
  }
}
*/
