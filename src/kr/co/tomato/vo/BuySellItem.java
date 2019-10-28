package kr.co.tomato.vo;

import java.sql.Date;

public class BuySellItem {
	private int itemNo;
    private int memberNo;
    private String itemName;
    private String itemMainCategory;
    private String itemSubCategoty;
    private int itemPrice;
    private Date itemEnrollDate;
    private String itemState;
    private int readcount;
    private String itemContent;
    private int itemAmount;
    private int itemDeliveryNY;
    private String itemDealRegion;
    private String itemThumFilename;
    private String itemThumFilepath;
    private String itemDealState;
    
    private int dealNo;
    private int buyer;
    private int saler;
    private int itemNo1;
    private String dealState;
    private Date dealEndDate;
    
	public BuySellItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BuySellItem(int itemNo, int memberNo, String itemName, String itemMainCategory, String itemSubCategoty,
			int itemPrice, Date itemEnrollDate, String itemState, int readcount, String itemContent, int itemAmount,
			int itemDeliveryNY, String itemDealRegion, String itemThumFilename, String itemThumFilepath,
			String itemDealState, int dealNo, int buyer, int saler, int itemNo1, String dealState, Date dealEndDate) {
		super();
		this.itemNo = itemNo;
		this.memberNo = memberNo;
		this.itemName = itemName;
		this.itemMainCategory = itemMainCategory;
		this.itemSubCategoty = itemSubCategoty;
		this.itemPrice = itemPrice;
		this.itemEnrollDate = itemEnrollDate;
		this.itemState = itemState;
		this.readcount = readcount;
		this.itemContent = itemContent;
		this.itemAmount = itemAmount;
		this.itemDeliveryNY = itemDeliveryNY;
		this.itemDealRegion = itemDealRegion;
		this.itemThumFilename = itemThumFilename;
		this.itemThumFilepath = itemThumFilepath;
		this.itemDealState = itemDealState;
		this.dealNo = dealNo;
		this.buyer = buyer;
		this.saler = saler;
		this.itemNo1 = itemNo1;
		this.dealState = dealState;
		this.dealEndDate = dealEndDate;
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
	public String getItemSubCategoty() {
		return itemSubCategoty;
	}
	public void setItemSubCategoty(String itemSubCategoty) {
		this.itemSubCategoty = itemSubCategoty;
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
	public int getItemDeliveryNY() {
		return itemDeliveryNY;
	}
	public void setItemDeliveryNY(int itemDeliveryNY) {
		this.itemDeliveryNY = itemDeliveryNY;
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
	public int getItemNo1() {
		return itemNo1;
	}
	public void setItemNo1(int itemNo1) {
		this.itemNo1 = itemNo1;
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
