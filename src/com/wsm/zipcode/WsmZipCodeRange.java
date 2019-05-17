package com.wsm.zipcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WsmZipCodeRange {
	private static Scanner scan;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter Range");
		scan = new Scanner(System.in);
		String ranges;
		ranges = scan.nextLine();
		ShippingZipCodes mergeZipcode = new ShippingZipCodes(ranges);
		List<ZipCodeRange> zipcodeList = mergeZipcode.trimZipcode();
		List<ZipCodeRange> sortedCodeList = mergeZipcode.lowerBoundSort(zipcodeList);
		List<ZipCodeRange> resultCodeList = mergeZipcode.zipCodeMerge(sortedCodeList);
		for (ZipCodeRange zipcodeRange : resultCodeList) {
			System.out.println("[" + zipcodeRange.getLower_bound() + "," + zipcodeRange.getUpper_bound() + "]");

		}

	}

}
