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
                + "R - Return to the Main Menu\n";
                
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
                + "R - Return to the Main Menu\n"; */
		
		
        switch (inputs[0].trim().toUpperCase()) {
			case "1":
				System.out.println("goals");
				pause();
				break;
			case "2":
				System.out.println("where");
				pause();
				break;
			case "3":
				System.out.println("map");
				pause();
				break;
			case "4":
				System.out.println("move");
				pause();
				break;
			case "5":
				System.out.println("reports");
				pause();
				break;
			case "R":
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
