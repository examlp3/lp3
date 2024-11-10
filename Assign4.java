/*
Assignment No: 4
Write a program to solve a 0-1 Knapsack problem using dynamic programming strategy.
*/

import java.util.*;

/*

Time complexity: O(2^n) (because the function explores all possible subsets).
Space complexity: O(n) (due to recursion depth).

class Assign4{

	static int solve(int ind, int W, int[] wt, int[] val){
        
        if(ind == 0){
            if(wt[0] <= W) return val[0];
            return 0;
        }
        
        int notTake = 0 + solve(ind-1, W, wt, val);
        
        int take = Integer.MIN_VALUE;
        if(wt[ind] <= W){
            take = val[ind] + solve(ind-1, W - wt[ind], wt,  val);
        }
        
        return Math.max(take, notTake);
    }


	public static void main(String agrc[]){
		Scanner io = new Scanner(System.in);

		System.out.print("Enter the N : ");
		int n = io.nextInt();

		System.out.print("Enter the Weight : ");
		int w = io.nextInt();

		System.out.println();

		int[] wt = new int[n];
		int[] val = new int[n];

		for(int i=0; i<n; i++){
			System.out.print("Enter the "+(i+1)+" Value : ");
			val[i] = io.nextInt();

			System.out.print("Enter the "+(i+1)+" Weight : ");
			wt[i] = io.nextInt();
		}

		int ans = solve(n-1, w, wt, val);
		System.out.println(ans);
	}
}
*/

/*
Time complexity: O(n * W) (due to memoization).
Space complexity: O(n * W) (for the DP table and recursion stack).

class Assign4{

	static int solve(int ind, int W, int[] wt, int[] val, int[][] dp){
        
        if(ind == 0){
            if(wt[0] <= W) return val[0];
            return 0;
        }
        
        if(dp[ind][W] != -1) return dp[ind][W];
        
        int notTake = solve(ind-1, W, wt, val, dp);
        
        int take = Integer.MIN_VALUE;
        if(wt[ind] <= W){
            take = val[ind] + solve(ind-1, W - wt[ind], wt,  val, dp);
        }
        
        return dp[ind][W] = Math.max(take, notTake);
    }


	public static void main(String agrc[]){
		Scanner io = new Scanner(System.in);

		System.out.print("Enter the N : ");
		int n = io.nextInt();

		System.out.print("Enter the Weight : ");
		int w = io.nextInt();

		System.out.println();

		int[] wt = new int[n];
		int[] val = new int[n];

		for(int i=0; i<n; i++){
			System.out.print("Enter the "+(i+1)+" Value : ");
			val[i] = io.nextInt();

			System.out.print("Enter the "+(i+1)+" Weight : ");
			wt[i] = io.nextInt();
		}

		int[][] dp = new int[n+1][w+1];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=w; j++){
                dp[i][j] = -1;
            }
        }

		int ans = solve(n-1, w, wt, val, dp);
		System.out.println(ans);
	}
}

*/


/*
Time complexity: O(n * W)
Space complexity: O(n * W) 

class Assign4{
	public static void main(String agrc[]){
		Scanner io = new Scanner(System.in);

		System.out.print("Enter the N : ");
		int n = io.nextInt();

		System.out.print("Enter the Weight : ");
		int w = io.nextInt();

		System.out.println();

		int[] wt = new int[n];
		int[] val = new int[n];

		for(int i=0; i<n; i++){
			System.out.print("Enter the "+(i+1)+" Value : ");
			val[i] = io.nextInt();

			System.out.print("Enter the "+(i+1)+" Weight : ");
			wt[i] = io.nextInt();
		}

		//solution
		int[][] dp = new int[n][w+1];
        for(int W= wt[0]; W <= w; W++) dp[0][W] = val[0];
        
        for(int ind=1; ind<n; ind++){
            for(int W=0; W<=w; W++){
                
                
                int notTake = 0 + dp[ind-1][W];
                
                int take = Integer.MIN_VALUE;
                if(wt[ind] <= W){
                    take = val[ind] + dp[ind-1][W - wt[ind]];
                }
                
                dp[ind][W] = Math.max(take, notTake);
            }
        }
        
        System.out.println(dp[n-1][w]);
	}
}
*/


/*

Time complexity: O(n * W)
Space complexity: O(W)

*/


class Assign4{
	public static void main(String agrc[]){
		Scanner io = new Scanner(System.in);

		System.out.print("Enter the Size of the Array N : ");
		int n = io.nextInt();

		System.out.print("Enter the N  Weight : ");
		int w = io.nextInt();

		System.out.println();

		int[] wt = new int[n];
		int[] val = new int[n];

		for(int i=0; i<n; i++){
			System.out.print("Enter the "+(i+1)+" Value : ");
			val[i] = io.nextInt();

			System.out.print("Enter the "+(i+1)+" Weight : ");
			wt[i] = io.nextInt();
		}

		//solution
		int[] prev = new int[w+1];
        for(int W= wt[0]; W <= w; W++) prev[W] = val[0];
        
        for(int ind=1; ind<n; ind++){

        	int[] cur = new int[w+1];

            for(int W=0; W<=w; W++){
                
                int notTake = 0 + prev[W];
                
                int take = Integer.MIN_VALUE;
                if(wt[ind] <= W){
                    take = val[ind] + prev[W - wt[ind]];
                }
                
                cur[W] = Math.max(take, notTake);
            }
            prev = cur;
        }
        
        System.out.println(prev[w]);
	}
}

