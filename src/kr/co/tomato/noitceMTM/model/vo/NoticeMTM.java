package kr.co.tomato.noitceMTM.model.vo;

import oracle.sql.DATE;

public class NoticeMTM {
	private int NoticeMTMNo;
	private int MemberMTMNo;
	private String NoticeMTMWriter;
	private String NoticeMTMContent;
	private DATE NoticeMTMDate;
	private String FileName;
	private String FilePath;
	private String NoticeMTMMainCategory;
	private String NoticeMTMSubCategory;
	private String NoticeMTMAnswerState;
	private String NoticeMTMAnswerContent;
	private DATE NoticeMTMAnswerDate;
	public NoticeMTM(int noticeMTMNo, int memberMTMNo, String noticeMTMWriter, String noticeMTMContent,
			DATE noticeMTMDate, String fileName, String filePath, String noticeMTMMainCategory,
			String noticeMTMSubCategory, String noticeMTMAnswerState, String noticeMTMAnswerContent,
			DATE noticeMTMAnswerDate) {
		super();
		NoticeMTMNo = noticeMTMNo;
		MemberMTMNo = memberMTMNo;
		NoticeMTMWriter = noticeMTMWriter;
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
	public String getNoticeMTMWriter() {
		return NoticeMTMWriter;
	}
	public void setNoticeMTMWriter(String noticeMTMWriter) {
		NoticeMTMWriter = noticeMTMWriter;
	}
	public String getNoticeMTMContent() {
		return NoticeMTMContent;
	}
	public void setNoticeMTMContent(String noticeMTMContent) {
		NoticeMTMContent = noticeMTMContent;
	}
	public DATE getNoticeMTMDate() {
		return NoticeMTMDate;
	}
	public void setNoticeMTMDate(DATE noticeMTMDate) {
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
	public String getNoticeMTMAnswerState() {
		return NoticeMTMAnswerState;
	}
	public void setNoticeMTMAnswerState(String noticeMTMAnswerState) {
		NoticeMTMAnswerState = noticeMTMAnswerState;
	}
	public String getNoticeMTMAnswerContent() {
		return NoticeMTMAnswerContent;
	}
	public void setNoticeMTMAnswerContent(String noticeMTMAnswerContent) {
		NoticeMTMAnswerContent = noticeMTMAnswerContent;
	}
	public DATE getNoticeMTMAnswerDate() {
		return NoticeMTMAnswerDate;
	}
	public void setNoticeMTMAnswerDate(DATE noticeMTMAnswerDate) {
		NoticeMTMAnswerDate = noticeMTMAnswerDate;
	}
	public NoticeMTM() {
		super();
		// TODO Auto-generated constructor stub
	}
}
