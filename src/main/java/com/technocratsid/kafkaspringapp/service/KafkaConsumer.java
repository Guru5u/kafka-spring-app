package com.technocratsid.kafkaspringapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.technocratsid.kafkaspringapp.bean.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class KafkaConsumer {
	
	@Autowired
	UserService userService;

    public static List<String> messages = new ArrayList<>();
    private final static String topic = "TestTopic";
    private final static String groupId = "kafka-spring-app";

    @KafkaListener(topics = topic, groupId = groupId)
    public void listen(String message) {
    	
    	System.out.println("======>>> "+message);
    	String json = message;
    	JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
    	System.out.println(" jsonObject.isJsonObject() "+jsonObject.isJsonObject());
    	System.out.println("jsonObject.get(\"name\").getAsString() "+jsonObject.get("quoteId").getAsString());
    	
    	String quoteId = jsonObject.get("quoteId").getAsString();
    	String quoteMsg = jsonObject.get("quoteMsg").getAsString();
    	
    	User usr = new User(quoteId , quoteMsg);
    	userService.createUser(usr);
    	
    	List<User> quotes =  userService.getQuotes();
    	
    	for (int i = 0; i < quotes.size(); i++) {
    		System.out.println(" quotes "+quotes.get(i).getQuoteId() +"::: "+quotes.get(i).getQuoteMsg());			
		}
    	
    	System.out.println("userService.getUser() :: "+ userService.getQuotes());
        messages.add(message);
    }
}