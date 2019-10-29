package kr.co.tomato.myshop.model.vo;

import java.util.Date;

public class Deal {

	private int dealNo;
	private int buyer;
	private int saler;
	private int item_no;
	private String dealState;
	private Date dealEndDate;

	public Deal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Deal(int dealNo, int buyer, int saler, int item_no, String dealState, Date dealEndDate) {
		super();
		this.dealNo = dealNo;
		this.buyer = buyer;
		this.saler = saler;
		this.item_no = item_no;
		this.dealState = dealState;
		this.dealEndDate = dealEndDate;
	}

	public int getDealNo() {
		return dealNo;
	}

	public void setDealNo(int dealNo) {
		this.dealNo = dealNo;
	}

	public int getBuyer() {
		return buyer;
	}

	public void setBuyer(int buyer) {
		this.buyer = buyer;
	}

	public int getSaler() {
		return saler;
	}

	public void setSaler(int saler) {
		this.saler = saler;
	}

	public int getItem_no() {
		return item_no;
	}

	public void setItem_no(int item_no) {
		this.item_no = item_no;
	}

	public String getDealState() {
		return dealState;
	}

	public void setDealState(String dealState) {
		this.dealState = dealState;
	}

	public Date getDealEndDate() {
		return dealEndDate;
	}

	public void setDealEndDate(Date dealEndDate) {
		this.dealEndDate = dealEndDate;
	}
	
}
