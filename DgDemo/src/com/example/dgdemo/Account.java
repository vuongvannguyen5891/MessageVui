package com.example.dgdemo;

import java.io.Serializable;
import java.util.Date;

public class Account implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String email;
	private int cardID;
	private String phone;
	private boolean updateViewable;
	private boolean isVertified;
	private Date syncTime;
	private String password;
	private String mediaPath;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isUpdateViewable() {
		return updateViewable;
	}

	public void setUpdateViewable(boolean updateViewable) {
		this.updateViewable = updateViewable;
	}

	public boolean isVertified() {
		return isVertified;
	}

	public void setVertified(boolean isVertified) {
		this.isVertified = isVertified;
	}

	public Date getSyncTime() {
		return syncTime;
	}

	public void setSyncTime(Date syncTime) {
		this.syncTime = syncTime;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMediaPath() {
		return mediaPath;
	}

	public void setMediaPath(String mediaPath) {
		this.mediaPath = mediaPath;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	public int getCardID() {
		return cardID;
	}

	public void setCardID(int cardID) {
		this.cardID = cardID;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", email=" + email + ", phone=" + phone
				+ ", updateViewable=" + updateViewable + ", isVertified="
				+ isVertified + ", cardId=" + cardID + ", syncTime=" + syncTime
				+ ", password=" + password + ", mediaPath=" + mediaPath + "]";
	}

}
