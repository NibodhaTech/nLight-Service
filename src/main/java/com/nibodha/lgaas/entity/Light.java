package com.nibodha.lgaas.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Light extends BaseEntity{
	@Id
	private Long id;
	private String name;
	@ManyToOne
	private Device devicename;
	private String lightlot;
	private String lightlat;
	private String lightVoltage;
	private String lightTemperature;
	private String description;
	private String status;
	private String zone;
	
	
	
	
	
	
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	public String getLightTemperature() {
		return lightTemperature;
	}
	public void setLightTemperature(String lightTemperature) {
		this.lightTemperature = lightTemperature;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Device getDevicename() {
		return devicename;
	}
	public void setDevicename(Device devicename) {
		this.devicename = devicename;
	}
	public String getLightlot() {
		return lightlot;
	}
	public void setLightlot(String lightlot) {
		this.lightlot = lightlot;
	}
	public String getLightlat() {
		return lightlat;
	}
	public void setLightlat(String lightlat) {
		this.lightlat = lightlat;
	}
	public String getLightVoltage() {
		return lightVoltage;
	}
	public void setLightVoltage(String lightVoltage) {
		this.lightVoltage = lightVoltage;
	}
	
	

}
