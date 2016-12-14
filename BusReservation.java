/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.reservation;

/**
 *
 * @author Najihah64
 */
import java.util.Scanner;
import java.util.Date;

public class BusReservation {

    /**
     * @param args the command line arguments
     */
private static int[] seats = new int[12];

    public static void main(String[] args) {
       String username;
       String password;
       
       Scanner input = new Scanner(System.in);
       System.out.println("Welcome to the DIC lovin train reservation system!");
       System.out.println("Code ninjas, code newbies, one fabulous DIC ride!");
       System.out.println();
       //cy
		
       System.out.println ("Username: ");
       username = input.nextLine();
       
       System.out.println("Password: ");
       password = input.nextLine();
       
       Login login = new Login(username, password);
       {
       

        if(login.checkPassword())
            
            System.out.println("You are logged in!");
        else
            System.out.println("The username and password you entered are incorrect.");
            
            
       }
		// Lets start by setting all seats equal to 0 (aka Empty)
		for (int i = 0; i < 12; i++) {
			seats[i] = 0;
		}

		// Setup our scanner and default the choice to window.
		Scanner s = new Scanner(System.in);
		int choice = 1;

		// Ask user for a window or an aisle seat and store their coice.
		System.out.print("Please enter 1 for window, 2 for aisle, or 0 to exit: ");
		choice = s.nextInt();


		// While their choice is not the one for exit, execute our booking.
		while (choice != 0) {
			int seatnumber = 0;


			// If they chose a window seat, attempt to book it.
			if (choice == 1) {
				seatnumber = bookWindow();

//2
				// No window seats available, try booking an aisle seat for them instead.
				if (seatnumber == -1) {
					seatnumber = bookAisle();
				
					if (seatnumber != -1) {
						System.out.println("Sorry, we were not able to book a window seat. But do have an aisle seat.");
						printBoardingPass(seatnumber);
					}
				}
				else {
					// Booking a window seat was successful.
					System.out.println("You are in luck, we have a window seat available!");
					printBoardingPass(seatnumber);
				}
			}
			else if (choice == 2) {

				// If they chose booking an isle, check to see if it is available.
				seatnumber = bookAisle();
			
				// If not available, see if we have window seats available.
				if (seatnumber == -1) {
					seatnumber = bookWindow();

					if (seatnumber != -1) {
						System.out.println("Sorry, we were not able to book an aisle seat. But do have a window seat.");
						printBoardingPass(seatnumber);
					}
				}
				else {
					// Booking an aisle seat was successful.
					System.out.println("You are in luck, we have an aisle seat available!");
					printBoardingPass(seatnumber);
				}
			}
			else {
				// Print an error message if they did not choose 1, 2, or 0 for their choice.
				System.out.println("Invalid choice made. Please try again!");
				choice = 0;
			}


			// No window or aisle seats were available. 
			if (seatnumber == -1) {
				System.out.println("We are sorry, there are no window or aisle seats available.");
				System.out.println();
			}

// im new
			// Reprompt for a choice
			System.out.print("Please enter 1 for window, 2 for aisle, or 0 to exit: ");
			choice = s.nextInt();
		}

			
	}


	// This function checks for window seats and returns seat number or -1 if full.
	private static int bookWindow() {
		for (int i = 0; i < 6; i++) {
			if (seats[i] == 0) {
				seats[i] = 1;
				return i + 1;
			}
		}
		return -1;
	}


	// This function checks to see if aisle seats were available, -1 if full.
	private static int bookAisle() {
		for (int i = 6; i < 12; i++) {
			if (seats[i] == 0) {
				seats[i] = 1;
				return i + 1;
			}
		}
		return -1;

	}


	// This simply prints out a nice little boarding pass message with their seat number and date of issue.
	private static void printBoardingPass(int seatnumber) {
		Date timenow = new Date();
		System.out.println();
		System.out.println("Date: " + timenow.toString());
		System.out.println("Boarding pass for seat number: " + seatnumber);
		System.out.println("This ticket is non-refundable and non-transferable.");
		System.out.println("Please be curteous, do not smoke. Enjoy your trip.");
		System.out.println();
	}
    }
    
