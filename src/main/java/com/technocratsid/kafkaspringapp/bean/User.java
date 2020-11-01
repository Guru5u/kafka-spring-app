package com.technocratsid.kafkaspringapp.bean;

import org.springframework.data.mongodb.core.mapping.Document;


@SuppressWarnings("serial")
@Document(collection = "quote")
public class User  extends BaseEntity{

	
	private String quoteId;
	
	private String quoteMsg;
	
	public User(){
		
	}
	public User(String quoteId, String quoteMsg){
		this.quoteId = quoteId;
		this.quoteMsg = quoteMsg;
	}
	public String getQuoteId() {
		return quoteId;
	}
	public String getQuoteMsg() {
		return quoteMsg;
	}
	public void setQuoteId(String quoteId) {
		this.quoteId = quoteId;
	}
	public void setQuoteMsg(String quoteMsg) {
		this.quoteMsg = quoteMsg;
	}

	

}
