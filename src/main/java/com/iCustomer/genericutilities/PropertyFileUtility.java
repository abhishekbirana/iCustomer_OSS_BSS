package com.iCustomer.genericutilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consists of generic methods related to property File
 * @author abhishek.birana
 *
 */
public class PropertyFileUtility {
	
	/**
	 * This method will read data from property File
	 * @author abhishek.birana
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDatafromPropertyFile(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(ConstantsUtility.propertyFilePath);
		Properties pObj = new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key);		
		return value;
	}

}
