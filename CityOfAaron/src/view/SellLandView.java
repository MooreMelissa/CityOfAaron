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
 * @author heatherholt
 */
public class SellLandView {
	
	
	
	/**
     * The message that will be displayed by this view.
     */
    protected String message;
    
    /**
     * Constructor
     */
    public SellLandView(){
		
		Game game = CityOfAaron.getCurrentGame();
        
        message = "\n\nWelcome to the market! You can sell land here, or press 'Enter' to return to the previous menu.\n"
				+ "The current price of land is " + game.getLandPrice() + " bushels per acre.";
                
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
        
        inputs[0] = getUserInput("\nHow many acres of land do you want to sell?", true);
        
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
        
		// If the user just hits 'enter', bail out and don't do the action.
		// Returning false will take us back to the Game Menu.
        if (inputs[0] == null || inputs[0].equals("") || inputs[0].equals("\n")) {
			System.out.println("No amount was entered. Returning to the Manage the Crops Menu...");
			pause();
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
			boolean result = sellLandTransaction(inputs);
			return result;
		}
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
	
	private boolean sellLandTransaction(String[] inputs){
		
		Game game = CityOfAaron.getCurrentGame();
		
		int acresToSell = Integer.parseInt(inputs[0]);
		int totalWheat = game.getWheatInStorage();
		int totalAcres = game.getAcresOwned();
		
		int profit = GameControl.sellLand(acresToSell, game.getLandPrice(), totalAcres);
		
		if (profit < 0) {
			System.out.println("\n** Invalid input, please try again. **");
			return true;
		} else {
			game.setWheatInStorage(totalWheat + profit);
			game.setAcresOwned(totalAcres - acresToSell);
			System.out.println("\nYou have successfully sold " + acresToSell + " acres of land.\n"
					+ "You now own " + game.getAcresOwned() + " total acres.\n"
					+ "You have " + game.getWheatInStorage() + " bushels of wheat in storage.");
			pause();
			return false;
		}
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
