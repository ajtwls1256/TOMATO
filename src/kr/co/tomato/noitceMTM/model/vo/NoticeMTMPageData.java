package kr.co.tomato.noitceMTM.model.vo;

import java.util.ArrayList;

public class NoticeMTMPageData {
	private ArrayList<NoticeMTM> list;
	private ArrayList<NoticeMTM> list2;
	private String pageNavi;
	public NoticeMTMPageData(ArrayList<NoticeMTM> list, ArrayList<NoticeMTM> list2, String pageNavi) {
		super();
		this.list = list;
		this.list2 = list2;
		this.pageNavi = pageNavi;
	}
	public ArrayList<NoticeMTM> getList2() {
		return list2;
	}
	public void setList2(ArrayList<NoticeMTM> list2) {
		this.list2 = list2;
	}
	public NoticeMTMPageData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NoticeMTMPageData(ArrayList<NoticeMTM> list, String pageNavi) {
		super();
		this.list = list;
		this.pageNavi = pageNavi;
	}
	public ArrayList<NoticeMTM> getList() {
		return list;
	}
	public void setList(ArrayList<NoticeMTM> list) {
		this.list = list;
	}
	public String getPageNavi() {
		return pageNavi;
	}
	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}
	
}
