package com.mogotco.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

@Service
public class KakaologinAPI {
	
	public String getAccessToken (String authorize_code) throws Exception{
		
		String accessToken = null;
		String refreshToken = null;
		String reqURL = "https://kauth.kakao.com/oauth/token";
		
		try {
			URL url = new URL(reqURL);
			HttpURLConnection hucon = (HttpURLConnection) url.openConnection();
			
			hucon.setRequestMethod("POST");
			hucon.setDoOutput(true);
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(hucon.getOutputStream()));
            StringBuilder sb = new StringBuilder();
            sb.append("grant_type=authorization_code");
            sb.append("&client_id=df5e3953f8c59b9326e8bd7fdeabcdcc");
            sb.append("&redirect_uri=http://127.0.0.1/mogotco/user/kakaologin");
            sb.append("&code=" + authorize_code);
            bw.write(sb.toString());
            bw.flush();
			
            int responseCode = hucon.getResponseCode();
            System.out.println("responseCode : " + responseCode);
            
            BufferedReader br = new BufferedReader(new InputStreamReader(hucon.getInputStream()));
            String line = null;
            String result = "";
            
            while ((line = br.readLine()) != null) {
                result += line;
            }
            System.out.println("response body : " + result);
            
//            JSONParser jsonparser = new JSONParser();
//            JSONObject jo = (JSONObject)jsonparser.parse(result);

            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);
            
            accessToken = element.getAsJsonObject().get("access_token").getAsString();
            refreshToken = element.getAsJsonObject().get("refresh_token").getAsString();
            
            System.out.println("access_token : " + accessToken);
            System.out.println("refresh_token : " + refreshToken);
            
            br.close();
            bw.close();
            
            
		} catch (IOException  e) {
			e.printStackTrace();
		}
		
		
		return accessToken;
	}
	
}
