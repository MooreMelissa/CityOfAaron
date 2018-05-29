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
public class Location implements Serializable {

	private String name;
	private String description;
	private String mapSymbol;
	private String[] gameTips = {"One person can't care for more than 10 acres of wheat.",
		"Each person consumes about 20 bushels of wheat per year.",
		"Each acres requires one bushel for planting."};

	public Location() {
		//Empty Constructor
	}

	public Location(String name, String description, String mapSymbol) {
		this.name = name;
		this.description = description;
		this.mapSymbol = mapSymbol;
	}

	//Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMapSymbol() {
		return mapSymbol;
	}

	public void setMapSymbol(String mapSymbol) {
		this.mapSymbol = mapSymbol;
	}

	public String[] getGameTips() {
		return gameTips;
	}

	public void setGameTips(String[] gameTips) {
		this.gameTips = gameTips;
	}

	@Override
	public String toString() {
		return "Location{"
				+ "name=" + name
				+ " description=" + description
				+ " mapSymbol=" + mapSymbol
				+ '}';
	}
}
