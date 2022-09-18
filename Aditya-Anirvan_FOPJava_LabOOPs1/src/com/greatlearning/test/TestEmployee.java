package com.greatlearning.test;

import java.util.*;
import com.greatlearning.model.Employee;
import com.greatlearning.service.CredentialServiceImpl;
public class TestEmployee {

	public static void main(String[] args) {
		String firstName , lastName, Department, email;
		char[] Password;
		int option;
		Scanner sc = new Scanner(System.in);
		 System.out.println("Enter your First Name");
		 firstName = sc.nextLine();
		 System.out.println("Enter your Last Name");
		 lastName = sc.nextLine();
		 Employee employee = new Employee(firstName,lastName);
		 System.out.println("please Enter your department\n 1. Technical\n 2. Admin\n 3. Human Resource\n 4. Legal");
		 option = sc.nextInt();
		 switch(option) {
		 case 1:
			 Department = "tech";
			 break;
		 case 2:
			 Department = "adm";
			 break;
		 case 3:
			 Department = "hr";
			 break;
		 case 4:
			 Department = "legal";
			 break;
		 default:
			 System.out.println("Invalid Selection!!!");
			 sc.close();
			 return;
		 }
		 CredentialServiceImpl creds = new CredentialServiceImpl();
		 email = creds.generateEmailAddress(firstName, lastName, Department);
		 Password = creds.generatePassword();
		 creds.showCredentials(employee, email, Password);
		 sc.close();
	}

}
