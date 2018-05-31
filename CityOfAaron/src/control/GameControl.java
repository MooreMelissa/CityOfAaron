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
public class GameControl {

	public boolean liveTheYear(Game game,
			int acresToBuy,
			int acresToSell,
			int bushelsFed,
			int acresToPlant,
			int percentage) {

		int totalWheat = game.getWheatInStorage();
		int totalAcres = game.getAcresOwned();
		int totalPopulation = game.getCurrentPopulation();

		// Random Numbers
		int randomYieldLow = RandomNumbers.getRandom(1, 3); // harvestWheat
		int randomYieldMid = RandomNumbers.getRandom(2, 4); // harvestWheat
		int randomYieldHigh = RandomNumbers.getRandom(2, 5); // harvestWheat
		int randomPrice = RandomNumbers.getRandom(17, 27);  // buyLand

		
		// Beginning of harvestWheat function
		if (acresToPlant < 0) {
			return false;
		}
		int totalHarvest = harvestWheat(acresToPlant,
				percentage,
				randomYieldLow,
				randomYieldMid,
				randomYieldHigh);
		if (totalHarvest < 0) {
			return false;
		}
		totalWheat = totalWheat + totalHarvest;

		//wheatOfferings() - R
		//wheatEatenRats() - H
		//populationMortality() - M
		//peopleMoveIn() - R
		int landCostInWheat = buyLand(acresToBuy, randomPrice, totalWheat);
		if (landCostInWheat < 0) {
			return false;
		}
		totalWheat = totalWheat - landCostInWheat;
		totalAcres = totalAcres + acresToBuy;
		//sellLand() - H
		//feedPeople() - M
                int feedThePeople = feedPeople(bushelsFed, totalWheat);
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
		game.setCurrentPopulation(totalPopulation);
		game.setAcresOwned(totalAcres);
		game.setWheatInStorage(totalWheat);
		return true;
	}

	
	/**
	 * @param acresToPlant
	 * @param percentage
	 * @param randomYieldLow
	 * @param randomYieldMid
	 * @param randomYieldHigh
	 * @return
	 */
	public static int harvestWheat(int acresToPlant,
			int percentage,
			int randomYieldLow,
			int randomYieldMid,
			int randomYieldHigh) {
		if (percentage < 0 || percentage > 100) {
			return -1;
		}
		if (acresToPlant < 0) {
			return -1;
		}
		int randomYield = 0;
		if (percentage < 8) {
			randomYield = randomYieldLow;
		} else if (percentage >= 8 && percentage <= 12) {
			randomYield = randomYieldMid;
		} else if (percentage > 12) {
			randomYield = randomYieldHigh;
		}
		int wheatHarvested = acresToPlant * randomYield;
		return wheatHarvested;
	}

	
	/**
	 * @param acresToBuy
	 * @param randomPrice
	 * @param totalWheat
	 * @return
	 */
	public static int buyLand(int acresToBuy,
			int randomPrice,
			int totalWheat) {
		if (acresToBuy < 0) {
			return -1;
		}
		int cost = (acresToBuy * randomPrice);
		if (cost > totalWheat) {
			return -1;
		}
		return cost;
	}

	/**
	 * public void plantCrops(int acresToPlant, int getAcresOwned, int
	 * getWheatInStorage, int getCurrent Population) BEGIN IF (acresToPlant  <  0)  THEN  RETURN -1
	 *IF (acresToPlant > getAcresOwned) THEN RETURN -2 IF (acresToPlant >
	 * getCurrentPopulation * 10) THEN RETURN -3 IF (acresToPlant / 2 >
	 * getWheatInStorage) THEN RETURN -4 setWheatInStorage = getWheatInStorage -
	 * (acresToPlant / 2) setAcresPlanted = acresToPlant END
	 *
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

        /**  public int feedPeople(int bushelsFed, int totalWheat) BEGIN
         *IF (bushelsFed < 0) THEN RETURN -1
         *IF (bushelsFed > totalWheat) THEN RETURN -2
         *totalWheat = totalWheat - bushelsFed
         *RETURN totalWheat
         *END
         * @param bushelsFed
         * @param totalWheat
         * @return
         */

        public static int feedPeople(int bushelsFed, int totalWheat) {
                
                if (bushelsFed < 0) {
                       return -1;
                }
              
                if (bushelsFed > totalWheat) {
                       return -2;
                }
              
                totalWheat = totalWheat - bushelsFed;
                
                return totalWheat;
        }
        
    
        /** public int populationMortality (int bushelFed, int totalPopulation) BEGIN
         *IF (bushelFed < 0 ) THEN RETURN -1
         *int noPeopleFed = bushelFed / 20 
         *IF (noPeopleFed < totalPopulation) THEN
         *int starvedPeople = totalPopulation – noPeopleFed
         *RETURN starvedPeople
         *ELSE
         *starvedPeople = 0
         *RETURN starvedPeople
         *END
         * @param bushelFed
         * @param totalPopulation
         * @return
         */
        
        public static int populationMortality(int bushelFed, int totalPopulation) {
          
                if (bushelFed < 0) {
                       return -1;
                }
               
                int noPeopleFed = bushelFed / 20;
               
                if (noPeopleFed < totalPopulation) {
                   int starvedPeople = totalPopulation - noPeopleFed;
                   
                   return starvedPeople;
            
                }
               
                else {
                  int starvedPeople = 0;
                   
                  return starvedPeople;
                }
                    
        }

}
