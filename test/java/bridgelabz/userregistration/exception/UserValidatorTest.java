package bridgelabz.userregistration.exception;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UserValidatorTest {
	private UserValidator validator;

	@Before
	public void init() {
		validator = new UserValidator();
	}

	@Test
	public void givenFirstName_WhenProper_ShouldReturnTrue() {
		try {
			boolean isValid = validator.validateFirstName("Rachit");
			assertEquals(true, isValid);
		} catch (InvalidUserDetailsException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenFirstName_WhenImproper_ShouldThrowCustomExcetion_ofTypeInvalidFirstName() {
		try {
			validator.validateFirstName("Rachit$");
		} catch (InvalidUserDetailsException e) {
			assertEquals(InvalidUserDetailsException.ExceptionType.INVALID_FIRST_NAME, e.type);
		}
	}
	// Tests for first name

	@Test
	public void givenLastName_WhenProper_ShouldReturnTrue() {
		try {
			boolean isValid = validator.validateLastName("Shukla");
			assertEquals(true, isValid);
		} catch (InvalidUserDetailsException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenLastName_WhenImproper_ShouldThrowCustomExcetion_ofTypeInvalidLastName() {
		try {
			validator.validateLastName("shukla");
		} catch (InvalidUserDetailsException e) {
			assertEquals(InvalidUserDetailsException.ExceptionType.INVALID_LAST_NAME, e.type);
		}
	}

	// Tests for last name

	@Test
	public void givenMobileNumber_WhenProper_ShouldReturnTrue() {
		try {
			boolean isValid = validator.validateMobile("91 9876543210");
			assertEquals(true, isValid);
		} catch (InvalidUserDetailsException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenMobileNumber_Improper_ShouldThrowCustomException_ofTypeInvalidMobile() {
		try {
			validator.validateMobile("1 98765");
		} catch (InvalidUserDetailsException e) {
			assertEquals(InvalidUserDetailsException.ExceptionType.INVALID_MOBILE, e.type);
		}
	}
	// Tests for mobile number

	@Test
	public void givenEmail_WhenProper_ShouldReturnTrue() {
		try {
			boolean isValid = validator.validateEmail("abc@yahoo.com");
			assertEquals(true, isValid);
		} catch (InvalidUserDetailsException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenEmail_WhenImproper_ShouldThrowCustomException_ofTypeInvalidEmail() {
		try {
			validator.validateEmail(".100@abc.com.au");
		} catch (InvalidUserDetailsException e) {
			assertEquals(InvalidUserDetailsException.ExceptionType.INVALID_EMAIL, e.type);
		}
	}
	// Tests for Email ID

	@Test
	public void givenPassword_WhenProper_ShouldReturnTrue() {
		try {
			boolean isValid =validator.validatePassword("aBcd123@m");
			assertEquals(true, isValid);
		} catch (InvalidUserDetailsException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenPassword_WhenImproper_ShouldThrowCustomException_ofTypeInvalidPassword() {
		try {
			validator.validatePassword("ABC12345");
		} catch (InvalidUserDetailsException e) {
			assertEquals(InvalidUserDetailsException.ExceptionType.INVALID_PASSWORD, e.type);
		}
	}
	// Tests for password

}
