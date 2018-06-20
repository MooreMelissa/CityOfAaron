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
public class StartProgramView extends ViewBase {
    
    /**
     * Constructor
     */
    public StartProgramView(){
        super();
    }
    
    @Override
    protected String getMessage() {
        return "Welcome to the City of Aaron!"
		+ "You have been elected as the new ruler.\n"
                + "\n"
                + "You must keep your villagers alive and help them thrive by:\n"
                + "1 - Managing the buying and selling of acres of land\n"
                + "2 - Keeping your people from starvation\n"
                + "3 - Planting and harvesting wheat\n"
                + "4 - Electing to pay a religious tithe\n"
                + "\n"
                + "Your reign will last 10 years at which point your rule will\n"
                + "end and the village judge will give you a score.\n"
                + "\n"
                + "Are you destined for greatness or failure? Play to know!";
    }
    
    /**
     * Get the set of inputs from the user.
     * @return 
     */
    @Override
    public String[] getInputs() {
        
		// This view is not interactive, it does not need any inputs.
		// This view shows a welcome message, then moves on to the main menu.
		
        return null;
    }
    
    
    /**
     * Perform the action indicated by the user's input.
     * @param inputs
     * @return true if the view should repeat itself, and false if the view
     * should exit and return to the previous view.
     */
    @Override
    public boolean doAction(String[] inputs){
        
		// This view is not interactive, it does not need any inputs.
		// This view will show a welcome message, pause, then move on to the
		// main menu.
		
        startMainMenuView();
        
		// This view will return false so it is not called again.
        return false;
    }
    
    
    // Define your action handlers here. These are the methods that your doAction()
    // method will call based on the user's input. We don't want to do a lot of 
    // complex game stuff in our doAction() method. It will get messy very quickly.
    
    
    private void startMainMenuView() {
		pause(2000);
		View mainMenu = new MainMenuView();
		mainMenu.displayView();
	}
}
