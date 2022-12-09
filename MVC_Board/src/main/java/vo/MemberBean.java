package vo;

import java.sql.Date;
// 12/09 추가
public class MemberBean {
/*
 *  CREATE TABLE member (
	name VARCHAR(20) NOT NULL,
	id VARCHAR(16) PRIMARY KEY,
	passwd VARCHAR(16) NOT NULL,
	email VARCHAR(50) UNIQUE NOT NULL,
	gender VARCHAR(1) NOT NULL,
	date DATE NOT NULL
	);
 */
	private String name;
	private String id;
	private String passwd;
	private String email;
	private String gender;
   	private Date date; // java.sql
   	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "MemberBean [name=" + name + ", id=" + id + ", passwd=" + passwd + ", email=" + email + ", gender="
				+ gender + ", date=" + date + "]";
	}
	
}
