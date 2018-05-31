/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author heatherholt
 */
public class GameControlTest {
	
	public GameControlTest() {
	}

	/**
	 * Test of liveTheYear method, of class GameControl.
	 */


	/**
	 * Test of harvestWheat method, of class GameControl.
	 * harvestWheat(int acresToPlant, 
		int percentage, 
		int randomYieldLow, 
		int randomYieldMid, 
		int randomYieldHigh, 
		int wheatInStorage)
	 */
	
	@Test
	public void testHarvestWheat1() {
		int result = GameControl.harvestWheat(900, 15, 1, 2, 4);
		assertEquals(3600, result);
	}
	
	@Test
	public void testHarvestWheat2() {
		int result = GameControl.harvestWheat(-500, 15, 1, 2, 4);
		assertEquals(-1, result);
	}
	
	@Test
	public void testHarvestWheat3() {
		int result = GameControl.harvestWheat(900, -5, 1, 2, 4);
		assertEquals(-1, result);
	}
	
	@Test
	public void testHarvestWheat4() {
		int result = GameControl.harvestWheat(900, 115, 1, 2, 4);
		assertEquals(-1, result);
	}
	
	@Test
	public void testHarvestWheat5() {
		int result = GameControl.harvestWheat(0, 15, 1, 2, 2);
		assertEquals(0, result);
	}
	
	@Test
	public void testHarvestWheat6() {
		int result = GameControl.harvestWheat(900, 0, 2, 3, 3);
		assertEquals(1800, result);
	}
	
	@Test
	public void testHarvestWheat7() {
		int result = GameControl.harvestWheat(900, 100, 3, 4, 5);
		assertEquals(4500, result);
	}
	
	@Test
	public void testHarvestWheat8() {
		int result = GameControl.harvestWheat(900, 7, 1, 2, 2);
		assertEquals(900, result);
	}
	
	@Test
	public void testHarvestWheat9() {
		int result = GameControl.harvestWheat(900, 13, 3, 4, 5);
		assertEquals(4500, result);
	}
	
	
	/**
	 * Test of buyLand method, of class GameControl.
	 */
	
	@Test
	public void testBuyLand1() {
		int result = GameControl.buyLand(10, 20, 2700);
		assertEquals(200, result);
	}
	
	@Test
	public void testBuyLand2() {
		int result = GameControl.buyLand(-5, 20, 2700);
		assertEquals(-1, result);
	}
	
	@Test
	public void testBuyLand3() {
		int result = GameControl.buyLand(200, 20, 2700);
		assertEquals(-1, result);
	}
	
	@Test
	public void testBuyLand4() {
		int result = GameControl.buyLand(0, 17, 2700);
		assertEquals(0, result);
	}
	
	@Test
	public void testBuyLand5() {
		int result = GameControl.buyLand(30, 17, 2700);
		assertEquals(510, result);
	}
	
	@Test
	public void testBuyLand6() {
		int result = GameControl.buyLand(100, 27, 2700);
		assertEquals(2700, result);
	}
        
        /**
	 * Test of plantcrops method, of class GameControl.
	 */
	
	@Test
	public void testPlantCrops1() {
		int result = GameControl.plantCrops(800, 1000, 100, 2700);
		assertEquals(400, result);
	}
        
	
}
