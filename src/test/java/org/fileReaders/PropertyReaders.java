package org.fileReaders;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReaders {

	public static String getEndPoint() throws IOException {
		
		Properties properties = new Properties();

		String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\environment.properties";

		// To read the propeties we need to use fileINsputStream class,and to write the
		// property we need to use fileoutputstream class

		FileInputStream inputSteam = new FileInputStream(filePath);

		properties.load(inputSteam);

		String endPoint = properties.getProperty("Endpoint");

		System.out.println(endPoint);

		return endPoint;

	}

}
