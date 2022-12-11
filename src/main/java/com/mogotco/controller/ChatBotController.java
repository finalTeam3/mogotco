package com.mogotco.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatBotController {

    private static String secretKey = "c2FaYm96VGVtWHNxWm1GSVRiZHF6aGdkRGh4cndoS0M=";
    private static String apiUrl = "https://fhtjpdwz5t.apigw.ntruss.com/custom/v1/8347/286db146b52e296095a5f0a17e130971e0063aaeca7df69b23ef5894597b55ac";

    @MessageMapping("/sendMessage")
    @SendTo("/topic/public")
    public String sendMessage(@Payload String chatMessage) throws IOException
    {

        URL url = new URL(apiUrl);
        String message =  getReqMessage(chatMessage);
        String encodeBase64String = makeSignature(message, secretKey);

        //api서버 접속 (서버 -> 서버 통신)		
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

        BufferedReader br;

        if(responseCode==200) { // 정상 호출

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            con.getInputStream(), "UTF-8"));
            String decodedString;
            String jsonString = "";
            while ((decodedString = in.readLine()) != null) {
                jsonString = decodedString;
            }
            
            //받아온 값을 세팅하는 부분
            JSONParser jsonparser = new JSONParser();
            try {
            	// 들어온 메시지 확인
            	System.out.println("chatmessage:"+chatMessage);
            	
            	JSONObject json = (JSONObject)jsonparser.parse(jsonString);
            	JSONArray bubblesArray = (JSONArray)json.get("bubbles");
            	JSONObject bubbles = (JSONObject)bubblesArray.get(0);
            	JSONObject data = (JSONObject)bubbles.get("data");
//            	System.out.println("data: "+data);
            	
            	String descriptionvalue = "";
            	descriptionvalue = (String)data.get("description");
//            	System.out.println("descriptionvalue: " + descriptionvalue);
            	
            	
            	// 각 요청 메시지에 따라 다른 답변을 응답
            	if(descriptionvalue == null) {
//            		System.out.println("ok");
            		JSONObject cover = (JSONObject)data.get("cover");//data 객체 -> cover 객체
//            		System.out.println("cover: "+cover);
            		JSONObject coverdata = (JSONObject)cover.get("data");//cover 객체-> data 객체
            		JSONObject description = (JSONObject)coverdata.get(0);//data 객체->0번째 key값 desciption
            		
            		descriptionvalue = (String)coverdata.get("description");					
//            		System.out.println("descriptionvalue: "+descriptionvalue);
            		
            		JSONArray contentTable = (JSONArray)data.get("contentTable");//data->contenTable
            		JSONArray cm = new JSONArray();
            		
            		String contentvalue = "";
            		String buttonarray = "";
            		List<String> buttonlist = new ArrayList<>();
            		for(int i = 0; i < contentTable.size(); i++) {
            			JSONObject co = new JSONObject();
            			
            			JSONArray contentTable1 = (JSONArray)contentTable.get(i);//data->contenTable
            			JSONObject contenTable2 = (JSONObject)contentTable1.get(0);//contenTable의 첫번째
            			JSONObject contentdata = (JSONObject)contenTable2.get("data");//contenTable의 첫번째->data
            			contentvalue = (String)contentdata.get("title");
            			
            			co.put("button", contentvalue);
            			cm.add(co);
            			
            			JSONObject buttons = (JSONObject)cm.get(i);
            			buttonarray = (String)buttons.get("button");
            			buttonlist.add(buttonarray);
            			
            		} // ------ 내부 for문 종료 -----
            		
//            		System.out.println("cv: "+contentvalue);
//            		System.out.println("cm: "+cm);
//            		System.out.println(buttonlist);
            		
            		chatMessage = descriptionvalue +" "+ buttonlist;
            		
            		
            	} else {
            		
            		chatMessage = descriptionvalue;
            	} // 각 요청 메시지에 따라 다른 답변을 응답 if - else문 끝
            	
            	
            } catch (Exception e) {
                System.out.println("error");
                e.printStackTrace();
            }

            in.close();
        } else {  // 에러 발생
            chatMessage = con.getResponseMessage();
        }
		System.out.println("REsult:"+chatMessage);
        return chatMessage;
    }

    
    //보낼 메세지를 네이버에서 제공해준 암호화로 변경해주는 메소드
    public static String makeSignature(String message, String secretKey) {

        String encodeBase64String = "";

        try {
            byte[] secrete_key_bytes = secretKey.getBytes("UTF-8");

            SecretKeySpec signingKey = new SecretKeySpec(secrete_key_bytes, "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(signingKey);

            byte[] rawHmac = mac.doFinal(message.getBytes("UTF-8"));
            encodeBase64String = Base64.encodeBase64String(rawHmac);

            return encodeBase64String;

        } catch (Exception e){
            System.out.println(e);
        }

        return encodeBase64String;

    }

    //보낼 메세지를 네이버 챗봇에 포맷으로 변경해주는 메소드
    public static String getReqMessage(String voiceMessage) {

        String requestBody = "";

        try {
        	
        	//

            JSONObject obj = new JSONObject();

            long timestamp = new Date().getTime();

            System.out.println("##"+timestamp);

            obj.put("version", "v2");
            obj.put("userId", "U47b00b58c90f8e47428af8b7bddc1231heo2");
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
}