package kr.co.tomato.vo;

import java.util.ArrayList;

import kr.co.tomato.noitceMTM.model.vo.NoticeMTM;

public class PageData2 {
	private String pageNavi;
	private ArrayList<NoticeMTM> list;
	public String getPageNavi() {
		return pageNavi;
	}
	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}
	public ArrayList<NoticeMTM> getList() {
		return list;
	}
	public void setList(ArrayList<NoticeMTM> list) {
		this.list = list;
	}
	public PageData2(String pageNavi, ArrayList<NoticeMTM> list) {
		super();
		this.pageNavi = pageNavi;
		this.list = list;
	}
	public PageData2() {
		super();
		// TODO Auto-generated constructor stub
	}
}
