/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

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
	 */
	
	public void buyLand(int acresToBuy, int randomPrice, int getAcresOwned, int getWheatInStorage) {
		
		randomPrice = 0; /** random number between 17 and 27 **How to implement the random number? */
		
		if (acresToBuy < 0) {
			return; /** *per page 113 in the textbook this should end the function (can't return -1 without an error) **How to indicate an error? */
		}
		
		int cost = (acresToBuy * randomPrice);
		
		if (cost > getWheatInStorage) {
			return; /** *per page 113 in the textbook this should end the function (can't return -1 without an error) **How to indicate an error? */
		}
		
		int setAcresOwned = getAcresOwned + acresToBuy; /** *How to implement getters/setters at this phase? Set as int for now  */
		int setWheatInStorage = getWheatInStorage - cost; /** *How to test this? Java doesn't return multiple values, we won't know if the function returns the right numbers in the testing without setting a return here.   */
		
	}
	
	
	
}
