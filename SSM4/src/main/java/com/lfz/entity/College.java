package com.lfz.entity;

public class College {

	private int collegeID;
	private String collegename;

	public int getCollegeID() {
		return collegeID;
	}

	public void setCollegeID(int collegeID) {
		this.collegeID = collegeID;
	}

	public String getCollegename() {
		return collegename;
	}

	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}

	@Override
	public String toString() {
		return "College [collegeID=" + collegeID + ", collegename=" + collegename + "]";
	}

}
