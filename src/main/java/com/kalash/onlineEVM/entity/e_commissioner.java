package com.kalash.onlineEVM.entity;

import java.util.Optional;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "e_commissioner")
public class e_commissioner {
	@Id
	int id;
	
	public e_commissioner() {
		// TODO Auto-generated constructor stub
	}

	public e_commissioner(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "e_commissioner [id=" + id + "]";
	}

	
	
	
}
