package com.insertBits;

/**
 * Class that inserts the bit in the number m in the number in, at the specified positions in n.
 * Eg : M = 1011101001110 (5966)
 *      N = 111
 *      i = 5
 *      j = 8
 *      O/P = 1011111101110
 * @author tanvi
 *
 */
public class InsertMintoN {
	
	int m; //Number in which bits are to be inserted
	int n; //The bits that are to be inserted
	int i; //Start position of the sequence where n is to be inserted in m. Counting from 0, lsb to msb.
	int j; //End position of the sequence where n is to be inserted in m. Counting from 0, lsb to msb.
	int result; //The result of inserting n in m.
	
	/**
	 * Constructor to initialize the values of m,n,i and j
	 */
	public InsertMintoN(int m, int n, int i, int j) {
		this.m = m;
		this.n = n;
		this.i = i;
		this.j = j;
		
		try {
		
			int diff = j - i;	//Difference between positions i and j.
			int lengthN = 32 - Integer.numberOfLeadingZeros(n);	//The length of the bits in number n

			//If the length of n in bits does not match the difference in positions i to j exit with error
			if(lengthN != diff){
					throw new Exception("Unmatched lengths of n and i-j");
			} 
			
			int lengthM = 32 - Integer.numberOfLeadingZeros(m);
			//If length of M is smaller than N exit
			if(lengthM < lengthN){
				throw new Exception("Length of M is smaller than N, thus N cannot be inserted in M");
			}
		}
		catch (Exception e) {
				e.printStackTrace();
		}
		
	}
	
	public void insert(){
		
		//rightMask = 0s followed by i 1s
		int rightMask = ~((~0) << i);  //(1 << i) - 1
		//leftMask = 1s followed by j 0s
		int leftMask = ~0 << j;
		//Mask = 1111100011111
		int mask = rightMask | leftMask;
		
		//mCLeared = clear i to j(exclusive) bits in m 
		int mCleared = m & mask;
		
		//left shift n to fit in i to j positions
		n = n << i;
		
		
		result = mCleared | n;
		
//		System.out.println(Integer.toBinaryString(m));
//		System.out.println(Integer.toBinaryString(rightMask));
//		System.out.println(Integer.toBinaryString(leftMask));
//		System.out.println(Integer.toBinaryString(mask));
//		System.out.println(Integer.toBinaryString(mCleared));
//		System.out.println(Integer.toBinaryString(n));
//		System.out.println(Integer.toBinaryString(result));
	}
	
	public static void main(String args[]){
		InsertMintoN obj = new InsertMintoN(5966, 7, 5, 8);
		obj.insert();
	}
}
