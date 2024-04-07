/*
Name: Michael Lawson
Class: CSC400 Data Structures
Project Name: Portfolio Project

Interface for a linked queue.

*/
package data;

/**Contains blueprint for queue methods
 * @author Michael Lawson
 * @reference Carrano, F. & Henry, T. (2019). Data structures and abstractions with Java (5th ed.).
 */
public interface QueueInterface<T>
{
	/**Method is used to add elements to the queue.
	 * @param newEntry  Object that is added to the queue.
	 */
	public void enqueue(T newEntry);
	
	/**Remove top object from queue.
	 * @return top object
	 */
	public T dequeue();
	
	/**Show next object in queue.
	 * @return top object
	 */
	public T getFront();
	
	/**Determine if queue is empty.
	 * @return True if queue is empty
	 */
	public boolean isEmpty();
	
	/**Clears all objects in queue.
	 */
	public void clear();
}
