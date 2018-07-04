/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import cityofaaron.CityOfAaron;
import control.GameControl;
import exception.GameControlException;
import model.Game;

/**
 *
 * @author heatherholt, kanderson
 */
public class GameMenuView extends ViewBase {

	/**
	 * Constructor
	 */
	public GameMenuView() {

	}

	@Override
	protected String getMessage() {
		return "\n\nGame Menu\n"
				+ "-------------\n"
				+ "V - View Map\n"
				+ "M - Move Location\n"
				+ "C - Manage Crops\n"
				+ "L - Live The Year\n"
				+ "R - View Reports Menu\n"
				+ "S - Save Game\n"
				+ "Q - Return to Main Menu";

	}

	/**
	 * Get the set of inputs from the user.
	 *
	 * @return
	 */
	@Override
	public String[] getInputs() {

		// Declare the array to have the number of elements you intend to get 
		// from the user.
		String[] inputs = new String[1];

		inputs[0] = getUserInput("Please choose a menu option:");

		// Repeat for each input you need, putting it into its proper slot in the array.
		return inputs;
	}

	/**
	 * Perform the action indicated by the user's input.
	 *
	 * @param inputs
	 * @return true if the view should repeat itself, and false if the view
	 * should exit and return to the previous view.
	 */
	@Override
	public boolean doAction(String[] inputs) {

		switch (inputs[0].trim().toUpperCase()) {
			case "V":
				viewMap();
				break;
			case "M":
				moveLocation();
				break;
			case "C":
				manageCropsMenu();
				break;
			case "L":
				liveTheYear();
				break;
			case "R":
				reportsMenu();
				break;
			case "S":
				saveGame();
				break;
			case "Q":
				return false;
		}

		return true;
	}

	// Define your action handlers here. These are the methods that your doAction()
	// method will call based on the user's input. We don't want to do a lot of 
	// complex game stuff in our doAction() method. It will get messy very quickly.
	private void viewMap() {
		MapView mapView = new MapView();
		mapView.displayView();
	}

	private void moveLocation() {
		MoveLocationsView moveView = new MoveLocationsView();
		moveView.displayView();
	}

	private void manageCropsMenu() {
		ManageCropsMenuView manageCrops = new ManageCropsMenuView();
		manageCrops.displayView();
	}

	private void liveTheYear() {
		// System.out.println("* liveTheYear() called. Implementation coming soon. *");

		// I'm not positive how to do this yet, just experimenting.
		try {
			Game currentGame = CityOfAaron.getCurrentGame();
			GameControl.liveTheYear(CityOfAaron.getCurrentGame());
			int cropYield = currentGame.getTotalWheatHarvested()/currentGame.getAcresPlanted();
			System.out.println("\n\n- Year: " + currentGame.getCurrentYear()
				+ "\n- " + currentGame.getPopulationDecrease() + " people starved"
				+ "\n- " + currentGame.getPopulationIncrease() + " people came to the city"
				+ "\n- The current population is " + currentGame.getCurrentPopulation()
				+ "\n- The city owns " + currentGame.getAcresOwned() + " acres of crop land"
				+ "\n- " +  cropYield + " bushels per acre were harvested"
				+ "\n- The total harvest was " + currentGame.getTotalWheatHarvested() + " bushels of wheat"
				+ "\n- The total tithe paid was " + currentGame.getTithingPaidInBushels() + " bushels of wheat"
				+ "\n- " + currentGame.getTotalWheatRatsAte() + " bushels of wheat were eaten by rats"
				+ "\n- The total amount of wheat in storage is " + currentGame.getWheatInStorage() + " bushels");
		} catch (GameControlException gce) {
			System.out.println(gce.getMessage());
		}
		
		/* if (errorResult == false) {
				System.out.println("There has been an error. Please check the values"
						+ " in the Manage The Crops Menu and try again.");
			} else {
				System.out.println("\n\n- Year: " + currentGame.getCurrentYear()
					+ "\n- 0 people starved" // ** How do we get this value for display?
					+ "\n- 5 people came to the city" // ** How do we get this value for display?
					+ "\n- The current population is " + currentGame.getCurrentPopulation()
					+ "\n- The city owns " + currentGame.getAcresOwned() + " acres of crop land"
					+ "\n- 3 bushels per acre were harvested" // ** How do we get this value for display?
					+ "\n- The total harvest was " + " bushels of wheat" 
						// ** How do we get this value for display?
					+ "\n- The total tithe paid was " + currentGame.getTithingPaidInBushels() + " bushels of wheat"
					+ "\n- 0 bushels of wheat were eaten by rats" // ** How do we get this value for display?
					+ "\n- The total amount of wheat in storage is " + currentGame.getWheatInStorage() + " bushels");
			} */
		
	}

	private void reportsMenu() {
		ReportsMenuView reports = new ReportsMenuView();
		reports.displayView();
	}

	private void saveGame() {
		SaveGameView saveGame = new SaveGameView();
		saveGame.displayView();
	}

}
