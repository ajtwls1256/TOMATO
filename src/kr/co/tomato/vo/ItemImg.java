package kr.co.tomato.vo;

public class ItemImg {
	private int itemNo;
	private String filename;
	private String filepath;
	private int thumNy;
	public ItemImg() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemImg(int itemNo, String filename, String filepath, int thumNy) {
		super();
		this.itemNo = itemNo;
		this.filename = filename;
		this.filepath = filepath;
		this.thumNy = thumNy;
	}
	public int getItemNo() {
		return itemNo;
	}
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public int getThumNy() {
		return thumNy;
	}
	public void setThumNy(int thumNy) {
		this.thumNy = thumNy;
	}
	
	
}
