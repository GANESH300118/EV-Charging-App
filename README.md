# EV-Charging-App


This is a simple Java application that helps users find electric vehicle (EV) charging stations based on filters like location and charger type. It also allows users to book charging slots in advance.

## Table of Contents
- [Features](#features)
- [How It Works](#how-it-works)
- [Installation](#installation)
- [Usage](#usage)
- [Sample Input and Output](#sample-input-and-output)
- [Future Improvements](#future-improvements)

## Features
- Search and filter EV charging stations based on location and charger type.
- Display detailed information about available charging stations.
- Book a charging slot at a selected station.
- User-friendly interface with console-based interaction.

## How It Works
1. **User Input**: The user is prompted to enter the preferred location and charger type.
2. **Station Filtering**: The program filters charging stations based on the user's criteria.
3. **Station Selection**: The user selects a station from the list of available options.
4. **Slot Booking**: The user can book an available slot at the chosen station.
5. **Confirmation**: The program confirms if the booking was successful.

## Installation
1. Ensure that you have [Java JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) installed on your machine.
2. Clone this repository or download the source code:
   ```bash
   git clone https://github.com/your-username/ev-charging-booking.git
   ```
3. Navigate to the project directory:
   ```bash
   cd ev-charging-booking
   ```
4. Compile the Java files:
   ```bash
   javac EVChargingApp.java
   ```
5. Run the application:
   ```bash
   java EVChargingApp
   ```

## Usage
1. The program will prompt you to enter a preferred location and charger type.
2. It will display a list of available charging stations that match your criteria.
3. You can select a station and choose an available time slot to book.
4. The program will confirm if the slot was successfully booked.

## Sample Input and Output

**Example Input:**
```
Enter your preferred location: Downtown
Enter your preferred charger type (e.g., Fast Charger, Standard Charger): Fast Charger
```

**Example Output:**
```
Available Stations:
1. Station A at Downtown

Select a station to book a slot (enter the number): 1

Station Name: Station A
Location: Downtown
Charger Type: Fast Charger
Available Slots: 3

Booking a slot at Station A...

Available Slots:
1. 9:00 AM - 10:00 AM
2. 10:00 AM - 11:00 AM
3. 11:00 AM - 12:00 PM

Select a slot to book (enter the number): 2

Slot booked successfully for 10:00 AM - 11:00 AM
```

## Future Improvements
- Add user authentication for personalized booking history.
- Include payment gateway integration for booking slots.
- Enhance the filtering criteria (e.g., price range, charger speed).
- Implement real-time slot availability updates.
- Expand to a GUI-based application for a better user experience.
