/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.util.Scanner;
import model.Author;
import model.InventoryItem;
import model.Storehouse;

/**
 *
 * @author heatherholt, kanderson
 */
public class ReportsMenuView {
	
	
	
	/**
     * The message that will be displayed by this view.
     */
    protected String message;
    
	
	Storehouse storehouse = new Storehouse();
	
	
    /**
     * Constructor
     */
    public ReportsMenuView(){
        
        message = "\n\nReports Menu\n"
                + "-------------\n"
                + "A - View Animals in Storehouse\n"
                + "T - View Tools in Storehouse\n"
                + "P - View Provisions in Storehouse\n"
                + "V - View Authors of Game\n"
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
        
		/* "Reports Menu\n"
                + "-------------\n"
                + "A - View Animals in Storehouse\n"
                + "T - View Tools in Storehouse\n"
                + "P - View Provisions in Storehouse\n"
                + "V - View Authors of Game\n"
				+ "Q - Return to Main Menu" */
		
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
	
	private void viewAnimals() {
		//System.out.println("* viewAnimals() called. Implementation coming soon. *");
		InventoryItem[] animals = storehouse.getAnimals();
		System.out.println(animals[0]);
		System.out.println(animals[1]);
		System.out.println(animals[2]);
		pause();
	}
	
	private void viewTools() {
		//System.out.println("* viewTools() called. Implementation coming soon. *");
		InventoryItem[] tools = storehouse.getTools();
		System.out.println(tools[0]);
		System.out.println(tools[1]);
		System.out.println(tools[2]);
		pause();
	}
	
	private void viewProvisions() {
		//System.out.println("* viewProvisions() called. Implementation coming soon. *");
		InventoryItem[] provisions = storehouse.getProvisions();
		System.out.println(provisions[0]);
		System.out.println(provisions[1]);
		System.out.println(provisions[2]);
		pause();
	}
	
	private void viewAuthors() {
		//System.out.println("* viewAuthors() called. Implementation coming soon. *");
		Author[] authors = storehouse.getAuthors();
		System.out.println(authors[0]);
		System.out.println(authors[1]);
		System.out.println(authors[2]);
		pause();
	}
	
}
