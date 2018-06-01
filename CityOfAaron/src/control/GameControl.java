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
	
	
	/**
	 * Transaction to buy land, calculate cost of acres to buy
	 * @param acresToBuy user input request of acres to buy
	 * @param randomPrice random number between 17 and 27
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
	 * public int feedPeople(int bushelsFed, int totalWheat) BEGIN
	 * IF (bushelsFed < 0) THEN RETURN -1
	 * IF (bushelsFed > totalWheat) THEN RETURN -2
	 * totalWheat = totalWheat - bushelsFed
	 * RETURN totalWheat
	 * END
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

		return bushelsFed;
	}
	
	
	/**
	 * public void plantCrops(int acresToPlant, int getAcresOwned, int
	 * getWheatInStorage, int getCurrent Population) BEGIN IF (acresToPlant  <  0)  THEN  RETURN -1
	 * IF (acresToPlant > getAcresOwned) THEN RETURN -2 IF (acresToPlant >
	 * getCurrentPopulation * 10) THEN RETURN -3 IF (acresToPlant / 2 >
	 * getWheatInStorage) THEN RETURN -4 setWheatInStorage = getWheatInStorage -
	 * (acresToPlant / 2) setAcresPlanted = acresToPlant END
	 * @param acresToPlant
	 * @param acresOwned
	 * @param wheatInStorage
	 * @param currentPopulation
	 * @return
	 */
	public static int plantCrops(int acresToPlant, 
			int acresOwned, 
			int currentPopulation, 
			int wheatInStorage) {

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
	
	
	
	
	
	

	public boolean liveTheYear(Game game) {

		int totalWheat = game.getWheatInStorage();
		int totalPopulation = game.getCurrentPopulation();
		int percentage = game.getTithingPercentage();
		int acresToPlant = game.getAcresPlanted();
		int bushelsFed = game.getBushelsFedToPeople();

		// Random Numbers
		int randomYieldLow = RandomNumbers.getRandom(1, 3); // harvestWheat
		int randomYieldMid = RandomNumbers.getRandom(2, 4); // harvestWheat
		int randomYieldHigh = RandomNumbers.getRandom(2, 5); // harvestWheat
        int randomGrowth = RandomNumbers.getRandom(1, 5); //peopleMoveIn
		
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

		//Beginning of wheatOfferings function
		int totalTithe = wheatOfferings(percentage, totalHarvest);
		totalWheat = totalWheat - totalTithe; 
                
		//wheatEatenRats() - H
		//Beginning of populationMortality function
                int popMortality = populationMortality(bushelsFed, totalPopulation);
                totalPopulation = totalPopulation - popMortality;
                
		//Beginning of peopleMoveIn function
		int populationGrowth = peopleMoveIn(randomGrowth, totalPopulation);
		totalPopulation = totalPopulation + populationGrowth;
                
		
		
		game.setTithingPaidInBushels(totalTithe);
		game.setAcresPlanted(acresToPlant);
		game.setCurrentPopulation(totalPopulation);
		game.setWheatInStorage(totalWheat);
		return true; 
	}

	
	/**
	 * harvestWheat
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
	 * wheatOfferings
	 * @param percentage
	 * @param totalHarvest 
	 * @return
	 */
	public static int wheatOfferings(int percentage, int totalHarvest) {
		if (percentage < 0 || percentage > 100) {
			return -1;
		}
		int offeringsTithes = (int) (totalHarvest * (percentage * 0.01)); 
		return offeringsTithes;
	}
	
        
    
	/** public int populationMortality (int bushelFed, int totalPopulation) BEGIN
	 * IF (bushelFed < 0 ) THEN RETURN -1
	 * int noPeopleFed = bushelFed / 20 
	 * IF (noPeopleFed < totalPopulation) THEN
	 * int starvedPeople = totalPopulation – noPeopleFed
	 * RETURN starvedPeople
	 * ELSE
	 * starvedPeople = 0
	 * RETURN starvedPeople
	 * END
	 * @param bushelsFed
	 * @param totalPopulation
	 * @return
	 */

	public static int populationMortality(int bushelsFed, int totalPopulation) {

		if (bushelsFed < 0) {
			   return -1;
		}

		int noPeopleFed = bushelsFed / 20;
		int starvedPeople = 0;

		if (noPeopleFed < totalPopulation) {
			starvedPeople = totalPopulation - noPeopleFed;
		}

		return starvedPeople;

	}
        
	
        
	/**
	 * peopleMoveIn
	 * @param randomGrowth
	 * @param totalPopulation
	 * @return
	 */
	public static int peopleMoveIn(int randomGrowth, int totalPopulation) {
		if (randomGrowth < 1 || randomGrowth > 5){ 
			return -1; 
		}
		int growPopulation = (int) (totalPopulation * (randomGrowth * 0.01)); 
		return growPopulation;
	}

}
