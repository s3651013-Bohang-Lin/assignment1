package apass.game.factory;

import java.util.HashMap;
import java.util.Map;

import apass.enumeration.GameEnum;
import apass.game.AbstractGame;
import apass.game.impl.Cycling;
import apass.game.impl.Running;
import apass.game.impl.Swimming;

/**
 *  because the game can choose more than one election each time the same game Id need to change 
 * So through the factory class to create the game 
 * @author Bohang Lin s3651013
 *
 */
public class GameFactory {

	//Save the current number of games used to generate the game ID 
	private  static Map<GameEnum, Integer> gameMap = new HashMap<GameEnum, Integer>(); 
	
	static{//Initialize to 0 
		for(GameEnum gameEnum : GameEnum.values()){
			gameMap.put(gameEnum, 0);
		}
	}
	
	/**
	 * Create a game based on the selected game type 
	 * @param gameType
	 * @return
	 */
	public static AbstractGame createAGame(GameEnum gameType){
		
		int nowNum = 0;
		switch(gameType){
		  case SWIMMING:
			  nowNum = gameMap.get(gameType) + 1;
			  gameMap.put(gameType, nowNum);
			  return new Swimming(gameType.getGameIdPre() + nowNum);
		  case RUNNIING:
			  nowNum = gameMap.get(gameType) + 1;
			  gameMap.put(gameType, nowNum);
			  return new Running(gameType.getGameIdPre() + nowNum);
		  case CYCLING:
			  nowNum = gameMap.get(gameType) + 1;
			  gameMap.put(gameType, nowNum);
			  return new Cycling(gameType.getGameIdPre() + nowNum);
		  default:
			  return null;
		}
	}
}
