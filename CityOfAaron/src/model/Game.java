/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

public class Game implements Serializable {

	private Player thePlayer;
	private Map theMap;
	private Storehouse theStorehouse;
	private int currentPopulation;
	private int acresOwned;
	private int wheatInStorage;
	private int currentYear;
	private int acresPlanted;
	private int tithingPaidInBushels;
	private int bushelsFedToPeople;
	private int tithingPercentage;
	private int landPrice;
	private int populationIncrease;
	private int populationDecrease;
	private int totalWheatHarvested;
	private int totalWheatRatsAte;

	public Game() {
		//Empty constructor for JavaBeans
	}

	public Player getThePlayer() {
		return thePlayer;
	}

	public void setThePlayer(Player thePlayer) {
		this.thePlayer = thePlayer;
	}

	public Map getTheMap() {
		return theMap;
	}

	public void setTheMap(Map theMap) {
		this.theMap = theMap;
	}

	public Storehouse getTheStorehouse() {
		return theStorehouse;
	}

	public void setTheStorehouse(Storehouse theStorehouse) {
		this.theStorehouse = theStorehouse;
	}

	public int getCurrentPopulation() {
		return currentPopulation;
	}

	public void setCurrentPopulation(int currentPopulation) {
		this.currentPopulation = currentPopulation;
	}

	public int getAcresOwned() {
		return acresOwned;
	}

	public void setAcresOwned(int acresOwned) {
		this.acresOwned = acresOwned;
	}

	public int getWheatInStorage() {
		return wheatInStorage;
	}

	public void setWheatInStorage(int wheatInStorage) {
		this.wheatInStorage = wheatInStorage;
	}

	public int getCurrentYear() {
		return currentYear;
	}

	public void setCurrentYear(int currentYear) {
		this.currentYear = currentYear;
	}

	public int getAcresPlanted() {
		return acresPlanted;
	}

	public void setAcresPlanted(int acresPlanted) {
		this.acresPlanted = acresPlanted;
	}

	public int getTithingPaidInBushels() {
		return tithingPaidInBushels;
	}

	public void setTithingPaidInBushels(int tithingPaidInBushels) {
		this.tithingPaidInBushels = tithingPaidInBushels;
	}

	public int getBushelsFedToPeople() {
		return bushelsFedToPeople;
	}

	public void setBushelsFedToPeople(int bushelsFedToPeople) {
		this.bushelsFedToPeople = bushelsFedToPeople;
	}

	public int getTithingPercentage() {
		return tithingPercentage;
	}

	public void setTithingPercentage(int tithingPercentage) {
		this.tithingPercentage = tithingPercentage;
	}

	public int getLandPrice() {
		return landPrice;
	}

	public void setLandPrice(int landPrice) {
		this.landPrice = landPrice;
	}

	public int getPopulationIncrease() {
		return populationIncrease;
	}

	public void setPopulationIncrease(int populationIncrease) {
		this.populationIncrease = populationIncrease;
	}

	public int getPopulationDecrease() {
		return populationDecrease;
	}

	public void setPopulationDecrease(int populationDecrease) {
		this.populationDecrease = populationDecrease;
	}

	public int getTotalWheatHarvested() {
		return totalWheatHarvested;
	}

	public void setTotalWheatHarvested(int totalWheatHarvested) {
		this.totalWheatHarvested = totalWheatHarvested;
	}

	public int getTotalWheatRatsAte() {
		return totalWheatRatsAte;
	}

	public void setTotalWheatRatsAte(int totalWheatRatsAte) {
		this.totalWheatRatsAte = totalWheatRatsAte;
	}
	
	

	@Override
	public String toString() {
		return "Game{"
				+ "  thePlayer=" + thePlayer
				+ ", theMap=" + theMap
				+ ", theStorehouse=" + theStorehouse
				+ ", currentPopulation=" + currentPopulation
				+ ", acresOwned=" + acresOwned
				+ ", wheatInStorage=" + wheatInStorage
				+ ", currentYear=" + currentYear
				+ ", acresPlanted=" + acresPlanted
				+ ", tithingPaidInBushels=" + tithingPaidInBushels
				+ ", bushelsFedToPeople=" + bushelsFedToPeople
				+ ", tithingPercentage=" + tithingPercentage
				+ ", landPrice=" + landPrice
				+ '}';
	}

}
