package kr.co.tomato.myshop.model.vo;

import java.util.Date;

public class DealItem {

	private int itemNo;
	private int memberNo;
	private String email;
	private String itemName;
	private String shopName;
	private int shopReadcount;
	private String itemThumFilename;
	private String itemThumFilepath;
	private Date paymentDate;
	private int paymentPay;
	
	public DealItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DealItem(int itemNo, int memberNo, String email, String itemName, String shopName, int shopReadcount,
			String itemThumFilename, String itemThumFilepath, Date paymentDate, int paymentPay) {
		super();
		this.itemNo = itemNo;
		this.memberNo = memberNo;
		this.email = email;
		this.itemName = itemName;
		this.shopName = shopName;
		this.shopReadcount = shopReadcount;
		this.itemThumFilename = itemThumFilename;
		this.itemThumFilepath = itemThumFilepath;
		this.paymentDate = paymentDate;
		this.paymentPay = paymentPay;
	}

	/**
	 * @return the itemNo
	 */
	public int getItemNo() {
		return itemNo;
	}

	/**
	 * @param itemNo the itemNo to set
	 */
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	/**
	 * @return the memberNo
	 */
	public int getMemberNo() {
		return memberNo;
	}

	/**
	 * @param memberNo the memberNo to set
	 */
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * @return the shopName
	 */
	public String getShopName() {
		return shopName;
	}

	/**
	 * @param shopName the shopName to set
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	/**
	 * @return the shopReadcount
	 */
	public int getShopReadcount() {
		return shopReadcount;
	}

	/**
	 * @param shopReadcount the shopReadcount to set
	 */
	public void setShopReadcount(int shopReadcount) {
		this.shopReadcount = shopReadcount;
	}

	/**
	 * @return the itemThumFilename
	 */
	public String getItemThumFilename() {
		return itemThumFilename;
	}

	/**
	 * @param itemThumFilename the itemThumFilename to set
	 */
	public void setItemThumFilename(String itemThumFilename) {
		this.itemThumFilename = itemThumFilename;
	}

	/**
	 * @return the itemThumFilepath
	 */
	public String getItemThumFilepath() {
		return itemThumFilepath;
	}

	/**
	 * @param itemThumFilepath the itemThumFilepath to set
	 */
	public void setItemThumFilepath(String itemThumFilepath) {
		this.itemThumFilepath = itemThumFilepath;
	}

	/**
	 * @return the paymentDate
	 */
	public Date getPaymentDate() {
		return paymentDate;
	}

	/**
	 * @param paymentDate the paymentDate to set
	 */
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	/**
	 * @return the paymentPay
	 */
	public int getPaymentPay() {
		return paymentPay;
	}

	/**
	 * @param paymentPay the paymentPay to set
	 */
	public void setPaymentPay(int paymentPay) {
		this.paymentPay = paymentPay;
	}

	


}
