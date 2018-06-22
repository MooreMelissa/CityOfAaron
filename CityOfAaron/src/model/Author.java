/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author heatherholt
 */
public class Author implements Serializable {

	public String name;
	public String title;

	public Author() {
		//Empty constructor for JavaBeans
	}

	public Author(String name, String title) {
		this.name = name;
		this.title = title;
	}

	//Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "\n" + name + " - "
				+ title;
	}

}
