/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import cityofaaron.CityOfAaron;
import model.Game;

/**
 *
 * @author heatherholt, kanderson
 */
public class PayTithingView extends ViewBase {

	/**
	 * Constructor
	 */
	public PayTithingView() {
	}

	@Override
	protected String getMessage() {
		return "\n\nWelcome to the temple. Here you can pay your tithes and offerings.\n"
				+ "Tithing is a percentage of your previous years' total harvest.\n"
				+ "The Lord has promised us blessings for paying our tithing.\n"
				+ "Press 'Enter' to return to the previous menu.\n";
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

		inputs[0] = getUserInput("What percentage of your total harvest would you like to pay in tithing?", true);

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
		if (inputs[0] == null || inputs[0].equals("")) {
			System.out.println("\nNo amount was entered. Returning to the Manage the Crops Menu...");
			pause(2000);
			return false;
		} else {
			boolean check = false;
			while (check == false) {
				try {
					Integer.parseInt(inputs[0]);
					check = true;
				} catch (NumberFormatException nfe) {
					System.out.println("That was an invalid entry. Enter a number between 1 and 100.");
					inputs = getInputs();
				}
			}
			boolean result = payTithing(inputs);
			return result;
		}
	}

	// Define your action handlers here. These are the methods that your doAction()
	// method will call based on the user's input. We don't want to do a lot of 
	// complex game stuff in our doAction() method. It will get messy very quickly.
	private boolean payTithing(String[] inputs) {
		Game game = CityOfAaron.getCurrentGame();

		int percentage = Integer.parseInt(inputs[0]);

		if (percentage < 0 || percentage > 100) {
			System.out.println("That was an invalid number. Enter a value between 1 and 100.");
			return true;
		} else {
			game.setTithingPercentage(percentage);
			System.out.println("\nYou have chosen to pay " + percentage + "% of your harvested wheat to tithing.\n");
			pause(2000);
			return false;
		}
	}

}
