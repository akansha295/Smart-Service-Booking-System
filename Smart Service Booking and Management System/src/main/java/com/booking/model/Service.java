package com.booking.model;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Service {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int sid;
private String sname;
private String description;
private int price;
private int duration;
@OneToMany (mappedBy = "service")
private List<Booking> service;
/**
 * @return the sid
 */
public int getSid() {
	return sid;
}
/**
 * @param sid the sid to set
 */
public void setSid(int sid) {
	this.sid = sid;
}
/**
 * @return the sname
 */
public String getSname() {
	return sname;
}
/**
 * @param sname the sname to set
 */
public void setSname(String sname) {
	this.sname = sname;
}
/**
 * @return the description
 */
public String getDescription() {
	return description;
}
/**
 * @param description the description to set
 */
public void setDescription(String description) {
	this.description = description;
}
/**
 * @return the price
 */
public int getPrice() {
	return price;
}
/**
 * @param price the price to set
 */
public void setPrice(int price) {
	this.price = price;
}
/**
 * @return the duration
 */
public int getDuration() {
	return duration;
}
/**
 * @param duration the duration to set
 */
public void setDuration(int duration) {
	this.duration = duration;
}
/**
 * @return the service
 */
/**
 * @return the service
 */
public List<Booking> getService() {
	return service;
}
/**
 * @param service the service to set
 */
public void setService(List<Booking> service) {
	this.service = service;
}


}
