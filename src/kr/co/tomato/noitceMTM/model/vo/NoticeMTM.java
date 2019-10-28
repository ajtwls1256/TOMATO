package kr.co.tomato.noitceMTM.model.vo;

import java.sql.Date;

public class NoticeMTM {
	private int rNum;
	private int NoticeMTMNo;
	private int MemberMTMNo;
	private String NoticeMTMContent;
	private Date NoticeMTMDate;
	private String FileName;
	private String FilePath;
	private String NoticeMTMMainCategory;
	private String NoticeMTMSubCategory;
	private int NoticeMTMAnswerState;
	private String NoticeMTMAnswerContent;
	private Date NoticeMTMAnswerDate;
	public NoticeMTM(int rNum, int noticeMTMNo, int memberMTMNo, String noticeMTMContent, Date noticeMTMDate,
			String fileName, String filePath, String noticeMTMMainCategory, String noticeMTMSubCategory,
			int noticeMTMAnswerState, String noticeMTMAnswerContent, Date noticeMTMAnswerDate) {
		super();
		this.rNum = rNum;
		NoticeMTMNo = noticeMTMNo;
		MemberMTMNo = memberMTMNo;
		NoticeMTMContent = noticeMTMContent;
		NoticeMTMDate = noticeMTMDate;
		FileName = fileName;
		FilePath = filePath;
		NoticeMTMMainCategory = noticeMTMMainCategory;
		NoticeMTMSubCategory = noticeMTMSubCategory;
		NoticeMTMAnswerState = noticeMTMAnswerState;
		NoticeMTMAnswerContent = noticeMTMAnswerContent;
		NoticeMTMAnswerDate = noticeMTMAnswerDate;
	}
	public int getrNum() {
		return rNum;
	}
	public void setrNum(int rNum) {
		this.rNum = rNum;
	}
	public NoticeMTM() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NoticeMTM(int noticeMTMNo, int memberMTMNo, String noticeMTMContent, Date noticeMTMDate, String fileName,
			String filePath, String noticeMTMMainCategory, String noticeMTMSubCategory, int noticeMTMAnswerState,
			String noticeMTMAnswerContent, Date noticeMTMAnswerDate) {
		super();
		NoticeMTMNo = noticeMTMNo;
		MemberMTMNo = memberMTMNo;
		NoticeMTMContent = noticeMTMContent;
		NoticeMTMDate = noticeMTMDate;
		FileName = fileName;
		FilePath = filePath;
		NoticeMTMMainCategory = noticeMTMMainCategory;
		NoticeMTMSubCategory = noticeMTMSubCategory;
		NoticeMTMAnswerState = noticeMTMAnswerState;
		NoticeMTMAnswerContent = noticeMTMAnswerContent;
		NoticeMTMAnswerDate = noticeMTMAnswerDate;
	}
	public int getNoticeMTMNo() {
		return NoticeMTMNo;
	}
	public void setNoticeMTMNo(int noticeMTMNo) {
		NoticeMTMNo = noticeMTMNo;
	}
	public int getMemberMTMNo() {
		return MemberMTMNo;
	}
	public void setMemberMTMNo(int memberMTMNo) {
		MemberMTMNo = memberMTMNo;
	}
	public String getNoticeMTMContent() {
		return NoticeMTMContent;
	}
	public void setNoticeMTMContent(String noticeMTMContent) {
		NoticeMTMContent = noticeMTMContent;
	}
	public Date getNoticeMTMDate() {
		return NoticeMTMDate;
	}
	public void setNoticeMTMDate(Date noticeMTMDate) {
		NoticeMTMDate = noticeMTMDate;
	}
	public String getFileName() {
		return FileName;
	}
	public void setFileName(String fileName) {
		FileName = fileName;
	}
	public String getFilePath() {
		return FilePath;
	}
	public void setFilePath(String filePath) {
		FilePath = filePath;
	}
	public String getNoticeMTMMainCategory() {
		return NoticeMTMMainCategory;
	}
	public void setNoticeMTMMainCategory(String noticeMTMMainCategory) {
		NoticeMTMMainCategory = noticeMTMMainCategory;
	}
	public String getNoticeMTMSubCategory() {
		return NoticeMTMSubCategory;
	}
	public void setNoticeMTMSubCategory(String noticeMTMSubCategory) {
		NoticeMTMSubCategory = noticeMTMSubCategory;
	}
	public int getNoticeMTMAnswerState() {
		return NoticeMTMAnswerState;
	}
	public void setNoticeMTMAnswerState(int noticeMTMAnswerState) {
		NoticeMTMAnswerState = noticeMTMAnswerState;
	}
	public String getNoticeMTMAnswerContent() {
		return NoticeMTMAnswerContent;
	}
	public void setNoticeMTMAnswerContent(String noticeMTMAnswerContent) {
		NoticeMTMAnswerContent = noticeMTMAnswerContent;
	}
	public Date getNoticeMTMAnswerDate() {
		return NoticeMTMAnswerDate;
	}
	public void setNoticeMTMAnswerDate(Date noticeMTMAnswerDate) {
		NoticeMTMAnswerDate = noticeMTMAnswerDate;
	}
	
	
}
