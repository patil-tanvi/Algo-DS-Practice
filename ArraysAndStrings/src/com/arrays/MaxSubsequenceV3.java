package com.arrays;

/**
 * Class that stores the parameters of a subsequence in an array
 * @author tanvi
 *
 */
class Sequence{
	int start; 	//Start index of the sequence
	int end;	//End index of the sequence
	int sum;	//Sum of the sequence
	
	
	//Constructor to intialize the sequence
	Sequence(int start, int end, int sum){
		this.start = start;
		this.end = end;
		this.sum = sum;
	}
	
	//Returns String representation of the sequence.
	public String toString(){
		return ("Start : " + start + "\nEnd : " + end + "\nSum : " + sum);
	}
}

/**
 * Class that finds the maximum Subsequence in an array
 * @author tanvi
 *
 */
public class MaxSubsequenceV3 {

	int arr[] = { 2, -1, 3};

	/**
	 * Function that prints the array
	 */
	private void printArray() {
		System.out.print("Array : ");
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	/**
	 * Function that returns the maximum Subsequence in an array
	 * @return Type String. Start index, end index and sum of the sequence.
	 */
	private String maxSubsequence() {
		
		//Sum of the sequence inclusive of previous value.
		Sequence prev = new Sequence(0,0,arr[0]);
		//The maximum sequence
		Sequence max = new Sequence(0,0,arr[0]);
		
		for(int i = 1; i < arr.length; i++){
			
			int addToPrev = prev.sum + arr[i];
			
			//case 1 : prev + arr[i] is maximum
			if(addToPrev > max.sum && addToPrev > arr[i]){
				prev = new Sequence(prev.start, i, addToPrev);
				max = prev;
			}
			//case 2 : arr[i] is maximum
			else if(arr[i] > max.sum){
				max = new Sequence(i, i, arr[i]);
				prev = max;
			}
			//case 3 : the previous maxSum is maximum 
			else{
				prev = new Sequence(prev.start, i, addToPrev);
			}
		}
		
		return max.toString();
	}

	public static void main(String args[]) {
		MaxSubsequenceV3 obj = new MaxSubsequenceV3();
		obj.printArray();
		System.out.println(obj.maxSubsequence());
	}
}
