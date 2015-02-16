package com.fibo;

public class TraditionalFibonacci {

	private static long fibo(long n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}

		return fibo(n - 1) + fibo(n - 2);
	}

	public static void main(String args[]) {

		long timeStart = System.currentTimeMillis();
		System.out.println(fibo(60));
		long timeEnd = System.currentTimeMillis();
		System.out.println((timeEnd - timeStart) / 1000);

	}

}
