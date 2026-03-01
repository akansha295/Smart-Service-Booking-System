package com.booking.model;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Booking {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int bid;
private String status;
private Date bdob;
private int btime;
@ManyToOne
private Customer customer;
private Service service;
/**
 * @return the bid
 */
public int getBid() {
	return bid;
}
/**
 * @param bid the bid to set
 */
public void setBid(int bid) {
	this.bid = bid;
}
/**
 * @return the status
 */
public String getStatus() {
	return status;
}
/**
 * @param status the status to set
 */
public void setStatus(String status) {
	this.status = status;
}
/**
 * @return the bdob
 */
public Date getBdob() {
	return bdob;
}
/**
 * @param bdob the bdob to set
 */
public void setBdob(Date bdob) {
	this.bdob = bdob;
}
/**
 * @return the btime
 */
public int getBtime() {
	return btime;
}
/**
 * @param btime the btime to set
 */
public void setBtime(int btime) {
	this.btime = btime;
}
/**
 * @return the customer
 */
public Customer getCustomer() {
	return customer;
}
/**
 * @param customer the customer to set
 */
public void setCustomer(Customer customer) {
	this.customer = customer;
}
/**
 * @return the service
 */
public Service getService() {
	return service;
}
/**
 * @param service the service to set
 */
public void setService(Service service) {
	this.service = service;
}

}
