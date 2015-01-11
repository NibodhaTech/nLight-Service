package com.nibodha.lgaas.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nibodha.lgaas.dao.DeviceDao;
import com.nibodha.lgaas.dao.LightDao;
import com.nibodha.lgaas.entity.Light;

@Service
public class LightActionService {
	
	@Autowired
	public LightDao lightDao;
	
	@Autowired
	public DeviceDao deviceDao;
	
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

		public Light getLightInfo(Long lightid, String activationkey) {
			// TODO Auto-generated method stub
			Light l = lightDao.findOne(lightid);
			if(l == null){
				Light lig = new Light();
				lig.setDescription("Philips offers a wide range of both decorative and functional lighting. From outdoor LED lights to multicolored indoor lights, Philips has it all.");
				lig.setDevicename(deviceDao.findOne(1L));
				lig.setId(1L);
				lig.setLightlat("10.2323234556");
				lig.setLightlot("10.2323234556");
				lig.setLightTemperature("10^C");
				lig.setLightVoltage("200 v");
				lig.setName("My Light");
				l = lig;
				lightDao.save(lig);
			}
			return l;
		}

		public List<Light> getAllLight(String activationkey) {
			// TODO Auto-generated method stub
			List lightList = lightDao.findAll();
			return lightList;
		}

		public String createlightdata(Light light) {
			// TODO Auto-generated method stub
			lightDao.save(light);
			return null;
		}
	

}
