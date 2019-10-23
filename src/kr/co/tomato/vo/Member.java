package kr.co.tomato.vo;

import java.sql.Date;

public class Member {
	private int rnum;
	private int memberNo;
	private String email;
	private String memberPw;
	private String memberName;
	private Date enrollDate;
	private String phone;
	private String address;
	private String zipCode;
	private String memberBank;
	private String memberAccount;
	private String shopName;
	private String shopContent;
	private int shopReadcount;
	private String fileName;
	private String filePath;
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Member(int rnum, int memberNo, String email, String memberPw, String memberName, Date enrollDate,
			String phone, String address, String zipCode, String memberBank, String memberAccount, String shopName,
			String shopContent, int shopReadcount, String fileName, String filePath) {
		super();
		this.rnum = rnum;
		this.memberNo = memberNo;
		this.email = email;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.enrollDate = enrollDate;
		this.phone = phone;
		this.address = address;
		this.zipCode = zipCode;
		this.memberBank = memberBank;
		this.memberAccount = memberAccount;
		this.shopName = shopName;
		this.shopContent = shopContent;
		this.shopReadcount = shopReadcount;
		this.fileName = fileName;
		this.filePath = filePath;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getMemberBank() {
		return memberBank;
	}
	public void setMemberBank(String memberBank) {
		this.memberBank = memberBank;
	}
	public String getMemberAccount() {
		return memberAccount;
	}
	public void setMemberAccount(String memberAccount) {
		this.memberAccount = memberAccount;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShopContent() {
		return shopContent;
	}
	public void setShopContent(String shopContent) {
		this.shopContent = shopContent;
	}
	public int getShopReadcount() {
		return shopReadcount;
	}
	public void setShopReadcount(int shopReadcount) {
		this.shopReadcount = shopReadcount;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}
