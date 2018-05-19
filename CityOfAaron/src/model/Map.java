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
    
    private Location[][] locations = {{new Location("Undeveloped Land","Behold the vast expanse of untouched wilderness.","U"),
                                       new Location("Undeveloped Land","Behold the vast expanse of untouched wilderness.","U"),
                                       new Location("Wheat Fields","The field is white, all ready to harvest. Literally.","W"),
                                       new Location("Wakanda","A very technologically advanced village. Wakanda Forever!","X"),
                                       new Location("Wheat Fields","The field is white, all ready to harvest. Literally.","W")
                                       },
                                    //row2
                                     {new Location("Wheat Fields","The field is white, all ready to harvest. Literally.","W"),
                                      new Location("Granary & Storehouse","The granary and storehouse process and store Aaron's supply of wheat.","G"),
                                      new Location("Wheat Fields","The field is white, all ready to harvest. Literally.","W"),
                                      new Location("Undeveloped Land","Behold the vast expanse of untouched wilderness.","U"),
                                      new Location("Undeveloped Land","Behold the vast expanse of untouched wilderness.","U")
                                      },                           
                                    //row3
                                     {new Location("Wheat Fields","The field is white, all ready to harvest. Literally.","W"),
                                      new Location("Wheat Fields","The field is white, all ready to harvest. Literally.","W"),
                                      new Location("Temple","A holy place, central in Aaron, to remind the people to center their lives around Christ.","T"),
                                      new Location("Wheat Fields","The field is white, all ready to harvest. Literally.","W"),
                                      new Location("Asgard","Asgard is like BYU. You go there to find a hot spouse.","A")
                                      },
                                     //row4
                                     {new Location("Wheat Fields","The field is white, all ready to harvest. Literally.","W"),
                                      new Location("Skyfall","This village goes by the name of Fall. SKYfall.","S"),
                                      new Location("Market","Villagers meet at Aaron's lively market to buy and sell goods, including land.","M"),
                                      new Location("Wheat Fields","The field is white, all ready to harvest. Literally.","W"),
                                      new Location("River","This river, at the edge of Aaron, divides the lands north and south.","R")
                                      },
                                     //row5
                                     {new Location("Undeveloped Land","Behold the vast expanse of untouched wilderness.","U"),
                                      new Location("Wheat Fields","The field is white, all ready to harvest. Literally.","W"),
                                      new Location("Wheat Fields","The field is white, all ready to harvest. Literally.","W"),
                                      new Location("River","This river, at the edge of Aaron, divides the lands north and south.","R"),
                                      new Location("Border of Lamanite Land","This is the border of the Lamanite land. YOU SHALL NOT PASS!","L")
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
