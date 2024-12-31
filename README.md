# JustJava Coffee Ordering App
JustJava is an Android application that provides a user-friendly interface for ordering coffee. Users can customize their coffee orders with add-ons like whipped cream and chocolate, specify the quantity, and submit the order via email.

## Table of Contents
- [Features](#features)
- [How It Works](#how_it_works)
- [Screenshots](#screenshots)
- [Code Structure](#code_structure)
- [Main Functionality](#main_functionality)
- [Layout](#layout)
- [Setup and Installation](#setup_and_installation)
- [Dependencies](#dependencies)
- [Contributing](#contributing)
- [License](#license)
- [Acknowledgments](#acknowledgements)

## Features
- Customizable Orders: Users can choose to add whipped cream and/or chocolate to their coffee.
- Quantity Adjustment: Users can increase or decrease the number of coffee cups to order.
- Order Summary: Displays the details of the order, including the customer's name, email, selected add-ons, quantity, and total price.
- Email Integration: Submits the coffee order via email using the user's preferred email app.
## How It Works
1. Enter Details:
Input your name and email address.
2. Customize Coffee:
Select add-ons like whipped cream and chocolate.
3. Set Quantity:
Use the increment (+) or decrement (-) buttons to select the desired number of coffee cups.
4. Submit Order:
Tap the "Order" button to review the order summary and send the order via email.

## Screenshots


## Code Structure
### Main Functionality
The primary logic resides in the MainActivity.java file:

- submitOrder(View view): Handles order submission and sends order details via email.
- calculatePrice(): Computes the total price based on the number of coffees and selected add-ons.
- createOrderSummary(...): Generates a detailed order summary.
- incrementValue(View view) & decrementValue(View view): Adjust the number of coffee cups to order.

### Layout
XML layout files are stored in the res/layout/ directory.<br>
Example: activity_main.xml contains the UI elements for the app's main screen.

## Setup and Installation
1. Clone or download the repository.
2. Open the project in Android Studio.
3. Build the project and resolve any dependencies.
4. Run the app on an emulator or connected Android device.

## Dependencies
- Android Support Libraries (e.g., appcompat-v7)
- Intent Integration: Used for sending emails via the device's email client.

## Contributing
Feel free to fork the repository, make changes, and submit a pull request. Suggestions and contributions are welcome!

## License
This project is licensed under the MIT License. See the LICENSE file for more details.

## Acknowledgments
This project was inspired by the Android Basics course and serves as a practice application to enhance Android development skills.

