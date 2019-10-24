package kr.co.tomato.noticeCategory.model.vo;

public class noticeCategory {
private String main;
private String sub;
private String content;
public noticeCategory() {
	super();
	// TODO Auto-generated constructor stub
}
public noticeCategory(String main, String sub, String content) {
	super();
	this.main = main;
	this.sub = sub;
	this.content = content;
}
public String getMain() {
	return main;
}
public void setMain(String main) {
	this.main = main;
}
public String getSub() {
	return sub;
}
public void setSub(String sub) {
	this.sub = sub;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}

}
