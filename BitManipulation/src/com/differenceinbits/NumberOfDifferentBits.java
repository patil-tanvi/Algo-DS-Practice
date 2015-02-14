package com.differenceinbits;

/**
 * Class that returns the number of different bits in the two numbers 
 * @author tanvi
 *
 */
public class NumberOfDifferentBits {
	
	int num1, num2; //The two numbers whose bits are to e compared.
	int count;
	
	NumberOfDifferentBits(int n1, int n2) {
		num1 = n1;	//Eg : 1101
		num2 = n2;	//Eg : 0001
	}
	
	/**
	 * Returns the number of bits that are different in the two numbers.
	 * @return count - Type int.
	 */
	int getNumberOfDifferentBits(){
	
		for(int diff = num1 ^ num2; diff != 0; diff = diff & (diff - 1)){
			count++;
		}
		return count;	//Eg : 2
	}
	
	public static void main(String args[]){
		NumberOfDifferentBits diffBits = new NumberOfDifferentBits(13,1);
		System.out.println(diffBits.getNumberOfDifferentBits());
	}

}
