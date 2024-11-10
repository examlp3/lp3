/*
Assignment No: 1
Write a program non-recursive and recursive program to calculate Fibonacci numbers and analyze
their time and space complexity.

Time complexity: O(n)
Space complexity: O(1) (constant space).
*/


import java.util.*;
class Assignonefibiter{

	public static void main(String agrc[]){
		Scanner io = new Scanner(System.in);

		System.out.print("Enter the Number : ");
		int n = io.nextInt();

		if(n == 0) return;

		System.out.print(0 + " ");
		if(n == 1) return; 
		System.out.print(1 + " ");

		int prev2 = 0;
		int prev1 = 1;

		for(int i=2; i<n; i++){
			int curNum = prev1 + prev2;
			prev2 = prev1;
			prev1 = curNum;


			System.out.print(curNum + " ");
		}
	}
}
