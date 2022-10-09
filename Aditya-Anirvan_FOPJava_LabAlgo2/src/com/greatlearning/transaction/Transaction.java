package com.greatlearning.transaction;
import java.util.*;

public class Transaction {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arraysize=0,target=0,transno=0;
		System.out.println("enter the size of transaction array");
		arraysize = sc.nextInt();
		int []array = new int[arraysize];
		System.out.println("enter the values of array");
		for(int i=0;i<arraysize;i++) {
			array[i] = sc.nextInt();
		}
		System.out.println("enter the total no of targets that needs to be achieved");
		transno=sc.nextInt();
		while(transno!=0) {
			System.out.println("enter the value of target");
			target=sc.nextInt();
			int sum=0,flag=0;
			for(int i=0;i<arraysize;i++) {
				sum=sum+array[i];
				if(sum>=target) {
					flag=1;
					System.out.println("Target achieved after "+(i+1) + " transactions");
					break;
				}
			}
			if(flag==0)System.out.println(" Given target is not achieved ");
		}
		sc.close();
	}
	
}
