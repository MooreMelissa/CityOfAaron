/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import cityofaaron.CityOfAaron;
import control.GameControl;
import control.RandomNumbers;
import model.Game;
import model.Map;
import model.Player;
import model.Storehouse;

/**
 *
 * @author heatherholt, kanderson
 */
public class StartNewGameView extends ViewBase {

	/**
	 * Constructor
	 */
	public StartNewGameView() {

	}

	@Override
	protected String getMessage() {
		return "\nStarting a new game...\n\n"
				+ "So you've chosen to accept the position as ruler of Aaron!\n"
				+ "Rule with bravery and wit and your village will thrive.\n"
				+ "Good luck! And watch out for the rats...\n";

	}

	/**
	 * Get the set of inputs from the user.
	 * @return
	 */
	@Override
	public String[] getInputs() {

		// Declare the array to have the number of elements you intend to get 
		// from the user.
		String[] inputs = new String[1];

		inputs[0] = getUserInput("Please enter your name, or press 'Enter' to return to the Main Menu:", true);

		// Repeat for each input you need, putting it into its proper slot in the array.
		return inputs;
	}

	/**
	 * Perform the action indicated by the user's input.
	 * @param inputs
	 * @return true if the view should repeat itself, and false if the view
	 * should exit and return to the previous view.
	 */
	@Override
	public boolean doAction(String[] inputs) {
		// There is only one action here: Initialize the Game and
		// set it in the main CityOfAaron class.

		// If the user just hits 'enter', bail out and don't do the action.
		// Returning false will take us back to the Main Menu.
		if (inputs[0] == null || inputs[0].equals("")) {
			System.out.println("No player name was entered. Returning to the Main Menu...");
			return false;
		}

		String playerName = inputs[0];
		createAndStartGame(playerName);

		// Return false to prevent loop.
		return false;
	}

	// Define your action handlers here. These are the methods that your doAction()
	// method will call based on the user's input. We don't want to do a lot of 
	// complex game stuff in our doAction() method. It will get messy very quickly.
	/**
	 * Create a new Game with the named Player and call the GameMenuView.
	 */
	private void createAndStartGame(String playerName) {

		Game currentGame = GameControl.createNewGame(playerName);

		System.out.println("\n\nWelcome to your new domain, " + playerName + "!"
				+ "\nHere's what you need to know before you start:"
				+ "\n\n- Year: " + currentGame.getCurrentYear()
				+ "\n- 0 people starved"
				+ "\n- 5 people came to the city"
				+ "\n- The current population is " + currentGame.getCurrentPopulation()
				+ "\n- The city owns " + currentGame.getAcresOwned() + " acres of crop land"
				+ "\n- 3 bushels per acre were harvested"
				+ "\n- The total harvest was 3000 bushels of wheat"
				+ "\n- The total tithe paid was " + currentGame.getTithingPaidInBushels() + " bushels of wheat"
				+ "\n- 0 bushels of wheat were eaten by rats"
				+ "\n- The total amount of wheat in storage is " + currentGame.getWheatInStorage() + " bushels"
				+ "\n\n ** Please be sure to complete all the tasks in the"
				+ "\n'Manage Crops' menu before choosing to 'Live The Year' **");

		pause(2000);

		// Once the GameMenuView is created, we will call it here.
		GameMenuView gameMenu = new GameMenuView();
		gameMenu.displayView();
	}
}
