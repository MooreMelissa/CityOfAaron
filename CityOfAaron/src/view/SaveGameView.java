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
public class SaveGameView extends ViewBase{
	    
    /**
     * Constructor
     */
    public SaveGameView() {
                
    }
    
	@Override
	protected String getMessage() {
		return "\n\nSave Game View Coming Soon";
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
        
        inputs[0] = getUserInput("Press Q to return to the previous menu.");
        
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
    public boolean doAction(String[] inputs){
        switch (inputs[0].trim().toUpperCase()) {
			case "Q":
				return false;
		}
       
        return true;
    }
    
	
    // Define your action handlers here. These are the methods that your doAction()
    // method will call based on the user's input. We don't want to do a lot of 
    // complex game stuff in our doAction() method. It will get messy very quickly.
    
    
    private boolean someActionHandler(){
        // Define whatever code you need here to accomplish the action.
        // You can make this a void method if you want. Whatever you need 
        // here, you are free to do.
        //
        // Generally, though, this is where you will call into your Control
        // classes to do the work of the application.
        
        return true;
	}
	
	
	
	
}
