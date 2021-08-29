package com.revature.bookproject.model;

public class status {
private String sts;

public status() {
	super();
	// TODO Auto-generated constructor stub
}

public status(String sts) {
	super();
	this.sts = sts;
}

public String getSts() {
	return sts;
}

public void setSts(String sts) {
	this.sts = sts;
}

@Override
public String toString() {
	return "status [sts=" + sts + "]";
}

}
