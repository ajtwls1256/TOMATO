package kr.co.tomato.sellPage.model.vo;

import java.sql.Date;

public class ItemInquiry {
	private int itemInquiryNo;
	private String itemInquiryWriter;
	private int itemRef;
	private String itemInquiryComment;
	private Date itemInquiryDate;
	private int itemInquiryLevel;
	private int itemInquiryRef;
	
	
	public ItemInquiry() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ItemInquiry(int itemInquiryNo, String itemInquiryWriter, int itemRef, String itemInquiryComment,
			Date itemInquiryDate, int itemInquiryLevel, int itemInquiryRef) {
		super();
		this.itemInquiryNo = itemInquiryNo;
		this.itemInquiryWriter = itemInquiryWriter;
		this.itemRef = itemRef;
		this.itemInquiryComment = itemInquiryComment;
		this.itemInquiryDate = itemInquiryDate;
		this.itemInquiryLevel = itemInquiryLevel;
		this.itemInquiryRef = itemInquiryRef;
	}


	public int getItemInquiryNo() {
		return itemInquiryNo;
	}


	public void setItemInquiryNo(int itemInquiryNo) {
		this.itemInquiryNo = itemInquiryNo;
	}


	public String getItemInquiryWriter() {
		return itemInquiryWriter;
	}


	public void setItemInquiryWriter(String itemInquiryWriter) {
		this.itemInquiryWriter = itemInquiryWriter;
	}


	public int getItemRef() {
		return itemRef;
	}


	public void setItemRef(int itemRef) {
		this.itemRef = itemRef;
	}


	public String getItemInquiryComment() {
		return itemInquiryComment;
	}


	public void setItemInquiryComment(String itemInquiryComment) {
		this.itemInquiryComment = itemInquiryComment;
	}


	public Date getItemInquiryDate() {
		return itemInquiryDate;
	}


	public void setItemInquiryDate(Date itemInquiryDate) {
		this.itemInquiryDate = itemInquiryDate;
	}


	public int getItemInquiryLevel() {
		return itemInquiryLevel;
	}


	public void setItemInquiryLevel(int itemInquiryLevel) {
		this.itemInquiryLevel = itemInquiryLevel;
	}


	public int getItemInquiryRef() {
		return itemInquiryRef;
	}


	public void setItemInquiryRef(int itemInquiryRef) {
		this.itemInquiryRef = itemInquiryRef;
	}
	
	
	
	
}
