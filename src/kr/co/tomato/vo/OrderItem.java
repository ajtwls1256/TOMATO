package kr.co.tomato.vo;

import java.util.ArrayList;

public class OrderItem {
	
	private ArrayList<BuySellItem> bList;
	private ArrayList<BuySellItem> sList;
	
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderItem(ArrayList<BuySellItem> bList, ArrayList<BuySellItem> sList) {
		super();
		this.bList = bList;
		this.sList = sList;
	}

	public ArrayList<BuySellItem> getbList() {
		return bList;
	}

	public void setbList(ArrayList<BuySellItem> bList) {
		this.bList = bList;
	}

	public ArrayList<BuySellItem> getsList() {
		return sList;
	}

	public void setsList(ArrayList<BuySellItem> sList) {
		this.sList = sList;
	}
	

}
