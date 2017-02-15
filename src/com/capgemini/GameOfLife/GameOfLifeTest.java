package com.capgemini.GameOfLife;

import org.junit.Test;
import org.junit.Assert;

public class GameOfLifeTest {
@Test
public void shouldCell11BeDeadNextRound(){
	GameOfLife newGame = new GameOfLife(6);
	newGame.setFirstStage0();
	newGame.setFirstStage(0, 0);
	newGame.setFirstStage(1, 0);
	newGame.setFirstStage(2, 0);
	newGame.setFirstStage(1, 1);
	newGame.setFirstStage(0, 0);
	newGame.setFirstStage(0, 1);
	newGame.setFirstStage(0, 2);
	newGame.setFirstStage(2, 2);
	newGame.setFirstStage(2, 1);
	newGame.nextRound();
	Assert.assertEquals(0, newGame.getStateXY(1, 1));
}
@Test
public void shouldCell11BeAliveNextRoundWhenHas2Neghbors(){
	GameOfLife newGame = new GameOfLife(6);
	newGame.setFirstStage0();
	newGame.setFirstStage(0, 0);
	newGame.setFirstStage(0, 1);
	newGame.setFirstStage(1, 1);
	newGame.nextRound();
	Assert.assertEquals(1, newGame.getStateXY(1, 1));
}
@Test
public void shouldCell11BeAliveNextRoundWhenHas3Neghbors(){
	GameOfLife newGame = new GameOfLife(6);
	newGame.setFirstStage0();
	newGame.setFirstStage(0, 0);
	newGame.setFirstStage(1, 0);
	newGame.setFirstStage(2, 0);
	newGame.setFirstStage(1, 1);
	newGame.nextRound();
	Assert.assertEquals(1, newGame.getStateXY(1, 1));
}
@Test
public void shouldCell01BeAliveNextRoundWhenHas3Neghbors(){
	GameOfLife newGame = new GameOfLife(6);
	newGame.setFirstStage0();
	newGame.setFirstStage(0, 0);
	newGame.setFirstStage(1, 0);
	newGame.setFirstStage(2, 0);
	newGame.setFirstStage(1, 1);
	newGame.nextRound();
	Assert.assertEquals(1, newGame.getStateXY(0, 1));
}
}
