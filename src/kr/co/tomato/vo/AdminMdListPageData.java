package kr.co.tomato.vo;

import java.util.ArrayList;

public class AdminMdListPageData {
	private ArrayList<Item> list;
	private String pageNavi;
	public AdminMdListPageData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminMdListPageData(ArrayList<Item> list, String pageNavi) {
		super();
		this.list = list;
		this.pageNavi = pageNavi;
	}
	public ArrayList<Item> getList() {
		return list;
	}
	public void setList(ArrayList<Item> list) {
		this.list = list;
	}
	public String getPageNavi() {
		return pageNavi;
	}
	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}
	
}
