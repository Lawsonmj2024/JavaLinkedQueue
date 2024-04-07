package main;

/**OrderDetails contains information about an order
 * @author Michael Lawson
 */
public class OrderDetails implements Comparable<OrderDetails>
{
	// Store customer last name, order number, and order cost
	private String lastName;
	private Integer orderNumber;
	private double orderCost;
	
	/**Parameterized constructor initializes object with defined values
	 * O(1)
	 * @param name is the last name of the customer
	 * @param number is the order number
	 * @param cost is the cost of the order
	 */
	public OrderDetails(String name, int number, double cost)
	{
		lastName = name;
		orderNumber = number;
		orderCost = cost;
	}
	
	/**Get the last name of the customer for this order.
	 * O(1)
	 * @return last name of the customer as a string
	 */
	public String getLastName()
	{
		return lastName;
	}
	
	/**Get the order number for this order.
	 * O(1)
	 * @return the order number as an integer
	 */
	public int getOrderNumber()
	{
		return orderNumber;
	}
	
	/**Get the cost of this order
	 * O(1)
	 * @return the cost of the order as a double
	 */
	public double getOrderCost()
	{
		return orderCost;
	}
	
	/**Convert object to a string
	 * O(1)
	 * @return Formatted string containing the order number, order cost, and customer last name.
	 */
	@Override
	public String toString()
	{
		String cost = String.format("%.2f", orderCost);
		String result = String.format("#%02d  %7s  %s", orderNumber, "$" + cost, lastName);
		return result;
	}
	
	/**Compares this object to another
	 * O(1)
	 * @return -1 if this is less than other, 0 if this is same as other, 1 if this is greater than other.
	 */
	@Override
	public int compareTo(OrderDetails o)
	{
		return lastName.compareTo(o.getLastName());
	}
}