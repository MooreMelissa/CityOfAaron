/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import cityofaaron.CityOfAaron;
import control.GameControl;
import model.Game;
import java.util.Scanner;

/**
 *
 * @author heatherholt, kanderson
 */
public class PlantCropsView {
	
    Game game = CityOfAaron.getCurrentGame();
	
    /**
     * The message that will be displayed by this view.
     */
    protected String message;
    
    /**
     * Constructor
     */
    public PlantCropsView(){
        
        message = "\n\nWelcome to the Granary and Storehouse!\n "
                + "You can get seed for your fields here.\n"
                + "To return to Manage the Crops Menu press Enter\n\n";
                
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
        
        inputs[0] = getUserInput("How many acres of land do you want to plant?", true);
        
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
	    // Returning false will take us back to the Manage Crops Menu.
            // check input from user can be converted to int call method here
            if (inputs[0] == null || inputs[0].equals("")) {
			System.out.println("\nNo amount was entered. Returning to the Manage the Crops Menu...");
			pause();
			return false;
		} 
            
            else {
                
                boolean check = false;
                while (check == false) {
                    try {
                        Integer.parseInt(inputs[0]);
                        check = true;
                    } catch (NumberFormatException nfe) {

                        System.out.println("Not a valid input. Please enter a number");
                        inputs = getInputs();
                        

                    }
                }

                boolean result = plantCropsTransaction(inputs);
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
    
    
    private boolean plantCropsTransaction(String[] inputs) {
		
		Game game = CityOfAaron.getCurrentGame();
		 
		int acresToPlant = Integer.parseInt(inputs[0]);
                int acresOwned = game.getAcresOwned();
                int currentPopulation = game.getCurrentPopulation();
		int totalWheat = game.getWheatInStorage();
		
		int crops = GameControl.plantCrops(acresToPlant, acresOwned, currentPopulation, totalWheat);
                
                if (crops == -1) {
                    System.out.println("\n** Invalid input, please try again. **");
			return true;
                }
                if (crops == -2) {
                    System.out.println("\n ** Invalid input **"
                                       + "\nThe amount of acres entered is more than acres owned"
                                       + "\nPlease try again");
                        return true;
                }
                if (crops == -3) {
                    System.out.println("\n** Invalid input **"
                                       + "\nThe amount of acres entered is more than the"
                                       + "current population can take care of"
                                       + "Please try again");
                        return true;
                }
                if (crops == -4) {
                    System.out.println("\n** Invalid input **"
                                       + "\nThe amount of acres entered is exceeded"
                                       + "the wheat in storage"
                                       + "\nPlease try again");
                        return true;
                }
                
                else {
                    game.setWheatInStorage(totalWheat - crops);
                    game.setAcresPlanted(acresToPlant);
                    System.out.println("\nYou have " + game.getWheatInStorage() + " bushels of wheat in storage.");
			pause();
			return false;
                }
	}
	
    private void pause(){
        // Pause for a few seconds
	try {
	    // 2000 millisecond delay after the welcome message is displayed.
	    Thread.sleep(2000);
	    } 
        
        catch(InterruptedException exception) {
			// ignore this exception for now
		}
    }
	
}
