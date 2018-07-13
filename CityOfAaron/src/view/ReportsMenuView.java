/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import cityofaaron.CityOfAaron;
import control.StorehouseControl;
import java.io.PrintWriter;
import model.Author;
import model.Game;
import model.InventoryItem;
import model.Storehouse;
import model.Provision;
import model.Animal;

/**
 *
 * @author heatherholt, kanderson
 */
public class ReportsMenuView extends ViewBase {

    Game game = CityOfAaron.getCurrentGame();
    Storehouse storehouse = game.getTheStorehouse();

    /**
     * Constructor
     */
    public ReportsMenuView() {

    }

    @Override
    protected String getMessage() {
        return "\n\nReports Menu\n"
                + "-------------\n"
                + "A - View Animals in Storehouse\n"
                + "T - View Tools in Storehouse\n"
                + "P - View Provisions in Storehouse\n"
                + "V - View Authors of Game\n"
                + "Q - Return to Game Menu";
    }

    /**
     * Get the set of inputs from the user.
     *
     * @return
     */
    @Override
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
     *
     * @param inputs
     * @return true if the view should repeat itself, and false if the view
     * should exit and return to the previous view.
     */
    @Override
    public boolean doAction(String[] inputs) {

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

    // Define your action handlers here. These are the methods that your doAction()
    // method will call based on the user's input. We don't want to do a lot of 
    // complex game stuff in our doAction() method. It will get messy very quickly.
    private void viewAnimals() {
        animalsPrintReport(this.console);
        String question = getFileName("\n\nDo you want to save the Animals Report to a File? (Yes of No)");
        switch (question) {

            case "Yes":
            case "yes":
            case "y":
            case "Y":
                String filepath = getFileName("\n\nWhat file would you like to save the Animals Report to?");
                if (filepath == null || filepath.equals("")) {
                    this.console.println("\n\nReturning to Reports Menu");
                    pause(2000);
                    return;
                }
                try (PrintWriter animalsFile = new PrintWriter(filepath)) {

                    animalsPrintReport(animalsFile);
                    animalsFile.close();
                    this.console.println("\n\nThe animals Report was successfully saved to " + filepath);
                } catch (Exception ex) {
                    ErrorView.display(this.getClass().getName(), ex.getMessage());
                }
                pause(2000);
                break;

            default:
                this.console.println("\n\nReturning to Reports Menu");
                pause(2000);
                break;
        }
    }

    private void viewTools() {
        toolsPrintReport(this.console);
        String question = getFileName("\n\nDo you want to save the Tools Report to a File? (Yes of No)");
        switch (question) {

            case "Yes":
            case "yes":
            case "y":
            case "Y":
                String filepath = getFileName("\n\nWhat file would you like to save the Tools Report to?");
                if (filepath == null || filepath.equals("")) {
                    this.console.println("\n\nReturning to Reports Menu");
                    pause(2000);
                    return;
                }
                try (PrintWriter toolsFile = new PrintWriter(filepath)) {

                    toolsPrintReport(toolsFile);
                    toolsFile.close();
                    this.console.println("\n\nTools Report was successfully saved to " + filepath);
                } catch (Exception ex) {
                    ErrorView.display(this.getClass().getName(), ex.getMessage());
                }
                pause(2000);
                break;

            default:
                this.console.println("\n\nReturning to Reports Menu");
                pause(2000);
                break;
        }
    }

    private void viewProvisions() {
        //provisionsPrintReport(this.console);
        //pause(2000);
        // trying to merge into one function
        provisionsPrintReport(this.console);
        String question = getFileName("\n\nDo you want to save Provisions Report to a File? (Yes or No)");
        switch (question) {

            case "Yes":
            case "yes":
                String filepath = getFileName("\n\nWhat file to save Provisions Report?");
                if (filepath == null || filepath.equals("")) {
                    this.console.println("\n\nReturing to Reports Menu");
                    pause(2000);
                    return;
                }

                try (PrintWriter provisionsFile = new PrintWriter(filepath)) {

                    provisionsPrintReport(provisionsFile);
                    provisionsFile.close();
                    this.console.println("\n\nProvisions Report was successfully saved to " + filepath);

                } catch (Exception ex) {
                    ErrorView.display(this.getClass().getName(), ex.getMessage());

                }
                pause(2000);
                break;

            default:
                this.console.println("\n\nReturing to Reports Menu");
                pause(2000);
                break;

        }
    }

    private void viewAuthors() {
        Author[] authors = storehouse.getAuthors();
        int arrayLength = authors.length;
        for (int i = 0; i < arrayLength; i++) {
            this.console.print(authors[i]);
        }
        pause(2000);
    }

    private String getFileName(String prompt) {
        this.console.println(prompt);
        try {
            return this.keyboard.readLine();

        } catch (Exception ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }
        return null;
    }
    
        private void animalsPrintReport(PrintWriter printWriter) {
        InventoryItem[] animals = StorehouseControl.sortAnimals(storehouse.getAnimals());

        printWriter.println("    Animals Report     ");
        printWriter.printf("%n%-12s%-10s%-10s%-10s", "Name", "Quantity", "Condition", "Age");
        printWriter.printf("%n%-12s%-10s%-10s%-10s", "----", "--------", "---------", "---");
        for (InventoryItem animal : animals) {
            int age = ((Animal) animal).getAge();
            printWriter.printf("%n%-12s%-10d%-10s%-10d", animal.getName(), animal.getQuantity(), animal.getCondition(), age);
        }
        printWriter.flush();
    }

    private void toolsPrintReport(PrintWriter printWriter) {
        InventoryItem[] tools = StorehouseControl.sortTools(storehouse.getTools());

        printWriter.println("    Tools Report     ");
        printWriter.printf("%n%-12s%-10s%-10s", "Name", "Quantity", "Condition");
        printWriter.printf("%n%-12s%-10s%-10s", "----", "--------", "---------");
        for (InventoryItem tool : tools) {
            printWriter.printf("%n%-12s%-10d%-10s", tool.getName(), tool.getQuantity(), tool.getCondition());
        }
        printWriter.flush();
    }

    private void provisionsPrintReport(PrintWriter printWriter) {
        InventoryItem[] provisions = StorehouseControl.sortProvisions(storehouse.getProvisions());

        printWriter.println("               Provisions Report           ");
        printWriter.printf("%n%-12s%-10s%-10s%-12s", "Name", "Quantity", "Condition", "Perishable");
        printWriter.printf("%n%-12s%-10s%-10s%-12s", "-----", "---------", "---------", "-----------");
        for (InventoryItem provision : provisions) {
            boolean perishable = (provision instanceof Provision)
                    ? ((Provision) provision).isPerishable()
                    : false;
            printWriter.printf("%n%-12s%-10d%-10s%-12s", provision.getName(), provision.getQuantity(),
                    provision.getCondition(), perishable);

        }
        printWriter.flush();
    }
}
