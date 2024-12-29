# Parcel Depot Management System

The **Parcel Depot Management System** is a Java-based application designed to streamline the process of managing parcel deliveries at a depot. It allows a worker to process customers who are collecting their parcels, calculate fees, and log events for later review. This system utilizes various classes such as `Parcel`, `Customer`, `QueueOfCustomers`, `ParcelMap`, `Log`, and `Worker` to handle tasks efficiently.

## Description
This system simulates a depot worker processing customers in a queue to collect their parcels. The system supports:
- Managing a queue of customers.
- Calculating fees based on parcel attributes.
- Logging all events, including customer arrivals, parcel collection, and fee calculations.
- A GUI interface for viewing the current queue, unprocessed parcels, and worker’s current task.

## Features
- **Queue Management**: The system allows customers to be added and removed from the queue, ensuring that the processing happens in an orderly manner.
- **Fee Calculation**: The worker calculates fees based on predefined criteria for each parcel.
- **Event Logging**: All actions, such as adding/removing customers and processing parcels, are logged in a file for tracking purposes.
- **Graphical User Interface (GUI)**: The system provides a visual interface that displays the queue of customers, parcels awaiting processing, and details of the current parcel being handled.

## Installation

### Prerequisites
- Java 11 or higher is required to run the system.
