package com.greatlearning.denominations;
import java.util.*;
import com.greatlearning.mergesort.*;
public class currency {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int amount = 0,size=0 ;
    	System.out.println("enter the size of currency denominations");
    	size=sc.nextInt();
    	int[] notes = new int[size];
    	System.out.println("enter the currency denominations value");
    	for(int i=0;i<size;i++) {
    		notes[i] = sc.nextInt();
    	}
    	Mergesort ob = new Mergesort ();
        ob.sort(notes, 0, size - 1);
        System.out.println("enter the amount you want to pay");
        amount = sc.nextInt();
        int[] noteCounter = new int[size];
      
        for (int i = size-1; i >= 0; i--) {
            if (amount >= notes[i]) {
                noteCounter[i] = amount / notes[i];
                amount = amount % notes[i];
            }
        }
        if(amount == 0) {
        System.out.println("Currency Count ->");
        for (int i = size-1; i >= 0; i--) {
            if (noteCounter[i] != 0) {
                System.out.println(notes[i] + " : "
                    + noteCounter[i]);
            }
        }
        }
        else
        	System.out.println("Exact Amount not possible");
        sc.close();

}
}
