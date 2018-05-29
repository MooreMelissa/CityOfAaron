/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.Game;

/**
 *
 * @author heatherholt
 */
public class GameControl{
	
	
	/**
	 * public void buyLand(int acresToBuy, int getAcresOwned, int getWheatInStorage)
	 * BEGIN
	 * int randomPrice = Generate a Random Number from 17 to 27
	 * IF (acresToBuy less than 0) THEN RETURN -1
	 * cost = (acresToBuy * randomPrice)
	 * IF (cost greater than getWheatInStorage) THEN RETURN -1
	 * setAcresOwned = getAcresOwned + acresToBuy 
	 * setWheatInStorage = getWheatInStorage – cost
	 * END 
	 * @param acresToBuy
	 * @param randomPrice
	 * @param game
	 * @return 
	 */
	
	public static int buyLand(int acresToBuy, int randomPrice, Game game) { /** Per Bro. Anderson's reply to my DB post about static, the method has been declared as static and I have added the game class as a parameter which should let us grab anything we need from the game. */
		
		randomPrice = 0; /** random number between 17 and 27 **How to implement the random number? */
		
		if (acresToBuy < 0) {
			return -1; /** *per page 113 in the textbook return; should end the function (can't return -1 without the function returning an int. To eliminate some errors at this point, I have the function returning an int.) **How to indicate an error? */
		}
		
		int cost = (acresToBuy * randomPrice);
		
		if (cost > game.getWheatInStorage()) {
			return -1; /** *per page 113 in the textbook return; should end the function (can't return -1 without the function returning an int. To eliminate some errors at this point, I have the function returning an int.) **How to indicate an error? */
		}
		
		int setAcresOwned = game.getAcresOwned() + acresToBuy; /** *How to implement getters/setters at this phase? Set as int for now  */
		int setWheatInStorage = game.getWheatInStorage() - cost; /** *How to test this? Java doesn't return multiple values, we won't know if the function returns the right numbers in the testing without setting a return here.   */
				
		return setAcresOwned; /** returning an int for the sake of testing */
	}
	
	
	
}
