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
 * @author heatherholt
 */
public class LoadSavedGameView extends ViewBase {

	/**
	 * Constructor
	 */
	public LoadSavedGameView() {

	}

	@Override
	protected String getMessage() {
		return "\n\nHere you can load a saved game.";
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

		inputs[0] = getUserInput("Please enter the name of your saved game, ending in '.dat'");

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
		try {
			GameControl.loadGame(filePath);
			Game currentGame = CityOfAaron.getCurrentGame();
			this.console.println("\n\n- Year: " + currentGame.getCurrentYear()
					+ "\n- The current population is " + currentGame.getCurrentPopulation()
					+ "\n- The city owns " + currentGame.getAcresOwned() + " acres of crop land"
					+ "\n- The total amount of wheat in storage is " + currentGame.getWheatInStorage() + " bushels");
			pause(2000);
		} catch (GameControlException gce) {
			ErrorView.display(this.getClass().getName(), gce.getMessage());
			return true;
		} catch (IOException ex) {
			ErrorView.display(this.getClass().getName(), ex.getMessage());
			return true;
		} catch (ClassNotFoundException cnfe) {
			ErrorView.display(this.getClass().getName(), cnfe.getMessage());
		}
		
		GameMenuView gameMenu = new GameMenuView();
		gameMenu.displayView();
		
		return false;
	}

}
