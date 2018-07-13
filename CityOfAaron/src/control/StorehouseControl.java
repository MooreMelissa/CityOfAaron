/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.InventoryItem;

/**
 *
 * @author heatherholt
 */
public class StorehouseControl {

	public static InventoryItem[] sortAnimals(InventoryItem[] animals) {
		for (int a = 0; a < animals.length - 1; a++) {
			for (int b = a + 1; b < animals.length; b++) {
				if (animals[a].getName().compareTo(animals[b].getName()) > 0) {
					InventoryItem temp = animals[a];
					animals[a] = animals[b];
					animals[b] = temp;
				}
			}
		}
		return animals;
	}

	public static InventoryItem[] sortTools(InventoryItem[] tools) {
		for (int i = 0; i < tools.length - 1; i++) {
			for (int j = i + 1; j < tools.length; j++) {
				if (tools[i].getName().compareTo(tools[j].getName()) > 0) {
					InventoryItem temp = tools[i];
					tools[i] = tools[j];
					tools[j] = temp;
				}
			}
		}
		return tools;
	}

	public static InventoryItem[] sortProvisions(InventoryItem[] provisions) {
		for (int i = 0; i < provisions.length - 1; i++) {

			for (int j = i + 1; j < provisions.length; j++) {

				if (provisions[i].getCondition().compareTo(provisions[j].getCondition()) > 0) {
					InventoryItem temp = provisions[i];
					provisions[i] = provisions[j];
					provisions[j] = temp;

				}
			}
		}
		return provisions;
	}

}
