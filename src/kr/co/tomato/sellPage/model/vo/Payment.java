package kr.co.tomato.sellPage.model.vo;

import java.sql.Date;

public class Payment {
	
	private String mechantUid;
	private int itemNo;
	private int memberNo;
	private String impUid;
	private int paymentPay;
	private String paymentState;
	private Date paymentDate;
	private String paymentApplyNum;
	private int paymentCommission;
	private String paymentNy;
	
	
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Payment(String mechantUid, int itemNo, int memberNo, String impUid, int paymentPay, String paymentState,
			Date paymentDate, String paymentApplyNum, int paymentCommission, String paymentNy) {
		super();
		this.mechantUid = mechantUid;
		this.itemNo = itemNo;
		this.memberNo = memberNo;
		this.impUid = impUid;
		this.paymentPay = paymentPay;
		this.paymentState = paymentState;
		this.paymentDate = paymentDate;
		this.paymentApplyNum = paymentApplyNum;
		this.paymentCommission = paymentCommission;
		this.paymentNy = paymentNy;
	}


	public String getMechantUid() {
		return mechantUid;
	}


	public void setMechantUid(String mechantUid) {
		this.mechantUid = mechantUid;
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


	public String getImpUid() {
		return impUid;
	}


	public void setImpUid(String impUid) {
		this.impUid = impUid;
	}


	public int getPaymentPay() {
		return paymentPay;
	}


	public void setPaymentPay(int paymentPay) {
		this.paymentPay = paymentPay;
	}


	public String getPaymentState() {
		return paymentState;
	}


	public void setPaymentState(String paymentState) {
		this.paymentState = paymentState;
	}


	public Date getPaymentDate() {
		return paymentDate;
	}


	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}


	public String getPaymentApplyNum() {
		return paymentApplyNum;
	}


	public void setPaymentApplyNum(String paymentApplyNum) {
		this.paymentApplyNum = paymentApplyNum;
	}


	public int getPaymentCommission() {
		return paymentCommission;
	}


	public void setPaymentCommission(int paymentCommission) {
		this.paymentCommission = paymentCommission;
	}


	public String getPaymentNy() {
		return paymentNy;
	}


	public void setPaymentNy(String paymentNy) {
		this.paymentNy = paymentNy;
	}
	
	
	
	
}


