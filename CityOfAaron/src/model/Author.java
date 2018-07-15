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
	public String skill;

	public Author() {
		//Empty constructor for JavaBeans
	}

	public Author(String name, String title, String skill) {
		this.name = name;
		this.title = title;
		this.skill = skill;
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

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	
	@Override
	public String toString() {
		return "\n" + name + " - "
				+ title;
	}

}
