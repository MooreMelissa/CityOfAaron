/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import exception.GameControlException;
import org.junit.Assert;
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
	 */
	@Test
	public void testHarvestWheat1() throws GameControlException {
		int result = GameControl.harvestWheat(900, 15, 1, 2, 4);
		assertEquals(3600, result);
	}

	@Test
	public void testHarvestWheat2() {
		try {
			GameControl.harvestWheat(-500, 15, 1, 2, 4);
			Assert.fail("\nAcres to plant cannot be a negative number.");
		} catch (GameControlException gce) {
			System.out.println(gce.getMessage());
		}
		//int result = GameControl.harvestWheat(-500, 15, 1, 2, 4);
		//assertEquals(-1, result);
	}

	@Test
	public void testHarvestWheat3() {
		try {
			GameControl.harvestWheat(900, -5, 1, 2, 4);
			Assert.fail("\nThe percentage of tithing paid must be between 0 and 100.");
		} catch (GameControlException gce) {
			System.out.println(gce.getMessage());
		}
	}

	@Test
	public void testHarvestWheat4() {
		try {
			GameControl.harvestWheat(900, 115, 1, 2, 4);
			Assert.fail("\nThe percentage of tithing paid must be between 0 and 100.");
		} catch (GameControlException gce) {
			System.out.println(gce.getMessage());
		}
	}

	@Test
	public void testHarvestWheat5() throws GameControlException {
		int result = GameControl.harvestWheat(0, 15, 1, 2, 2);
		assertEquals(0, result);
	}

	@Test
	public void testHarvestWheat6() throws GameControlException {
		int result = GameControl.harvestWheat(900, 0, 2, 3, 3);
		assertEquals(1800, result);
	}

	@Test
	public void testHarvestWheat7() throws GameControlException {
		int result = GameControl.harvestWheat(900, 100, 3, 4, 5);
		assertEquals(4500, result);
	}

	@Test
	public void testHarvestWheat8() throws GameControlException {
		int result = GameControl.harvestWheat(900, 7, 1, 2, 2);
		assertEquals(900, result);
	}

	@Test
	public void testHarvestWheat9() throws GameControlException {
		int result = GameControl.harvestWheat(900, 13, 3, 4, 5);
		assertEquals(4500, result);
	}

	/**
	 * Test of buyLand method, of class GameControl.
	 */
	@Test
	public void testBuyLand1() throws GameControlException {
		int result = GameControl.buyLand(10, 20, 2700);
		assertEquals(200, result);
	}

	@Test
	public void testBuyLand2() {
		try {
			GameControl.buyLand(-5, 20, 2700);
			Assert.fail("\nNumber of acres to buy cannot be a negative number.");
		} catch (GameControlException gce) {
			System.out.println(gce.getMessage());
		}
	}

	@Test
	public void testBuyLand3() {
		try {
			GameControl.buyLand(200, 20, 2700);
			Assert.fail("\nThe cost of the number of acres you"
                    + " want to buy is more than the total wheat in storage.");
		} catch (GameControlException gce) {
			System.out.println(gce.getMessage());
		}
	}

	@Test
	public void testBuyLand4() throws GameControlException {
		int result = GameControl.buyLand(0, 17, 2700);
		assertEquals(0, result);
	}

	@Test
	public void testBuyLand5() throws GameControlException {
		int result = GameControl.buyLand(30, 17, 2700);
		assertEquals(510, result);
	}

	@Test
	public void testBuyLand6() throws GameControlException {
		int result = GameControl.buyLand(100, 27, 2700);
		assertEquals(2700, result);
	}

	/**
	 * Test of sellLand method, of class GameControl.
	 */
	@Test
	public void testSellLand1() throws GameControlException {
		int result = GameControl.sellLand(50, 22, 1000);
		assertEquals(1100, result);
	}

	@Test
	public void testSellLand2() {
		try {
			GameControl.sellLand(-75, 22, 1000);
			Assert.fail("\nNumber of acres to sell cannot be a negative number.");
		} catch (GameControlException gce) {
			System.out.println(gce.getMessage());
		}
	}

	@Test
	public void testSellLand3() {
		try {
			GameControl.sellLand(1100, 22, 1000);
			Assert.fail("\nThe number of acres you want to sell"
                    + " cannot be more than the number of acres you own.");
		} catch (GameControlException gce) {
			System.out.println(gce.getMessage());
		}
	}

	@Test
	public void testSellLand4() throws GameControlException {
		int result = GameControl.sellLand(0, 17, 1000);
		assertEquals(0, result);
	}

	@Test
	public void testSellLand5() throws GameControlException {
		int result = GameControl.sellLand(1000, 17, 1000);
		assertEquals(17000, result);
	}

	@Test
	public void testSellLand6() throws GameControlException {
		int result = GameControl.sellLand(0, 27, 1000);
		assertEquals(0, result);
	}

	@Test
	public void testSellLand7() throws GameControlException {
		int result = GameControl.sellLand(1000, 27, 1000);
		assertEquals(27000, result);
	}

	/**
	 * Test of plantCrops method, of class GameControl.
	 */
	@Test
	public void testPlantCrops1() throws GameControlException {
		System.out.println("testPlantCrops1");
		int result = GameControl.plantCrops(800, 1000, 100, 2700);
		assertEquals(400, result);
		System.out.println(result);
	}

	@Test
	public void testPlantCrops2() {
		System.out.println("testPlantCrops2");
		try {
			GameControl.plantCrops(-100, 1000, 100, 2700);
			Assert.fail("\n** Invalid Input **\n"
                    + "Number of acres of land to plant"
                    + " cannot be a negative number."
                    + "\nPlease try again");
		} catch (GameControlException gce) {
			System.out.println(gce.getMessage());
		}
	}

	@Test
	public void testPlantCrops3() {
		System.out.println("testPlantCrops3");
		try {
			GameControl.plantCrops(1100, 1000, 100, 2700);
			Assert.fail("\n** Invalid input **"
                    + "\nThe amount of acres entered is more than acres owned"
                    + "\nPlease try again");
		} catch (GameControlException gce) {
			System.out.println(gce.getMessage());
		}
	}

	@Test
	public void testPlantCrops4() {
		System.out.println("testPlantCrops4");
		try {
			GameControl.plantCrops(1000, 1000, 80, 2700);
			Assert.fail("\n** Invalid input **"
                    + "\nThe amount of acres entered is more than the "
                    + "current population can take care of"
                    + "\nPlease try again");
		} catch (GameControlException gce) {
			System.out.println(gce.getMessage());
		}
	}

	@Test
	public void testPlantCrops5() {
		System.out.println("testPlantCrops5");
		try {
			GameControl.plantCrops(1000, 1000, 100, 400);
			Assert.fail("\n** Invalid input **"
                    + "\nThe amount of acres entered is exceeded "
                    + "the wheat in storage"
                    + "\nPlease try again");
		} catch (GameControlException gce) {
			System.out.println(gce.getMessage());
		}
	}

	@Test
	public void testPlantCrops6()throws GameControlException {
		System.out.println("testPlantCrops6");
		int result = GameControl.plantCrops(0, 1000, 100, 2700);
		assertEquals(0, result);
		System.out.println(result);
	}

	@Test
	public void testPlantCrops7() throws GameControlException {
		System.out.println("testPlantCrops7");
		int result = GameControl.plantCrops(1000, 1000, 100, 2700);
		assertEquals(500, result);
		System.out.println(result);
	}

	@Test
	public void testPlantCrops8() throws GameControlException {
		System.out.println("testPlantCrops8");
		int result = GameControl.plantCrops(500, 1000, 50, 2700);
		assertEquals(250, result);
		System.out.println(result);
	}

	@Test
	public void testPlantCrops9() throws GameControlException {
		System.out.println("testPlantCrops9");
		int result = GameControl.plantCrops(1000, 1000, 100, 500);
		assertEquals(500, result);
		System.out.println(result);
	}

	@Test
	public void testPlantCrops10() throws GameControlException {
		System.out.println("testPlantCrops10");
		int result = GameControl.plantCrops(10, 10, 100, 2700);
		assertEquals(5, result);
		System.out.println(result);
	}

	/**
	 * Test of testFeedPeople method, of class GameControl.
	 */
	@Test
	public void testFeedPeople1() throws GameControlException {
		System.out.println("testFeedPeople1");
		int result = GameControl.feedPeople(800, 2700);
		assertEquals(800, result);
		System.out.println(result);
	}

	@Test
	public void testFeedPeople2() {
		System.out.println("testFeedPeople2");
		try {
			GameControl.feedPeople(-100, 2700);
			Assert.fail("\n** Invalid Input **\n"
                    + "Number of bushels to feed people"
                    + " cannot be a negative number."
                    + "\nPlease try again");
		} catch (GameControlException gce) {
			System.out.println(gce.getMessage());
		}
	}

	@Test
	public void testFeedPeople3() {
		System.out.println("testFeedPeople3");
		try {
			GameControl.feedPeople(2800, 2700);
			Assert.fail("\n** Invalid input **\n"
                    + "The amount of bushels entered is exceeded"
                    + " the wheat in storage."
                    + "\nPlease try again ");
		} catch (GameControlException gce) {
			System.out.println(gce.getMessage());
		}
	}

	@Test
	public void testFeedPeople4() throws GameControlException {
		System.out.println("testFeedPeople4");
		int result = GameControl.feedPeople(0, 2700);
		assertEquals(0, result);
		System.out.println(result);
	}

	@Test
	public void testFeedPeople5() throws GameControlException {
		System.out.println("testFeedPeople5");
		int result = GameControl.feedPeople(0, 0);
		assertEquals(0, result);
		System.out.println(result);
	}

	@Test
	public void testFeedPeople6() throws GameControlException {
		System.out.println("testFeedPeople6");
		int result = GameControl.feedPeople(50, 50);
		assertEquals(50, result);
		System.out.println(result);
	}

	@Test
	public void testFeedPeople7() throws GameControlException {
		System.out.println("testFeedPeople7");
		int result = GameControl.feedPeople(3500, 4000);
		assertEquals(3500, result);
		System.out.println(result);
	}

	/**
	 * Test of wheatEatenByRats method, of class GameControl.
	 */
	@Test
	public void testWheatEatenByRats1() throws GameControlException {
		int result = GameControl.wheatEatenByRats(15, 25, 8, 5, 4, 2700);
		assertEquals(108, result);
	}

	@Test
	public void testWheatEatenByRats2() {
		try {
			GameControl.wheatEatenByRats(-5, 25, 1, 2, 4, 2700);
			Assert.fail("\nThe percentage of tithing paid must be between 0 and 100.");
		} catch (GameControlException gce) {
			System.out.println(gce.getMessage());
		}
	}

	@Test
	public void testWheatEatenByRats3() {
		try {
			GameControl.wheatEatenByRats(115, 25, 1, 2, 4, 2700);
			Assert.fail("\nThe percentage of tithing paid must be between 0 and 100.");
		} catch (GameControlException gce) {
			System.out.println(gce.getMessage());
		}
	}

	@Test
	public void testWheatEatenByRats4() throws GameControlException {
		int result = GameControl.wheatEatenByRats(0, 25, 10, 7, 5, 2700);
		assertEquals(270, result);
	}

	@Test
	public void testWheatEatenByRats5() throws GameControlException {
		int result = GameControl.wheatEatenByRats(100, 25, 6, 3, 3, 2700);
		assertEquals(81, result);
	}

	@Test
	public void testWheatEatenByRats6() throws GameControlException {
		int result = GameControl.wheatEatenByRats(10, 25, 9, 6, 4, 2700);
		assertEquals(162, result);
	}

	@Test
	public void testWheatEatenByRats7() throws GameControlException {
		int result = GameControl.wheatEatenByRats(15, 1, 8, 5, 5, 2700);
		assertEquals(135, result);
	}

	@Test
	public void testWheatEatenByRats8() throws GameControlException {
		int result = GameControl.wheatEatenByRats(15, 100, 7, 4, 4, 2700);
		assertEquals(0, result);
	}

	/**
	 * Test of testPopulationMortality method, of class GameControl.
	 */
	@Test
	public void testPopulationMortality1() throws GameControlException {
		System.out.println("testPopulationMortality1");
		int result = GameControl.populationMortality(1500, 100);
		assertEquals(25, result);
		System.out.println(result);
	}

	@Test
	public void testPopulationMortality2() {
		System.out.println("testPopulationMortality2");
		try {
			GameControl.populationMortality(-100, 100);
			Assert.fail("\n** Invalid Input **\n"
                    + "Number of bushels to feed people"
                    + " cannot be a negative number."
                    + "\nPlease try again");
		} catch (GameControlException gce) {
			System.out.println(gce.getMessage());
		}
	}

	@Test
	public void testPopulationMortality3() throws GameControlException {
		System.out.println("testPopulationMortality3");
		int result = GameControl.populationMortality(2000, 100);
		assertEquals(0, result);
		System.out.println(result);
	}

	@Test
	public void testPopulationMortality4() throws GameControlException {
		System.out.println("testPopulationMortality4");
		int result = GameControl.populationMortality(3000, 100);
		assertEquals(0, result);
		System.out.println(result);
	}

	@Test
	public void testPopulationMortality5() throws GameControlException {
		System.out.println("testPopulationMortality5");
		int result = GameControl.populationMortality(900, 50);
		assertEquals(5, result);
		System.out.println(result);
	}

	/**
	 * Test of wheatOfferings method, of class GameControl
	 */
	@Test
	public void testWheatOfferings1() throws GameControlException {
		int result = GameControl.wheatOfferings(10, 2000);
		assertEquals(200, result);
	}

	@Test
	public void testWheatOfferings2() {
		try {
			GameControl.wheatOfferings(-10, 2000);
			Assert.fail("\nYou cannot offer less than 0% or more than 100%.");
		} catch (GameControlException gce) {
			System.out.println(gce.getMessage());
		}
	}

	@Test
	public void testWheatOfferings3() {
		try {
			GameControl.wheatOfferings(110, 2000);
			Assert.fail("\nYou cannot offer less than 0% or more than 100%.");
		} catch (GameControlException gce) {
			System.out.println(gce.getMessage());
		}
	}

	@Test
	public void testWheatOfferings4() throws GameControlException {
		int result = GameControl.wheatOfferings(0, 2000);
		assertEquals(0, result);
	}

	@Test
	public void testWheatOfferings5() throws GameControlException {
		int result = GameControl.wheatOfferings(100, 2000);
		assertEquals(2000, result);
	}

	/**
	 * Test of peopleMoveIn method, of class GameControl Because the only
	 * validation is on a random number, only one validity test is needed.
	 */
	@Test
	public void testPeopleMoveIn1() throws GameControlException {
		int result = GameControl.peopleMoveIn(5, 150);
		assertEquals(7, result); // Because of the explicit typecasting, any decimal is rounded DOWN to the nearest whole number.
	}

}
