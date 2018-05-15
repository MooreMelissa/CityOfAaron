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
public class Map implements Serializable {
    
    private Location[][] locations;
    private Point currentLocation;
    
    public Map(){
        //Empty constructor for JavaBeans
    }
    
    //Getters and Setters
    public Location[][] getLocations() {
        return locations;
    }

    public Point getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Point currentLocation) {
        this.currentLocation = currentLocation;
    }
    
    
    @Override
    public String toString(){
        return "Map{" 
                + "locations=" + locations 
                + ", currentLocation=" + currentLocation 
                + '}';
    }
}
