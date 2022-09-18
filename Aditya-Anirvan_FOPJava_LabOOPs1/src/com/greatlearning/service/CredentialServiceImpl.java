package com.greatlearning.service;

import com.greatlearning.model.Employee;
import java.util.*;

public class CredentialServiceImpl implements CredentialService{

	@Override
	public char[] generatePassword() {
		String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	      String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
	      String specialCharacters = "!@#$%^&*()";
	      String numbers = "1234567890";
	      String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
	      Random random = new Random();
	      char[] password = new char[8];
	      /*password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
	      password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
	      password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
	      password[3] = numbers.charAt(random.nextInt(numbers.length()));*/ 
	   
	      for(int i = 0; i< 8 ; i++) {
	         password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
	      }
	      return password;
	}

	@Override
	public String generateEmailAddress(String firstname, String lastname, String department) {
		
		return (firstname+lastname+"@"+department+".greatlearning.com");
	}

	@Override
	public void showCredentials(Employee employee, String email, char[] generatedpassword) {
		
		System.out.println("Email ---> " + email);
		System.out.println("Password ---> " + generatedpassword);
	}

}
