/*
Name: Michael Lawson
Class: CSC400 Data Structures
Project Name: Portfolio Project

LinkedQueue data structure

*/
package data;

/**LinkedQueue implements a Linked Object implementation of the QueueInterface
 * @author Michael Lawson
 * @reference Carrano, F. & Henry, T. (2019). Data structures and abstractions with Java (5th ed.).
 * @param <T>
 */
public class LinkedQueue<T> implements QueueInterface<T>
{
	private Node firstNode; // first node in the queue
	private Node lastNode; // last node in the queue
	private int size; // number of objects in the queue
	
	/**Constructor initializes attributes.
	 */
	public LinkedQueue()
	{
		firstNode = null;
		lastNode = null;
		size = 0;
	}
	
	/**Method is used to add elements to the queue.
	 * @param newEntry  Object that is added to the queue.
	 */
	@Override
	public void enqueue(T newEntry)
	{
		Node newNode = new Node(newEntry, null);
		if(isEmpty())
			firstNode = newNode;
		else
			lastNode.setNextNode(newNode);
		lastNode = newNode;
		size++;
	}

	/**Remove top object from queue.
	 * @return top object
	 */
	@Override
	public T dequeue()
	{
		T front = getFront();
		firstNode.setData(null);
		firstNode = firstNode.getNextNode();
		if(firstNode == null)
			lastNode = null;
		size--;
		return front;
	}

	/**Show next object in queue.
	 * @return top object
	 */
	@Override
	public T getFront()
	{
		if(isEmpty())
			throw new EmptyQueueException();
		else
			return firstNode.getData();
	}
	
	/**Determine if queue is empty.
	 * @return True if queue is empty
	 */
	@Override
	public boolean isEmpty()
	{
		return (firstNode == null) && (lastNode == null);
	}

	/**Clears all objects in queue.
	 */
	@Override
	public void clear()
	{
		firstNode = null;
		lastNode = null;
	}
	
	/**Convert the queue to an array.
	 * @return queue as an array
	 */
	public T[] toArray()
	{
		@SuppressWarnings("unchecked")
		T[] arr = (T[])new Object[size];
		
		Node currentNode = firstNode;
		int i = 0;
		while((i < size) && (currentNode != null))
		{
			arr[i] = currentNode.data;
			i++;
			currentNode = currentNode.next;
		}
		return arr;
	}
	
	/**Get the size of the queue.
	 * @return size of linked queue as an integer
	 */
	public int getSize()
	{
		return size;
	}
	
	// Node class holds data in stack and points to next Node in stack
	private class Node {
		private T data; // Holds data associated with the node
		private Node next; // Pointer to next node in stack
		
		// Constructor assigns data to Node; first node points to null as next
		private Node(T dataPortion) {
			this(dataPortion, null);
		}
		
		// Constructor assigns data to Node; next node assigned to next
		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		}
		
		// Returns data stored in this Node
		private T getData() {
			return data;
		}
		
		// Returns the next node
		private Node getNextNode() {
			return next;
		}
		
		// Changes data associated with Node
		private void setData(T newData) {
			data = newData;
		}
		
		// Changes the next node
		private void setNextNode(Node nextNode) {
			next = nextNode;
		}
	} // ends Node
} // ends LinkedQueue
