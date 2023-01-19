package com.masai.Model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CurrentUserSession {
	
	@Id
	@Column(unique = true)
	private Integer id;
	private String uuid;
	private LocalDateTime localDateTime;
	
	public CurrentUserSession() {
		// TODO Auto-generated constructor stub
	}

	public CurrentUserSession(Integer id, String uuid, LocalDateTime localDateTime) {
		super();
		this.id = id;
		this.uuid = uuid;
		this.localDateTime = localDateTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	@Override
	public String toString() {
		return "CurrentUserSession [id=" + id + ", uuid=" + uuid + ", localDateTime=" + localDateTime + "]";
	}
	
	
	
	
	
	
	

}
