/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author melissamoore, heatherholt, kanderson
 */
public class ManageCropsMenuView extends ViewBase {

	/**
	 * Constructor
	 */
	public ManageCropsMenuView() {

	}

	@Override
	protected String getMessage() {

		return "\n\nManage the Crops Menu\n"
				+ "-------------------\n"
				+ "B - Buy Land\n"
				+ "S - Sell Land\n"
				+ "F - Feed the People\n"
				+ "P - Plant Crops\n"
				+ "T - Pay Tithes and Offerings\n"
				+ "Q - Return to Game Menu\n";

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

		inputs[0] = getUserInput("Please Choose a Menu Option:");

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
			case "B":
				buyLand();
				break;
			case "S":
				sellLand();
				break;
			case "F":
				feedPeople();
				break;
			case "P":
				plantCrops();
				break;
			case "T":
				payTithing();
				break;
			case "Q":
				return false;
		}

		return true;
	}

	// Define your action handlers here. These are the methods that your doAction()
	// method will call based on the user's input. We don't want to do a lot of 
	// complex game stuff in our doAction() method. It will get messy very quickly.
	private void buyLand() {
		BuyLandView buyLand = new BuyLandView();
		buyLand.displayView();
	}

	private void sellLand() {
		SellLandView sellLand = new SellLandView();
		sellLand.displayView();
	}

	private void feedPeople() {
		FeedPeopleView feedPeople = new FeedPeopleView();
		feedPeople.displayView();
	}

	private void plantCrops() {
		PlantCropsView plantCrops = new PlantCropsView();
		plantCrops.displayView();
	}

	private void payTithing() {
		PayTithingView payTithing = new PayTithingView();
		payTithing.displayView();
	}

}
