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
    private InventoryItem[] animals = {new Animal("Tiger", ItemType.Animal, 2, Condition.Good, 10),
        new Animal("Emu", ItemType.Animal, 5, Condition.Good, 7),
        new Animal("Zebra", ItemType.Animal, 13, Condition.Good, 5),
        new Animal("Llama", ItemType.Animal, 3, Condition.Good, 1),
        new Animal("Badger", ItemType.Animal, 8, Condition.Good, 3)};
    private InventoryItem[] tools = {new InventoryItem("Hammer", ItemType.Tool, 2, Condition.Fair),
        new InventoryItem("Jig Saw", ItemType.Tool, 1, Condition.Good),
        new InventoryItem("Axe", ItemType.Tool, 4, Condition.Poor),
        new InventoryItem("Wrench", ItemType.Tool, 12, Condition.Fair),
        new InventoryItem("Screw Driver", ItemType.Tool, 6, Condition.Good)};
    private InventoryItem[] provisions = {new Provision("Apples", ItemType.Provisions, 5, Condition.Good, true),
        new Provision("Crates", ItemType.Provisions, 20, Condition.Fair, false),
        new Provision("Blankets", ItemType.Provisions, 8, Condition.Poor, false),
        new Provision("Carts", ItemType.Provisions, 7, Condition.Good, false),
        new Provision("Tents", ItemType.Provisions, 35, Condition.Fair, false),
        new Provision("Nuts", ItemType.Provisions, 25, Condition.Good, true),
        new Provision("Potatoes", ItemType.Provisions, 50, Condition.Good, true),
        new Provision("Ropes", ItemType.Provisions, 10, Condition.Poor, false)};

    public Storehouse() {
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
    public String toString() {
        String temporary = "";
        for (Author author : authors) {
            temporary += author.toString();
        }
        for (InventoryItem animal : animals) {
            temporary += animal.toString();
        }
        for (InventoryItem tool : tools) {
            temporary += tool.toString();
        }
        for (InventoryItem provision : provisions) {
            temporary += provision.toString();
        }
        return temporary;
        /*return "Storehouse{" 
                + "authors=" + authors 
                + ", animals=" + animals 
                + ", tools=" + tools 
                + ", provisions=" + provisions
                + '}';*/
    }

}
