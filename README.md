# Java Linked Queue

Michael Lawson
Colorado State University, Global
CSC400: Data Structures
Prof. Russell Frith
January 11, 2023

## Purpose
Write a program that handles the order list for an online retailer.

Program should contain a minimum of three classes:

- Order class,
- Display class,
- Main class.

### Order class

Order class uses a queue to hold the orders in the order they  were taken. The queue should contain the following:

- Customer last name,
- Order number,
- Order total cost.

### Display class

The display class will store a copy of the order queue in two arrays. Each array will contain the order list sorted as follows:

- One will be sorted by name,
- One will be sorted by order number.

When an order is taken and stored in the Order class, the program will:

0. Update the Display class arrays automatically,
0. Sort them in descending order using quick sort algorithm,
0. Output the contents to the console upon each entry of new data.

### Main class

The Main class will handle operator data input and update the Order class and Display class when an order is added or removed.

The user will be presented a menu for the following actions:

- Add an order,
- Remove an order,
- Display the order list from the queue.
