package kr.co.tomato.vo;

public class MemberAddress {
	private String email;
	private String addrChoiceCity;
	private String addrChoiceGungu;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddrChoiceCity() {
		return addrChoiceCity;
	}
	public void setAddrChoiceCity(String addrChoiceCity) {
		this.addrChoiceCity = addrChoiceCity;
	}
	public String getAddrChoiceGungu() {
		return addrChoiceGungu;
	}
	public void setAddrChoiceGungu(String addrChoiceGungu) {
		this.addrChoiceGungu = addrChoiceGungu;
	}
	public MemberAddress(String email, String addrChoiceCity, String addrChoiceGungu) {
		super();
		this.email = email;
		this.addrChoiceCity = addrChoiceCity;
		this.addrChoiceGungu = addrChoiceGungu;
	}
	public MemberAddress() {
		super();
		// TODO Auto-generated constructor stub
	}
}
