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
public class Point implements Serializable {
    
    private int row;
    private int column;
    
    public Point(){
        //Empty constructor for JavaBeans
    }

    //Convenience constructor
    public Point(int row, int column) {
        setRow(row);
        setColumn(column);
    }
    
    //Getters and Setters
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
    
    @Override
    public String toString() {
        return "Point{"
                + "row=" + row
                + ", column=" + column
                + '}';
    }
}
