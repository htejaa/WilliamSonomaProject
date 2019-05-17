package com.wsm.zipcode;

import java.util.Comparator;

public class CodeCompare implements Comparator<ZipCodeRange> {
	public int compare(ZipCodeRange range1,ZipCodeRange range2) {
		if(range1.getLower_bound()>range2.getLower_bound())
			return 1;
		else 
			return -1;
	}

}
