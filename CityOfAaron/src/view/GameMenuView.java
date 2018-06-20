/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import cityofaaron.CityOfAaron;
import control.GameControl;
import control.RandomNumbers;
import java.util.Scanner;
import model.Game;

/**
 *
 * @author heatherholt, kanderson
 */
public class GameMenuView {
	
	/**
     * The message that will be displayed by this view.
     */
    protected String message;
    
    /**
     * Constructor
     */
    public GameMenuView(){
        
        message = "\n\nGame Menu\n"
                + "-------------\n"
                + "V - View Map\n"
                + "M - Move Location\n"
                + "C - Manage Crops\n"
                + "L - Live The Year\n"
				+ "R - View Reports Menu\n"
				+ "S - Save Game\n"
				+ "Q - Return to Main Menu";
                
    }
    
    
    /**
     * Get the user's input. Keep prompting them until they enter a value.
     * @param prompt
     * @param allowEmpty - determine whether the user can enter no value (just a return key)
     * @return 
     */
    protected String getUserInput(String prompt, boolean allowEmpty){
        
        Scanner keyboard = new Scanner(System.in);
        String input = "";
        boolean inputReceived = false;
        
        while(inputReceived == false){
            
            System.out.println(prompt);
            input = keyboard.nextLine();
            
            // Make sure we avoid a null-pointer error.
            if (input == null){
                input = "";
            }
            
            // Trim any trailing whitespace, including the carriage return.
            input = input.trim();
            
            if (input.equals("") == false || allowEmpty == true){
                inputReceived = true;
            }
        }
        
        return input;
    }
    
    
    /**
     * An overloaded version of getUserInput that sets allowEmpty to false so we don't have 
     * to type it ourselves.
     * @param prompt
     * @return 
     */
    protected String getUserInput(String prompt){
        return getUserInput(prompt, false);
    }
    
    /**
     * Get the set of inputs from the user.
     * @return 
     */
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
    public boolean doAction(String[] inputs){
		
		switch (inputs[0].trim().toUpperCase()) {
			case "V":
				viewMap();
				break;
			case "M":
				moveLocation();
				break;
			case "C":
				manageCropsMenu();
				break;
			case "L":
				liveTheYear();
				break;
			case "R":
				reportsMenu();
				break;
			case "S":
				saveGame();
				break;
			case "Q":
				return false;
		}
        
        return true;
    }
    
    
    /**
     * Control this view's display/prompt/action loop until the user
     * chooses and action that causes this view to close.
     */
    public void displayView(){
        
        boolean keepGoing = true;
        
        while(keepGoing == true){
            
            System.out.println(message);
            String[] inputs = getInputs();
            keepGoing = doAction(inputs);
        }
    }
    
    
    // Define your action handlers here. These are the methods that your doAction()
    // method will call based on the user's input. We don't want to do a lot of 
    // complex game stuff in our doAction() method. It will get messy very quickly.
    				
	private void viewMap() {
		MapView mapView = new MapView();
		mapView.displayView();
	}
	
	private void moveLocation() {
		MoveLocationsView moveView = new MoveLocationsView();
		moveView.displayView();;
	}

	private void manageCropsMenu() {
		ManageCropsMenuView manageCrops = new ManageCropsMenuView();
		manageCrops.displayView();
               
	}
	
	
	private void liveTheYear() {
		System.out.println("* liveTheYear() called. Implementation coming soon. *");
		
		// I'm not positive how to do this yet, just experimenting.
		
		/* Game currentGame = CityOfAaron.getCurrentGame();
		boolean errorResult = GameControl.liveTheYear(CityOfAaron.getCurrentGame());
		if (errorResult == false) {
			System.out.println("There has been an error. Please check the values"
					+ " in the Manage The Crops Menu and try again.");
		} else {
			System.out.println("\n\n- Year: " + currentGame.getCurrentYear()
				+ "\n- 0 people starved" // ** How do we get this value for display?
				+ "\n- 5 people came to the city" // ** How do we get this value for display?
				+ "\n- The current population is " + currentGame.getCurrentPopulation()
				+ "\n- The city owns " + currentGame.getAcresOwned() + " acres of crop land"
				+ "\n- 3 bushels per acre were harvested" // ** How do we get this value for display?
				+ "\n- The total harvest was " + GameControl.harvestWheat(currentGame.getAcresPlanted(), 
					currentGame.getTithingPercentage(), RandomNumbers.getRandom(1, 3), 
					RandomNumbers.getRandom(2, 4), RandomNumbers.getRandom(2, 5)) + " bushels of wheat" 
					// ** How do we get this value for display?
				+ "\n- The total tithe paid was " + currentGame.getTithingPaidInBushels() + " bushels of wheat"
				+ "\n- 0 bushels of wheat were eaten by rats" // ** How do we get this value for display?
				+ "\n- The total amount of wheat in storage is " + currentGame.getWheatInStorage() + " bushels");
		} */
	}
	
	private void reportsMenu() {
		ReportsMenuView reports = new ReportsMenuView();
		reports.displayView();
	}
	
	private void saveGame() {
		SaveGameView saveGame = new SaveGameView();
		saveGame.displayView();
	}
	
	private void pause(){
        // Pause for a few seconds
		try {
			// 2000 millisecond delay after the welcome message is displayed.
			Thread.sleep(2000);
		} catch(InterruptedException exception) {
			// ignore this exception for now
		}
    }
	
}
