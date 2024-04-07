/*
Name: Michael Lawson
Class: CSC400 Data Structures
Project Name: Portfolio Project

Project Purpose: Create a program for handling an order queue.

Algorithms Used:
	- Linked Queue implemented with a Queue Interface.  Uses a custom exception for empty queue: EmptyQueueException.
	- Order system operates a OrderDetails linked queue and updates Display class containing printable arrays.
	- Main method drives program and uses methods from Menu class for user interface through the console.

Program Inputs: Keyboard inputs through Scanner object

Program Outputs: Console

Program Limits: Cannot remove orders that are not at top of queue.

Program Errors: None.
*/
package main;

import java.util.InputMismatchException;
import java.util.Scanner;

import ui.Menu;


/**Main class handles menu and drives program.
 * @author Michael Lawson
 */
public class Main
{
	// Static variables allow for easy use across main static methods.
	private static Order orderQueue;
	private static Menu main;
	
	/**Route menu input to appropriate function.
	 * O(n^2)
	 * @param choice
	 * @return true to start menu, false to exit program.
	 */
	private static boolean action(int choice)
	{
		// Unless user enters a zero at main menu, program should run again.
		boolean again = true;
		
		// Use switch to determine which action to take.
		switch(choice)
		{
		case 0: // Exit
			again = false;
			break;
		case 1: // Create a new order
			addOrder(new Scanner(System.in));
			break;
		case 2: // Remove next order
			orderQueue.fill();
			break;
		case 3: // Display orders
			orderQueue.display();
			break;
		default:
			System.out.println("Invalid option!");
		}
		
		// Allow user to see action and result before next iteration.
		if(again)
			main.pause();
		
		// true to start menu, false to exit prgram.
		return again;
	}
	
	/**Collect information to add an order to queue.
	 * O(n^2)
	 * @param in is the scanner object for keyboard input.
	 */
	private static void addOrder(Scanner in)
	{
		Double cost = 0.0; // initialize cost to zero
		System.out.print("Enter customer name: ");
		String name = in.next(); // initialize name to input
		
		// Keep trying to get cost until entered properly
		while(true)
		{
			try
			{
				System.out.print("Enter order cost: $");
				cost = in.nextDouble();
				break;
			}
			catch(InputMismatchException ime) // User did not enter a valid number
			{
				System.out.println("Cost must be a numeric value! Please try again.");
				in.nextLine();
			}
		}
		System.out.println();
		
		// add order to queue
		orderQueue.add(name, cost);
	}
	
	/**Main method drives program
	 * @param args
	 */
	public static void main(String[] args) {
		boolean again = true;
		
		initialize();
		while(again)
		{
			main.display();
			int choice = main.select(new Scanner(System.in));
			again = action(choice);
		}
	}
	
	/**Initialize static objects and populate menu options.
	 * O(1)
	 */
	private static void initialize()
	{
		orderQueue = new Order();
		main = new Menu(72, "Lawson Ordering Queue");
		
		main.add("Create a new order");
		main.add("Remove next order");
		main.add("Display all orders");
	}
}