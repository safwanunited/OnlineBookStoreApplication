package com.revature.bookproject.model;

import java.util.Arrays;

public class bookIdObj {
private long[] bookIds;

public bookIdObj(long[] bookIds) {
	super();
	this.bookIds = bookIds;
}

public bookIdObj() {
	super();
}

public long[] getBookIds() {
	return bookIds;
}

public void setBookIds(long[] bookIds) {
	this.bookIds = bookIds;
}

@Override
public String toString() {
	return "bookIdObj [bookIds=" + Arrays.toString(bookIds) + "]";
}

}
