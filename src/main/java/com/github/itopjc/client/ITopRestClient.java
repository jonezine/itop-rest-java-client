package com.github.itopjc.client;

import org.json.JSONObject;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class ITopRestClient implements ITopRestClientSpecification {

	private final RestTemplate restTemplate;
	private final MultiValueMap<String, String> map;
	private final String url;
	private String jsonResponse;

	
	public ITopRestClient( String authPwd, String authUser, String version, String url )
	{
		this.restTemplate = new RestTemplate();
		this.map = new LinkedMultiValueMap<>();
		this.map.add("auth_pwd", authPwd);
		this.map.add("auth_user", authUser);
		this.map.add("version", version);
		this.url = url;
	}

	
	public JSONObject getObjects( String objectClass, String key )
	{
		this.map.add("json_data", "{\"operation\":\"core/get\",\"class\":\"" + objectClass + "\",\"key\":\"" + key + "\"}");
		this.jsonResponse = ((String)this.restTemplate.postForObject(this.url, this.map, String.class, new Object[0]));

		JSONObject objects = new JSONObject(this.jsonResponse);
		JSONObject itopObjects = objects.getJSONObject("objects");

		return itopObjects;
	}

}
