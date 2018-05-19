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

            
          Animal theInventoryItem = new Animal();
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
          
          System.out.println(theProvisionItem.toString());
		  
		           
          
         Point thePoint = new Point(3,2);
         
         System.out.println(thePoint.toString());
         
         
         Location theLocation = new Location();
         theLocation.setName("Wheat Fields");
         theLocation.setDescription("The field is white, all ready to harvest. Literally.");
         theLocation.setMapSymbol("W");
         
         System.out.println(theLocation.toString());
         
         String[] tip = theLocation.getGameTips();
         System.out.println("gameTip=" + tip[0]);
         
         Map theMap = new Map();
         Location[][] loc = theMap.getLocations();
         System.out.println("loc=" + loc[0][1]);
         
         Storehouse theStorehouse = new Storehouse();
          Author[] aut = theStorehouse.getAuthors();
         System.out.println("author=" + aut[0]);
         InventoryItem[] ani = theStorehouse.getAnimals();
         System.out.println("animal=" + ani[2]);
         InventoryItem[] too = theStorehouse.getTools();
         System.out.println("tools=" + too[1]);
         InventoryItem[] pro = theStorehouse.getTools();
         System.out.println("provisions=" + pro[0]);
         
	}
	
}
