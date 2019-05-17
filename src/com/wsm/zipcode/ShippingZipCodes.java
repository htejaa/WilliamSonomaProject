package com.wsm.zipcode;

import java.util.List;
import java.util.Collections;
import java.util.LinkedList;

public class ShippingZipCodes {
	private String range;

	public ShippingZipCodes(String range) {
		super();
		this.range = range;
	}

	public List<ZipCodeRange> trimZipcode() {
		String[] zipcodeInterval = range.split(" ");
		return zipcodeInput(zipcodeInterval);
	}

	public int stringToInt(String zipcode) {
		return Integer.parseInt(zipcode);
	}

	public boolean compareZipcode(int lowerBound, int upperBound) {
		if (lowerBound > upperBound)
			return false;
		return true;
	}

	public ZipCodeRange zipcodeValidate(String[] zipRange) {
		if (zipRange.length != 2)
			throw new IllegalArgumentException(
					zipRange[0] + "Each range shhould include both their upper and lower bounds");
		int lowerBound = stringToInt(zipRange[0]);
		int upperBound = stringToInt(zipRange[1]);
		ZipCodeRange zipcode = null;
		zipcode = new ZipCodeRange(lowerBound, upperBound);
		return zipcode;
	}

	public ZipCodeRange getZipcodeRange(String zipcodeRange) {
		return zipcodeValidate(zipcodeRange.replaceAll("\\[|\\]", "").split(","));
	}

	public List<ZipCodeRange> zipcodeInput(String[] zipcodeRange) {
		List<ZipCodeRange> zipcodesList = new LinkedList<ZipCodeRange>();
		for (int i = 0; i < zipcodeRange.length; i++) {
			zipcodesList.add(getZipcodeRange(zipcodeRange[i]));
		}
		return zipcodesList;
	}

	public List<ZipCodeRange> lowerBoundSort(List<ZipCodeRange> codeList) {
		Collections.sort(codeList, new CodeCompare());
		return codeList;
	}

	public List<ZipCodeRange> zipCodeMerge(List<ZipCodeRange> sortedCodeList) {
		List<ZipCodeRange> mergeZipcodeList = new LinkedList<ZipCodeRange>();
		ZipCodeRange zipcodeRange = null;
		for (ZipCodeRange zipcodeInterval : sortedCodeList) {
			if (zipcodeRange == null)
				zipcodeRange = zipcodeInterval;
			else {
				if (zipcodeRange.getUpper_bound() >= zipcodeInterval.getLower_bound()) {
					zipcodeRange.setUpper_bound(Math.max(zipcodeRange.getUpper_bound(), zipcodeInterval.getUpper_bound()));

				} else {
					mergeZipcodeList.add(zipcodeRange);
					zipcodeRange = zipcodeInterval;
				}
			}
		}
		mergeZipcodeList.add(zipcodeRange);
		return mergeZipcodeList;
	}

}
