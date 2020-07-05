package Snake_Game;
import java.util.*;
import java.io.*;
import java.math.*;

public class Game {

    public enum directions{up,down,left,right};
    public directions dir;
    private int[][] gameMap;
    public Pos head;
    public Pos food;
    public int len;
    public ArrayList<Pos> prePos;
    public boolean food_Present;
    
    //constructor
    public Game(){
        gameMap= new int[10][10];
        head= new Pos(0,0);
        food = new Pos(0,0);
        newGame();
    }

    public void newGame(){
        len=1;
        prePos= new ArrayList<Pos>();
        head.change(((int)(Math.random()*7)),((int)(Math.random()*10)));
        dir=directions.right;
        // intilizing
        for (int i=0;i<gameMap.length;i++){
            for (int j=0;j<gameMap[i].length;j++){
                gameMap[i][j]=0;
             
            }
        }
        //first food pos
        food.change(((int)(Math.random()*10)), ((int)(Math.random()*10)));
        gameMap[food.getX()][food.getY()]=2;
        //new head pos
        prePos.add(new Pos(head.getX(),head.getY()));
        gameMap[head.getX()][head.getY()]=1; //head position    
    }
    
    public void preview() {
    	for (int i=0;i<gameMap.length;i++){
            for (int j=0;j<gameMap[i].length;j++){
                System.out.print(gameMap[i][j]);
            }
            System.out.println();
        } 
    }
    
    public void update() {
    	//update prePos
    	;
    	if(!isGameOver()) {
    		if (!eatenCheck()) { //if eaten add 1 to pos
    			// move 1
    			for(int i=0; i<len-1;i++) {
    				prePos.set(i, prePos.get(i+1));
    			}
    			prePos.set(len-1, getNextPos());
    			head.change(getNextPos().getX(),getNextPos().getY());
    		}
    		resetBoard();
    	}
    	else {
    	System.out.println("Game Over");
    	gameOver();	
    	}
    }  
    
    public void gameOver() {
    	for (int i=0;i<gameMap.length;i++){
            for (int j=0;j<gameMap[i].length;j++){
                gameMap[i][j]=9;
             
            }
        }
    }
    
    public boolean isGameOver() {
    	if( getNextPos().getX()>=10 || getNextPos().getY()>=10 ) return true;
    	else return false;
    }
    
    public void resetBoard(){
    	for (int i=0;i<gameMap.length;i++){
            for (int j=0;j<gameMap[i].length;j++){
                gameMap[i][j]=0;
             
            }
        }
    	 gameMap[food.getX()][food.getY()]=2;
    	 for(int i=0; i<len;i++) {
    		 gameMap[prePos.get(i).getX()][prePos.get(i).getY()]=1;
 		}
    }
    
    public Pos getNextPos() {
    	switch (dir){
		case left:
			return new Pos(head.getX(), head.getY()-1);
		case right:
			return new Pos(head.getX(), head.getY()+1);
		case down:
			return new Pos(head.getX()+1, head.getY());
		case up:
			return new Pos(head.getX()-1, head.getY());
    	}
    	return null;
    }

    public boolean eatenCheck() {
    	if (getNextPos().getX()==food.getX() && getNextPos().getY()==food.getY()){
    		len++;
    		prePos.add(getNextPos());
    		randFood();
    		return true;
    	}
    	else return false;
    }
    
    public void randFood() {
    	gameMap[food.getX()][food.getY()]=0;
    	 food.change(((int)(Math.random()*10)), (int)(Math.random()*10));
    	 gameMap[food.getX()][food.getY()]=2;
    }

}