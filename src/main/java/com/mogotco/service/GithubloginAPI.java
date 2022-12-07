package com.mogotco.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

@Service
public class GithubloginAPI {
	
	public String getAccessToken (String code) throws Exception{
		
		// 인가코드를 이용해 엑세스 토큰을 받아옴
		String host = "https://github.com/login/oauth/access_token";
		URL url = new URL(host);
		HttpURLConnection hucon = (HttpURLConnection) url.openConnection();
		String token = "";
		
		// post방식으로 json타입의 유저정보를 주세요
		hucon.setRequestMethod("POST");
		hucon.setRequestProperty("Accept", "application/json");
		hucon.setDoOutput(true);
		
		// post에 필요한 키값 전송
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(hucon.getOutputStream()));
        StringBuilder sb = new StringBuilder();
        sb.append("grant_type=authorization_code");
        sb.append("&client_id=d09e08d1edcc188a134c");
        sb.append("&client_secret=6df354d016a0f195aac76d73148616ad880c5479");
        sb.append("&redirect_uri=http://127.0.0.1/mogotco/user/githublogin");
        sb.append("&code=" + code);
        bw.write(sb.toString());
        bw.flush();
        
        // 200 서버 통신 정상
        int responseCode = hucon.getResponseCode();
//        System.out.println("responseCode : " + responseCode);
        
        // 받아온 데이터 읽어오기
        BufferedReader br = new BufferedReader(new InputStreamReader(hucon.getInputStream()));
        String line = "";
        String result = "";
        
        while ((line = br.readLine()) != null) {
            result += line;
        }
//        System.out.println("result : " + result);
        
        // JSON 파싱
        JSONParser parser = new JSONParser();
        JSONObject elem = (JSONObject)parser.parse(result);
//        System.out.println("elem : " + elem);
        
        String access_token = elem.get("access_token").toString();
//        System.out.println(access_token);
        
        token = access_token;

        br.close();
        bw.close();
        
		return token;
	}
	
	public Map<String, Object> getUserInfo (String access_token) throws Exception{
		
		// 엑세스 토큰을 이용해서 유저 정보를 받아옴
		String host = "https://api.github.com/user";
		Map<String, Object> result = new HashMap<>();
		URL url = new URL(host);
//		System.out.println(access_token);
		
		// get 방식으로 json타입의 정보를 주세요
		HttpURLConnection hucon = (HttpURLConnection) url.openConnection();
		hucon.setRequestProperty("Accept", "application/json");
        hucon.setRequestProperty("Authorization", "Bearer " + access_token);
        hucon.setRequestMethod("GET");
        
        // 200 서버 통신 정상
        int responseCode = hucon.getResponseCode();
//        System.out.println("responseCode : " + responseCode);
        
        // 받아온 데이터 읽어오기
        BufferedReader br = new BufferedReader(new InputStreamReader(hucon.getInputStream()));
        String line = "";
        String res = "";
        
        while ((line = br.readLine()) != null) {
            res += line;
        }
//        System.out.println("response body : " + res);
        
        // JSON 파싱
        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject)parser.parse(res);
        
        // String 으로 대응되는 키값 추출
        String id = obj.get("id").toString();
        String git = obj.get("html_url").toString();
        String login = obj.get("login").toString();
//        System.out.println(id);
//        System.out.println(git);
//        System.out.println(login);
        
        // result에 넣어줌
        result.put("id", id);
        result.put("git", git);
        result.put("login", login);
        
        br.close();
        
        return result;
	}
}
