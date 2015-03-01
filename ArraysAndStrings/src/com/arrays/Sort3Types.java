package com.arrays;

/**
 * Class that sorts an array which is composed of 3 distinct numbers, occurring
 * any number of times. Constraint : Don't use counting sort
 * 
 * @author tanvi
 *
 */
public class Sort3Types {

	int arr[] = { 0, 1, 2, 0, 2, 2, 1, 0 };
//	int arr[] = { 0, 0, 0, 0, 0 };
//	int arr[] = { 0, 0, 0, 0, 1 };
//	int arr[] = { 1, 1 ,1 , 1 };
//	int arr[] = { 1, 1, 1, 1, 2 };
//	int arr[] = { 2, 2, 2, 2 };
//	int arr[] = { 0, 0, 2, 2, 0 };
//	int arr[] = { 2, 0, 0, 0 };
//	int arr[] = { 0, 2, 1, 0, 2, 1 };
	
	// The three distinct numbers in the array
	final int ZERO = 0;
	final int ONE = 1;
	final int TWO = 2;

	/**
	 * Function that returns the array in String format
	 * 
	 * @return stringArray
	 */
	public String toString() {
		StringBuilder stringArray = new StringBuilder();

		for (int i = 0; i < arr.length; i++) {
			stringArray.append(arr[i] + " ");
		}

		return stringArray.toString();
	}

	/**
	 * Function that will increment p0 till it is placed at the last 0 of the
	 * sorted part of array.
	 * 
	 * @param p0
	 *            : Type int. Initial index of p0 in the array.
	 * @return p0 : Type int. Updated index of p0.
	 */
	private int incrementP0(int p0) {

		while ((p0 < arr.length - 1) && arr[p0 + 1] == ZERO) {
			p0++;
		}

		return p0;
	}

	/**
	 * Function that will decrement p2 till it is placed at the first 2 of the
	 * sorted part of array.
	 * 
	 * @param p2
	 *            : Type int. Initial index of p2 in the array.
	 * @return p2 : Type int. Updated index of p2.
	 */
	private int decrementP2(int p2) {

		while ((p2 > 0) && arr[p2 - 1] == TWO) {
			p2--;
		}

		return p2;
	}

	/**
	 * Swap array elements 
	 * @param p0 : Type int. Index 1 
	 * @param p1 : Type int. Index 2
	 */
	private void swap(int p0, int p1) {
		int temp = arr[p0];
		arr[p0] = arr[p1];
		arr[p1] = temp;
	}

	/**
	 * Function that sorts the array arr
	 */
	private void sort() {
		int p0 = -1; // Last Index of the part of sorted 0's.
		int p2 = arr.length; // First Index of the part of sorted 2's
		int p1; // Index used to traverse through and thus sort the array

		p0 = incrementP0(p0);
		p2 = decrementP2(p2);
		p1 = p0 + 1; // Index of next element under consideration

		
		while (p1 < p2) {

			switch (arr[p1]) {
			case ZERO:
				swap(++p0, p1);
				p1++;
				break;
			case ONE:
				p1++;
				break;
			case TWO:
				swap(--p2, p1);
				break;
			}
		}
	}

	public static void main(String args[]) {
		Sort3Types obj = new Sort3Types();
		System.out.println(obj.toString());
		obj.sort();
		System.out.println(obj.toString());
	}

}
