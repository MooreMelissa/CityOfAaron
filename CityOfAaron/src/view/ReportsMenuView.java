/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import cityofaaron.CityOfAaron;
import java.util.Arrays;
import model.Author;
import model.Game;
import model.InventoryItem;
import model.Storehouse;

/**
 *
 * @author heatherholt, kanderson
 */
public class ReportsMenuView extends ViewBase {

	Game game = CityOfAaron.getCurrentGame();
	Storehouse storehouse = game.getTheStorehouse();

	/**
	 * Constructor
	 */
	public ReportsMenuView() {

	}

	@Override
	protected String getMessage() {
		return "\n\nReports Menu\n"
				+ "-------------\n"
				+ "A - View Animals in Storehouse\n"
				+ "T - View Tools in Storehouse\n"
				+ "P - View Provisions in Storehouse\n"
				+ "V - View Authors of Game\n"
				+ "Q - Return to Game Menu";
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

		inputs[0] = getUserInput("Please choose a menu option:");

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

		switch (inputs[0].trim().toUpperCase()) {
			case "A":
				viewAnimals();
				break;
			case "T":
				viewTools();
				break;
			case "P":
				viewProvisions();
				break;
			case "V":
				viewAuthors();
				break;
			case "Q":
				return false;
		}

		return true;
	}

	// Define your action handlers here. These are the methods that your doAction()
	// method will call based on the user's input. We don't want to do a lot of 
	// complex game stuff in our doAction() method. It will get messy very quickly.
	private void viewAnimals() {
		InventoryItem[] animals = storehouse.getAnimals();
		Arrays.sort(animals, (a,b) -> a.getName().compareTo(b.getName()));
		for (int i=0; i < animals.length; i++) {
			System.out.println(animals[i]);
		}
		pause(2000);
	}

	private void viewTools() {
		InventoryItem[] tools = storehouse.getTools();
		int arrayLength = tools.length;
		for (int i = 0; i < arrayLength; i++) {
			System.out.print(tools[i]);
		}
		pause(2000);
	}

	private void viewProvisions() {
		//System.out.println("* viewProvisions() called. Implementation coming soon. *");
		InventoryItem[] provisions = storehouse.getProvisions();
		int arrayLength = provisions.length;
		for (int i = 0; i < arrayLength; i++) {
			System.out.print(provisions[i]);
		}
		pause(2000);
	}

	private void viewAuthors() {
		//System.out.println("* viewAuthors() called. Implementation coming soon. *");
		Author[] authors = storehouse.getAuthors();
		int arrayLength = authors.length;
		for (int i = 0; i < arrayLength; i++) {
			System.out.print(authors[i]);
		}
		pause(2000);
	}

}
