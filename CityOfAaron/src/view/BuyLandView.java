/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import cityofaaron.CityOfAaron;
import control.GameControl;
import model.Game;

/**
 *
 * @author heatherholt, kanderson
 */
public class BuyLandView extends ViewBase {

	/**
	 * Constructor
	 */
	public BuyLandView() {

	}

	@Override
	protected String getMessage() {
		Game game = CityOfAaron.getCurrentGame();
		return "\n\nWelcome to the market! You can buy land here, or press "
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

		inputs[0] = getUserInput("\nHow many acres of land do you want to buy?", true);

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
		if (inputs[0] == null || inputs[0].equals("")) {
			System.out.println("No amount was entered. Returning to the Manage the Crops Menu...");
			pause(2000);
			return false;
		} else {
			boolean check = false;
			while (check == false) {
				try {
					Integer.parseInt(inputs[0]);
					check = true;
				} catch (NumberFormatException nfe) {
					System.out.println("That was not a valid input. Please enter a number.");
					inputs = getInputs();
				}
			}
			boolean result = buyLandTransaction(inputs);
			return result;
		}
	}

	// Define your action handlers here. These are the methods that your doAction()
	// method will call based on the user's input. We don't want to do a lot of 
	// complex game stuff in our doAction() method. It will get messy very quickly.
	private boolean buyLandTransaction(String[] inputs) {

		Game game = CityOfAaron.getCurrentGame();

		int acresToBuy = Integer.parseInt(inputs[0]);
		int totalWheat = game.getWheatInStorage();

		int cost = GameControl.buyLand(acresToBuy, game.getLandPrice(), totalWheat);

		if (cost < 0) {
			System.out.println("\n** Invalid input, please try again. **");
			return true;
		} else {
			game.setWheatInStorage(totalWheat - cost);
			game.setAcresOwned(game.getAcresOwned() + acresToBuy);
			System.out.println("\nYou have successfully purchased " + acresToBuy + " acres of land.\n"
					+ "You now own " + game.getAcresOwned() + " total acres.\n"
					+ "You have " + game.getWheatInStorage() + " bushels of wheat in storage.");
			pause(2000);
			return false;
		}
	}

}
