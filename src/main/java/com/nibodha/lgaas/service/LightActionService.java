package com.nibodha.lgaas.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.stereotype.Service;

@Service
public class LightActionService {
	private final String USER_AGENT = "Mozilla/5.0";
	public String blinkLight(Long level, Long lightid, String activationkey) throws Exception {
		// TODO Auto-generated method stub
		return sendPost(level, lightid, activationkey);
	}
	
	// HTTP POST request
		private String sendPost(Long level, Long lightid, String activationkey) throws Exception {
	 
			String url = "http://2210eaaf.ngrok.com/control/light/"+lightid;
	 
			HttpClient client = new DefaultHttpClient();
			HttpPost post = new HttpPost(url);
	 
			// add header
			post.setHeader("User-Agent", USER_AGENT);
			post.setHeader("Content-Type", "application/json");
			post.setEntity(new StringEntity("{\"action\":"+level+"}"));

	 
			HttpResponse response = client.execute(post);
			System.out.println("\nSending 'POST' request to URL : " + url);
			System.out.println("Post parameters : " + post.getEntity());
			System.out.println("Response Code : " + 
	                                    response.getStatusLine().getStatusCode());
	 
			BufferedReader rd = new BufferedReader(
	                        new InputStreamReader(response.getEntity().getContent()));
	 
			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
	 
			System.out.println(result.toString());
			return result.toString();
	 
		}
	

}
