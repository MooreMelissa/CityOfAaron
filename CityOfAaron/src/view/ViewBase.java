

package view;

import java.util.Scanner;

/**
 *
 * @author JK
 */
public abstract class ViewBase implements View {

	/**
	 * Constructor
	 */
	public ViewBase() {
	}

	/**
	 * Get the views content. This will allow the view to have dynamic content
	 * (it can change each time the message is displayed).
	 */
	protected abstract String getMessage();

	/**
	 * Get the set of inputs from the user.
	 *
	 * @return
	 */
	protected abstract String[] getInputs();

	/**
	 * Perform the action indicated by the user's input.
	 * @param inputs
	 * @return true if the view should repeat itself, and false if the view
	 * should exit and return to the previous view.
	 */
	public abstract boolean doAction(String[] inputs);

	/**
	 * Control this views display/prompt/action loop until the user chooses an
	 * action that causes this view to close.
	 */
	public void displayView() {

		boolean keepGoing = true;

		while (keepGoing == true) {

			// get the message that should be displayed
			// Only print it if it is non-null
			String message = getMessage();
			if (message != null) {
				System.out.println(getMessage());
			}

			String[] inputs = getInputs();
			keepGoing = doAction(inputs);
		}
	}

	/**
	 * Get the user's input. Keep prompting them until they enter a value.
	 * @param prompt
	 * @param allowEmpty - determine whether the user can enter no value (just a
	 * return key)
	 * @return
	 */
	protected String getUserInput(String prompt, boolean allowEmpty) {

		Scanner keyboard = new Scanner(System.in);
		String input = "";
		boolean inputReceived = false;

		while (inputReceived == false) {

			System.out.println(prompt);
			input = keyboard.nextLine();

			// Make sure we avoid a null-pointer error.
			if (input == null) {
				input = "";
			}

			// Trim any trailing whitespace, including the carriage return.
			input = input.trim();

			if (input.equals("") == false || allowEmpty == true) {
				inputReceived = true;
			}
		}

		return input;
	}

	/**
	 * An overloaded version of getUserInput that sets allowEmpty to false so we
	 * don't have to type it ourselves.
	 * @param prompt
	 * @return
	 */
	protected String getUserInput(String prompt) {
		return getUserInput(prompt, false);
	}

	/**
	 * Pause the program for the specified number of milliseconds.
	 */
	protected static void pause(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException exception) {
			//do nothing
		}
	}

}
