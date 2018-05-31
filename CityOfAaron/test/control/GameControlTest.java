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
	 * Test of buyLand method, of class GameControl.
	 */
	/*@Test
	public void testBuyLand() {
		System.out.println("buyLand");
		int acresToBuy = 0;
		int randomPrice = 0;
		int wheatInStorage = 0;
		int acresOwned = 0;
		int expResult = 0;
		int result = GameControl.buyLand(acresToBuy, randomPrice, wheatInStorage, acresOwned);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}*/
	
	@Test
	public void testBuyLand1() {
		int result = GameControl.buyLand(10, 20, 2700, 1000);
		assertEquals(1010, result);
	}
	
	@Test
	public void testBuyLand2() {
		int result = GameControl.buyLand(-5, 20, 2700, 1000);
		assertEquals(-1, result);
	}
	
	@Test
	public void testBuyLand3() {
		int result = GameControl.buyLand(200, 20, 2700, 1000);
		assertEquals(-1, result);
	}
	
	@Test
	public void testBuyLand4() {
		int result = GameControl.buyLand(0, 17, 2700, 1000);
		assertEquals(1000, result);
	}
	
	@Test
	public void testBuyLand5() {
		int result = GameControl.buyLand(30, 17, 2700, 1000);
		assertEquals(1030, result);
	}
	
	@Test
	public void testBuyLand6() {
		int result = GameControl.buyLand(100, 27, 2700, 1000);
		assertEquals(1100, result);
	}
	
}
