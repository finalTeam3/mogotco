package com.mogotco.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Paths;
import java.util.UUID;

// json 관련된 것은 simple에 있는 걸 사용한다.
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
public class OcrService {
	
	String apiURL = "https://7efoxxvkek.apigw.ntruss.com/custom/v1/19092/6d9e630d6786c0f9e1946bf8ae877c02f848a0fe795ce15764411c1e6ca4ad5a/infer";
	String secretKey = "UGFDWVdDaEJURHN2eVllWkRkb0FzS3VKU1VIeVJUbEc=";
	
	public Object ocrresult(String mcardimgname) {
		
//		System.out.println("ocrresult 실행");
		StringBuffer response = null;
		Object jo = null;
	    String imgpath = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "static","img").toString(); // 로컬 이미지 저장 경로
//	    String imgpath = ""; // ncp 서버 이미지 저장 경로
	    String imageFile = imgpath + "/" + mcardimgname;
//	    System.out.println("mcardimgname: " + imageFile);
	    
		try {
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setUseCaches(false);
			con.setDoInput(true);
			con.setDoOutput(true);
			con.setReadTimeout(30000);
			con.setRequestMethod("POST");
			String boundary = "----" + UUID.randomUUID().toString().replaceAll("-", "");
			con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
			con.setRequestProperty("X-OCR-SECRET", secretKey);

			JSONObject json = new JSONObject();
			json.put("version", "V2");
			json.put("requestId", UUID.randomUUID().toString());
			json.put("timestamp", System.currentTimeMillis());
			JSONObject image = new JSONObject();
			image.put("format", "jpg");
			image.put("name", "demo");
			JSONArray images = new JSONArray();
			images.add(image);
			json.put("images", images);
			String postParams = json.toString();

			con.connect();
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			long start = System.currentTimeMillis();
			File file = new File(imageFile);
			
//			System.out.println("----------"+file.getName());
//			System.out.println("----------"+file.getPath());
//			System.out.println("----------"+file.getAbsolutePath());
			writeMultiPart(wr, postParams, file, boundary);
			wr.close();

			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();
//			System.out.println("REsult:");
//			System.out.println(response);   // 여기서 데이터를 어떻게 잘 풀어서 뽑아내야 할 지 알아보기
			
			JSONParser jsonparser = new JSONParser();
			jo = (JSONObject)jsonparser.parse(response.toString());
//			System.out.println(jo.toString());
//			JSONArray ja1 = (JSONArray) jo.get("images");
//			JSONObject jo1 = (JSONObject) ja1.get(0);
//			JSONArray ja2 = (JSONArray) jo1.get("fields");
//			
//			JSONObject f1 = (JSONObject) ja2.get(0);
//			JSONObject f2 = (JSONObject) ja2.get(1);
//			JSONObject f3 = (JSONObject) ja2.get(2);
//			
//			String name = (String) f1.get("inferText");
//			String position = (String) f2.get("inferText");
//			String company = (String) f3.get("inferText");
//			
//			System.out.println("name: "+name);
//			System.out.println("position: "+position);
//			System.out.println("company: "+company);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return jo;
	}
	
	private void writeMultiPart(OutputStream out, String jsonMessage, File file, String boundary) throws
	IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("--").append(boundary).append("\r\n");
		sb.append("Content-Disposition:form-data; name=\"message\"\r\n\r\n");
		sb.append(jsonMessage);
		sb.append("\r\n");
	
		out.write(sb.toString().getBytes("UTF-8"));
		out.flush();
	
		if (file != null && file.isFile()) {
			out.write(("--" + boundary + "\r\n").getBytes("UTF-8"));
			StringBuilder fileString = new StringBuilder();
			fileString
				.append("Content-Disposition:form-data; name=\"file\"; filename=");
			fileString.append("\"" + file.getName() + "\"\r\n");
			fileString.append("Content-Type: application/octet-stream\r\n\r\n");
			out.write(fileString.toString().getBytes("UTF-8"));
			out.flush();
	
			try (FileInputStream fis = new FileInputStream(file)) {
				byte[] buffer = new byte[8192];
				int count;
				while ((count = fis.read(buffer)) != -1) {
					out.write(buffer, 0, count);
				}
				out.write("\r\n".getBytes());
			}
	
			out.write(("--" + boundary + "--\r\n").getBytes("UTF-8"));
		}
		out.flush();
	}	
}
