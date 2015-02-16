package com.fibo;

public class DPFibonacci {

	 static long arr[] = new long[10000];

		private static long fibo(long n) {
			if (n == 0) {
				 arr[0] = 0;
				return 0;
			}
			if (n == 1) {
				 arr[1] = 1;
				return 1;
			}

			 if (arr[(int) n] != 0) {
			 return arr[(int) n];
			 }

			 arr[(int) n] = fibo(n - 1) + fibo(n - 2);
			return arr[(int)n];
		}

		public static void main(String args[]) {

			long timeStart = System.currentTimeMillis();
			System.out.println(fibo(60));
			long timeEnd = System.currentTimeMillis();
			System.out.println((timeEnd - timeStart) / 1000);
//			for(int i = 0; i <= 5; i++){
//				System.out.println(arr[i]);
//			}

		}
}
