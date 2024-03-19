package com.iCustomer.genericutilities;

import java.util.Date;
import java.util.Random;

//single line comment
/* multiple line comment*/
/**
 * This class consists of generic methods related to Java
 * @author abhishek.birana
 *
 */
public class JavaUtility {
	
	/**
	 * This method will generate random number for every run
	 * @author abhishek.birana
	 * @return
	 */
	public int getRandomNumber()
	{
		Random r = new Random();
		return r.nextInt(100000);
	}

	/**
	 * This method will generate the system date
	 * @author abhishek.birana
	 * @return
	 */
	public String getSystemDate()
	{
		Date d = new Date();
		return d.toString();
	}
	
	/**
	 * This method will generate system date in specific format
	 * @author abhishek.birana
	 * @return
	 */
	public String getSystemDateinFormat()
	{
		Date d = new Date();
		String[] dArr = d.toString().split(" ");
		String day = dArr[2];
		String month = dArr[1];
		String year = dArr[5];
		String time = dArr[3].replace(":", "-");
		
		String date = day+"-"+month+"-"+year+" "+time;
		return date;
	}
	
	
	/**
	 * This method will generate random mail with given format
	 * @author abhishek.birana
	 * @param mail
	 * @return
	 */
	public String getRandomMail(String mail, int num)
	{
		String email = mail;
		String[] emailU = email.split("@");
		emailU[0] = emailU[0].replaceAll("[^A-Za-z]", "");
		String newMail = emailU[0]+num+"@"+emailU[1];
		return newMail;
		
		
	}
	
	/**
	 * This method will generate random mobile number
	 * @author abhishek.birana
	 * @param num
	 * @return
	 */
	public String getRandomMobileNumber()
	{
	        StringBuilder sb = new StringBuilder();
	        Random random = new Random();

	        // Generate the first digit of the mobile number (starts with 9, 8, 7, or 6)
	        int firstDigit = 6 + random.nextInt(4); // Random digit between 6 and 9
	        sb.append(firstDigit);

	        // Generate the remaining digits of the mobile number (9 digits)
	        for (int i = 0; i < 9; i++) {
	            int digit = random.nextInt(10); // Random digit between 0 and 9
	            sb.append(digit);
	        }

	        return sb.toString();
	    }
	
	
	/**
	 * This method will change the number after name
	 * @author abhishek.birana
	 * @param name
	 * @param delimiter
	 * @param num
	 * @return
	 */
	public String getNameChange(String name, String delimiter, int num)
	{
		String[] nameUpdate =name.split(delimiter);
		String newName = nameUpdate[0]+delimiter+num;
		return newName;
	}
	
	/**
	 * This method will change the string after name
	 * @author abhishek.birana
	 * @param name
	 * @param delimiter
	 * @param num
	 * @return
	 */
	public String getNameChange(String name, String delimiter, String text)
	{
		String[] nameUpdate =name.split(delimiter);
		String newName = nameUpdate[0]+delimiter+text;
		return newName;
	}
	
	
	/**
	 * This method will generate random String
	 * @author abhishek.birana
	 * @return
	 */
	public String getRandomString()
	{
		Random random = new Random();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < 5; i++) {
            int randomIndex = random.nextInt(26);
            
            char randomLetter = (char) (97 + randomIndex);
            
            sb.append(randomLetter);
        }
        
        return sb.toString();
	}
}
