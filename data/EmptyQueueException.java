/*
Name: Michael Lawson
Class: CSC400 Data Structures
File: EmptyQueueException.java

Custom exception used by the LinkedQueue.

*/
package data;

/**Custom exception used in LinkedQueue when attempting to manipulate empty queue.
 * @author Michael Lawson
 */
public class EmptyQueueException extends RuntimeException
{
	@java.io.Serial
	private static final long serialVersionUID = 5862268367351125352L;
	
	// constructor calls RuntimeException with custom message
	public EmptyQueueException()
	{
		super("The queue is empty!");
	}
}
