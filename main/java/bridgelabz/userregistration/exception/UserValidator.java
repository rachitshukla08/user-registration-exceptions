package bridgelabz.userregistration.exception;

import java.util.Scanner;
import java.util.regex.*;

import bridgelabz.userregistration.exception.InvalidUserDetailsException.ExceptionType;

/**Refactor the Code to throw custom exceptions in case of Invalid User Details
 * 
 */

/**
 * @author Rachit
 *
 */
public class UserValidator {

	public boolean validateFirstName(String firstName) throws InvalidUserDetailsException {
		String namePattern = "^[A-Z]{1}[a-zA-Z]{2,}";
		if (firstName.matches(namePattern)) 
			return true;
		
		else 
			throw new InvalidUserDetailsException(ExceptionType.INVALID_FIRST_NAME,"Please enter proper first name");
	}

	public boolean validateLastName(String lastName) throws InvalidUserDetailsException {
		String namePattern = "^[A-Z]{1}[a-zA-Z]{2,}";
		if (lastName.matches(namePattern)) 
			return true;
		
		else 
			throw new InvalidUserDetailsException(ExceptionType.INVALID_LAST_NAME,"Please enter proper last name");
	}

	public boolean validateEmail(String email) throws InvalidUserDetailsException {
		String emailPattern = "^[a-zA-Z0-9+_-]+([.][a-zA-Z0-9]+)*@([a-zA-Z0-9]+)([.][a-z]+)?[.][a-z]{2,}$";
		if (email.matches(emailPattern)) 
			return true;
		
		else 
			throw new InvalidUserDetailsException(ExceptionType.INVALID_EMAIL,"Please enter proper Email");
	}

	public boolean validateMobile(String mobile) throws InvalidUserDetailsException {
		String mobilePattern = "[0-9-]{1,}[ ][1-9]{1}[0-9]{9}";
		if (mobile.matches(mobilePattern)) 
			return true;
		
		else 
			throw new InvalidUserDetailsException(ExceptionType.INVALID_MOBILE,"Please enter proper mobile number");
	}

	public boolean validatePassword(String password) throws InvalidUserDetailsException {
		String passwordPattern = "^(?=.*\\d)(?=.*[A-Z])(?=.*\\W)(?!.*\\W\\w*\\W)(?!.*\\s).{8,}$";
		if (password.matches(passwordPattern)) 
			return true;
		
		else 
			throw new InvalidUserDetailsException(ExceptionType.INVALID_PASSWORD,"Please enter proper password");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UserValidator vObj = new UserValidator();
		
		System.out.println("Welcome to user registration");

		System.out.println("Please enter your first name:");
		String firstName = sc.nextLine();
		System.out.println("Please enter your last name:");
		String lastName = sc.nextLine();
		System.out.println("Enter Email ID");
		String email = sc.nextLine();
		System.out.println("Enter Mobile number");
		String mobile = sc.nextLine();
		System.out.println("Enter password");
		String password = sc.nextLine();
		// Inputs
		try {
			System.out.println("Valid first name: "+vObj.validateFirstName(firstName));
		} catch (InvalidUserDetailsException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("Valid last name: "+vObj.validateLastName(lastName));
		} catch (InvalidUserDetailsException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("Valid Email: "+vObj.validateEmail(email));
		} catch (InvalidUserDetailsException e1) {
			e1.printStackTrace();
		}
		try {
			System.out.println("Valid Mobile number: "+vObj.validateMobile(mobile));
		} catch (InvalidUserDetailsException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("Valid password: "+vObj.validatePassword(password));
		} catch (InvalidUserDetailsException e) {
			e.printStackTrace();
		}
		// Patterns

	}

}
