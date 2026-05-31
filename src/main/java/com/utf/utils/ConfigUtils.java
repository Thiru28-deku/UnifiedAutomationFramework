package com.utf.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.utf.enums.ConfigProperties;

public class ConfigUtils {

	private ConfigUtils() {

	}

	private static Properties property = new Properties();
	private static final Map<String,String> CONFIGMAP = new HashMap<>();

	static {
		try {
			FileInputStream fil = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Config/config.properties");
			property.load(fil);

			//			for(Object key : property.keySet()) {
			//				CONFIGMAP.put(String.valueOf(key), String.valueOf(property.get(key)));
			//			}

			//			for(Map.Entry<Object, Object> entry: property.entrySet()) {
			//				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
			//			}

			property.entrySet().forEach(entry->CONFIGMAP.put
					(String.valueOf(entry.getKey()), String.valueOf(entry.getValue())));

		}

		catch(IOException e) {
			e.printStackTrace();
		}

		
	}

	public static String get(ConfigProperties key) throws Exception {
		if(Objects.isNull(key)|| Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
			throw new Exception("Property key '" + key + "' not found in config file."
					);
		}

		return CONFIGMAP.get(key.name().toLowerCase());



	}

}
