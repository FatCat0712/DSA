package dynamicprogramming;

import java.util.Scanner;

public class test {
	
	public static int memoizeRecursionFib(int n,int[] cache) {
		cache[1] = 1;
		cache[2] = 1;
		if(n == 1) return 1;
		if(n == 2) return 1;
		if(cache[n] != 0)
			return cache[n];
		cache[n] = memoizeRecursionFib(n - 1, cache) + memoizeRecursionFib(n - 2, cache);
		return cache[n];
	}
	public static void main(String[] args) {
		int n = 1000;
		int[] cache = new int[n+1];
		long start = System.currentTimeMillis();
		int result = memoizeRecursionFib(n, cache);
		long end = System.currentTimeMillis();
		System.out.println(result);
		System.out.println("Thoi gian: "+(end - start));
		System.out.println("Thoi gian: "+((end - start)/1000));
	}

	
}
