package control;

import model.Location;
import model.Map;
import exception.MapControlException;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author heatherholt
 */
public class MapControl {

	public static Map createMap(int noOfRows, int noOfColumns) throws MapControlException {

		if (noOfRows < 0 || noOfColumns < 0) {
			// return null;
			throw new MapControlException("\nMap is empty");
		}

		Map map = new Map();

		//Location[][] locations = map.getLocations();

		return map;
	}

	/* private static Location[][] createLocations(int rows, int columns, Map map) {

		if (rows < 1 || columns < 1) {
			return null;
		}

		Location[][] locations = map.getLocations();

		return locations;
	} */
}
