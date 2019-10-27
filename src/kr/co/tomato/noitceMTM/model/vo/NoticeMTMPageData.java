package kr.co.tomato.noitceMTM.model.vo;

import java.util.ArrayList;

public class NoticeMTMPageData {
	private ArrayList<NoticeMTM> list;
	private String pageNavi;
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
