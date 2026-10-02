package utilities;

import com.github.javafaker.Faker;

public class RandomDataUtility {
	Faker fk=new Faker();
	public String generateRandomUserName()
	{
		return fk.name().username();
	}
	
	public String generateRandomPassword()
	{
		return fk.internet().password();
	}
	
	public String generateFullName()
	{
		return fk.name().fullName();
	}
	
	public String generateRandomEmailId()
	{
		return fk.internet().emailAddress();
	}
	
	public String generateRandomPhoneNumber()
	{
		return fk.phoneNumber().cellPhone();
	}
	
	public String generateRandomAddress()
	{
		return fk.address().streetAddress();
	}
	
	public String generateCategoryText()
	{
		return  fk.name().fullName();
	}

}
