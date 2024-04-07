/*
Name: Michael Lawson
Class: CSC400 Data Structures
Project Name: Portfolio Project



*/
package main;

/**Display class contains copies of order queue.
 * @author Michael Lawson
 */
public class Display
{
	private OrderDetails[] orderArray; // Sorted in descending order
	private OrderDetails[] orderArrayByName; // Sorted in descending order
	private int size;
	
	/**Default constructor initializes arrays to null and size to zero
	 */
	public Display()
	{
		size = 0;
		orderArray = null;
		orderArrayByName = null;
	}
	
	/**Replace current arrays with new array and sort
	 * O(n)
	 * @param arr is the new array.
	 * @param size is the size of the new array.
	 */
	public void update(Object[] arr, int n)
	{
		// Set size to new size and re-initialize arrays
		size = n;
		orderArray = new OrderDetails[size];
		orderArrayByName = new OrderDetails[size];
		
		// Copy contents of new array into arrays
		for(int i = 0; i < size; i++)
		{
			// copy in reverse order
			orderArray[size - 1 - i] = (OrderDetails)arr[i];
			
			// copy in order
			orderArrayByName[i] = (OrderDetails)arr[i];
		}
		// The array by number is already sorted.
		// Sort the array by name using quicksort algorithm
		quicksort(orderArrayByName, 0, size - 1);
		
		// Print the arrays
		printArray();
	}
	
	/**Prints contents of both arrays to console.
	 * O(n)
	 */
	public void printArray()
	{
		System.out.println();
		
		// Print array if size is greater than zero.
		if(size > 0)
		{
			// Center list headers
			printCentered("Orders by number", "Orders by name");
			printCentered("-".repeat(24), "-".repeat(24));
			
			// Print both arrays side by side
			for(int i = 0; i < size; i++)
			{
				printIndented(orderArray[i].toString(), orderArrayByName[i].toString());
			}
		}
		// If size is zero, inform user.
		else
			System.out.println("There are not any orders at this time.");
		
		System.out.println();
	}
	
	/**Indent list items beneath their headers
	 * O(1)
	 * @param msgLeft
	 * @param msgRight
	 */
	private void printIndented(String msgLeft, String msgRight)
	{
		int wsLeft = 9;
		int wsRight = 32 - msgLeft.length();
		
		System.out.println(" ".repeat(wsLeft) + msgLeft + " ".repeat(wsRight) + msgRight);
	}
	
	/**Print two messages indented 8 spaces from left.
	 * O(1)
	 * @param msgLeft
	 * @param msgRight
	 */
	private void printCentered(String msgLeft, String msgRight)
	{
		// Adjust left and right messages centered across 24 spaces
		String left  = center(msgLeft,  24);
		String right = center(msgRight, 24);
		
		// Print indented and spaced 8 spaces
		System.out.println(" ".repeat(8) + left + " ".repeat(8) + right);
	}
	
	/**Center a message across a specified width.
	 * O(1)
	 */
	private String center(String msg, int width)
	{
		// Find left and right indentations
		int wsLeft  = (width - msg.length()) / 2;
		int wsRight = width - (msg.length() + wsLeft);
		
		// Return indented and whitespaced message
		return (" ".repeat(wsLeft) + msg + " ".repeat(wsRight));
	}
	
	/**Quicksort algorithm locates a suitable pivot and swaps values that are higher
	 *   than pivot to right side and less than to left side. 
	 * O(n^2)
	 * @param arr is the Array to be sorted
	 * @param low is the lower bounds
	 * @param high is the upper bounds
	 */
	private void quicksort(OrderDetails[] arr, int low, int high)
	{
		if(low < high)
		{
			int pi = partition(arr, low, high);
			
			quicksort(arr, low, pi - 1);
			quicksort(arr, pi + 1, high);
		}
	}
	
	/**Partitions for quicksort algorithm.
	 * O(n^2)
	 * @param arr is array being sorted
	 * @param low is lower bounds of array
	 * @param high is upper bounds of array
	 * @return the pivot index
	 */
	private int partition(OrderDetails[] arr, int low, int high)
	{
		OrderDetails pivot = arr[high];
		int i = (low - 1);
		for(int j = low; j < high; j++)
		{
			if(arr[j].compareTo(pivot) > 0)
			{
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, high, i + 1);
		
		return (i + 1);
	}
	
	/**Swaps information between two array elements.
	 * O(1)
	 * @param arr is the array containing the elements needing swapped.
	 * @param i is the index of the first array element.
	 * @param j is the index of the second array element.
	 */
	private void swap(OrderDetails[] arr, int i, int j)
	{
		OrderDetails temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
