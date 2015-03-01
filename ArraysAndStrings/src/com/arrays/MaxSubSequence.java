package com.arrays;

public class MaxSubSequence {

	/**
	 * Class that stores the parameters of the maximum subsequence
	 * @author tanvi
	 *
	 */
	class Sequence{
		int start;	//Start index of the sequence
		int end;	//End index of the sequence
		int sum;	//Sum of the sequence
	
		Sequence(int s, int e, int total){
			start = s;
			end = e;
			sum = total;
		}
		
		public String toString(){
			return ("start = " + start + "\nend = " + end + "\nsum = " + sum);
		}
	}
	
	enum ArrayPart{
		NONE, LEFT, RIGHT, COMBINATION;
	}
	
	
//	int arr[] = {3, 8, -2, -4, 2};
	
	int arr[] = {-1, -2, -3};
	
//	int arr[] = {1, -1, 2, 200, -60, -8};
	
//	int arr[] = {2, -1, 3, 2};
	
	Sequence maxSequence = new Sequence(-1, -1, Integer.MIN_VALUE);
	
	private int getArrayLength(){
		return arr.length;
	}
	
	private void printMaxSequence(){
		System.out.println(maxSequence.toString());
	}
	
	private void printArray() {
		System.out.print("Array : ");
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	private void getMaxSubsequence(int start, int end){
		
		ArrayPart part = ArrayPart.NONE;
		
		if(start < end){
			int mid = (end + start) / 2;
			int lSum = 0;	//Sum of left part of array
			int rSum = 0;	//Sum of right part of array
			
			for(int i = start; i <= mid; i++){
				lSum += arr[i];
			}
			
			for(int i = mid + 1; i <= end; i++){
				rSum += arr[i];
			}
			
			//Assign maxSequence to left part if it's current sum is less than lSum
			if(maxSequence.sum < lSum){
				maxSequence = new Sequence(start, mid, lSum);
				part = ArrayPart.LEFT;
			}

			//Assign maxSequence to left part if it's current sum is less than rSum
			if(maxSequence.sum < rSum){
				maxSequence = new Sequence(mid + 1, end, rSum);
				part = ArrayPart.RIGHT;
			}
			
			//Assign maxSequence to left part if it's current sum is less than lSum + rSum
			if(maxSequence.sum < lSum + rSum){
				int total = lSum + rSum;
				
				while(arr[start] < 0){
					total -= arr[start];
					start++;
				}
				while(arr[end] < 0){
					total -= arr[end];
					end--;
				}
				
				maxSequence = new Sequence(start, end, total);
				part = ArrayPart.COMBINATION;
			}
			
			//Make recursive call based on which part of array has max sum
			
			if(part == ArrayPart.LEFT){
				getMaxSubsequence(start, mid);
			}
			else if(part == ArrayPart.RIGHT){
				getMaxSubsequence(mid + 1, end);
			}
			else if(part == ArrayPart.COMBINATION){
				getMaxSubsequence(start, end);
			}
			
		}
		
	}
	
	public static void main(String args[]){
		
		MaxSubSequence obj = new MaxSubSequence();
		obj.getMaxSubsequence(0, obj.getArrayLength() - 1);
		obj.printArray();
		obj.printMaxSequence();
	}
}
