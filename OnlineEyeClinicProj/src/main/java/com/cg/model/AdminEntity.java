package com.cg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//import org.junit.experimental.theories.DataPoint;
/**
 * 
 * Table in Database
 *
 */
@Entity
@Table(name="Admin")
public class AdminEntity {
	/**
	 * mapping the key present in database table
	 * 
	 */	 
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="admin_seq")
	@SequenceGenerator(name="admin_seq",sequenceName="admin_seq",allocationSize=1)
	@Column(name="admin_id")
private int adminId;
	/**
	 * mapping the column admin_user_name
	 */
	@Column(name="admin_user_name")
private String adminUserName;
	/**
	 * mapping the column admin_password
	 */
	@Column(name="admin_password")
private String adminPassword;
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(final int adminId) {
		this.adminId = adminId;
	}
	public String getAdminUserName() {
		return adminUserName;
	}
	public void setAdminUserName(final String adminUserName) {
		this.adminUserName = adminUserName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(final String adminPassword) {
		this.adminPassword = adminPassword;
	}
	/**
	 * 
	 * @param adminId
	 * @param adminUserName
	 * @param adminPassword
	 */
	public AdminEntity(final int adminId, final String adminUserName, final String adminPassword) {
		//super();
		this.adminId = adminId;
		this.adminUserName = adminUserName;
		this.adminPassword = adminPassword;
	}
	/**
	 * default empty constructor
	 */
public AdminEntity() {
	/**
	 * default empty constructor
	 */
}
@Override
public String toString() {
	return "Admin [adminId=" + adminId + ", adminUserName=" + adminUserName + ", adminPassword=" + adminPassword + "]";
}
}
