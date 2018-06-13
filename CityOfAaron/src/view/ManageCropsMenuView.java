/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Scanner;

/**
 *
 * @author melissamoore, heatherholt, kanderson
 */
public class ManageCropsMenuView {

    /**
     * The message that will be displayed by this view.
     */
    protected String message;

    /**
     * Constructor
     */
    public ManageCropsMenuView() {

        message = "\n\nManage the Crops Menu\n"
                + "-------------------\n"
                + "B - Buy Land\n"
                + "S - Sell Land\n"
                + "F - Feed the People\n"
                + "P - Plant Crops\n"
                + "T - Pay Tithes and Offerings\n"
                + "Q - Return to Game Menu\n";

    }

    /**
     * Get the user's input. Keep prompting them until they enter a value.
     *
     * @param prompt
     * @param allowEmpty - determine whether the user can enter no value (just a
     * return key)
     * @return
     */
    protected String getUserInput(String prompt, boolean allowEmpty) {

        Scanner keyboard = new Scanner(System.in);
        String input = "";
        boolean inputReceived = false;

        while (inputReceived == false) {

            System.out.println(prompt);
            input = keyboard.nextLine();

            // Make sure we avoid a null-pointer error.
            if (input == null) {
                input = "";
            }

            // Trim any trailing whitespace, including the carriage return.
            input = input.trim();

            if (input.equals("") == false || allowEmpty == true) {
                inputReceived = true;
            }
        }

        return input;
    }

    /**
     * An overloaded version of getUserInput that sets allowEmpty to false so we
     * don't have to type it ourselves.
     *
     * @param prompt
     * @return
     */
    protected String getUserInput(String prompt) {
        return getUserInput(prompt, false);
    }

    /**
     * Get the set of inputs from the user.
     *
     * @return
     */
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
    public boolean doAction(String[] inputs) {
        /* "Manage the Crops Menu.\n"
                + "-------------------\n"
                + "B Buy Land\n"
                + "S Sell Land\n"
                + "F Feed the People\n"
                + "P Plant Crops\n"
                + "T Pay Tithes and Offerings "
                + "Q Return to Game Menu\n";*/

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

    /**
     * Control this view's display/prompt/action loop until the user chooses and
     * action that causes this view to close.
     */
    public void displayView() {

        boolean keepGoing = true;

        while (keepGoing == true) {

            System.out.println(message);
            String[] inputs = getInputs();
            keepGoing = doAction(inputs);
        }
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
