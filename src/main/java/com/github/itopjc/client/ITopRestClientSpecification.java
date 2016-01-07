package com.github.itopjc.client;

import org.json.JSONObject;

public interface ITopRestClientSpecification {
	
	JSONObject getObjects(String objectClass, String key);

}
