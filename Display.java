package Snake_Game;

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
  boolean gameOver = false;
  public Display() {
    super("Snake");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(514, 538);
    setResizable(false);
    setLocationRelativeTo(null);
    setVisible(true);
    setFont(new Font("Courier", Font.BOLD, 16));
  }
  public void paint(Graphics g){
    g.fillRect(0, 0, 600, 600);
    g.setColor(Color.GREEN);
    for(int i = 0; i < grid.length; i++) {
      for(int j = 0; j < grid[i].length; j++) {//grid[x][y]
        if(grid[i][j] == 0) continue;
        else if(grid[i][j] == 1) g.fillRect(j * snakeSize + xOffSet, i * snakeSize + yOffSet, 50, 50);
        else g.drawOval(j * snakeSize + xOffSet, i * snakeSize + yOffSet, 50, 50);
      }
    }
    g.setColor(Color.WHITE);
    g.drawString("Score: " + grid.length, 2 + xOffSet, 16 + yOffSet);
    if(gameOver) {
      g.setColor(Color.RED);
      g.drawString("Game Over", 210, 250 + yOffSet);
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