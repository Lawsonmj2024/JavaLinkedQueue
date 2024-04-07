
package ui;

import java.util.InputMismatchException;
import java.util.Scanner;

/**Handles menu creation and operation
 * @author Michael Lawson
 */
public class Menu
{
	// Class Members
	private String[] mOptions; //
	private int mMax;
	private int mSize;
	private int mConsoleWidth;
	private String mTitle;
	
	public Menu(int w, String t)
	{
		mConsoleWidth = w;
		mTitle = t;
		mSize = 0;
		mMax = 10;
		mOptions = new String[mMax];
		add("Exit");
	}
	
	/**Adds an option to the menu
	 * O(n)
	 * @param msg : String. Option name.
	 */
	public void add(String msg)
	{
		if(mSize < mOptions.length)
		{
			mOptions[mSize] = "["+mSize+"] "+msg;
			mSize++;
		}
		else
		{
			mMax += 10;
			String[] temp = new String[mMax];
			
			for(int i = 0; i < mSize; i++)
				temp[i] = mOptions[i];
			
			mOptions = temp;
			add(msg);
		}
	}
	
	/**Removes an option from the menu
	 * O(n)
	 * @param index : int. Option number to be removed.
	 */
	public void remove(int index)
	{
		for(int i = index; i < mSize - 1; i++)
			mOptions[i] = mOptions[i + 1];
		mSize --;
	}
	
	/**Prints the title of the program
	 * O(1)
	 */
	private void title()
	{
		String spacedTitle = " ".repeat(3) + mTitle + " ".repeat(3);
		System.out.println("_".repeat(mConsoleWidth));
		System.out.println();
		
		head(spacedTitle, "<", ">");
		System.out.println("_".repeat(mConsoleWidth));
		System.out.println();
	}
	
	/**Prints the menu containing options for user.
	 * O(1)
	 */
	public void display()
	{
		title();
		for(int i = 1; i < mSize; i++)
			System.out.println(mOptions[i]);
		System.out.println();
		System.out.println(mOptions[0]);
		head("", "-");
	}
	
	/**Get menu choice from user
	 * O(n)
	 * @param in is a scanner object for keyboard input
	 * @return users selection as an integer
	 */
	public int select(Scanner in)
	{
		int choice = -1;
		for(int i = 0; i < 5; i++)
		{
			try
			{
				System.out.print("Select an option: ");
				choice = in.nextInt();
				if(choice < 0 || choice >= mSize)
					throw new InputMismatchException();
				break;
			}
			catch(InputMismatchException ime)
			{
				System.out.println("Invalid option, please enter the number in the square bracket.");
				in.nextLine();
			}
		}
		String subTitle = mOptions[choice].substring(mOptions[choice].indexOf("]") + 1) + " ";
		head(subTitle, "-");
		return choice;
	}
	
	/**Prints a divider
	 * O(1)
	 * @param msg message to display at center of divider
	 * @param line to represent the divide
	 */
	public void head(String msg, String line)
	{
		head(msg, line, line);
	}
	
	/**Prints a divider with a different left and right line
	 * O(1)
	 * @param msg message to display at center of divider
	 * @param lineLeft to represent the divide on the left
	 * @param lineRight to represent the divide on the right
	 */
	private void head(String msg, String lineLeft, String lineRight)
	{
		int width = mConsoleWidth;
		lineLeft = lineLeft.substring(0, 1);
		lineRight = lineRight.substring(0, 1);
		
		int left = (width - msg.length()) / 2;
		int right = width - (msg.length() + left);
		
		System.out.println(lineLeft.repeat(left) + msg + lineRight.repeat(right));
	}
	
	/**Passes a scanner object to the pause function
	 * O(1)
	 */
	public void pause()
	{
		pause(new Scanner(System.in));
	}
	
	/**Pauses the program until user presses enter
	 * O(1)
	 */
	private void pause(Scanner in)
	{
		System.out.print("Press Enter to continue");
		try
		{
			System.in.read();
		}
		catch(Exception e) {}
		in.nextLine();
	}
}
