/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author heatherholt, kanderson
 */
public class HelpMenuView extends ViewBase {

	/**
	 * Constructor
	 */
	public HelpMenuView() {

	}

	@Override
	protected String getMessage() {
		return "\n\nHelp Menu\n"
				+ "-------------\n"
				+ "1 - What are the goals of the game?\n"
				+ "2 - Where is the city of Aaron?\n"
				+ "3 - How do I view the map?\n"
				+ "4 - How do I move to another location?\n"
				+ "5 - How do I display a list of animals, provisions, and tools in the city storehouse?\n"
				+ "Q - Return to the Main Menu\n";

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
			case "1":
				this.console.println("Goals of the Game\n"
						+ "--------------\n"
						+ "1- Last as ruler for 10 years\n"
						+ "2- The City of Aaron is better off than when you took over\n"
						+ "3- The people are fed\n"
						+ "4- The city has land to plant crops\n"
						+ "5- There is Wheat in Storage\n");
				pause(2000);
				break;
			case "2":
				this.console.println("The City of Aaron sits on a small hill overlooking the SkyFall River to the South.\n"
						+ "The temple is a beacon of light which shines from the center of the city\n"
						+ "Endless wheatfields circle the city as the staff of life\n"
						+ "It is a two days journey South to the City of Zarahemla\n");
				pause(2000);
				break;
			case "3":
				this.console.println("To View the Map\n"
						+ "--------------\n"
						+ "Go to Game Menu and select View the Map\n");
				pause(2000);
				break;
			case "4":
				this.console.println("To Move to Another Location\n"
						+ "--------------\n"
						+ "Go to Game Menu and select Move Location\n"
						+ "You will be prompted to enter the coordinates to a location on the map\n");
				pause(2000);
				break;
			case "5":
				this.console.println("To Display list of Animals, Tools, and Provisions\n"
						+ "---------------\n"
						+ "Go to the Reports Menu and select what list you want to view\n");
				pause(2000);
				break;
			case "Q":
				return false;

			default:
				this.console.println("Please enter one of the above menu options.");
		}

		return true;
	}

}
