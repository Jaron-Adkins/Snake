package Snake_Game;

public class Pos {
	private int x;
	private int y;
	
	public Pos(int i,int j) {
		x=i;
		y=j;
	}
	public void change(int i, int j){
		x=i;
		y=j;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
}
