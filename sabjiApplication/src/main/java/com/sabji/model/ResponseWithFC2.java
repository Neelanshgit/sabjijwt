package com.sabji.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseWithFC2 {
	public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, String customcode,List<FileResponseModel> filesStatus) {
        Map<String, Object> map = new HashMap<String, Object>();
            map.put("message", message);
            map.put("status", status.value());
            map.put("customcode", customcode);
            map.put("filesStatus", filesStatus);
            
            String auth_token= "agdhsgj";
            HttpHeaders headers2 = new HttpHeaders();
        	headers2.add("Authorization","basic "+auth_token);
        	//HttpEntity<String> request2 = new HttpEntity<String>(headers2);
        	//MultiValueMap< String,String> params =  new LinkedMultiValueMap<>();
        	//headers2.add("auth_token", auth_token);
        	headers2.add("Content-Type","application/json");
        	ResponseEntity<Object> resp=  new ResponseEntity<Object>(map, headers2, status.value());
           return resp;
          //  return new ResponseEntity<Object>();
    }
}
