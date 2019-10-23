package kr.co.tomato.vo;

import java.util.ArrayList;

public class AdminMemberListPageData {
	private ArrayList<Member> list;
	private String pageNavi;
	public AdminMemberListPageData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminMemberListPageData(ArrayList<Member> list, String pageNavi) {
		super();
		this.list = list;
		this.pageNavi = pageNavi;
	}
	public ArrayList<Member> getList() {
		return list;
	}
	public void setList(ArrayList<Member> list) {
		this.list = list;
	}
	public String getPageNavi() {
		return pageNavi;
	}
	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}
	
}
