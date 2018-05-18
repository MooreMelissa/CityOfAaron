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
    
    private Location[][] locations = {{new Location("Undeveloped Land","description","U"),
                                       new Location("Undeveloped Land","description","U"),
                                       new Location("Wheat Fields","description","W"),
                                       new Location("Wakanda","description","X"),
                                       new Location("Wheat Fields","description","W")
                                       },
                                    //row2
                                     {new Location("Wheat Fields","description","W"),
                                      new Location("Granary & Storehouse","description","G"),
                                      new Location("Wheat Fields","description","W"),
                                      new Location("Undeveloped Land","description","U"),
                                      new Location("Undeveloped Land","description","U")
                                      },                           
                                    //row3
                                     {new Location("Wheat Fields","description","W"),
                                      new Location("Wheat Fields","description","W"),
                                      new Location("Temple","description","T"),
                                      new Location("Wheat Fields","description","W"),
                                      new Location("Asgard","description","A")
                                      },
                                     //row4
                                     {new Location("Wheat Fields","description","W"),
                                      new Location("Skyfall","description","S"),
                                      new Location("Market","description","M"),
                                      new Location("Wheat Fields","description","W"),
                                      new Location("River","description","R")
                                      },
                                     //row5
                                     {new Location("Undeveloped Land","description","U"),
                                      new Location("Wheat Fields","description","W"),
                                      new Location("Wheat Fields","description","W"),
                                      new Location("River","description","R"),
                                      new Location("Border of Lamanite Land","description","L")
                                      }};

    private Point currentLocation;
    
    
    public Map(){
    //Empty constructor for JavaBeans
        currentLocation = new Point (0,0);
    }

    //Getters and Setters
    public Location[][] getLocations() {
        return locations;
    }

    public Point getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Point point) {
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
