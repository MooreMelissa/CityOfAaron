/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import cityofaaron.CityOfAaron;
import model.Game;
import model.Location;
import model.Map;

/**
 *
 * @author heatherholt
 */
public class MapView extends ViewBase {

	/**
	 * Constructor
	 */
	public MapView() {

	}

	@Override
	protected String getMessage() {
		return "\n\n";
	}

	/**
	 * Get the set of inputs from the user.
	 *
	 * @return
	 */
	@Override
	public String[] getInputs() {

		return null;
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
		displayMap();
		pause(2000);

		return false;
	}

	// Define your action handlers here. These are the methods that your doAction()
	// method will call based on the user's input. We don't want to do a lot of 
	// complex game stuff in our doAction() method. It will get messy very quickly.
	public void displayMap() {
		Game currentGame = CityOfAaron.getCurrentGame();
		Map map = currentGame.getTheMap();
		Location[][] locations = map.getLocations();

		System.out.println("      City Of Aaron          \n"
				+ "\n    1   2   3   4   5   "
				+ "\n------------------------");
		for (int i = 0; i < locations.length; i++) {
			System.out.print(i + 1 + " | ");
			for (int j = 0; j < locations[i].length; j++) {
				Location location = locations[i][j];
				System.out.print(location.getMapSymbol() + " | ");
			}
			System.out.print("\n------------------------\n");
		}

	}

}
