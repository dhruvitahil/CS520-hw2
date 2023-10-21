 # hw1- Manual Review

The homework will be based on this project named "Expense Tracker",where users will be able to add/remove daily transaction. 

## Compile

To compile the code from terminal, use the following command:
```
cd src
javac ExpenseTrackerApp.java
java ExpenseTracker
```

You should be able to view the GUI of the project upon successful compilation. 

## Java Version
This code is compiled with ```openjdk 17.0.7 2023-04-18```. Please update your JDK accordingly if you face any incompatibility issue.

## New Functionality
We have added two filter buttons: Filter by Amount & Filter by Category
This functionality is used to filter the record present in the expensetracker table based on the user input.
It filters either based on category or amount at a given time.

We have also made changes to ensure data immutability, encapsulation and prevent external data modification.

- Filter by Amount
In this funstionality, the records that are lower than or equal to the filter amount given by the user are higlighted using the Light Green colour(173, 255, 168)

- Filter by Category
In this functionality, the records are filtered based on one of the following categories: food, travel, bills, entertainment and other. Based on the user's input, filtered records are higlighted using the Light Green colour(173, 255, 168).

## Commit Information

All the commits made to the repository with their timestamp can be found at: https://github.com/dhruvitahil/CS520-hw2

