/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import model.Game;
import model.Player;
import model.Storehouse;
import model.Map;
import model.Point;
import model.Location;
import model.Author;
import model.InventoryItem;
import model.Animal;
import model.Provision;
import model.ItemType;
import model.Condition;
/**
 *
 * @author heatherholt
 */
public class CityOfAaron {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
            
            Game theGame = new Game();
            theGame.setThePlayer(new Player());
            theGame.setTheMap(new Map());
            theGame.setTheStorehouse(new Storehouse());
            theGame.setCurrentPopulation(105);
            theGame.setAcresOwned(2000);
            theGame.setWheatInStorage(15000);
            theGame.setCurrentYear(0);
            
            System.out.println(theGame.toString());

            
          /*Animal theInventoryItem = new Animal();
          theInventoryItem.setName("Tiger");
          theInventoryItem.setItemType(ItemType.Animal);
          theInventoryItem.setQuantity(1);
          theInventoryItem.setCondition(Condition.Good);
          theInventoryItem.setAge(10);
	
          System.out.println(theInventoryItem.toString());
          
          Provision theProvisionItem = new Provision();
          theProvisionItem.setName("Apple");
          theProvisionItem.setItemType(ItemType.Provisions);
          theProvisionItem.setQuantity(5);
          theProvisionItem.setCondition(Condition.Good);
          theProvisionItem.setPerishable(true);
          
          System.out.println(theProvisionItem.toString());*/
		  
		           
          
         Point thePoint = new Point(3,2);
         
         System.out.println(thePoint.toString());
         
         
         Location theLocation = new Location();
         theLocation.setName("name 1");
         theLocation.setDescription("description 1");
         theLocation.setMapSymbol("symbol 1");
         theLocation.setGameTips(args);
         
         System.out.println(theLocation.toString());

	}
	
}
