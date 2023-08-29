package OnlineReservationSystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ReservationSystem {
    private List<Room> rooms = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();

    public static void main(String[] args) {
        ReservationSystem system = new ReservationSystem();
        system.initializeRooms();
        system.run();
    }

    private void initializeRooms() {
    	Room room1 = new Room(101, "Single", 100.0, true);
        Room room2 = new Room(102, "Double", 150.0, true);
        Room room3 = new Room(103, "Suite", 250.0, false);

       
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Display available rooms");
            System.out.println("2. Make a reservation");
            System.out.println("3. Cancel a reservation");
            System.out.println("4. View reservations");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    displayAvailableRooms();
                    break;
                case 2:
                    makeReservation(scanner);
                    break;
                case 3:
                    cancelReservation(scanner);
                    break;
                case 4:
                    viewReservations();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void displayAvailableRooms() {
    	
    	    System.out.println("Available Rooms:");
    	    for (Room room : rooms) {
    	        if (room.isAvailable()) {
    	            System.out.println("Room " + room.getRoomNumber() + " - " + room.getRoomType() + " - $" + room.getPrice());
    	        }
    	    }
    	}


    private void makeReservation(Scanner scanner) {
        displayAvailableRooms();
        System.out.print("Enter your name: ");
        String guestName = scanner.nextLine();
        System.out.print("Enter the room number you want to reserve: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Room selectedRoom = null;
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && room.isAvailable()) {
                selectedRoom = room;
                break;
            }
        }

        
        // ...

        if (selectedRoom != null) {
            System.out.print("Enter check-in date (yyyy-mm-dd): ");
            String checkInDateStr = scanner.nextLine();

            // Parse and handle date
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date checkInDate;
            try {
                checkInDate = dateFormat.parse(checkInDateStr);
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please use yyyy-mm-dd.");
                return;
            }

            System.out.print("Enter check-out date (yyyy-mm-dd): ");
            String checkOutDateStr = scanner.nextLine();

            // Parse and handle date
            Date checkOutDate;
            try {
                checkOutDate = dateFormat.parse(checkOutDateStr);
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please use yyyy-mm-dd.");
                return;
            }

           
        }

    }


    private void cancelReservation(Scanner scanner) {
        System.out.print("Enter your name: ");
        String guestName = scanner.nextLine();
        System.out.print("Enter the room number of your reservation: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Reservation reservationToRemove = null;
        for (Reservation reservation : reservations) {
            if (reservation.getGuestName().equals(guestName) && reservation.getRoomNumber() == roomNumber) {
                reservationToRemove = reservation;
                break;
            }
        }

        if (reservationToRemove != null) {
            reservations.remove(reservationToRemove);
            for (Room room : rooms) {
                if (room.getRoomNumber() == roomNumber) {
                    room.setAvailable(true);
                    break;
                }
            }
            System.out.println("Reservation canceled successfully.");
        } else {
            System.out.println("No matching reservation found.");
        }
    }

    private void viewReservations() {
        System.out.println("Current Reservations:");
        for (Reservation reservation : reservations) {
            System.out.println("Guest: " + reservation.getGuestName() +
                               ", Room: " + reservation.getRoomNumber() +
                               ", Check-in: " + reservation.getCheckInDate() +
                               ", Check-out: " + reservation.getCheckOutDate());
        }
    }

}

