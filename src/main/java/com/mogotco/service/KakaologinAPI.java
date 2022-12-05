package com.mogotco.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

@Service
public class KakaologinAPI {

	public String getAccessToken (String code) throws Exception{
		
		String host = "https://kauth.kakao.com/oauth/token";
		URL url = new URL(host);
		HttpURLConnection hucon = (HttpURLConnection) url.openConnection();
		String token = "";
		
		try {
			hucon.setRequestMethod("POST");
			hucon.setDoOutput(true);

			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(hucon.getOutputStream()));
            StringBuilder sb = new StringBuilder();
            sb.append("grant_type=authorization_code");
            sb.append("&client_id=df5e3953f8c59b9326e8bd7fdeabcdcc");
            sb.append("&redirect_uri=http://127.0.0.1/mogotco/user/kakaologin");
            sb.append("&code=" + code);
            bw.write(sb.toString());
            bw.flush();

            int responseCode = hucon.getResponseCode();
            System.out.println("responseCode : " + responseCode);

            BufferedReader br = new BufferedReader(new InputStreamReader(hucon.getInputStream()));
            String line = "";
            String result = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }
            System.out.println("response body : " + result);

            JSONParser parser = new JSONParser();
            JSONObject elem = (JSONObject)parser.parse(result);
            
            String access_token = elem.get("access_token").toString();
            String refresh_token = elem.get("refresh_token").toString();

            System.out.println("access_token : " + access_token);
            System.out.println("refresh_token : " + refresh_token);
            
            token = access_token;

            br.close();
            bw.close();
            
		} catch (IOException  e) {
			e.printStackTrace();
		}

		return token;
	}
	
	public Map<String, Object> getUserInfo (String access_token) throws Exception{

		String host = "https://kapi.kakao.com/v2/user/me";
		Map<String, Object> result = new HashMap<>();

        try {
            URL url = new URL(host);
            
            HttpURLConnection hucon = (HttpURLConnection) url.openConnection();
            hucon.setRequestProperty("Authorization", "Bearer " + access_token);
            hucon.setRequestMethod("GET");

            int responseCode = hucon.getResponseCode();
            System.out.println("responseCode : " + responseCode);

            BufferedReader br = new BufferedReader(new InputStreamReader(hucon.getInputStream()));
            String line = "";
            String res = "";

            while ((line = br.readLine()) != null) {
                res += line;
            }
            System.out.println("response body : " + res);
            
            JSONParser parser = new JSONParser();
            JSONObject obj = (JSONObject)parser.parse(res);
            JSONObject kakao_account = (JSONObject)obj.get("kakao_account");
            JSONObject properties = (JSONObject)obj.get("properties");
            
            String id = obj.get("id").toString();
            String nickname = properties.get("nickname").toString();
            String profile_image = properties.get("profile_image").toString();
            String email = kakao_account.get("email").toString();
            String gender = kakao_account.get("gender").toString();
            String birthday = kakao_account.get("birthday").toString();
            
            
            result.put("id", id);
            result.put("nickname", nickname);
            result.put("profile_image", profile_image);
            result.put("email", email);
            result.put("gender", gender);
            result.put("birthday", birthday);
            
            br.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
	
	public String getAgreementInfo(String access_token) {
		String result = "";
        String host = "https://kapi.kakao.com/v2/user/scopes";
        
		try {
			URL url = new URL(host);
			HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setRequestProperty("Authorization", "Bearer "+access_token);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line = "";
            while((line=br.readLine())!=null)
            {
                result+=line;
            }
            
            int responseCode = urlConnection.getResponseCode();
            System.out.println("responseCode = " + responseCode);
            
            br.close();
            
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}