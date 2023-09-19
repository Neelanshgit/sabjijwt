package com.sabji.model;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
public class ResponseWithObject {
	public ResponseEntity<Object> generateResponse(String message, HttpStatus status, String customcode,Object obj) {
        Map<String, Object> map = new HashMap<String, Object>();
            map.put("message", message);
            map.put("status", status.value());
            map.put("customcode", customcode);
            map.put("result",obj);
            HttpHeaders headers2 = new HttpHeaders();
        	headers2.add("Content-Type","application/json");
        	ResponseEntity<Object> resp=  new ResponseEntity<Object>(map, headers2, status.value());
           return resp;
        }
}
