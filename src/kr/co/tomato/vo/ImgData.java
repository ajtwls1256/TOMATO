package kr.co.tomato.vo;

import java.util.ArrayList;

public class ImgData {
	private ArrayList<Item> list;
	private String imgNavi;
	public ImgData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ImgData(ArrayList<Item> list, String imgNavi) {
		super();
		this.list = list;
		this.imgNavi = imgNavi;
	}
	public ArrayList<Item> getList() {
		return list;
	}
	public void setList(ArrayList<Item> list) {
		this.list = list;
	}
	public String getImgNavi() {
		return imgNavi;
	}
	public void setImgNavi(String imgNavi) {
		this.imgNavi = imgNavi;
	}
}
