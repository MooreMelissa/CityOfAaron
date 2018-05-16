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
public class Animal implements Serializable {
    
    private int age;
    
    public Animal(){
        
        //Empty constructor for JavaBeans
        
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
        
        return "Animal{"
                + " ,age=" + age
                + '}';
    }
    
}
