package com.capgemini.GameOfLife;

public class Board {
	public Cell[][] board;
	private int size;
	public Board(int _size) throws IllegalStateException{
		if(_size<=0){
			throw new IllegalStateException();
		}
		board=new Cell[_size][_size];
		size=_size;
		for (int i=0;i<size;i++){
			for (int j=0;j<size;j++){
				board[i][j]= new Cellimpl();
			}
		}
	}
	public Board(int _size, int state)throws IllegalStateException{
		if(_size<=0){
			throw new IllegalStateException();
		}
		
		board=new Cell[_size][_size];
		size=_size;
		for (int i=0;i<size;i++){
			for (int j=0;j<size;j++){
				board[i][j]= new Cellimpl();
				board[i][j].setState(state);
			}
		}
	}
	public int getSize(){
		return size;
	}
	public void setStateXY(int X,int Y, int Stan){
		board[X][Y].setState(Stan);
		
	}
	public int getStateXY(int X,int Y){
		return board[X][Y].getState();
	}
}
