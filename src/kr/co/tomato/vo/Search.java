package kr.co.tomato.vo;

import java.sql.Date;

public class Search {
	private String searchContent;
	private Date searchDate;
	private int searchCount;
	public String getSearchContent() {
		return searchContent;
	}
	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}
	public Date getSearchDate() {
		return searchDate;
	}
	public void setSearchDate(Date searchDate) {
		this.searchDate = searchDate;
	}
	public int getSearchCount() {
		return searchCount;
	}
	public void setSearchCount(int searchCount) {
		this.searchCount = searchCount;
	}
	public Search(String searchContent, Date searchDate, int searchCount) {
		super();
		this.searchContent = searchContent;
		this.searchDate = searchDate;
		this.searchCount = searchCount;
	}
	public Search() {
		super();
		// TODO Auto-generated constructor stub
	}
}
