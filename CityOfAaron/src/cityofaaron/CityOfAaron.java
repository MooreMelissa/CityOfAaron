package cityofaaron;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import model.Game;
import view.View;
import view.StartProgramView;

/**
 *
 * @author heatherholt
 */
public class CityOfAaron {
	
	// Keep a copy of the current Game object in the main class.
	public static Game currentGame = null;
	
	public static Game getCurrentGame() {
		return currentGame;
	}
	
	public static void setCurrentGame (Game game) {
		currentGame = game;
	}
	
	

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		View startProgramView = new StartProgramView();
		startProgramView.displayView();


	}

}
