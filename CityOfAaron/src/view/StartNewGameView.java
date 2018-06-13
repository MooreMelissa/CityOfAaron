/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import cityofaaron.CityOfAaron;
import control.RandomNumbers;
import java.util.Scanner;
import model.Game;
import model.Player;

/**
 *
 * @author heatherholt, kanderson
 */
public class StartNewGameView {
	/**
     * The message that will be displayed by this view.
     */
    protected String message;
    
    /**
     * Constructor
     */
    public StartNewGameView(){
        
        message = "\nStarting a new game...\n\n"
				+ "So you've chosen to accept the position as ruler of Aaron!\n"
                + "Rule with bravery and wit and your village will thrive.\n"
                + "Good luck! And watch out for the rats...\n";
                
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
        
        inputs[0] = getUserInput("Please enter your name, or press 'Enter' to return to the Main Menu:", true);
        
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
        // There is only one action here: Initialize the Game and
		// set it in the main CityOfAaron class.
		
		// If the user just hits 'enter', bail out and don't do the action.
		// Returning false will take us back to the Main Menu.
        if (inputs[0] == null || inputs[0].equals("")) {
			System.out.println("No player name was entered. Returning to the Main Menu...");
			return false;
		}
		
		String playerName = inputs[0];
		createAndStartGame(playerName);
		
		// Return false to prevent loop.
        return false;
    }
    
    
    /**
     * Control this view's display/prompt/action loop until the user
     * chooses and action that causes this view to close.
     */
    public void displayView(){
        
        boolean keepGoing = true;
        
        while(keepGoing == true){
            
            System.out.println(message);
			pause();
            String[] inputs = getInputs();
            keepGoing = doAction(inputs);
        }
    }
    
    
    // Define your action handlers here. These are the methods that your doAction()
    // method will call based on the user's input. We don't want to do a lot of 
    // complex game stuff in our doAction() method. It will get messy very quickly.
	
	private void pause(){
        // Pause for a few seconds
		try {
			// 2000 millisecond delay after the welcome message is displayed.
			Thread.sleep(2000);
		} catch(InterruptedException exception) {
			// ignore this exception for now
		}
    }
	
	/**
	 * Create a new Game with the named Player and call the GameMenuView.
	 */
	private void createAndStartGame(String playerName) {
		
		// Eventually, we will do this:
		// Game game = GameControl.createNewGame(playerName);
		//
		// But for this week, we'll do this:
		
		Player player = new Player();
		player.setName(playerName);
		
		Game game = new Game();
		game.setThePlayer(player);
		
		CityOfAaron.setCurrentGame(game);
		
		Game currentGame = CityOfAaron.getCurrentGame();
		currentGame.setCurrentYear(1);
		currentGame.setCurrentPopulation(100);
		currentGame.setAcresOwned(1000);
		currentGame.setTithingPaidInBushels(300);
		currentGame.setTithingPercentage(10);
		currentGame.setWheatInStorage(2700);
		currentGame.setLandPrice(RandomNumbers.getRandom(17, 27));
		
		
		System.out.println("\n\nWelcome to your new domain, " + playerName + "!"
				+ "\nHere's what you need to know before you start:"
				+ "\n\n- Year: " + currentGame.getCurrentYear()
				+ "\n- 0 people starved"
				+ "\n- 5 people came to the city"
				+ "\n- The current population is " + currentGame.getCurrentPopulation()
				+ "\n- The city owns " + currentGame.getAcresOwned() + " acres of crop land"
				+ "\n- 3 bushels per acre were harvested"
				+ "\n- The total harvest was 3000 bushels of wheat"
				+ "\n- The total tithe paid was " + currentGame.getTithingPaidInBushels() + " bushels of wheat"
				+ "\n- 0 bushels of wheat were eaten by rats"
				+ "\n- The total amount of wheat in storage is " + currentGame.getWheatInStorage() + " bushels"
				+ "\n\n ** Please be sure to complete all the tasks in the"
				+ "\n'Manage Crops' menu before choosing to 'Live The Year' **");
		
		pause();
		
		// Once the GameMenuView is created, we will call it here.
		GameMenuView gameMenu = new GameMenuView();
		gameMenu.displayView();
	}
}
