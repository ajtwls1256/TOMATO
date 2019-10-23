package kr.co.tomato.vo;

import java.util.ArrayList;

public class AdminPaymentListPageData {
	private ArrayList<Payment> list;
	private String pageNavi;
	public ArrayList<Payment> getList() {
		return list;
	}
	public void setList(ArrayList<Payment> list) {
		this.list = list;
	}
	public String getPageNavi() {
		return pageNavi;
	}
	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}
	public AdminPaymentListPageData(ArrayList<Payment> list, String pageNavi) {
		super();
		this.list = list;
		this.pageNavi = pageNavi;
	}
	public AdminPaymentListPageData() {
		super();
		// TODO Auto-generated constructor stub
	}
}
