/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author heatherholt
 */
public class Storehouse implements Serializable {
    private Author[] authors = {new Author("Melissa Moore", "Maiden of Skyfall"),
		new Author("Rebekah Harris", "Queen of Wakanda"),
		new Author("Heather Holt", "Lady of Asgard")};
    private InventoryItem[] animals = {new InventoryItem("Tiger", ItemType.Animal, 2, Condition.Good), //age 10
		new InventoryItem("Emu", ItemType.Animal, 5, Condition.Good), //age 7
		new InventoryItem("Llama", ItemType.Animal, 3, Condition.Good)}; // age 1
    private InventoryItem[] tools = {new InventoryItem("Hammer", ItemType.Tool, 2, Condition.Fair), 
		new InventoryItem("Jig Saw", ItemType.Tool, 1, Condition.Good),
		new InventoryItem("Axe", ItemType.Tool, 4, Condition.Poor)};
    private InventoryItem[] provisions = {new InventoryItem("Apples", ItemType.Provisions, 5, Condition.Good), //true
		new InventoryItem("Crates", ItemType.Provisions, 20, Condition.Good), //false
		new InventoryItem("Blankets", ItemType.Provisions, 10, Condition.Poor)}; //false
    
    public Storehouse(){
        //Empty constructor for JavaBeans   
    }

    public Author[] getAuthors() {
        return authors;
    }

    public void setAuthors(Author[] authors) {
        this.authors = authors;
    }

    public InventoryItem[] getAnimals() {
        return animals;
    }

    public void setAnimals(InventoryItem[] animals) {
        this.animals = animals;
    }

    public InventoryItem[] getTools() {
        return tools;
    }

    public void setTools(InventoryItem[] tools) {
        this.tools = tools;
    }

    public InventoryItem[] getProvisions() {
        return provisions;
    }

    public void setProvisions(InventoryItem[] provisions) {
        this.provisions = provisions;
    }
    
    
    
    @Override
    public String toString(){
        return "Storehouse{" 
                + "authors=" + authors 
                + ", animals=" + animals 
                + ", tools=" + tools 
                + ", provisions=" + provisions
                + '}';
    }
    
}
