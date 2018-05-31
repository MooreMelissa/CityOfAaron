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

   

    /**
     * Test of plantCrops method, of class GameControl.
     */
    @Test
    public void testPlantCrops() {
        System.out.println("plantCrops");
        int acresToPlant = 0;
        int acresOwned = 0;
        int currentPopulation = 0;
        int wheatInStorage = 0;
        int expResult = 0;
        int result = GameControl.plantCrops(acresToPlant, acresOwned, currentPopulation, wheatInStorage);
        assertEquals(expResult, result);
        
    }

    @Test
    public void testPlantCrops1(){
        int result = GameControl.plantCrops(800, 1000, 100, 2700);
        assertEquals(2300, result);
    }
    
    @Test
    public void testPlantCrops2(){
        int result = GameControl.plantCrops(-100, 1000, 100, 2700);
        assertEquals(-1, result);
    }
    @Test
    public void testPlantCrops3(){
        int result = GameControl.plantCrops(1100, 1000, 100, 2700);
        assertEquals(-2, result);
    }
    @Test
    public void testPlantCrops4(){
        int result = GameControl.plantCrops(1000, 1000, 80, 2700);
        assertEquals(-3, result);
    }
    @Test
    public void testPlantCrops5(){
        int result = GameControl.plantCrops(1000, 1000, 100, 400);
        assertEquals(-4, result);
    }
    @Test
    public void testPlantCrops6(){
        int result = GameControl.plantCrops(0, 1000, 100, 2700);
        assertEquals(2700, result);
    }
    @Test
    public void testPlantCrops7(){
        int result = GameControl.plantCrops(1000, 1000, 100, 2700);
        assertEquals(2200, result);
    }
    @Test
    public void testPlantCrops8(){
        int result = GameControl.plantCrops(500, 1000, 50, 2700);
        assertEquals(2450, result);
    }
    @Test
    public void testPlantCrops9(){
        int result = GameControl.plantCrops(1000, 1000, 100, 500);
        assertEquals(0, result);
    }
    @Test
    public void testPlantCrops10(){
        int result = GameControl.plantCrops(10, 10, 100, 2700);
        assertEquals(2695, result);
    }
}
