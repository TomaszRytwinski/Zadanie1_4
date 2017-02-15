package com.capgemini.GameOfLife;

public class Cellimpl implements Cell {
	private int state;
	
	public Cellimpl(){
		state=0;
	}
	/* (non-Javadoc)
	 * @see com.capgemini.GameOfLife.Komorka#GetStan()
	 */
	@Override
	public int getState(){
		return state;
	}
	/* (non-Javadoc)
	 * @see com.capgemini.GameOfLife.Komorka#SetStan(int)
	 */
	@Override
	public void setState(int _stan){
		state=_stan;
	}
}
