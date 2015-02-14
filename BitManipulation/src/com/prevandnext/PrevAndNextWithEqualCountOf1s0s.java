package com.prevandnext;

/**
 * Class that calculates the immediate larger and immediate smaller number with
 * equal count of 1s and 0s.
 * 
 * Eg : 11011001111100 Next Larger : 11011010001111
 * 
 * Eg : 10011110000011 Previous Smaller : 10011101110000
 * 
 * @author tanvi
 *
 */
public class PrevAndNextWithEqualCountOf1s0s {
	int num;

	/**
	 * Constructor to initialize the number
	 * 
	 * @param n
	 *            - Type int.
	 */
	public PrevAndNextWithEqualCountOf1s0s(int n) {
		num = n;
		try {
			// Testing border cases
			if (num == 0) {
				throw new Exception("All bits zero. No bits can be flipped.");
			}

			if (num == ~0) {
				throw new Exception("All bits 1. No bits can be flipped.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Function that will return the smallest number greater than "num".
	 * Constraint : the number of 1 bits in num and the number of 0 bits in num
	 * should be the same as those in the new number.
	 * 
	 * @return num
	 */
	public int getNext() {
		int next = num;
		int c = num;
		int c0 = 0; // The number of trailing zeros
		int c1 = 0; // The number of trailing 1s.

		// While the last bit is 0 count trailing zeros
		while ((c & 1) == 0) {
			c0++;
			c >>= 1;
		}

		// While the last bit is 1 count trailing ones
		while ((c & 1) != 0) {
			c1++;
			c >>= 1;
		}
		try {
			// If the number is 11..00... next larger cannot be found
			if (c0 + c1 == 31) {
				throw new Exception(
						"Next larger number with same count of 1s and 0s is not possible to be found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int p = c0 + c1; //The position of the first non-trailing zero 

		int mask = 1 << p; 
		next |= mask;
		
		next &= ~((1 << p) - 1);	//Clear p lsb bit from num.
		next |= (1 << c1 - 1) - 1;
		
		
		return next;

	}
	
	/**
	 * Function that will return the largest number less than "num".
	 * Constraint : the number of 1 bits in num and the number of 0 bits in num
	 * should be the same as those in the new number.
	 * 
	 * @return prev
	 */
	public int getPrev() {
		int prev = num;
		int c = num;
		int c0 = 0; // The number of trailing zeros
		int c1 = 0; // The number of trailing 1s.

		// While the last bit is 1 count trailing ones
		while ((c & 1) == 1) {
			c1++;
			c >>= 1;
		}

		// While the last bit is 0 count trailing zeros
		while ((c & 1) != 1) {
			c0++;
			c >>= 1;
		}
		try {
			// If the number is 00...11... next smaller number cannot be found
			if (c0 + c1 == 31) {
				throw new Exception(
						"Next smaller number with same count of 1s and 0s is not possible to be found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int p = c0 + c1; //The position of the first non-trailing zero 

		int mask = ~(1 << p); 
		prev &= mask;	//Flip the first non trailing 1 to 0
		
		prev &= ~((1 << p) - 1);	//Clear p lsb bit from num.
		
		prev |= ((1 << c1 + 1) - 1) << (c0 - 1);
		
		
		return prev;

	}

	public static void main(String args[]) {
		PrevAndNextWithEqualCountOf1s0s nextObj = new PrevAndNextWithEqualCountOf1s0s(13948);
		System.out.println(Integer.toBinaryString(13948));
		System.out.println(Integer.toBinaryString(nextObj.getNext()));
		
		PrevAndNextWithEqualCountOf1s0s prevObj = new PrevAndNextWithEqualCountOf1s0s(10115);
		System.out.println(Integer.toBinaryString(10115));
		System.out.println(Integer.toBinaryString(prevObj.getPrev()));
		
		
	}
}
