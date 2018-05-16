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
public class Provision implements Serializable {
    
    private boolean perishable;
    
    public Provision(){
        
        //Empty constructo for JavaBeans
    }


    public boolean isPerishable() {
        
        return perishable;
    }

    public void setPerishable(boolean perishable) {
        
        this.perishable = perishable;
    }
    
    @Override
    public String toString(){
        
        return "Provision{" 
                + " ,perishable=" + perishable
                + '}';
    }
    
}
