package com.mogotco.chatbot;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.Date;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class ChatbotTest {
	private String secretKey = "c2FaYm96VGVtWHNxWm1GSVRiZHF6aGdkRGh4cndoS0M=";
	private String apiUrl = "https://fhtjpdwz5t.apigw.ntruss.com/custom/v1/8347/286db146b52e296095a5f0a17e130971e0063aaeca7df69b23ef5894597b55ac";

	
	@Test
	void contextLoads() throws IOException {
		URL url = new URL(apiUrl);
		String chatMessage = "문의";
		String message =  getReqMessage(chatMessage);
		String encodeBase64String = makeSignature(message, secretKey);
		System.out.println(message);
		System.out.println(encodeBase64String);
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json;UTF-8");
		con.setRequestProperty("X-NCP-CHATBOT_SIGNATURE", encodeBase64String);

		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());

		wr.write(message.getBytes("UTF-8"));
		wr.flush();
		wr.close();
		int responseCode = con.getResponseCode();
		System.out.println("responseCode:"+responseCode);

		BufferedReader br;

		if(responseCode==200) { // 정상 호출

			BufferedReader in = new BufferedReader(
					new InputStreamReader(
							con.getInputStream()));
			String decodedString;
			String jsonString = "";
			while ((decodedString = in.readLine()) != null) {
				jsonString = decodedString;
			}
			//chatbotMessage = decodedString;
			
			JSONParser jsonparser = new JSONParser();
			try {
				
				// json 객체는 문자로, 배열은 숫자로 인덱싱 
				JSONObject json = (JSONObject)jsonparser.parse(jsonString);// 파싱해야 할 json 객체
				JSONArray bubblesArray = (JSONArray)json.get("bubbles");//json객체 -> bubbles 배열
				JSONObject bubbles = (JSONObject)bubblesArray.get(0);//bubbles 배열의 0번째 객체
				JSONObject data = (JSONObject)bubbles.get("data");//bubbles 0번째 객체-> data 객체
				
				
				String descriptionvalue = "";
				descriptionvalue = (String)data.get("description");
				
				if(chatMessage == "문의" || chatMessage == "결제" || chatMessage == "계정" || chatMessage == "자주 묻는 질문") {
					JSONObject cover = (JSONObject)data.get("cover");//data 객체 -> cover 객체
					JSONObject coverdata = (JSONObject)cover.get("data");//cover 객체-> data 객체
					JSONObject description = (JSONObject)coverdata.get(0);//data 객체->0번째 key값 desciption
					descriptionvalue = (String)coverdata.get("description");					
					System.out.println(descriptionvalue);
					
					JSONArray contentTable = (JSONArray)data.get("contentTable");//data->contenTable
					JSONArray cm = new JSONArray();
					for(int i = 0; i < contentTable.size(); i++) {
						JSONObject co = new JSONObject();
						
						JSONArray contentTable1 = (JSONArray)contentTable.get(i);//data->contenTable
						JSONObject contenTable2 = (JSONObject)contentTable1.get(0);//contenTable의 첫번째
						JSONObject contentdata = (JSONObject)contenTable2.get("data");//contenTable의 첫번째->data
						String contentvalue = "";
						contentvalue = (String)contentdata.get("title");
						chatMessage = descriptionvalue +" "+ contentvalue;
						
						co.put("button", contentvalue);
						cm.add(co);
						
						//System.out.println(contentvalue);
					}
					System.out.println(cm);
					
				}
					
				chatMessage = descriptionvalue;	
					
		
				
//				JSONArray contentTable = (JSONArray)data.get("contentTable");//data->contenTable
//				JSONArray contentTable1 = (JSONArray)contentTable.get(0);//data->contenTable
//				JSONObject contenTable2 = (JSONObject)contentTable1.get(0);//contenTable의 첫번째
//				JSONObject contentdata = (JSONObject)contenTable2.get("data");//contenTable의 첫번째->data
//				
//				String contentvalue = "";
//				contentvalue = (String)contentdata.get("title");
//				chatMessage= contentvalue;
				
				
				
			} catch (Exception e) {
				System.out.println("error");
				e.printStackTrace();
			}

			in.close();

		} else {  // 에러 발생
			System.out.println("Error");

			chatMessage = con.getResponseMessage();
		}
		System.out.println("REsult:"+chatMessage);
	}	
	
	
	
	
	public String getReqMessage(String voiceMessage) {

		String requestBody = "";

		try {

			JSONObject obj = new JSONObject();

			long timestamp = new Date().getTime();

			System.out.println("##"+timestamp);

			obj.put("version", "v2");
			obj.put("userId", "xxxx");
			obj.put("timestamp", timestamp);

			JSONObject bubbles_obj = new JSONObject();

			bubbles_obj.put("type", "text");

			JSONObject data_obj = new JSONObject();
			data_obj.put("description", voiceMessage);

			bubbles_obj.put("type", "text");
			bubbles_obj.put("data", data_obj);

			JSONArray bubbles_array = new JSONArray();
			bubbles_array.add(bubbles_obj);

			obj.put("bubbles", bubbles_array);
			obj.put("event", "send");

			requestBody = obj.toString();

		} catch (Exception e){
			System.out.println("## Exception : " + e);
		}

		return requestBody;

	}
	public String makeSignature(String message, String secretKey) {

		 String encodeBase64String = "";

	        try {
	            byte[] secrete_key_bytes = secretKey.getBytes("UTF-8");

	            SecretKeySpec signingKey = new SecretKeySpec(secrete_key_bytes, "HmacSHA256");
	            Mac mac = Mac.getInstance("HmacSHA256");
	            mac.init(signingKey);

	            byte[] rawHmac = mac.doFinal(message.getBytes("UTF-8"));
	            encodeBase64String = Base64.getEncoder().encodeToString(rawHmac);

	            return encodeBase64String;

	        } catch (Exception e){
	            System.out.println(e);
	        }

	        return encodeBase64String;

	}
	
	
}
