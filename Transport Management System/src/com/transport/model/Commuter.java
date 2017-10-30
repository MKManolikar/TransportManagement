package com.transport.model;

public class Commuter {

	private int cId;
	private String cName;
	private int cLoc;
	private int cContact;

	public Commuter(int cId, String cName, int cLoc, int cContact) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cLoc = cLoc;
		this.cContact = cContact;
	}

	public Commuter() {
		// TODO Auto-generated constructor stub
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public int getcLoc() {
		return cLoc;
	}

	public void setcLoc(int cLoc) {
		this.cLoc = cLoc;
	}

	public int getcContact() {
		return cContact;
	}

	public void setcContact(int cContact) {
		this.cContact = cContact;
	}

}
