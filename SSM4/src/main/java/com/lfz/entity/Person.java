package com.lfz.entity;

import java.util.Date;

public class Person {
	private int pid;
	private String pname;
	private Date birthday;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", birthday=" + birthday + "]";
	}

}
