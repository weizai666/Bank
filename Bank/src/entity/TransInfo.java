package entity;

import java.util.Date;

public class TransInfo {
private String CardNo;
public String getCardNo() {
	return CardNo;
}
public void setCardNo(String cardNo) {
	CardNo = cardNo;
}
public String getTranstype() {
	return transtype;
}
public void setTranstype(String transtype) {
	this.transtype = transtype;
}
public String getTransmoney() {
	return transmoney;
}
public void setTransmoney(String transmoney) {
	this.transmoney = transmoney;
}
public Date getTransdate() {
	return transdate;
}
public void setTransdate(Date transdate) {
	this.transdate = transdate;
}
private String transtype;
private String transmoney;
private Date transdate;
}
