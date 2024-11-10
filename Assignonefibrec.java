/*
Assignment No: 1
Write a program non-recursive and recursive program to calculate Fibonacci numbers and analyze
their time and space complexity.

Time complexity: O(n)
Space complexity: O(n) (due to recursion depth)
*/

import java.util.*;
class Assignonefibrec{

	static void printFib(int prev1, int prev2, int n){
		if(n == 0) return;

		int curNum = prev1 + prev2;
		System.out.print(curNum + " ");

		printFib(curNum, prev1, n-1);

	}

	public static void main(String agrc[]){
		Scanner io = new Scanner(System.in);

		System.out.print("Enter the Number : ");
		int n = io.nextInt();

		if(n == 0) return;

		System.out.print(0 + " ");
		if(n == 1) return; 
		System.out.print(1 + " ");

		printFib(1, 0, n-2);
	}
}
