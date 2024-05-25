package com.kalash.onlineEVM.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="evm")
public class evm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int sr_no;
	String partyName;
	
	public evm() {
		// TODO Auto-generated constructor stub
	}

	public evm(int sr_no, String partyName) {
		super();
		this.sr_no = sr_no;
		this.partyName = partyName;
	}

	public int getSr_no() {
		return sr_no;
	}

	public void setSr_no(int sr_no) {
		this.sr_no = sr_no;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	@Override
	public String toString() {
		return "evm [sr_no=" + sr_no + ", partyName=" + partyName + "]";
	}

	
	
	
}
