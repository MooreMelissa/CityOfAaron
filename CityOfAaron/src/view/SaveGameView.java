/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import cityofaaron.CityOfAaron;
import control.GameControl;
import exception.GameControlException;
import java.io.IOException;
import model.Game;

/**
 *
 * @author heatherholt, kanderson
 */
public class SaveGameView extends ViewBase {

	/**
	 * Constructor
	 */
	public SaveGameView() {

	}

	@Override
	protected String getMessage() {
		return "\n\nHere you can save your game to play again!";
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

		inputs[0] = getUserInput("Please enter a name for your saved game, ending in '.dat'");

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

		String filePath = inputs[0];
		Game game = CityOfAaron.getCurrentGame();
		try {
			GameControl.saveGame(game, filePath);
		} catch (IOException ex) {
			ErrorView.display(this.getClass().getName(), ex.getMessage());
			return true;
		} catch (GameControlException gce) {
			ErrorView.display(this.getClass().getName(), gce.getMessage());
			return true;
		}
		this.console.println("\nThe game has been saved to: " + filePath);
		pause(2000);
		return false;
	}

}
