# Java Linked Queue

Michael Lawson  
Colorado State University, Global  
CSC400: Data Structures  
Prof. Russell Frith  
January 11, 2023  

## Instructions
Write a program that handles the order list for an online retailer.

Program should contain a minimum of three classes:

- Order class,
- Display class,
- Main class.

### Order class

Order class uses a queue to hold the orders in the order they were taken. The queue should contain the following:

- Customer last name,
- Order number,
- Order total cost.

### Display class

The display class will store a copy of the order queue in two arrays. Each array will contain the order list sorted as follows:

- One will be sorted by name,
- One will be sorted by order number.

When an order is taken and stored in the Order class, the program will:

1. Update the Display class arrays automatically,
1. Sort them in descending order using quick sort algorithm,
1. Output the contents to the console upon each entry of new data.

### Main class

The Main class will handle operator data input and update the Order class and Display class when an order is added or removed.

The user will be presented a menu for the following actions:

- Add an order,
- Remove an order,
- Display the order list from the queue.

## Solution

Eight classes were organized into three packages:

- main
- model
- ui

The main package contains the Display, Order, and Main classes. To better partition the function of each class, an OrderDetails class is used to contain the order information, while the Order class functions as an abstraction for the LinkedQueue.

The model package contains the classes that form the data structure of the Order queue: LinkedQueue, QueueInterface, and EmptyQueueException. The program specifications call for a queue data structure, and a LinkedQueue was used because it provides the necessary functions to operate a queue and can contain all the order information in an object.

The ui package contains the Menu class. The Menu class contains some simple methods for the command line interface.