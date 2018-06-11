/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Scanner;

/**
 *
 * @author heatherholt, kanderson
 */
public class HelpMenuView {
	/**
     * The message that will be displayed by this view.
     */
    protected String message;
    
    /**
     * Constructor
     */
    public HelpMenuView(){
        
        message = "\n\nHelp Menu\n"
                + "-------------\n"
                + "1 - What are the goals of the game?\n"
                + "2 - Where is the city of Aaron?\n"
                + "3 - How do I view the map?\n"
		+ "4 - How do I move to another location?\n"
		+ "5 - How do I display a list of animals, provisions, and tools in the city storehouse?\n"
                + "Q - Return to the Main Menu\n";
                
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
		
		/* "Help Menu\n"
                + "-------------\n"
                + "1 - What are the goals of the game?\n"
                + "2 - Where is the city of Aaron?\n"
                + "3 - How do I view the map?\n"
		+ "4 - How do I move to another location?\n"
		+ "5 - How do I display a list of animals, provisions, and tools in the city storehouse?"
                + "Q - Return to the Main Menu\n"; */
		
		
        switch (inputs[0].trim().toUpperCase()) {
			case "1":
				System.out.println("Goals of the Game\n"
                                        + "--------------\n"
                                        + "1- Last as ruler for 10 years\n"
                                        + "2- The City of Aaron is better off than when you took over\n"
                                        + "3- The people are fed\n"
                                        + "4- The city has land to plant crops\n"
                                        + "5- There is Wheat in Storage\n");
				pause();
				break;
			case "2":
				System.out.println("The City of Aaron sits on a small hill overlooking the SkyFall River to the South.\n"
                                        + "The temple is a beacon of light which shines from the center of the city\n"
                                        + "Endless wheatfields circle the city as the staff of life\n"
                                        + "It is a two days journey South to the City of Zarahemla\n");
				pause();
				break;
			case "3":
				System.out.println("To View the Map\n"
                                        + "--------------\n"
                                        + "Go to Game Menu and select View the Map\n");
				pause();
				break;
			case "4":
				System.out.println("To Move to Another Location\n"
                                        + "--------------\n"
                                        + "Go to Game Menu and select Move Location\n"
                                        + "You will be prompted to enter the coordinates to a location on the map\n");
				pause();
				break;
			case "5":
				System.out.println("To Display list of Animals, Tools, and Provisions\n"
										+ "---------------\n"
										+ "Go to the Reports Menu and select what list you want to view\n");
				pause();
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
