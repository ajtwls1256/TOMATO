package kr.co.tomato.vo;

import java.util.ArrayList;

public class MainItemListData {
	private ArrayList<MemberAddress> maList;
	private ArrayList<Item> iList;
	public ArrayList<MemberAddress> getMaList() {
		return maList;
	}
	public void setMaList(ArrayList<MemberAddress> maList) {
		this.maList = maList;
	}
	public ArrayList<Item> getiList() {
		return iList;
	}
	public void setiList(ArrayList<Item> iList) {
		this.iList = iList;
	}
	public MainItemListData(ArrayList<MemberAddress> maList, ArrayList<Item> iList) {
		super();
		this.maList = maList;
		this.iList = iList;
	}
	public MainItemListData() {
		super();
		// TODO Auto-generated constructor stub
	}
}
