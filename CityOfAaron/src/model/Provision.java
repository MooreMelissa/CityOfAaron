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
public class Provision extends InventoryItem implements Serializable {
 
    
    private boolean perishable;
    
    
    public Provision(){
        
        //Empty constructor for JavaBeans
        super();
       // setItemType(ItemType.Provisions);
        
    }


    public boolean isPerishable() {
        
        return perishable;
    }

    public void setPerishable(boolean perishable) {
        
        this.perishable = perishable;
    }
    
     
      
       
    @Override
    public String toString(){
        
        String sup = super.toString();
        
        return sup + "Provision{" 
                + " ,perishable=" + perishable
                + '}';
    }
    
}
