package kr.co.tomato.vo;

import java.sql.Date;

public class Chat
{
    private int chatNo;
    private int senderNo;
    private String senderShopName;
    private String senderFilePath;
    private int receiverNo;
    private String chatContent;
    private Date chatTime;
    
    
    public Chat()
    {
        super();
        // TODO Auto-generated constructor stub
    }


	public Chat(int chatNo, int senderNo, String senderShopName, String senderFilePath, int receiverNo,
			String chatContent, Date chatTime) {
		super();
		this.chatNo = chatNo;
		this.senderNo = senderNo;
		this.senderShopName = senderShopName;
		this.senderFilePath = senderFilePath;
		this.receiverNo = receiverNo;
		this.chatContent = chatContent;
		this.chatTime = chatTime;
	}


	public int getChatNo() {
		return chatNo;
	}


	public void setChatNo(int chatNo) {
		this.chatNo = chatNo;
	}


	public int getSenderNo() {
		return senderNo;
	}


	public void setSenderNo(int senderNo) {
		this.senderNo = senderNo;
	}


	public String getSenderShopName() {
		return senderShopName;
	}


	public void setSenderShopName(String senderShopName) {
		this.senderShopName = senderShopName;
	}


	public String getSenderFilePath() {
		return senderFilePath;
	}


	public void setSenderFilePath(String senderFilePath) {
		this.senderFilePath = senderFilePath;
	}


	public int getReceiverNo() {
		return receiverNo;
	}


	public void setReceiverNo(int receiverNo) {
		this.receiverNo = receiverNo;
	}


	public String getChatContent() {
		return chatContent;
	}


	public void setChatContent(String chatContent) {
		this.chatContent = chatContent;
	}


	public Date getChatTime() {
		return chatTime;
	}


	public void setChatTime(Date chatTime) {
		this.chatTime = chatTime;
	}
    
   
    
    
    
    
}
