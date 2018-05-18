/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
/**
 *
 * @author Melissa
 */
public class InventoryItem implements Serializable {
    
    private String name;
    private ItemType itemType;
    private int quantity;
    private Condition condition;
    
    public InventoryItem()  {
        
        //Empty constructor for JavaBeans
        
    }
    
   
    
    
    //Getters and Setters

    public String getName() {
        
         return name;
    }
    
    public void setName(String name) {
        
        this.name = name;
    }
    
    
    public ItemType getItemType() {
        
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        
        this.itemType = itemType;
    }

    public int getQuantity() {
        
        return quantity;
    }

    public void setQuantity(int quantity) {
        
        this.quantity = quantity;
    }

    public Condition getCondition() {
        
        return condition;
    }

    public void setCondition(Condition condition) {
        
        this.condition = condition;
    }
    
    @Override
    public String toString(){
        
        return "InventoryItem{"
                + " ,name="  + name
                + " ,itemType=" + itemType
                + " ,quantity=" + quantity
                + " ,condition=" + condition
                + '}';
    }
    
}
