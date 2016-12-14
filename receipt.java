/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busreservationsystem;

import java.util.Date;

/**
 *
 * @author Qaiyyim
 */
public class receipt {
    
    private int seatnumber;
    
    public receipt(int seatnumber)
    {
        this.seatnumber = seatnumber;
        //change geetha
    }
    
    Date timenow = new Date();
    public void printreceipit()
    {
        System.out.println("Receipt");
        System.out.println("------------------------------------------------------------------------");
        System.out.println("|\t\tTotal:\tRM30\t\t\t\t\t\t|");      
        System.out.println("|\t\tDate: " + timenow.toString() + "\t\t\t|");
	System.out.println("|\t\tBoarding pass for seat number: " + seatnumber + "\t\t\t|");
	System.out.println("|\t\tThis ticket is non-refundable and non-transferable.\t|");
        System.out.println("------------------------------------------------------------------------\n");

    }
}
