package com.kalash.onlineEVM.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "voter")
public class voter {
	@Id
	int voter_id;
	String password;
	
	public voter() {
		// TODO Auto-generated constructor stub
	}

	public voter(int voter_id, String password) {
		super();
		this.voter_id = voter_id;
		this.password = password;
	}

	public int getVoter_id() {
		return voter_id;
	}

	public void setVoter_id(int voter_id) {
		this.voter_id = voter_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "voter [voter_id=" + voter_id + ", password=" + password + "]";
	}
	
	
}
