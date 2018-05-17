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
public class Animal extends InventoryItem implements Serializable {

    
    private int age;
    
    public Animal(){
        
        //Empty constructor for JavaBeans
        super();
        setItemType(ItemType.Animal);
    }
    
 
    
    //Getters and Setters

 
    public int getAge() {
        
        return age;
    }

    public void setAge(int age) {
        
        this.age = age;
    }
    
    @Override
    public String toString(){
        
        String sup = super.toString();
        
        return sup + "Animal{"
                + " ,age=" + age
                + '}';
    }
    
}
