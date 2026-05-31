package com.utf.utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.utf.constant.FrameworkConstant;
import com.utf.enums.ConfigProperties;

public class JsonUtils {

	private JsonUtils() {
		
	}
	
	private static  Map<String,String> CONFIGMAP;

	static {
		try {
			
			CONFIGMAP = new ObjectMapper().readValue(new File(FrameworkConstant.getJsonFilePath()), 
					new TypeReference<HashMap<String,String>>(){});
			
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

