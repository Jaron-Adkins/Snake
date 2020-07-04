package Snake;

public class Runner {
  public static void main(String[] args) {
    Display display = new Display();
    int[][] tmp = new int[2][2];
    display.grid = tmp;
    for (int i = 0; i < 9; i++) {
      tmp[0][0] = i;
      tmp[0][1] = i;
      tmp[1][0] = i + 1;
      tmp[1][1] = i;
      display.repaint();
      System.out.print(i);
      try {
         Thread.sleep(1000);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
    }
  }
}