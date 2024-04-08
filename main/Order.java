package main;

import model.EmptyQueueException;
import model.LinkedQueue;

/**Order class contains queue of orders and methods to interact with queue.
 * @author Michael Lawson
 */
public class Order
{
	// Stores Linked Queue containing orders, the next order number
	private LinkedQueue<OrderDetails> orderQueue;
	private int nextOrderNumber;
	private Display myQueue;
	
	/**Default constructor initializes attributes.
	 * O(1)
	 */
	public Order()
	{
		orderQueue = new LinkedQueue<>();
		nextOrderNumber = 1;
		myQueue = new Display();
	}
	
	/**Add order to queue.
	 * O(n^2) because of updateDisplay() call.
	 * @param name : String. Customer's last name
	 * @param cost : double. Cost of the order
	 */
	public void add(String name, double cost)
	{
		// Create an OrderDetails object to insert into the queue
		OrderDetails deets = new OrderDetails(name, nextOrderNumber, cost);
		
		// Add order to the queue
		orderQueue.enqueue(deets);
		alertUser("Adding order", deets);
		
		// increment the next order number
		nextOrderNumber++;
		
		// Display the queue
		updateDisplay();
	}
	
	/**Fill top order in queue.
	 * O(n^2) because of updateDisplay() call.
	 * @return Order that was completed.
	 */
	public OrderDetails fill()
	{
		OrderDetails deets = null;
		try
		{
			// dequeue order
			deets = orderQueue.dequeue();
			alertUser("Removing order", deets);
			
			// update Display
			updateDisplay();
		}
		catch(EmptyQueueException eqe)
		{
			System.out.println(eqe.getMessage());
		}
		
		// Return the order that was filled
		return deets;
	}
	
	/**Print queue to console
	 * O(n)
	 */
	public void display()
	{
		myQueue.printArray();
	}
	
	/**Update Display object.
	 * O(n^2) because of quicksort algorithm call.
	 */
	private void updateDisplay()
	{
		int size = orderQueue.getSize();
		myQueue.update(orderQueue.toArray(), size);
	}
	
	/**Inform user of msg about item
	 * O(1)
	 * @param msg : String. Message to print in console.
	 * @param item : OrderDetails. Order that the message pertains to.
	 */
	private void alertUser(String msg, OrderDetails item)
	{
		System.out.println(msg + ": " + item.toString());
	}
}
