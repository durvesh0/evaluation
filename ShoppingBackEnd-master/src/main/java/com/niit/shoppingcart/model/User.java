package com.niit.shoppingcart.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "USER")
@Component
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 981036373753278492L;

	@Id
	@NotNull
	@Column(name="id")
	private String id;
	
	@NotNull
	@Column(name="name")
	private String name;
	
	@NotNull
	@Column(name="add")
	private String add;
	
	@NotNull
	@Column(name="mob")
	private String mob;
	
	@NotNull
	@Column(name="email")
	private String email;
	
	@NotNull
	@Column(name="password")
	private String password;
	
	@Column(name="admin",columnDefinition ="tinyint deafault 1")
	private byte admin=0;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	
	public String getMob() {
		return mob;
	}

	public void setMob(String mob) {
		this.mob = mob;
	}

	
	public String getEmail() {
	return email;
	}
	

	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public byte getAdmin() {
		return admin;
	}

	public void setAdmin(byte admin){
		this.admin = admin;
	}
}
