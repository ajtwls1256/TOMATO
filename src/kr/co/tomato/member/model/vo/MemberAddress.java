package kr.co.tomato.member.model.vo;

public class MemberAddress {

	private String email;
	private String addrChoice;
	
	public MemberAddress() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberAddress(String email, String addrChoice) {
		super();
		this.email = email;
		this.addrChoice = addrChoice;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddrChoice() {
		return addrChoice;
	}
	public void setAddrChoice(String addrChoice) {
		this.addrChoice = addrChoice;
	}
	
}
