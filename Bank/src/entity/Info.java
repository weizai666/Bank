package entity;

import java.sql.Date;

public class Info 
{
	private String CardNo;
	private String Name;
	private String Sex;
	private String IdentityNo;
	private String password;
	private Date Sdate;
	private String location;
	private String statementt;
	private double balance;
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getCardNo() {
		return CardNo;
	}
	public void setCardNo(String cardNo) {
		CardNo = cardNo;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	public String getIdentityNo() {
		return IdentityNo;
	}
	public void setIdentityNo(String identityNo) {
		IdentityNo = identityNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getSdate() {
		return Sdate;
	}
	public void setSdate(Date sdate) {
		Sdate = sdate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getStatementt() {
		return statementt;
	}
	public void setStatementt(String statementt) {
		this.statementt = statementt;
	}
}
