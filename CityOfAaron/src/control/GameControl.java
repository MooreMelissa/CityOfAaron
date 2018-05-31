/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.Game;
import java.util.Random;
/**
 *
 * @author heatherholt
 */
public class GameControl{	
	
	public boolean liveTheYear(Game game, 
		int acresToBuy, 
		int acresToSell, 
		int bushelsFed, 
		int acresToPlant, 
		int percentage) {
		
	    int totalWheat = game.getWheatInStorage();
		int totalAcres = game.getAcresOwned();
                int totalPopulation = game.getCurrentPopulation();
		int randomPrice = RandomNumbers.getRandom(17, 27);
		
		
		//harvestWheat() - H
		//wheatOfferings() - R
		//wheatEatenRats() - H
		//populationMortality() - M
		//peopleMoveIn() - R
		
		int landCostInWheat = buyLand (acresToBuy, randomPrice, totalWheat, totalAcres);
		if (landCostInWheat < 0) {
			return false;
		}
        totalWheat = totalWheat - landCostInWheat;
		totalAcres = totalAcres + acresToBuy;
        //sellLand() - H
		//feedPeople() - M
		if (acresToPlant < 0) {
                    return false;
                }
                int bushelsWheatUsed = plantCrops(acresToPlant,
                           totalAcres, 
                           totalPopulation, 
                           totalWheat); 
                if (bushelsWheatUsed < 0) {
                    return false;
                }
                totalWheat = totalWheat - bushelsWheatUsed;
                
                
                
                
                
                
              
                game.setAcresPlanted(acresToPlant);
                
		return true;
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
	
	public static int buyLand(int acresToBuy, 
		int randomPrice, 
		int wheatInStorage, 
		int acresOwned) {
				
		if (acresToBuy < 0) {
			return -1;
		}
		
		int cost = (acresToBuy * randomPrice);
		
		if (cost > wheatInStorage) {
			return -1;
		}
				
		return cost;
	}
	
	/**
         * public void plantCrops(int acresToPlant, int getAcresOwned, int getWheatInStorage, int getCurrent Population)
         *BEGIN
         *IF (acresToPlant  <  0)  THEN  RETURN -1
         *IF (acresToPlant  >  getAcresOwned)  THEN RETURN -2
         *IF (acresToPlant  >  getCurrentPopulation * 10)  THEN RETURN -3
         *IF (acresToPlant / 2 > getWheatInStorage) THEN RETURN -4
         *setWheatInStorage = getWheatInStorage  - (acresToPlant / 2)
         *setAcresPlanted = acresToPlant
         *END
         * @param acresToPlant
         * @param acresOwned
         * @param wheatInStorage
         * @param currentPopulation
         * @return
        */

        public static int plantCrops(int acresToPlant, int acresOwned, int currentPopulation, int wheatInStorage) {

            if (acresToPlant < 0) {
                return -1;
            }
            
            if (acresToPlant > acresOwned) {
                return -2;
            }
            
            if (acresToPlant > currentPopulation * 10) {
                return -3;
            }
            
            if (acresToPlant / 2 > wheatInStorage) {
                return -4;
            }
	
           
            int bushelsUsed = acresToPlant / 2;
            return bushelsUsed;
	
        }
	
	
	
}
