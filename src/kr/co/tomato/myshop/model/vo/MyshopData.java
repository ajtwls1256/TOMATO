package kr.co.tomato.myshop.model.vo;

import java.util.ArrayList;

import kr.co.tomato.member.model.vo.Member;
import kr.co.tomato.sellPage.model.vo.Item;

public class MyshopData {

	private Member mem;
	private ArrayList<Item> iList;
	private ArrayList<DealItem> dList;
	private ArrayList<Item> fList;
	private ArrayList<Review> rList;
	public MyshopData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyshopData(Member mem, ArrayList<Item> iList, ArrayList<DealItem> dList, ArrayList<Item> fList,
			ArrayList<Review> rList) {
		super();
		this.mem = mem;
		this.iList = iList;
		this.dList = dList;
		this.fList = fList;
		this.rList = rList;
	}
	/**
	 * @return the mem
	 */
	public Member getMem() {
		return mem;
	}
	/**
	 * @param mem the mem to set
	 */
	public void setMem(Member mem) {
		this.mem = mem;
	}
	/**
	 * @return the iList
	 */
	public ArrayList<Item> getiList() {
		return iList;
	}
	/**
	 * @param iList the iList to set
	 */
	public void setiList(ArrayList<Item> iList) {
		this.iList = iList;
	}
	/**
	 * @return the dList
	 */
	public ArrayList<DealItem> getdList() {
		return dList;
	}
	/**
	 * @param dList the dList to set
	 */
	public void setdList(ArrayList<DealItem> dList) {
		this.dList = dList;
	}
	/**
	 * @return the fList
	 */
	public ArrayList<Item> getfList() {
		return fList;
	}
	/**
	 * @param fList the fList to set
	 */
	public void setfList(ArrayList<Item> fList) {
		this.fList = fList;
	}
	/**
	 * @return the rList
	 */
	public ArrayList<Review> getrList() {
		return rList;
	}
	/**
	 * @param rList the rList to set
	 */
	public void setrList(ArrayList<Review> rList) {
		this.rList = rList;
	}
	
}
