package kr.co.tomato.vo;

public class Favorite {
	private int shopNo;
	private int itemNo;
	
	
	
	public Favorite() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Favorite(int shopNo, int itemNo) {
		super();
		this.shopNo = shopNo;
		this.itemNo = itemNo;
	}


	public int getShopNo() {
		return shopNo;
	}


	public void setShopNo(int shopNo) {
		this.shopNo = shopNo;
	}


	public int getItemNo() {
		return itemNo;
	}


	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	
	
	
	
	
}
