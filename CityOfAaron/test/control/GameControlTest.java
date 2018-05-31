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
	 * Test of plantCrops method, of class GameControl.
	 */
	
	
        @Test
	public void testPlantCrops1() {
                System.out.println("testPlantCrops1");
		int result = GameControl.plantCrops(800, 1000, 100, 2700);
		assertEquals(400, result);
                System.out.println(result);
	}
        
        @Test
	public void testPlantCrops2() {
                System.out.println("testPlantCrops2");
		int result = GameControl.plantCrops(-100, 1000, 100, 2700);
		assertEquals(-1, result);
                System.out.println(result);
	}
        
        @Test
	public void testPlantCrops3() {
                System.out.println("testPlantCrops3");
		int result = GameControl.plantCrops(1100, 1000, 100, 2700);
		assertEquals(-2, result);
                System.out.println(result);
	}
        
        @Test
	public void testPlantCrops4() {
                System.out.println("testPlantCrops4");
		int result = GameControl.plantCrops(1000, 1000, 80, 2700);
		assertEquals(-3, result);
                System.out.println(result);
	}
        
        @Test
	public void testPlantCrops5() {
                System.out.println("testPlantCrops5");
		int result = GameControl.plantCrops(1000, 1000, 100, 400);
		assertEquals(-4, result);
                System.out.println(result);
	}
        
        @Test
	public void testPlantCrops6() {
                System.out.println("testPlantCrops6");
		int result = GameControl.plantCrops(0, 1000, 100, 2700);
		assertEquals(0, result);
                System.out.println(result);
	}
        
        @Test
	public void testPlantCrops7() {
                System.out.println("testPlantCrops7");
		int result = GameControl.plantCrops(1000, 1000, 100, 2700);
		assertEquals(500, result);
                System.out.println(result);
	}
        
        @Test
	public void testPlantCrops8() {
                System.out.println("testPlantCrops8");
		int result = GameControl.plantCrops(500, 1000, 50, 2700);
		assertEquals(250, result);
                System.out.println(result);
	}
        
        @Test
	public void testPlantCrops9() {
                System.out.println("testPlantCrops9");
		int result = GameControl.plantCrops(1000, 1000, 100, 500);
		assertEquals(500, result);
                System.out.println(result);
	}
        
        @Test
	public void testPlantCrops10() {
                System.out.println("testPlantCrops10");
		int result = GameControl.plantCrops(10, 10, 100, 2700);
		assertEquals(5, result);
                System.out.println(result);
	}
        
        /**
	 * Test of testFeedPeople method, of class GameControl.
	 */
        
        @Test
        public void testFeedPeople1() {
                System.out.println("testFeedPeople1");
		int result = GameControl.feedPeople(800, 2700);
		assertEquals(1900, result);
                System.out.println(result);
        }
        
        @Test
        public void testFeedPeople2() {
                System.out.println("testFeedPeople2");
		int result = GameControl.feedPeople(-100, 2700);
		assertEquals(-1, result);
                System.out.println(result);
        }
        
        @Test
        public void testFeedPeople3() {
                System.out.println("testFeedPeople3");
		int result = GameControl.feedPeople(2800, 2700);
		assertEquals(-2, result);
                System.out.println(result);
        }
        
        @Test
        public void testFeedPeople4() {
                System.out.println("testFeedPeople4");
		int result = GameControl.feedPeople(0, 2700);
		assertEquals(2700, result);
                System.out.println(result);
        }
        
        @Test
        public void testFeedPeople5() {
                System.out.println("testFeedPeople5");
		int result = GameControl.feedPeople(0, 0);
		assertEquals(0, result);
                System.out.println(result);
        }
        
        @Test
        public void testFeedPeople6() {
                System.out.println("testFeedPeople6");
		int result = GameControl.feedPeople(50, 50);
		assertEquals(0, result);
                System.out.println(result);
        }
        
        @Test
        public void testFeedPeople7() {
                System.out.println("testFeedPeople7");
		int result = GameControl.feedPeople(3500, 4000);
		assertEquals(500, result);
                System.out.println(result);
        }
        
         /**
	 * Test of testPopulationMortality method, of class GameControl.
	 */
        
        
        @Test
        public void testPopulationMortality1() {
                System.out.println("testPopulationMortality1");
		int result = GameControl.populationMortality(1500, 100);
		assertEquals(25, result);
                System.out.println(result);
        }
        
        @Test
        public void testPopulationMortality2() {
                System.out.println("testPopulationMortality2");
		int result = GameControl.populationMortality(-100, 100);
		assertEquals(-1, result);
                System.out.println(result);
        }
        
        @Test
        public void testPopulationMortality3() {
                System.out.println("testPopulationMortality3");
		int result = GameControl.populationMortality(2000, 100);
		assertEquals(0, result);
                System.out.println(result);
        }
        
        @Test
        public void testPopulationMortality4() {
                System.out.println("testPopulationMortality4");
		int result = GameControl.populationMortality(3000, 100);
		assertEquals(0, result);
                System.out.println(result);
        }
        
        @Test
        public void testPopulationMortality5() {
                System.out.println("testPopulationMortality5");
		int result = GameControl.populationMortality(900, 50);
		assertEquals(5, result);
                System.out.println(result);
        }
	
}
