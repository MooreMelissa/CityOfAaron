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
	 * @param totalWheat total wheat in storage
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
	 * Transaction to sell land, calculate profit of acres sold
	 *
	 * @param acresToSell user input request of acres to sell
	 * @param randomPrice random number between 17 and 27
	 * @param totalAcres total acres owned
	 * @return profit from land sold
	 */
	public static int sellLand(int acresToSell, int randomPrice, int totalAcres) {
		if (acresToSell < 0) {
			return -1;
		}
		if (acresToSell > totalAcres) {
			return -1;
		}
		int profit = acresToSell * randomPrice;

		return profit;
	}

	/**
	 * public int feedPeople(int bushelsFed, int totalWheat) BEGIN IF
	 * (bushelsFed < 0) THEN RETURN -1
	 * IF (bushelsFed > totalWheat) THEN RETURN -2 RETURN buselsFed END
	 *
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

		return bushelsFed; // validates users amount
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

	public static boolean liveTheYear(Game game) {

		int totalWheat = game.getWheatInStorage();
		int totalPopulation = game.getCurrentPopulation();
		int percentage = game.getTithingPercentage();
		int acresToPlant = game.getAcresPlanted();
		int bushelsFed = game.getBushelsFedToPeople();

		// Random Numbers
		int randomYieldLow = RandomNumbers.getRandom(1, 3); // harvestWheat
		int randomYieldMid = RandomNumbers.getRandom(2, 4); // harvestWheat
		int randomYieldHigh = RandomNumbers.getRandom(2, 5); // harvestWheat
		int randomChance = RandomNumbers.getRandom(1, 100); // wheatEatenByRats
		int randomAmountLow = RandomNumbers.getRandom(6, 10); // wheatEatenByRats
		int randomAmountMid = RandomNumbers.getRandom(3, 7); // wheatEatenByRats
		int randomAmountHigh = RandomNumbers.getRandom(3, 5); // wheatEatenByRats
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

		// Beginning of wheatEatenByRats function
		int wheatRatsAte = wheatEatenByRats(percentage,
				randomChance,
				randomAmountLow,
				randomAmountMid,
				randomAmountHigh,
				totalWheat);
		if (wheatRatsAte < 0) {
			return false;
		}
		totalWheat = totalWheat - wheatRatsAte;

		//Beginning of populationMortality function
		int popMortality = populationMortality(bushelsFed, totalPopulation);
		totalPopulation = totalPopulation - popMortality;

		//Beginning of peopleMoveIn function
		int populationGrowth = peopleMoveIn(randomGrowth, totalPopulation);
		totalPopulation = totalPopulation + populationGrowth;

		game.setTithingPaidInBushels(totalTithe);
		game.setCurrentPopulation(totalPopulation);
		game.setWheatInStorage(totalWheat);
		game.setCurrentYear(game.getCurrentYear() + 1);
		game.setLandPrice(RandomNumbers.getRandom(17, 27));
		return true;
	}

	/**
	 * harvestWheat
	 * @param acresToPlant user input - acres planted
	 * @param percentage tithing percentage paid
	 * @param randomYieldLow random number between 1 and 3
	 * @param randomYieldMid random number between 2 and 4
	 * @param randomYieldHigh random number between 2 and 5
	 * @return amount of wheat harvested
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
	 * wheatOfferings - Calculate the number of bushels to pay in tithing
	 * @param percentage User input tithing percentage
	 * @param totalHarvest Total bushels harvested after live the year
	 * @return Number of bushels to pay in tithing
	 */
	public static int wheatOfferings(int percentage, int totalHarvest) {
		if (percentage < 0 || percentage > 100) {
			return -1;
		}
		int offeringsTithes = (int) (totalHarvest * (percentage * 0.01));
		return offeringsTithes;
	}

	/**
	 * Calculate the amount of wheat eaten by rats
	 * @param percentage percentage of tithing paid
	 * @param randomChance random number between 1 and 100
	 * @param randomAmountLow random number between 6 and 10
	 * @param randomAmountMid random number between 3 and 7
	 * @param randomAmountHigh random number between 3 and 5
	 * @param totalWheat total wheat in storage
	 * @return amount of wheat eaten by rats
	 */
	public static int wheatEatenByRats(int percentage,
			int randomChance,
			int randomAmountLow,
			int randomAmountMid,
			int randomAmountHigh,
			int totalWheat) {
		if (percentage < 0 || percentage > 100) {
			return -1;
		}
		int randomAmount = 0;
		int wheatEaten = 0;
		if (randomChance < 30) {
			if (percentage < 8) {
				randomAmount = randomAmountLow;
			} else if (percentage >= 8 && percentage <= 12) {
				randomAmount = randomAmountMid;
			} else if (percentage > 12) {
				randomAmount = randomAmountHigh;
			}
			wheatEaten = (int) (totalWheat * (randomAmount * 0.01));
		}
		return wheatEaten;
	}

	/**
	 * public int populationMortality (int bushelFed, int totalPopulation) BEGIN
	 * IF (bushelFed < 0 ) THEN RETURN -1 int noPeopleFed = bushelFed / 20 int
	 * starvedPeople = 0 IF (noPeopleFed < totalPopulation) THEN starvedPeople =
	 * totalPopulation – noPeopleFed RETURN starvedPeople END @param bushelsFed
	 * @param totalPopulation @return
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
	 * peopleMoveIn - Calculate the number of people that moved in
	 * @param randomGrowth random number generation between 1 and 5
	 * @param totalPopulation population prior to live the year
	 * @return number of people that moved in
	 */
	public static int peopleMoveIn(int randomGrowth, int totalPopulation) {
		if (randomGrowth < 1 || randomGrowth > 5) {
			return -1;
		}
		int growPopulation = (int) (totalPopulation * (randomGrowth * 0.01));
		return growPopulation;
	}

}
