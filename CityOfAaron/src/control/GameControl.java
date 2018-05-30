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
	
	static Game game = new Game();
	
	int acresToBuy = 80; //get user input
	int randomPrice = 22; //get random number between 17 and 27		
	
	
	public void liveTheYear() {
		//harvestWheat() - H
		//wheatOfferings() - R
		//wheatEatenRats() - H
		//populationMortality() - M
		//peopleMoveIn() - R
		
		buyLand (acresToBuy, randomPrice, game.getWheatInStorage(), game.getAcresOwned());
		//sellLand() - H
		//feedPeople() - M
		//plantCrops() - M
	}
	
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
	 * @param wheatInStorage
	 * @param acresOwned
	 * @return 
	 */
	
	public static int buyLand(int acresToBuy, int randomPrice, int wheatInStorage, int acresOwned) {
				
		if (acresToBuy < 0) {
			return -1;
		}
		
		int cost = (acresToBuy * randomPrice);
		
		if (cost > wheatInStorage) {
			return -1;
		}
		
		game.setAcresOwned(acresOwned + acresToBuy);
		game.setWheatInStorage(wheatInStorage - cost);
				
		return game.getAcresOwned();
		
	}
	
	
	
	
	
	
	
	
	
}
