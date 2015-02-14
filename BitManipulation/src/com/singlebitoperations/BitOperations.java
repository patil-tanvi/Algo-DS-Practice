package com.singlebitoperations;

/**
 * Class that performs clear bit, set bit, get bit and update bit operations on
 * a number.
 * 
 * @author tanvi
 *
 */
public class BitOperations {

	int num; // Number on whom the bit level operation is to be performed
	int var; // A variable which defines the position of the bit in the number
				// (3rd bit or 6th bit etc)

	/**
	 * Constructor that initializes the num and var variables for class
	 * BitOperations
	 * 
	 * @param n
	 *            -> Type int. Number on whom the bit level operation is to be
	 *            performed. (Eg. 10)
	 * @param v
	 *            -> Type int. A variable which defines the position of the bit
	 *            in the number. (Eg. 3)
	 */
	public BitOperations(int n, int v) {
		this.num = n;
		this.var = v;
	}

	/**
	 * Function that returns the "var"th bit in the number "num"
	 * @return 0(false) or 1(true)
	 */
	public boolean getBit(){
		return (num & (1 << var)) != 0;
	}
	
	/**
	 * Sets the "var"th bit in the number "num"
	 */
	public void setBit(){
		num = num | (1 << var);
	}
	
	/**
	 * Clears the "var"th bit in the number "num"
	 */
	public void clearBit(){
		int mask = ~(1 << var);
		num &= mask;
	}
	
	/**
	 * Clears bits from the MSB to the "var"th bit in the number "num"
	 */
	public void clearBitsMSBtoi(){
		num &= ~(~0 << var);
	}
	
	/**
	 * Clears bits from the "var"th bit to 0th bit in the number "num"
	 */
	public void clearBitsiThroughMsb(){
		num &= (~0 << var);
		System.out.println(Integer.toBinaryString(num));
	}
	
	public static void main(String args[]) {
		BitOperations bitOp = new BitOperations(15, 3);
		bitOp.clearBitsiThroughMsb();
	}
}
