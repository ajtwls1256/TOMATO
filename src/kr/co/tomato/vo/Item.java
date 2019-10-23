package kr.co.tomato.vo;

import java.sql.Date;

public class Item {
	private int rnum;
	private int itemNo;
	private int memberNo;
	private String itemName;
	private String itemMainCategory;
	private String itemSubCategory;
	private int itemPrice;
	private Date itemEnrollDate;
	private String itemState;
	private int readcount;
	private String itemContent;
	private int itemAmount;
	private int itemDeliveryNy;
	private String itemDealRegion;
	private String itemThumFilename;
	private String itemThumFilepath;
	private String itemDealState;
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Item(int rnum, int itemNo, int memberNo, String itemName, String itemMainCategory, String itemSubCategory,
			int itemPrice, Date itemEnrollDate, String itemState, int readcount, String itemContent, int itemAmount,
			int itemDeliveryNy, String itemDealRegion, String itemThumFilename, String itemThumFilepath,
			String itemDealState) {
		super();
		this.rnum = rnum;
		this.itemNo = itemNo;
		this.memberNo = memberNo;
		this.itemName = itemName;
		this.itemMainCategory = itemMainCategory;
		this.itemSubCategory = itemSubCategory;
		this.itemPrice = itemPrice;
		this.itemEnrollDate = itemEnrollDate;
		this.itemState = itemState;
		this.readcount = readcount;
		this.itemContent = itemContent;
		this.itemAmount = itemAmount;
		this.itemDeliveryNy = itemDeliveryNy;
		this.itemDealRegion = itemDealRegion;
		this.itemThumFilename = itemThumFilename;
		this.itemThumFilepath = itemThumFilepath;
		this.itemDealState = itemDealState;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public int getItemNo() {
		return itemNo;
	}
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemMainCategory() {
		return itemMainCategory;
	}
	public void setItemMainCategory(String itemMainCategory) {
		this.itemMainCategory = itemMainCategory;
	}
	public String getItemSubCategory() {
		return itemSubCategory;
	}
	public void setItemSubCategory(String itemSubCategory) {
		this.itemSubCategory = itemSubCategory;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public Date getItemEnrollDate() {
		return itemEnrollDate;
	}
	public void setItemEnrollDate(Date itemEnrollDate) {
		this.itemEnrollDate = itemEnrollDate;
	}
	public String getItemState() {
		return itemState;
	}
	public void setItemState(String itemState) {
		this.itemState = itemState;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public String getItemContent() {
		return itemContent;
	}
	public void setItemContent(String itemContent) {
		this.itemContent = itemContent;
	}
	public int getItemAmount() {
		return itemAmount;
	}
	public void setItemAmount(int itemAmount) {
		this.itemAmount = itemAmount;
	}
	public int getItemDeliveryNy() {
		return itemDeliveryNy;
	}
	public void setItemDeliveryNy(int itemDeliveryNy) {
		this.itemDeliveryNy = itemDeliveryNy;
	}
	public String getItemDealRegion() {
		return itemDealRegion;
	}
	public void setItemDealRegion(String itemDealRegion) {
		this.itemDealRegion = itemDealRegion;
	}
	public String getItemThumFilename() {
		return itemThumFilename;
	}
	public void setItemThumFilename(String itemThumFilename) {
		this.itemThumFilename = itemThumFilename;
	}
	public String getItemThumFilepath() {
		return itemThumFilepath;
	}
	public void setItemThumFilepath(String itemThumFilepath) {
		this.itemThumFilepath = itemThumFilepath;
	}
	public String getItemDealState() {
		return itemDealState;
	}
	public void setItemDealState(String itemDealState) {
		this.itemDealState = itemDealState;
	}
}
