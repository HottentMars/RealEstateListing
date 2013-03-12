package services.datasource;

import java.io.IOException;
import java.io.InputStream;
import java.util.PropertyResourceBundle;

public final class ConnectionData {
	
	private ConnectionData(){}
	
	private static final String fileName = "MyResources.properties";
    private static PropertyResourceBundle soleInstance = null;
    
    static {
    		InputStream propertiesFileStream = ConnectionData.class.getClassLoader().getResourceAsStream(fileName);
    		try {
				soleInstance = new PropertyResourceBundle(propertiesFileStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }

    public static String getString(String key) {
    		return soleInstance.getString(key);
    }
}
