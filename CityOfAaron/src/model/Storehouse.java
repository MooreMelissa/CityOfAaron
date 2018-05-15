/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Rebekah
 */
public class Storehouse implements Serializable {
    private Author[] authors;
    private InventoryItem[] animals;
    private InventoryItem[] tools;
    private InventoryItem[] provisions;
    
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
