package com.capgemini.GameOfLife;
import java.util.Random;
public class GameOfLife {
	private Board board;
	private int size=6;
	public GameOfLife(int _size){
		size=_size;
		try {
			board = new Board(size);
		}
		catch(IllegalStateException e){
			System.out.println("Nie prawidlowa wielkosc planszy. Zostanie utworzona domyslna 5x5");
			size=6;
		}
	}
	public void randomFirstStage(){
		Random rn = new Random();
		for (int i=0;i<size;i++){
			for (int j=0;j<size;j++){
				board.setStateXY(i, j, rn.nextInt(2));
			}
		}
	}
	public void printState(){
		for (int i=0;i<size;i++){
			for (int j=0;j<size;j++){
				System.out.print(board.getStateXY(i, j) + " ");
			}
			System.out.println("");
		}
	}
	public void nextRound(){
		Board TempPlansza = new Board(board.getSize(),0);
		int amountOfNeighbor;
		for (int i=0;i<board.getSize();i++){
			for (int j=0;j<board.getSize();j++){
				amountOfNeighbor=0;
				for(int x=-1;x<=1;x++){
					for(int y=-1;y<=1;y++){
						if((x+i>=0) && (j+y>=0) && 
								(i+x<board.getSize()) && (j+y<board.getSize()) 
								&& board.getStateXY(i+x, j+y)==1 ){
							amountOfNeighbor++;
						}
					}
				}
				if(board.getStateXY(i, j)==1){
					amountOfNeighbor--;
				}
				if (amountOfNeighbor<2 && board.getStateXY(i, j)==1){
					TempPlansza.setStateXY(i, j, 0);
				}
				if ((amountOfNeighbor==2 || amountOfNeighbor==3) && board.getStateXY(i, j)==1){
					TempPlansza.setStateXY(i, j, 1);
				}
				if (amountOfNeighbor>3 && board.getStateXY(i, j)==1){
					TempPlansza.setStateXY(i, j, 0);
				}
				if (amountOfNeighbor==3 && board.getStateXY(i, j)==0){
					TempPlansza.setStateXY(i, j, 1);
				}
			}
		}
		for (int i=0;i<board.getSize();i++){
			for (int j=0;j<board.getSize();j++){
				board.setStateXY(i, j, TempPlansza.getStateXY(i, j));
			}
		}
	}
	
	public void setFirstStage0(){
		for (int i=0;i<size;i++){
			for (int j=0;j<size;j++){
				board.setStateXY(i,j,0);
			}
		}
	}
	public void setFirstStage(int x, int y){
		board.setStateXY(x,y,1);
	}
	public int getStateXY(int x, int y){
		return board.getStateXY(x, y);
	}
	public static void main(String[] args) {
		GameOfLife newGame = new GameOfLife(6);
		newGame.randomFirstStage();
		newGame.setFirstStage(0, 0);
		newGame.setFirstStage(1, 0);
		newGame.setFirstStage(2, 0);
		newGame.setFirstStage(1, 1);
		newGame.printState();
		System.out.println("");
		System.out.println("");
		newGame.nextRound();
		newGame.printState();
		System.out.println("");
		System.out.println("");
		newGame.nextRound();
		newGame.printState();
		
	}

}
