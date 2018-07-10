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
 * @author heatherholt
 */
public class SellLandView extends ViewBase {

	/**
	 * Constructor
	 */
	public SellLandView() {

	}

	@Override
	protected String getMessage() {
		Game game = CityOfAaron.getCurrentGame();
		return "\n\nWelcome to the market! You can sell land here, or press "
				+ "'Enter' to return to the previous menu.\n"
				+ "The current price of land is " + game.getLandPrice() + " bushels per acre.";
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

		inputs[0] = getUserInput("\nHow many acres of land do you want to sell?", true);

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

		// If the user just hits 'enter', bail out and don't do the action.
		// Returning false will take us back to the Game Menu.
		if (inputs[0] == null || inputs[0].equals("") || inputs[0].equals("\n")) {
			this.console.println("No amount was entered. Returning to the Manage the Crops Menu...");
			pause(2000);
			return false;
		} else {
			boolean check = false;
			while (check == false) {
				try {
					if (inputs[0] == null || inputs[0].equals("") || inputs[0].equals("\n")) {
						this.console.println("No amount was entered. Returning to the Manage the Crops Menu...");
						pause(2000);
					} else {
						Integer.parseInt(inputs[0]);
						check = true;
					}
				} catch (NumberFormatException nfe) {
					ErrorView.display(this.getClass().getName(),
							"That was not a valid input. Please enter a number.");
					inputs = getInputs();
				}
			}

			boolean result = sellLandTransaction(inputs);
			return result;
		}
	}

	// Define your action handlers here. These are the methods that your doAction()
	// method will call based on the user's input. We don't want to do a lot of 
	// complex game stuff in our doAction() method. It will get messy very quickly.
	private boolean sellLandTransaction(String[] inputs) {

		Game game = CityOfAaron.getCurrentGame();

		int acresToSell = Integer.parseInt(inputs[0]);
		int totalWheat = game.getWheatInStorage();
		int totalAcres = game.getAcresOwned();

		try {
			int profit = GameControl.sellLand(acresToSell, game.getLandPrice(), totalAcres);
			game.setWheatInStorage(totalWheat + profit);
			game.setAcresOwned(totalAcres - acresToSell);
			this.console.println("\nYou have successfully sold " + acresToSell + " acres of land.\n"
					+ "You now own " + game.getAcresOwned() + " total acres.\n"
					+ "You have " + game.getWheatInStorage() + " bushels of wheat in storage.");
			pause(2000);
			return false;
		} catch (GameControlException gce) {
			ErrorView.display(this.getClass().getName(), gce.getMessage());
			return true;
		}
	}

}
