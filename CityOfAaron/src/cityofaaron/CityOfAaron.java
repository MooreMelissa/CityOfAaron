package cityofaaron;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
	private static PrintWriter output = null;
	private static BufferedReader input = null;
	private static PrintWriter logFile = null;

	public static Game getCurrentGame() {
		return currentGame;
	}

	public static void setCurrentGame(Game game) {
		currentGame = game;
	}

	public static PrintWriter getOutput() {
		return output;
	}

	public static void setOutput(PrintWriter output) {
		CityOfAaron.output = output;
	}

	public static BufferedReader getInput() {
		return input;
	}

	public static void setInput(BufferedReader input) {
		CityOfAaron.input = input;
	}

	public static PrintWriter getLogFile() {
		return logFile;
	}

	public static void setLogFile(PrintWriter logFile) {
		CityOfAaron.logFile = logFile;
	}

	
	
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		try {
			input = new BufferedReader(new InputStreamReader(System.in));
			output = new PrintWriter(System.out, true);
			logFile = new PrintWriter("logFile.txt");
			
			View startProgramView = new StartProgramView();
			startProgramView.displayView();
		} catch (Throwable te) {
			System.out.println("** " + te.getMessage() + " **"
					+ "\nDue to the above error, the program will now quit. "
					+ "Please restart the program.\n\n");
			te.printStackTrace();
			return;
		} finally {
			try {
				if (input != null)
					input.close();
				
				if (output != null)
					output.close();
				
				if (logFile != null) {
					logFile.close();
				}
			} catch (IOException ex) {
				System.console().printf("%s%s", "Error closing files");
				return;
			}
			
		}

	}

}
